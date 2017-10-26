package ListaAdy;

public class NodoListaAdy {
	public int destino;
	public int peso;
	public Object dato;
	
	public NodoListaAdy sig;
	
	public NodoListaAdy() {
		this.destino = -1;
		this.peso = -1;
		this.sig = null;
	}
	
	public NodoListaAdy(int d, int p, Object dato) {
		this.destino = d;
		this.peso = p;
		this.sig = null;
		this.dato = dato;
	}	
	
}
