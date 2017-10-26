package Grafo;

import ListaAdy.ListaAdy;
import ListaAdy.NodoListaAdy;

public class GrafoLista {

	int size;
	int cantidadNodos;
	
	ListaAdy[] listaAdyacencias;
	
	boolean[] nodosusados;
	
	
	/* Construyo el grafo con una cantidad n de vertices posibles pero en si esta vacio
	 * */
	public GrafoLista(int n) {
		
		this.size = 0;
		this.cantidadNodos = n;
		this.listaAdyacencias = new ListaAdy[cantidadNodos+1];
		
		for (int i=1; i<this.cantidadNodos; i++)
		{
			this.listaAdyacencias[i]= new ListaAdy();
		}
		
		this.nodosusados = new boolean[cantidadNodos+1];
	}
	
	
	/* Agrego una arista */
	public void agregarArista(int origen, int destino, int peso, Object dato)
	{
		NodoListaAdy nodo = new NodoListaAdy(destino,peso, dato);
		this.listaAdyacencias[origen].insertarInicio(nodo);
	}
	
	
	/* AGrego un vertice */
	public void agregarVerice(int v)
	{
		this.nodosusados[v]=true;
		this.size++;
	}
	
	/* Eliminar una arista */
	public void eliminarArista(int origen, int destino)
	{
		
	}
	
	
}
