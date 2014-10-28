/*
 * Refrigerat.java        
 *
 * 
 * Licensed under Creative Commons License, 
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 * 
 *          http://creativecommons.org/licenses/by-nc-sa/4.0
 */
package net.infobosccoma.portbarcelona;

/**
 * Classe Refrigerat, que hereta de Contenidor
 * 
 * Modela les dades d'un contenidor tipus Regrigerat
 * 
 * @author Marc Nicolau
 * @version 1.00 17/10/2014
 */
public class Refrigerat extends Contenidor {
	/**
	 * atribut temperatura mínima
	 */
	private float temperaturaMin;

	/**
	 * Crea un objecte de tipus Refrigerat amb el número de sèrie, la quantitat
	 * màxim a de mercaderies i la temperatura mínima
	 * 
	 * @param numSerie
	 *            el nújero de sèrie
	 * @param maxCapacity
	 *            la quantitat màxima de mercaderies
	 * @param temperaturaMin
	 *            la temperatura mínima
	 */
	public Refrigerat(String numSerie, double maxCapacity, float temperaturaMin) {
		super(numSerie, maxCapacity);
		this.setTemperaturaMin(temperaturaMin);
	}

	/**
	 * obté la temperatura mínima
	 * 
	 * @return la temperatura mínima
	 */
	public float getTemperaturaMin() {
		return temperaturaMin;
	}

	/**
	 * assigna la temperatura mínima
	 * 
	 * @param temperaturaMin
	 *            la temperatura a assignar
	 */
	public void setTemperaturaMin(float temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
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
		 * si està obert i el volum actual + el de la mercaderia aplicant el
		 * 0.01% d'increment no supera la capacitat permesa
		 */
		double volumMercaderia = m.getVolum() + m.getVolum() * 0.0001;
		if (isOpen() && getVolume() + volumMercaderia <= getMaxCapacity()) {
			setVolume(getVolume() + volumMercaderia);
			addToArray(m);
			return true;
		} else {
			return false;
		}
	}

}
