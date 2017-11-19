package Dominio;

import Dominio.Sistema.TipoPunto;

public class Ciudad extends Punto {

	public Ciudad(String nombre, Double coordX, Double coordY) {
		super(nombre,coordX,coordY,TipoPunto.CIUDAD);
	}
	

}
