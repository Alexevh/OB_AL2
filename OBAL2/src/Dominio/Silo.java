package Dominio;

import Dominio.Sistema.TipoPunto;

public class Silo extends Punto {

	private int capacidad;
	private int capacidadRemanente;

	public int getCapacidad() {
		return capacidad;
	}
	
	public int getCapacidadRemanente() {
		return capacidadRemanente;
	}

	public Silo(String nombre, Double coordX, Double coordY, int capacidad) {
		super(nombre,coordX,coordY,TipoPunto.SILO);
		this.capacidad = capacidad;
		this.capacidadRemanente = capacidad;
	}
	
	public boolean tieneCapacidadSuficiente(int capacidadRequerida) {
		return capacidadRemanente >= capacidadRequerida;
	}
	
	public int reservar(int capacidadRequerida) {
		if(!tieneCapacidadSuficiente(capacidadRequerida)) {
			return -1;
		}else {
			capacidadRemanente -= capacidad;
			return capacidadRemanente;
		}
	}
	

}
