package Grafo;

import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Cola.Cola;
import Cola.NodoCola;
import Dominio.Punto;
import Dominio.Sistema;
import Dominio.Sistema.TipoPunto;
import Hash.HashTable;
import Utiles.Retorno;

public class GrafoLista {

	private int cantidadActual;
	private int cantidadMaxima;
	private ListaAdy[] listaAdyacencias;
	//private Punto[] puntos;
	private HashTable puntos;

	/* Construir el grafo con una cantidad n de v�rtices posibles */
	public GrafoLista(int cantidad) {

		this.cantidadActual = 0;
		this.cantidadMaxima = cantidad;
		this.listaAdyacencias = new ListaAdy[cantidad];

		for (int i = 0; i < cantidad; i++) {
			this.listaAdyacencias[i] = new ListaAdy();
		}
		
		
		this.puntos = new HashTable(cantidad);
	}

	public HashTable getPuntos() {
		return puntos;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	/* Deuelve true si el grafo est� lleno */
	public boolean estaLleno() {
		return cantidadActual == cantidadMaxima;
	}

	/* Agregar una arista/tramo */
	public void agregarTramo(Punto puntoA, Punto puntoB, int peso, boolean dirigido) {
		int origen = puntos.buscarIndice(puntoA.getCoordX(), puntoA.getCoordY());
		int destino = puntos.buscarIndice(puntoB.getCoordX(), puntoB.getCoordY());
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

	/* Agregar un v�rtice/punto */
	public void agregarPunto(Punto punto) {
		int i = buscarIndice();
		if (i >= 0) {
			puntos.agregar(punto);
			cantidadActual++;
		}
	}

	/* Eliminar un v�rtice */
	public void eliminarPunto(Punto punto) {
		int i = puntos.buscarIndice(punto.getCoordX(), punto.getCoordY());
		if (puntos.getVectorHash()[i] != null) {
			listaAdyacencias[i].destruir();
			listaAdyacencias[i] = new ListaAdy();
			puntos.eliminar(punto.getCoordX(), punto.getCoordY());
			cantidadActual--;
		}
	}

	/*
	 * Destruir el grafo, destruye el array de listas de adyacencia y el array de
	 * v�rtices/puntos
	 */
	public void destruir() {
		for (int i = 1; i < cantidadMaxima; i++) {
			listaAdyacencias[i].destruir();
			puntos.getVectorHash()[i] = null;
		}
		cantidadActual = 0;
		cantidadMaxima = 0;
	}

	/* Buscar un punto por coordenadas en el array de puntos */
	public Punto buscarPunto(Double coordX, Double coordY) {
		Punto pAux = new Punto(coordX, coordY);
		
		
		for (int i=0; i< puntos.getVectorHash().length; i++) {
			if (puntos.getVectorHash()[i].getPunto() != null && puntos.getVectorHash()[i].getPunto().equals(pAux)) {
				return puntos.getVectorHash()[i].getPunto();
			}
		}
		return null;
	}
	public Punto buscarPunto(int indice) {
		if(indice >= 0 && indice < puntos.getVectorHash().length) {
			return puntos.getVectorHash()[indice].getPunto();
		}
		return null;
	}

	/*
	 * Buscar el �ndice de un lugar libre en el array de puntos. Devuelve -1 si el
	 * array est� lleno.
	 */
	private int buscarIndice() {
		int i = 0;
		if (estaLleno()) {
			i = -1;
		} else {
			boolean encontre = false;
			while (i < cantidadMaxima && !encontre) {
				if (puntos.getVectorHash()[i] == null) {
					encontre = true;
				} else {
					i++;
				}
			}
		}
		return i;
	}

	/* Buscar el �ndice de un Punto espec�fico. Devuelve -1 si no se encontr�. */
	public int buscarIndice(Punto p) {
		int i = 0;
		boolean encontre = false;
		while (i < cantidadMaxima && !encontre) {
			if (p.equals(puntos.getVectorHash()[i].getPunto())) {
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
		int origen = puntos.buscarIndice(puntoA.getCoordX(), puntoA.getCoordY());
		int destino = puntos.buscarIndice(puntoB.getCoordX(), puntoB.getCoordY());
		return buscarTramo(origen, destino);
	}

	public int buscarTramo(int origen, int destino) {
		return listaAdyacencias[origen].buscarPeso(destino);
	}

	/* Buscar todos los puntos de un tipo espec�fico. */
	public ArrayList<Punto> buscarPuntosPorTipo(Sistema.TipoPunto tipo) {
		ArrayList<Punto> puntosFiltrados = new ArrayList<Punto>();
		
		
		for (int i=0; i<puntos.getVectorHash().length; i++) {
			try {
				if (puntos.getVectorHash()[i].getPunto().getTipo().equals(tipo)) {
					puntosFiltrados.add(puntos.getVectorHash()[i].getPunto());
				}
			} catch (Exception e)
			{
				
			}
			
		}
		return puntosFiltrados;
	}
	
	
	/* Buscar caminos minimos desde un vertice Ciudad, la idea es  buscar todas las
	 * plantaciones que esten a 20 kilometros o menos de la ciudad o punto de origen */
	public CaminosMinimos buscarCaminosMinimosPlantacion(Punto p, int kilometros) {
		int origen = puntos.buscarIndice(p.getCoordX(), p.getCoordY());
		if (origen >= 0) {
			return buscarCaminosMinimosCiudad(origen, kilometros);
		}
		return null;
	}
	
	public CaminosMinimos buscarCaminosMinimosCiudad(int origen, int km) {
		boolean[] visitados = new boolean[cantidadMaxima];
		int[] costos = new int[cantidadMaxima];
		int[] predec = new int[cantidadMaxima];
		predec[origen] = -1;
		costos[origen] = 0;
		visitados[origen] = true;
		ArrayList<Integer> objetivos = new ArrayList<Integer>();

		for (int i = 0; i < cantidadMaxima; i++) {
			if (i != origen) {
				if (sonAdyacentes(origen, i)) {
					costos[i] = buscarTramo(origen, i);
					predec[i] = origen;
				} else {
					costos[i] = Integer.MAX_VALUE;
				}
			}
		}
		
		int objetivo = -1;
		for (int k = 0; k < cantidadMaxima; k++) {
			int v = buscarPuntoSinVisitarConCostoMinimo(costos, visitados);
			if(v >= 0) {
				visitados[v] = true;
				
				if(puntos.getVectorHash()[v].getPunto().getTipo().equals(TipoPunto.PLANTACION)) {
					objetivo = v;
					objetivos.add(v);
					//break;
					
				}
				/* No entra a este bucle, cuando entre le ponemos que valide menos de KM de distancia*/
				NodoListaAdy w = listaAdyacencias[v].inicio;
				
				
				while (w != null) {
					if (!visitados[w.destino] && w.peso + costos[v] < km) {
						costos[w.destino] = costos[v] + w.peso;
						predec[w.destino] = v;
					}
					w = w.sig;
				}
			}
		}

		CaminosMinimos caminos = new CaminosMinimos(costos, predec);
		caminos.setObjetivo(objetivo);
		return caminos;
	}
	
	
	
	

	/* [DIJKSTRA] Buscar caminos m�nimos desde un v�rtice/punto */
	public CaminosMinimos buscarCaminosMinimos(Punto p, int capacidadRequerida) {
		int origen = puntos.buscarIndice(p.getCoordX(), p.getCoordY());
		if (origen >= 0) {
			return buscarCaminosMinimos(origen, capacidadRequerida);
		}
		return null;
	}

	public CaminosMinimos buscarCaminosMinimos(int origen, int capacidadRequerida) {
		boolean[] visitados = new boolean[cantidadMaxima];
		int[] costos = new int[cantidadMaxima];
		int[] predec = new int[cantidadMaxima];
		predec[origen] = -1;
		costos[origen] = 0;
		visitados[origen] = true;

		for (int i = 0; i < cantidadMaxima; i++) {
			if (i != origen) {
				if (sonAdyacentes(origen, i)) {
					costos[i] = buscarTramo(origen, i);
					predec[i] = origen;
				} else {
					costos[i] = Integer.MAX_VALUE;
				}
			}
		}
		
		int objetivo = -1;
		for (int k = 0; k < cantidadMaxima; k++) {
			int v = buscarPuntoSinVisitarConCostoMinimo(costos, visitados);
			if(v >= 0) {
				visitados[v] = true;
				
				if(puntos.getVectorHash()[v].getPunto().esSiloConCapacidad(capacidadRequerida)) {
					objetivo = v;
					break;
					
				}
				NodoListaAdy w = listaAdyacencias[v].inicio;
				while (w != null) {
					if (!visitados[w.destino] && w.peso + costos[v] < costos[w.destino]) {
						costos[w.destino] = costos[v] + w.peso;
						predec[w.destino] = v;
					}
					w = w.sig;
				}
			}
		}

		CaminosMinimos caminos = new CaminosMinimos(costos, predec);
		caminos.setObjetivo(objetivo);
		return caminos;
	}

	public int buscarPuntoSinVisitarConCostoMinimo(int[] costos, boolean[] visitados) {
		int costoMin = Integer.MAX_VALUE;
		int indicePunto = -1;
		for (int i = 0; i < visitados.length; i++) {
			if (!visitados[i]) {
				if (costos[i] < costoMin) {
					costoMin = costos[i];
					indicePunto = i;
				}
			}
		}
		return indicePunto;
	}

	/* Buscar si dos vertices/puntos son adyacentes */
	public boolean sonAdyacentes(Punto puntoA, Punto puntoB) {
		int a = puntos.buscarIndice(puntoA.getCoordX(), puntoA.getCoordY());
		int b = puntos.buscarIndice(puntoB.getCoordX(), puntoB.getCoordY());
		return sonAdyacentes(a, b);
	}

	public boolean sonAdyacentes(int a, int b) {
		return this.listaAdyacencias[a].pertenece(b);
	}
	
	
	public String mostrarMapa()
	{
		
		String urlMapa = "http://maps.googleapis.com/maps/api/staticmap?center=Durazno,Uruguay&zoom=7&size=2400x1200&maptype=roadmap&";
		
			
		ArrayList<Punto> ListaSilos = buscarPuntosPorTipo(Sistema.TipoPunto.SILO);
		ArrayList<Punto> ListaCiudades = buscarPuntosPorTipo(Sistema.TipoPunto.CIUDAD);
		ArrayList<Punto> ListaPlantacion = buscarPuntosPorTipo(Sistema.TipoPunto.PLANTACION);
		
		for (Punto p: ListaSilos)
		{
			
			urlMapa +="&markers=color:green%7Clabel:Silo%7C"+p.getCoordX().toString()+","+p.getCoordY().toString();
		}
		
		for (Punto p: ListaCiudades)
		{
			
			urlMapa +="&markers=color:red%7Clabel:Ciudad%7C"+p.getCoordX().toString()+","+p.getCoordY().toString();
		}
		
		for (Punto p: ListaPlantacion)
		{
			
			urlMapa +="&markers=color:yellow%7Clabel:Plantacion%7C"+p.getCoordX().toString()+","+p.getCoordY().toString();
		}
		
		
	
		try {
		  Desktop.getDesktop().browse(new URL(urlMapa).toURI());
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		
		return urlMapa;
		
		
		
		
	}
	
	public String listadoDePlantacionesEnCiudad(Double coordX, Double CoordY) {
		
		String urlMapa = "";

		Punto p = buscarPunto(coordX, CoordY);
		
		
		
		CaminosMinimos caminos = buscarCaminosMinimosPlantacion(p, 20);
		
		 for (int i=0; i<caminos.getCostos().length; i++)
		 {
			
			    try {
			    	Punto p2 = puntos.getVectorHash()[i].getPunto();
					 int[] indiceCostos = caminos.getCostos();
					 int indice = indiceCostos[i];
					 
					 if (p2.getTipo().equals(TipoPunto.PLANTACION) && indice < 20)
					 {
						 urlMapa +=p2.getCoordX().toString()+";"+p2.getCoordY().toString()+"|";
					 }
			    } catch (Exception e)
			    {
			    	
			    }
			 	
			
		 }
		
		
		
		
		return urlMapa;
	}
	
public String mapaDePlantacionesEnCiudad(Double coordX, Double CoordY) {
		
		String urlMapa = "http://maps.googleapis.com/maps/api/staticmap?center=Durazno,Uruguay&zoom=7&size=2400x1200&maptype=roadmap&";

		Punto p = buscarPunto(coordX, CoordY);
		
		/* Marco en el mapa la ciudad */
		urlMapa +="&markers=color:red|label:Ciudad|"+p.getCoordX().toString()+","+p.getCoordY().toString();
		
		CaminosMinimos caminos = buscarCaminosMinimosPlantacion(p, 20);
		
		 for (int i=0; i<caminos.getCostos().length; i++)
		 {
			
				 Punto p2 = puntos.getVectorHash()[i].getPunto();
				 int[] indiceCostos = caminos.getCostos();
				 int indice = indiceCostos[i];
				 
				 if (p2.getTipo().equals(TipoPunto.PLANTACION) && indice < 20)
				 {
					 urlMapa +="&markers=color:yellow|label:Plantacion|"+p2.getCoordX().toString()+","+p2.getCoordY().toString();
				 }
			
		 }
		
		
		
		
		return urlMapa;
	}
	
	

}
