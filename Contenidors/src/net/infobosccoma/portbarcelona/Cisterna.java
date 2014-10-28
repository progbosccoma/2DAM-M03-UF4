/*
 * Cisterna.java        
 *
 * 
 * Licensed under Creative Commons License, 
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 * 
 *          http://creativecommons.org/licenses/by-nc-sa/4.0
 */
package net.infobosccoma.portbarcelona;

/**
 * Classe Cisterna, que hereta de Contenidor
 * 
 * Modela les dades d'un contenidor tipus Cisterna
 * 
 * @author Marc Nicolau
 * @version 1.00 17/10/2014
 */
public class Cisterna extends Contenidor {

	/**
	 * Crea un objecte Cisterna indicant el número de sèrie i la quantitat
	 * màxima de mercaderies.
	 * 
	 * @param numSerie
	 *            el número de sèrie
	 * @param maxCapacity
	 *            la quantitat màxima de mercaderies
	 */
	public Cisterna(String numSerie, double maxCapacity) {
		super(numSerie, maxCapacity);
	}

	/**
	 * calcula el volum expressat en litres
	 * 
	 * @return el volum en litres
	 */
	public double getVolume() {
		return super.getVolume() * 1000;
	}
}
