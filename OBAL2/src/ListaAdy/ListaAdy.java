package ListaAdy;

public class ListaAdy {
	NodoListaAdy inicio;
	
	public ListaAdy() {
		this.inicio = null;
	}
	
	
	public void insertarInicio(NodoListaAdy nodo) {
		if(nodo != null) {
			nodo.sig = inicio;
			inicio = nodo;
		}
	}
	
	public void insertarFinalRec(int d, int p, Object dato) {		
		if(inicio == null) {
			inicio = new NodoListaAdy(d, p, dato);
		}
		else {
			insertarFRec(d,p,inicio);
		}
	}
	
	public void insertarFRec(int d, int p, NodoListaAdy nodo) {
		if(nodo.sig == null) {
			nodo.sig = new NodoListaAdy(d,p, nodo.dato);
		}
		else {
			insertarFRec(d,p,nodo.sig);
		}
	}
	
	public boolean estaOrdenado() {
		return false;
	}
	
	public boolean estaOrdenadaRec(NodoListaAdy nodo) {
		return false;
	}
	
}
