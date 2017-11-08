package Hash;

import Dominio.Punto;

public class HashNode {
	private Punto punto;
	private int indiceNodo;
	private HashNode sig;
	
	public Punto getPunto() {
		return punto;
	}
	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	public HashNode getSig() {
		return sig;
	}
	public void setSig(HashNode sig) {
		this.sig = sig;
	}
	public int getIndiceNodo() {
		return indiceNodo;
	}
	public void setIndiceNodo(int indiceNodo) {
		this.indiceNodo = indiceNodo;
	}
	
	public HashNode(Punto punto, int ind) {
		this.punto = punto;
		this.indiceNodo = ind;
		this.sig = null;
	}
	
	public HashNode(Punto punto, int ind, HashNode sig) {
		this.punto = punto;
		this.indiceNodo = ind;
		this.sig = sig;
	}
	
}
