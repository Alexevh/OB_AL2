package Dominio;

public class Productor {

	private String nombre;
	private String cedula;
	private String direccion;
	private String mail;
	private String celular;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Productor(String cedula, String nombre, String direccion, String email, String celular) {

		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.mail = email;
		this.celular = celular;
	}

}
