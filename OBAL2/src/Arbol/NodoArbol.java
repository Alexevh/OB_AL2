package Arbol;

import Dominio.Productor;
import Dominio.Punto;

public class NodoArbol {

	private Productor dato;

	private NodoArbol nodoIzq;

	private NodoArbol nodoDer;

	
	public Productor getDato() {
		return dato;
	}

	public void setDato(Productor dato) {
		this.dato = dato;
	}

	public NodoArbol getNodoIzq() {
		return nodoIzq;
	}

	public void setNodoIzq(NodoArbol nodoIzq) {
		this.nodoIzq = nodoIzq;
	}

	public NodoArbol getNodoDer() {
		return nodoDer;
	}

	public void setNodoDer(NodoArbol nodoDer) {
		this.nodoDer = nodoDer;
	}

	public NodoArbol(Productor x) {
		this.dato = x;
	}

}
