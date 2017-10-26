package Dominio;

public class Ciudad {
	
	private String nombre;
	
	private Double coordX;
	
	private Double coordY;
	
	
	
	
	
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





	public Ciudad(String nombre, Double coordX, Double coordY)
	{
		this.nombre = nombre;
		this.coordX = coordX;
		this.coordY = coordY;
	}

}
