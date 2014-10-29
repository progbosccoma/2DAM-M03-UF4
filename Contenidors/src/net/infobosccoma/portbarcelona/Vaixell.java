/*
 * Vaixell.java        
 *
 * 
 * Licensed under Creative Commons License, 
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 * 
 *          http://creativecommons.org/licenses/by-nc-sa/4.0
 */
package net.infobosccoma.portbarcelona;

/**
 * Classe Mercaderia
 * 
 * Modela les dades d'un vaixell
 * 
 * @author Marc Nicolau
 * @version 1.00 17/10/2014
 */
public class Vaixell {
	/**
	 * constant que indica el màxim de contenidors per defecte
	 */
	private static final int MAX_CONTAINERS = 1000;
	/**
	 * guarda tots els objectes contenidor relacionats amb el vaixell
	 */
	private Contenidor[] containers;
	/**
	 * el màxim de contenidors permès
	 */
	private int maxContainers;
	/**
	 * la quantitat actual de contenidors
	 */
	private int quantity;
	/**
	 * el volum ocupat pels contenidors
	 */
	private double currentVolume;

	/**
	 * constructor per defecte
	 */
	public Vaixell() {
		this(MAX_CONTAINERS);
	}
	/**
	 * Crea un vaixell indicant una quantitat màxim de contenidors
	 * permesa.
	 * 
	 * @param capacity la quantitat màxima de contenidors permesa.
	 */
	public Vaixell(int capacity) {
		containers = new Contenidor[capacity];
		maxContainers = capacity;
		quantity = 0;
		currentVolume = 0;
	}

	/**
	 * indica si el vaixell ja té la quantitat màxima de contenidors permesa
	 * 
	 * @return true si està ple, false en cas contrari
	 */
	public boolean isFull() {
		return quantity == maxContainers;
	}

	/**
	 * afegir un contenidor al vaixell
	 * 
	 * @param c
	 *            el contenidor que es vol afegir
	 * @return true si pot afegir el contenidor, false en cas contrari
	 */
	public boolean add(Contenidor c) {
		if (!isFull()) {
			containers[quantity++] = c;
			// si és Cisterna, s'ha de sumar en m3
			if(c instanceof Cisterna) {
				currentVolume += c.getVolume() / 1000;  
			} else {
				currentVolume += c.getVolume();
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * afegir un conjunt (array) de mercaderies al vaixell
	 * 
	 * @param mercaderies
	 *            el conjunt de mercaderies que es vol afegir
	 * @return true si pot afegir totes les mercaderies, false en cas contrari
	 */
	public boolean add(Contenidor[] containers) {
		if (!isFull() && containers.length + quantity < maxContainers) {
			for (Contenidor c : containers) {
				containers[quantity++] = c;
			}
			return true;
		} else {
			return false;
		}
	}
	/**
	 * obtenir el contenidor que ocupa una determinada posició
	 * 
	 * @param i index, base 0, del contenidor que es vol obtenir
	 * @return el contenidor que ocupa la posició i
	 */
	public Contenidor get(int i) {
		return containers[i];
	}

	/**
	 * buida el vaixell.
	 */
	public void reset() {
		quantity = 0;
		currentVolume = 0;
	}
	/**
	 * obtenir el volum que ocupen els contenidors del vaixell
	 * @return
	 */
	public double getVolume() {
		return currentVolume;
	}
	/**
	 * obtenir la quantitat actual de contenidors del vaixell
	 * @return la quantitat de contenidors
	 */
	public int getQuantity() {
		return quantity;
	}

}
