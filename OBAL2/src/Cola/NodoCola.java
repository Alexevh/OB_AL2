package Cola;

import Dominio.Punto;
import Grafo.NodoListaAdy;

public class NodoCola {

	
	  NodoListaAdy dato;
	  NodoCola siguiente;
	  
	  
	    
	    public NodoListaAdy getDato() {
		return dato;
	}



	public void setDato(NodoListaAdy dato) {
		this.dato = dato;
	}



	public NodoCola getSiguiente() {
		return siguiente;
	}



	public void setSiguiente(NodoCola siguiente) {
		this.siguiente = siguiente;
	}



		public NodoCola(NodoListaAdy p)
	    {
	        this.dato=p;
	        this.siguiente =null;
	    }
	
}
