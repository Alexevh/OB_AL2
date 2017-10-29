package Dominio;

import Dominio.Sistema.TipoPunto;

public class Plantacion extends Punto {

	private Productor productor;
	private int capacidad;

	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Plantacion(String nombre, Double coordX, Double coordY, Productor productor, int capacidad) {
		super(nombre,coordX,coordY,TipoPunto.PLANTACION);
		this.productor = productor;
		this.capacidad = capacidad;
	}

}
