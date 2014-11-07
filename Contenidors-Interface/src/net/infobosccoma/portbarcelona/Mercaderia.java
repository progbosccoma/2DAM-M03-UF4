/*
 * Mercaderia.java        
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
 * Modela les dades d'una mercaderia
 * 
 * @author Marc Nicolau
 * @version 1.00 17/10/2014
 */
public class Mercaderia {
	/**
	 * atribut descripcio
	 */
	private String descripcio;
	/**
	 * atribut volum
	 */
	private double volum;
	/**
	 * atribut contenidor
	 */
	private Contenidor contenidor;

	/**
	 * Crea una mercaderia indicant les dades dels seus atributs.
	 * 
	 * @param descripcio
	 *            la descripció
	 * @param volum
	 *            el volum
	 * @param contenidor
	 *            el contenidor
	 */
	public Mercaderia(String descripcio, double volum, Contenidor contenidor) {
		this.descripcio = descripcio;
		this.volum = volum;
		this.contenidor = contenidor;
	}

	/**
	 * obtenir la descripció de la mercaderia
	 * 
	 * @return la descripció
	 */
	public String getDescripcio() {
		return descripcio;
	}

	/**
	 * assigna la descripció de la mercaderia
	 * 
	 * @param descripcio
	 *            la descripcio de la mercaderia
	 */
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	/**
	 * obtenir el volum de la mercaderia
	 * 
	 * @return el volum de la mercaderia
	 */
	public double getVolum() {
		return this.volum;
	}

	/**
	 * assigna el volum de la mercaderia
	 * 
	 * @param volum
	 *            el volum de la mercaderia
	 */
	public void setVolum(double volum) {
		this.volum = volum;
	}

	/**
	 * obtenir el contenidor on es troba la mercaderia
	 * 
	 * @return el contenidor
	 */
	public Contenidor getContenidor() {
		return contenidor;
	}

	/**
	 * assignar el contenidor on es troba la mercaderia
	 * 
	 * @param contenidor
	 *            el contenidor
	 */
	public void setContenidor(Contenidor contenidor) {
		this.contenidor = contenidor;
	}
}
