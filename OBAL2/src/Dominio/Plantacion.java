package Dominio;

public class Plantacion {

	
	private String nombre;
	
	private Double coordX;
	
	private Double coordY;
	
	private String cedula_productor;
	
	private int capacidad;
	
	
	
	
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




	public String getCedula_productor() {
		return cedula_productor;
	}




	public void setCedula_productor(String cedula_productor) {
		this.cedula_productor = cedula_productor;
	}




	public int getCapacidad() {
		return capacidad;
	}




	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}




	public Plantacion(String nombre, Double coordX, Double coordY, String cedula_productor, int capacidad)
	{
		this.nombre = nombre;
		this.coordX = coordX;
		this.coordY = coordY;
		this.cedula_productor = cedula_productor;
		this.capacidad = capacidad;
	}
	
}
