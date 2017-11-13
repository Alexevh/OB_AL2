package Hash;

import Dominio.Punto;

public class HashNode {
	private Punto punto;
	private int indiceNodo;
	public Estado estado;
	public enum Estado {
		OCUPADO, LIBRE, SUPRIMIDO
	}
	
	public Punto getPunto() {
		return punto;
	}
	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	public int getIndiceNodo() {
		return indiceNodo;
	}
	public void setIndiceNodo(int indiceNodo) {
		this.indiceNodo = indiceNodo;
	}
	
	public HashNode(Punto punto, int ind) {
		this.punto = punto;
		if(punto==null) {
			this.estado = estado.LIBRE;
		}else {
			this.estado = estado.OCUPADO;
		}
		this.indiceNodo = ind;
	}
	
	public HashNode(Punto punto, int ind, Estado estado) {
		this.punto = punto;
		this.estado = estado;
		this.indiceNodo = ind;
	}
	
}
