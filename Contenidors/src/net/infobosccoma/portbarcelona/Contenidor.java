/*
 * Contenidor.java        
 *
 * 
 * Licensed under Creative Commons License, 
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 * 
 *          http://creativecommons.org/licenses/by-nc-sa/4.0
 */
package net.infobosccoma.portbarcelona;

/**
 * Classe que modela el concepte de contenidor.
 * 
 * @author Marc Nicolau
 * @version 1.00 17/10/2014
 */
public abstract class Contenidor {
	/**
	 * Constant que conté el màxim de mercaderies per defecte
	 */
	public static final int MAX_MERCHANDISES = 100;
	/**
	 * El número de sèrie
	 */
	private String serial;
	/**
	 * L'estat, true per indicar obert, false per indicar tancat
	 */
	private boolean status;
	/**
	 * La quantitat màxima de mercaderies admeses
	 */
	private int maxMerchandises;
	/**
	 * El volum màxim permès
	 */
	private double maxCapacity;
	/**
	 * Guarda els objectes Mercaderia
	 */
	private Mercaderia[] merchandises;
	/**
	 * La quantitat de marcaderies que conté el contenidor
	 */
	private int quantity;
	/**
	 * Guarda el volum total actual, per evitar haver-ho de calcular cada vegada
	 * que s'afegeix una mercaderia
	 */
	private double currentVolume;

	/**
	 * Crea un objecte contenidor indicant el número de sèrie i el màxim 
	 * de mercaderies permès.
	 * 
	 * @param serial
	 *            el número de sèrie
	 * @param maxCapacity
	 *            la quantita màxima de mercaderies que es poden introduir al
	 *            contenidor
	 */
	public Contenidor(String serial, double maxCapacity) {
		this(MAX_MERCHANDISES, maxCapacity);
		this.serial = serial;
	}

	/**
	 * Crea un objecte contenidor indicant el màxim de mercaderies i el volum
	 * màxim
	 * 
	 * @param maxMerchandises
	 *            quantitat màxima de mercaderies
	 * @param maxCapacity
	 *            volum màxim permès
	 */
	public Contenidor(int maxMerchandises, double maxCapacity) {
		this.maxMerchandises = maxMerchandises;
		this.maxCapacity = maxCapacity;
		this.merchandises = new Mercaderia[maxMerchandises];
		open();
	}

	/**
	 * obtenir el número de sèrie
	 * 
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return serial;
	}

	/**plataforma
	 * assignar el número de sèrie
	 * 
	 * @param numSerie
	 *            the numSerie to set
	 */
	public void setNumSerie(String serial) {
		this.serial = serial;
	}

	/**
	 * saber si el contenidor és obert
	 * 
	 * @return true si és obert, tancat si és false
	 */
	public boolean isOpen() {
		return status;
	}

	/**
	 * tancar el contenidor
	 */
	public void close() {
		this.status = false;
	}

	/**
	 * obrir el contenidor
	 */
	public void open() {
		this.status = true;
	}


	/**
	 * obtenir la quantitat de mercaderies actual
	 * 
	 * @return quantitat de mercaderies
	 */
	public int getQuantityMerchandises() {
		return quantity;
	}

	/**
	 * Volum que ocupen les mercaderies.
	 * 
	 * @return el volum de les mercaderies
	 */
	public double getVolume() {
		return currentVolume;
	}

	/**
	 * assignar el volum que ocupen les seves mercaderies
	 * 
	 * @param volum
	 *            el volum ocupat
	 */
	public void setVolume(double volum) {
		this.currentVolume = volum;
	}
	
	/**
	 * obtenir el volum màxim permès
	 * 
	 * @return el volum màxim permès
	 */
	public double getMaxCapacity() {
		return this.maxCapacity;
	}

	/**
	 * obtenir la quantitat màxima de mercaderies
	 * 
	 * @return la quantitat màxima de mercaderies
	 */
	protected int getMaxMerchandises() {
		return this.maxMerchandises;
	}

	/**
	 * afegir la mercaderia a l'array de mercaderies
	 *
	 * @param m la mercaderia que es vol afegir
	 */
	protected void addToArray(Mercaderia m) {
		merchandises[quantity++] = m;
	}

	/**
	 * afegir una mercaderia al contenidor, però el deixa obert
	 * 
	 * @param m
	 *            la mercaderia a afegir
	 * @return true si l'ha pogut afegir, false en cas contrari
	 */
	public boolean add(Mercaderia m) {
		/* 
		 * si està obert i el volum actual + el de la mercaderia
		 * no supera la capacitat 
		 */
		if (isOpen() && currentVolume + m.getVolum() <= maxCapacity) {
			currentVolume += m.getVolum();
			addToArray(m);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * afegir un conjunt de mercaderies(array) al contenidor i el tanca si pot
	 * afegir-les totes
	 * 
	 * @param m
	 *            el conjunt de mercaderies a afegir
	 * @return true si les ha pogut afegir totes, false en cas contrari
	 */
	public boolean add(Mercaderia[] mercaderies) {
		// guardo l'actual per si no hi caben totes
		int quantitatInicial = quantity;
		double volumActual = currentVolume;
		boolean afegit = false;
		// si hi caben totes (per quantitat)
		if (mercaderies.length + quantitatInicial <= maxMerchandises) {
			for (Mercaderia m : mercaderies) {
				afegit = add(m);
				if (!afegit) {
					// "resetejo" a la quantitat inicial i al volum inicial
					quantity = quantitatInicial;
					currentVolume = volumActual;
					return false;
				}
			}
			close();
			return true;
		} else {
			return false;
		}
	}
}
