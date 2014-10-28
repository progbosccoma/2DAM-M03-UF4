/*
 * PortBarcelona.java        
 *
 * 
 * Licensed under Creative Commons License, 
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 * 
 *          http://creativecommons.org/licenses/by-nc-sa/4.0
 */
package net.infobosccoma.portbarcelona;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Classe PortBarcelona
 * 
 * Aplicació que emula la càrrega i descarrega de contenidors d'un vaixell
 * 
 * 
 * @author Marc Nicolau
 * @version 1.00 17/10/2014
 */
public class PortBarcelona {
	/**
	 * lector de dades des de teclat
	 */
	static Scanner in = new Scanner(System.in);

	/**
	 * el mètode principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int opcio;
		Vaixell vaixell = new Vaixell();

		demo(vaixell);
		do {
			menuPrincipal();
			opcio = llegirOpcio();

			switch (opcio) {
			case 1:
				carregarContenidor(vaixell);
				break;
			case 2:
				descarregar(vaixell);
				break;
			case 3:
				llistatMercaderies(vaixell);
				break;
			}
		} while (opcio != 0);

	}

	/**
	 * mètode que crea objectes per defecte
	 * 
	 * @param vaixell
	 *            el vaixell que conté els contenidors i les mercaderies.
	 */
	private static void demo(Vaixell vaixell) {
		DryVan dv = new DryVan("EUR123434", 100000, "red");
		Mercaderia[] mercaderies = new Mercaderia[] {
				new Mercaderia("PATATES", 23456, dv),
				new Mercaderia("MONIATOS", 12356, dv),
				new Mercaderia("BANANES", 45656, dv) };
		if (dv.add(mercaderies)) {
			vaixell.add(dv);
		}

		Cisterna cist = new Cisterna("USA433433", 500);
		if (cist.add(new Mercaderia("DIESEL", 450, cist))) {
			vaixell.add(cist);
		}

		Refrigerat ref = new Refrigerat("AUS998785", 700000.0, -5.0f);
		Mercaderia[] mercaderiesRef = new Mercaderia[] {
				new Mercaderia("RAP", 23456, ref),
				new Mercaderia("GAMBES", 42356, ref) };
		if (ref.add(mercaderiesRef)) {
			vaixell.add(ref);
		}

	}

