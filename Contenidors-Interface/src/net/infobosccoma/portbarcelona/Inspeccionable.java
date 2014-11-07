/*
 * Inspeccionable.java        
 *
 * 
 * Licensed under Creative Commons License, 
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 * 
 *          http://creativecommons.org/licenses/by-nc-sa/4.0
 */
 package net.infobosccoma.portbarcelona;

 /**
  * Interface Inspeccionable
  * 
  * Defineix un nou tipus amb un mètode. 
  * Descriu la possibilitat de poder carregar o no un contenidor en passar
  * per una inspecció.
  * 
  * @author Marc Nicolau
  * @version 1.00 05/11/2014
  */
  public interface Inspeccionable {
	public boolean esPotCarregar();
}