package Dominio;

import Dominio.Sistema.TipoPunto;

public class Punto {

	private String nombre;
	private Double coordX;
	private Double coordY;
	private TipoPunto tipo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCoordX() {
		return coordX;
	}

	public void setCoordX(Double coordX) {
		this.coordX = coordX;
	}

	public Double getCoordY() {
		return coordY;
	}

	public void setCoordY(Double coordY) {
		this.coordY = coordY;
	}
	
	public TipoPunto getTipo() {
		return tipo;
	}
	
	public Punto(Double coordX, Double coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Punto(String nombre, Double coordX, Double coordY, TipoPunto tipo) {
		this.nombre = nombre;
		this.coordX = coordX;
		this.coordY = coordY;
		this.tipo = tipo;
	}
	
	public boolean esSiloConCapacidad(int capacidadRequerida) {
		if(this.tipo.equals(TipoPunto.SILO)) {
			Silo s = (Silo)this;
			return s.tieneCapacidadSuficiente(capacidadRequerida);
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		Punto p = (Punto)o;
		return this.coordX.equals(p.getCoordX()) && this.coordY.equals(p.getCoordY());
	}

}
