package Grafo;

import java.util.ArrayList;

import Dominio.Punto;
import Dominio.Sistema;

public class GrafoLista {

	private int cantidadActual;
	private int cantidadMaxima;
	private ListaAdy[] listaAdyacencias;
	private Punto[] puntos;

	/* Construir el grafo con una cantidad n de vértices posibles */
	public GrafoLista(int cantidad) {

		this.cantidadActual = 0;
		this.cantidadMaxima = cantidad;
		this.listaAdyacencias = new ListaAdy[cantidad];

		for (int i = 0; i < cantidad; i++) {
			this.listaAdyacencias[i] = new ListaAdy();
		}
		this.puntos = new Punto[cantidad];
	}

	public Punto[] getPuntos() {
		return puntos;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	/* Deuelve true si el grafo está lleno */
	public boolean estaLleno() {
		return cantidadActual == cantidadMaxima;
	}

	/* Agregar una arista/tramo */
	public void agregarTramo(Punto puntoA, Punto puntoB, int peso, boolean dirigido) {
		int origen = buscarIndice(puntoA);
		int destino = buscarIndice(puntoB);
		agregarTramo(origen, destino, peso, dirigido);
	}

	public void agregarTramo(int origen, int destino, int peso, boolean dirigido) {
		listaAdyacencias[origen].insertar(destino, peso);
		if (!dirigido) {
			listaAdyacencias[destino].insertar(origen, peso);
		}
	}

	/* Eliminar una arista/tramo */
	public void eliminarTramo(Punto puntoA, Punto puntoB, boolean dirigido) {
		int origen = buscarIndice(puntoA);
		int destino = buscarIndice(puntoB);
		eliminarTramo(origen, destino, dirigido);
	}

	public void eliminarTramo(int origen, int destino, boolean dirigido) {
		listaAdyacencias[origen].eliminar(destino);
		if (!dirigido) {
			listaAdyacencias[destino].eliminar(origen);
		}
	}

	/* Agregar un vértice/punto */
	public void agregarPunto(Punto punto) {
		int i = buscarIndice();
		if (i >= 0) {
			puntos[i] = punto;
			cantidadActual++;
		}
	}

	/* Eliminar un vértice */
	public void eliminarPunto(Punto punto) {
		int i = buscarIndice(punto);
		if (puntos[i] != null) {
			listaAdyacencias[i].destruir();
			listaAdyacencias[i] = new ListaAdy();
			puntos[i] = null;
			cantidadActual--;
		}
	}

	/*
	 * Destruir el grafo, destruye el array de listas de adyacencia y el array de
	 * vértices/puntos
	 */
	public void destruir() {
		for (int i = 1; i < cantidadMaxima; i++) {
			listaAdyacencias[i].destruir();
			puntos[i] = null;
		}
		cantidadActual = 0;
		cantidadMaxima = 0;
	}

	/* Buscar un punto por coordenadas en el array de puntos */
	public Punto buscarPunto(Double coordX, Double coordY) {
		Punto pAux = new Punto(coordX, coordY);
		for (Punto p : puntos) {
			if (p.equals(pAux)) {
				return p;
			}
		}
		return null;
	}

	/*
	 * Buscar el índice de un lugar libre en el array de puntos. Devuelve -1 si el
	 * array está lleno.
	 */
	private int buscarIndice() {
		int i = 0;
		if (estaLleno()) {
			i = -1;
		} else {
			boolean encontre = false;
			while (i < cantidadMaxima && !encontre) {
				if (puntos[i] == null) {
					encontre = true;
				} else {
					i++;
				}
			}
		}
		return i;
	}

	/* Buscar el índice de un Punto específico. Devuelve -1 si no se encontró. */
	public int buscarIndice(Punto p) {
		int i = 0;
		boolean encontre = false;
		while (i < cantidadMaxima && !encontre) {
			if (p.equals(puntos[i])) {
				encontre = true;
			} else {
				i++;
			}
		}
		if (!encontre) {
			i = -1;
		}
		return i;
	}

	/*
	 * Buscar peso de un tramo entre dos puntos. Devuelve -1 si el tramo no existe.
	 */
	public int buscarTramo(Punto puntoA, Punto puntoB) {
		int origen = buscarIndice(puntoA);
		int destino = buscarIndice(puntoB);
		return buscarTramo(origen, destino);
	}

	public int buscarTramo(int origen, int destino) {
		return listaAdyacencias[origen].buscarPeso(destino);
	}

	/* Buscar todos los puntos de un tipo específico. */
	public ArrayList<Punto> buscarPuntosPorTipo(Sistema.TipoPunto tipo) {
		ArrayList<Punto> puntosFiltrados = new ArrayList();
		for (Punto p : puntos) {
			if (p.getTipo().equals(tipo)) {
				puntosFiltrados.add(p);
			}
		}
		return puntosFiltrados;
	}
	
//	/* Buscar caminos mínimos desde un vértice/punto */
//	public CaminosMinimos buscarCaminosMinimos(Punto p) {
//		int origen = buscarIndice(p);
//		if (origen >= 0) {
//			return buscarCaminosMinimos(origen);
//		}
//		return null;
//	}
//
//	public CaminosMinimos buscarCaminosMinimos(int origen) {
//		boolean[] visitados = new boolean[cantidadMaxima];
//		int[] costos = new int[cantidadMaxima];
//		int[] predec = new int[cantidadMaxima];
//		predec[origen] = -1;
//		visitados[origen] = true;
//
//		for (int i = 0; i < cantidadMaxima; i++) {
//			if (sonAdyacentes(origen, i)) {
//				costos[i] = buscarTramo(origen, i);
//				predec[i] = origen;
//			} else {
//				costos[i] = Integer.MAX_VALUE;
//			}
//		}
//
//		for (int k = 0; k < cantidadMaxima; k++) {
//			int v = buscarPuntoSinVisitarConCostoMinimo(costos, visitados);
//			visitados[v] = true;
//
//			NodoListaAdy w = listaAdyacencias[v].inicio;
//			while (w != null) {
//				if (!visitados[w.destino] && w.peso + costos[v] < costos[w.destino]) {
//					costos[w.destino] = costos[v] + w.peso;
//					predec[w.destino] = v;
//				}
//				w = w.sig;
//			}
//		}
//
//		CaminosMinimos caminos = new CaminosMinimos(costos, predec);
//		return caminos;
//	}
//	public int buscarPuntoSinVisitarConCostoMinimo(int[] costos, boolean[] visitados) {
//		int costoMin = Integer.MAX_VALUE;
//		int indicePunto = -1;
//		for (int i = 0; i < visitados.length; i++) {
//			if (!visitados[i]) {
//				if (costos[i] < costoMin) {
//					costoMin = costos[i];
//					indicePunto = i;
//				}
//			}
//		}
//		return indicePunto;
//	}
	

	/* Buscar si dos vertices/puntos son adyacentes */
	public boolean sonAdyacentes(Punto puntoA, Punto puntoB) {
		int a = buscarIndice(puntoA);
		int b = buscarIndice(puntoB);
		return sonAdyacentes(a, b);
	}

	public boolean sonAdyacentes(int a, int b) {
		return this.listaAdyacencias[a].pertenece(b);
	}

}
