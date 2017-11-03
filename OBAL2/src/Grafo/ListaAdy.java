package Grafo;

public class ListaAdy {
	private int cantidad;
	NodoListaAdy inicio;

	public ListaAdy() {
		this.inicio = null;
	}

	public void insertar(int destino, int peso) {
		if (destino >= 0 && peso >= 0) {
			NodoListaAdy nodo = new NodoListaAdy(destino, peso);
			if(inicio != null) {
				inicio.ant = nodo;
				nodo.sig = inicio;
			}
			inicio = nodo;
			cantidad++;
		}
	}
	
	public int getCantidad() {
		return cantidad;
	}

	// public void insertarFinalRec(int d, int p) {
	// if (inicio == null) {
	// inicio = new NodoListaAdy(d, p);
	// } else {
	// insertarFRec(d, p, inicio);
	// }
	// }
	//
	// public void insertarFRec(int d, int p, NodoListaAdy nodo) {
	// if (nodo.sig == null) {
	// nodo.sig = new NodoListaAdy(d, p);
	// } else {
	// insertarFRec(d, p, nodo.sig);
	// }
	// }

	public boolean pertenece(int posPunto) {
		NodoListaAdy nodo = inicio;
		boolean encontrado = false;
		while (nodo != null && !encontrado) {
			if (nodo.destino == posPunto) {
				encontrado = true;
			}else {
				nodo = nodo.sig;
			}
		}
		return encontrado;
	}
	
	public int buscarPeso(int posPunto) {
		NodoListaAdy nodo = buscarNodo(posPunto);
		if(nodo==null) {
			return -1;
		}else {
			return nodo.peso;
		}
	}

	public NodoListaAdy buscarNodo(int posPunto) {
		NodoListaAdy nodo = inicio;
		NodoListaAdy nodoRet = null;
		boolean encontre = false;
		while(nodo != null && !encontre) {
			if(nodo.destino==posPunto) {
				nodoRet = nodo;
				encontre = true;
			}
			nodo = nodo.sig;
		}
		return nodoRet;
	}

	public void eliminar(int d) {
		if (inicio != null) {
			NodoListaAdy nodo = inicio;

			while (nodo.destino != d && nodo != null) {
				nodo = nodo.sig;
			}

			if (nodo != null) {
				unir(nodo.ant, nodo.sig);
				nodo = null;
				cantidad--;
			}
		}
	}

	public void destruir() {
		NodoListaAdy nodo = inicio;
		NodoListaAdy nodoAux = nodo;

		while (nodo != null) {
			nodoAux = nodo;
			nodo = nodo.sig;
			nodoAux = null;
			cantidad--;
		}
	}

	public void unir(NodoListaAdy nodoA, NodoListaAdy nodoB) {
		if(nodoA != null) {
			nodoA.sig = nodoB;
			if(nodoB != null) {
				nodoB.ant = nodoA;
			}
		}
	}
}