	/**
	 * mostra una capçalera en el llistat
	 */
	private static void capcaleraLlistat() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("\nP O R T  D E  B A R C E L O N A");
		System.out.println("-------------------------------\n");
		System.out.println("DATA: "
				+ dateFormat.format(System.currentTimeMillis()));
	}

	/**
	 * llista els contenidors i la quantitat de mercaderies que conté cadascun
	 * 
	 * @param vaixell
	 *            el vaixell que conté els contenidors
	 */
	private static void llistatMercaderies(Vaixell vaixell) {
		int quantitatMercaderies = 0;

		capcaleraLlistat();
		System.out.println("\nCONTENIDOR         QUANT. MERC.");
		System.out.println("-------------------------------");
		for (int i = 0; i < vaixell.getQuantity(); i++) {
			System.out.println(vaixell.get(i).getNumSerie() + "\t"
					+ String.format("%15s",vaixell.get(i).getQuantityMerchandises()));
			quantitatMercaderies += vaixell.get(i).getQuantityMerchandises();
		}
		System.out.println("\nTOTAL MERCADERIES: " + String.format("%12s",quantitatMercaderies));
		System.out.println("-------------------------------\n");
	}

	/**
	 * descarrega el vaixell i mostra el llistat de contenidors i el seu volum.
	 * També mostra el volum total.
	 * 
	 * @param vaixell
	 */
	private static void descarregar(Vaixell vaixell) {
		DecimalFormat formatDecimal = new DecimalFormat("#########.000");
		capcaleraLlistat();
		System.out.println("\nCONTENIDOR                VOLUM");
		System.out.println("-------------------------------");
		for (int i = 0; i < vaixell.getQuantity(); i++) {
			System.out.print(vaixell.get(i).getNumSerie() 
					+ String.format("%19s", formatDecimal.format(vaixell.get(i).getVolume())));
			if (vaixell.get(i) instanceof Cisterna) {
				System.out.println("  l");
			} else {
				System.out.println(" m3");
			}
		}
		System.out.println("\nVOLUM TOTAL: " + String.format("%18s", formatDecimal.format(vaixell.getVolume()) + " m3"));
		System.out.println("-------------------------------\n");
		vaixell.reset(); // buidar-lo
	}

	/**
	 * mètode que carrega un contenidor al vaixell
	 * 
	 * @param vaixell
	 *            el vaixell on s'ha de carregar
	 */
	private static void carregarContenidor(Vaixell vaixell) {
		int opcio;

		do {
			menuContenidor();
			opcio = llegirOpcio();
			switch (opcio) {
			case 1:
				carregarDryVan(vaixell);
				break;
			case 2:
				carregarCisterna(vaixell);
				break;
			case 3:
				carregarRefrigerat(vaixell);
				break;
			}
		} while (opcio != 0);

	}

	/**
	 * mètdode que carrega un contenidor tipus DryVan
	 * 
	 * @param vaixell
	 *            el vaixell on s'ha de carregar
	 */
	private static void carregarDryVan(Vaixell vaixell) {

		System.out.print("Número de sèrie: ");
		String numSerie = in.nextLine();
		System.out.print("Capacitat (m3): ");
		double volum = Double.parseDouble(in.nextLine());
		System.out.print("Color: ");
		String color = in.nextLine();

		DryVan c = new DryVan(numSerie, volum, color);
		System.out.print("Quantes mercaderies? ");
		int quant = Integer.parseInt(in.nextLine());

		if (c.add(demanarMercaderies(quant, c))) {
			vaixell.add(c);
		}
	}

	/**
	 * mètdode que carrega un contenidor tipus Cisterna
	 * 
	 * @param vaixell
	 *            el vaixell on s'ha de carregar
	 */
	private static void carregarCisterna(Vaixell vaixell) {
		System.out.print("Número de sèrie: ");
		String numSerie = in.nextLine();
		System.out.print("Capacitat (m3): ");
		double volum = Double.parseDouble(in.nextLine());

		Cisterna c = new Cisterna(numSerie, volum);
		if (c.add(demanarMercaderies(1, c))) {
			vaixell.add(c);
		}
	}

	/**
	 * mètdode que carrega un contenidor tipus Refrigerat
	 * 
	 * @param vaixell
	 *            el vaixell on s'ha de carregar
	 */
	private static void carregarRefrigerat(Vaixell vaixell) {
		System.out.print("Número de sèrie: ");
		String numSerie = in.nextLine();
		System.out.print("Capacitat (m3): ");
		double volum = Double.parseDouble(in.nextLine());
		System.out.print("Temperatura mínima: ");
		float temperatura = Float.parseFloat(in.nextLine());

		Refrigerat c = new Refrigerat(numSerie, volum, temperatura);
		System.out.print("Quantes mercaderies? ");
		int quant = Integer.parseInt(in.nextLine());

		c.add(demanarMercaderies(quant, c));
		vaixell.add(c);
	}

	/**
	 * s'encarrega de demanar les dades d'una quantitat de mercaderies
	 * 
	 * @param quant
	 *            la quantitat de mercaderies a demanar
	 * @param c
	 *            el contenidor on es trobaran les mercaderies
	 * @return la llista de mercaderies llegida
	 */
	private static Mercaderia[] demanarMercaderies(int quant, Contenidor c) {
		Mercaderia[] list = new Mercaderia[quant];
		String descripcio;
		double volum;

		for (int i = 0; i < quant; i++) {
			System.out.print("Descripcio: ");
			descripcio = in.nextLine();
			System.out.print("Volum (m3): ");
			volum = Double.parseDouble(in.nextLine());
			list[i] = new Mercaderia(descripcio, volum, c);
		}

		return list;
	}

	/**
	 * mètode que mostra el menú principal
	 */
	private static void menuPrincipal() {
		System.out.println("\nP O R T  D E  B A R C E L O N A");
		System.out.println("-------------------------------\n");
		System.out.println("1. CARREGAR CONTENIDOR");
		System.out.println("2. DESCARREGAR VAIXELL");
		System.out.println("3. MOSTRAR CONTENIDORS");
		System.out.println("0. SORTIR");
		System.out.print("\nEscull una opcio: ");
	}

	/**
	 * mètode que mostra el menú del contenidor
	 */
	private static void menuContenidor() {
		System.out.println("CARREGAR CONTENIDOR");
		System.out.println("--------------");
		System.out.println("1. DRY VAN");
		System.out.println("2. CISTERNA");
		System.out.println("3. REFRIGERAT");
		System.out.println("0. SORTIR");
		System.out.print("\nEscull una opcio: ");
	}

	/**
	 * mètode que llegeix i valida un opció de menú. només s'admet del 0 al 3.
	 * 
	 * @return el valor 0, 1, 2 o 3
	 */
	private static int llegirOpcio() {
		int opcio;

		do {
			opcio = in.nextInt();
			if (opcio != 0 && opcio != 1 && opcio != 2 && opcio != 3) {
				System.out.println("Opció incorrecta. Torna-hi");
			}
		} while (opcio < 0 || opcio > 3);

		return opcio;
	}

}