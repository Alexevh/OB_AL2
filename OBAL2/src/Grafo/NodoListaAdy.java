package Grafo;

public class NodoListaAdy {
	public int destino;
	public int peso;
	public NodoListaAdy ant;
	public NodoListaAdy sig;

	public NodoListaAdy() {
		this.destino = -1;
		this.peso = -1;
		this.ant = null;
		this.sig = null;
	}

	public NodoListaAdy(int d, int p) {
		this.destino = d;
		this.peso = p;
		this.ant = null;
		this.sig = null;
	}
	

}
