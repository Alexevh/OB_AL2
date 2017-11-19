package Cola;

import Dominio.Punto;
import Grafo.NodoListaAdy;

public class Cola {

	NodoCola inicio;
	NodoCola fin;
	int tamano;

	public NodoCola getInicio() {
		return inicio;
	}

	public void setInicio(NodoCola inicio) {
		this.inicio = inicio;
	}

	public NodoCola getFin() {
		return fin;
	}

	public void setFin(NodoCola fin) {
		this.fin = fin;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public Cola() {
		inicio = null;
		fin = null;
		tamano = 0;
	}

	public boolean estaVacia() {
		/* Si inicio es null esta vacia regresa true */
		return inicio == null;
	}

	public void insertar(NodoListaAdy ele) {
		NodoCola nuevo = new NodoCola(ele);
		if (estaVacia()) {
			inicio = nuevo;
		} else {
			fin.siguiente = nuevo;
		}

		/* El fin siempre apunta al nuevo */
		fin = nuevo;
		tamano++;
	}

	public NodoCola quitar() {
		NodoCola aux = inicio;
		inicio = inicio.siguiente;
		tamano--;
		return aux;

	}

	public NodoCola inicoCola() {
		return inicio;
	}

	public int tamanoCola() {
		return tamano;
	}
	

}
