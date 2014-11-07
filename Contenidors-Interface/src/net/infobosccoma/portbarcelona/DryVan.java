/*
 * DryVan.java        
 *
 * 
 * Licensed under Creative Commons License, 
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 * 
 *          http://creativecommons.org/licenses/by-nc-sa/4.0
 */
package net.infobosccoma.portbarcelona;
/**
 * Classe DryVan, que hereta de Contenidor i implementa 
 * la interface Inspeccionalbe
 * 
 * Modela les dades d'un contenidor tipus DryVan
 * 
 * @author Marc Nicolau
 * @version 1.01 05/11/2014
 */
public class DryVan extends Contenidor implements Inspeccionable{
	/**
	 * atribut color
	 */
	private String color;
	
	/**
	 * Crea un objecte DryVan indicant el número de sèrie, la quantitat
	 * màxima de mercaderies i el seu color
	 *
	 * @param numSerie el número de sèrie del contenidor
	 * @param maxCapacity la quantitat màxima de mercaderies
	 * @param color el color del contenidor
	 */
	public DryVan(String numSerie, double maxCapacity, String color) {
		super(numSerie, maxCapacity);
		this.color = color;
	}
	
	/**
	 * obté el color del contenidor
	 * 
	 * @return el color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * assigna el color del contenidor
	 * 
	 * @param color el color que es vol assignar
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * indica si el contenidor es pot carregar
	 * 
	 * @return true si es pot carregar, false en cas contrari
	 */	
	public boolean esPotCarregar() {
		return !this.color.toUpperCase().equals("NEGRE");
	}
}
