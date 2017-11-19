package Dominio;

import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;

import Arbol.Arbol;
import Dominio.Productor;
import Dominio.Sistema.TipoPunto;
import Grafo.CaminosMinimos;
import Grafo.GrafoLista;
import Interface.ISistema;
import Utiles.Retorno;
import Utiles.Retorno.Resultado;
import Utiles.Utilidades;

public class Sistema implements ISistema {

	private Arbol productoresArbol;

	private GrafoLista grafo;

	private static Sistema instancia;

	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}



	public Productor buscarProductor(String cedula_productor) {

		Productor p;
		try {
			p = this.productoresArbol.buscarPorCedula(cedula_productor).getDato();

		} catch (Exception e) {
			return null;
		}

		return p;
	}

	public enum TipoPunto {
		CIUDAD, PLANTACION, SILO
	}

	/* Para probar Caminos M�nimos. ELIMINAR PARA LA ENTREGA */
	public GrafoLista getGrafo() {
		return grafo;
	}

	public Arbol getProductoresArbol() {
		return productoresArbol;
	}

	public void setProductoresArbol(Arbol productoresArbol) {
		this.productoresArbol = productoresArbol;
	}

	public void setGrafo(GrafoLista grafo) {
		this.grafo = grafo;
	}

	public static void setInstancia(Sistema instancia) {
		Sistema.instancia = instancia;
	}

	@Override
	public Retorno inicializarSistema(int cantPuntos) {
		Retorno ret = new Retorno();
		if (cantPuntos <= 0) {
			ret.valorString = "Error: cantPuntos debe ser mayor a 0.";
			ret.resultado = Resultado.ERROR_1;
		} else {
			instancia = getInstancia();
			instancia.grafo = new GrafoLista(cantPuntos);
			instancia.productoresArbol = new Arbol();
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

	@Override
	public Retorno destruirSistema() {
		Retorno ret = new Retorno();

		instancia.grafo.destruir();
		instancia.grafo = null;
		instancia.productoresArbol.destruirArbol();
		instancia.productoresArbol = null;
		ret.resultado = Resultado.OK;

		return ret;
	}

	@Override
	public Retorno registrarProductor(String cedula, String nombre, String direccion, String email, String celular) {
		Retorno ret = new Retorno();

		if (!Utilidades.validarCedula(cedula)) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: " + cedula + " no comple con el formato de c�dula N.NNN.NNN-N.";
		} else if (!Utilidades.validarTelefono(celular)) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "Error: " + celular + " no comple con el formato de celular 09NNNNNNN.";
		} else if (!Utilidades.validarEmail(email)) {
			ret.resultado = Resultado.ERROR_3;
			ret.valorString = "Error: " + email + " no comple con el formato de direcciones de e-mail.";
		} else if (buscarProductor(cedula) != null) {
			ret.resultado = Resultado.ERROR_4;
			ret.valorString = "Error: ya existe un productor de c�dula " + cedula + ".";
		} else {
			instancia.productoresArbol.insertar(new Productor(cedula, nombre, direccion, email, celular));
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		if (grafo.estaLleno()) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: capacidad m�xima alcanzada.";
		} else if (grafo.buscarPunto(coordX, coordY) != null) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "Error: ya existe un punto en las coordenadas " + coordX + " y " + coordY + ".";
		} else {
			Ciudad ciudad = new Ciudad(nombre, coordX, coordY);
			grafo.agregarPunto(ciudad);
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

	@Override
	public Retorno registrarPlantacion(String nombre, Double coordX, Double coordY, String cedula_productor,
			int capacidad) {
		Retorno ret = new Retorno();

		if (grafo.estaLleno()) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: capacidad m�xima alcanzada.";
		} else if (capacidad <= 0) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "Error: capacidad debe ser mayor a 0.";
		} else if (grafo.buscarPunto(coordX, coordY) != null) {
			ret.resultado = Resultado.ERROR_3;
			ret.valorString = "Error: ya existe un punto en las coordenadas " + coordX + " y " + coordY + ".";
		} else {
			Productor productor = buscarProductor(cedula_productor);
			if (productor == null) {
				ret.resultado = Resultado.ERROR_4;
				ret.valorString = "Error: no existe un productor de c�dula " + cedula_productor + ".";
			} else {
				Plantacion plantacion = new Plantacion(nombre, coordX, coordY, productor, capacidad);
				grafo.agregarPunto(plantacion);
				ret.resultado = Resultado.OK;
			}
		}

		return ret;
	}

	@Override
	public Retorno registrarSilo(String nombre, Double coordX, Double coordY, int capacidad) {
		Retorno ret = new Retorno();

		if (grafo.estaLleno()) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: capacidad m�xima alcanzada.";
		} else if (capacidad <= 0) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "Error: capacidad debe ser mayor a 0.";
		} else if (grafo.buscarPunto(coordX, coordY) != null) {
			ret.resultado = Resultado.ERROR_3;
			ret.valorString = "Error: ya existe un punto en las coordenadas " + coordX + " y " + coordY + ".";
		} else {
			Silo silo = new Silo(nombre, coordX, coordY, capacidad);
			grafo.agregarPunto(silo);
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int peso) {
		Retorno ret = new Retorno();
		Punto puntoA = grafo.buscarPunto(coordXi, coordYi);
		Punto puntoB = grafo.buscarPunto(coordXf, coordYf);

		if (peso <= 0) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: peso debe ser mayor a 0.";
		} else if (puntoA == null) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "Error: el punto de coordenadas " + coordXi + " y " + coordYi + " no existe.";
		} else if (puntoB == null) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "Error: el punto de coordenadas " + coordXf + " y " + coordYf + " no existe.";
		} else if (grafo.buscarTramo(puntoA, puntoB) > 0) {
			ret.resultado = Resultado.ERROR_3;
			ret.valorString = "Error: ya existe un tramo entre las coordenadas " + coordXi + "/" + coordYi + " y "
					+ coordXf + "/" + coordYf + ".";
		} else {
			grafo.agregarTramo(puntoA, puntoB, peso, false);
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		Retorno ret = new Retorno();
		Punto puntoA = grafo.buscarPunto(coordXi, coordYi);
		Punto puntoB = grafo.buscarPunto(coordXf, coordYf);
		
		
		

		if (puntoA == null) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: el punto de coordenadas " + coordXi + " y " + coordYi + " no existe.";
		} else if (puntoB == null) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: el punto de coordenadas " + coordXf + " y " + coordYf + " no existe.";
		} else if (grafo.buscarTramo(puntoA, puntoB) == -1) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "Error: no existe un tramo entre las coordenadas " + coordXi + "/" + coordYi + " y "
					+ coordXf + "/" + coordYf + ".";
		} else {
			grafo.eliminarTramo(puntoA, puntoB, false);
			ret.resultado = Resultado.OK;
		}
		
		

		return ret;
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		Punto punto = grafo.buscarPunto(coordX, coordY);
		if (punto == null) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: el punto de coordenadas " + coordX + " y " + coordY + " no existe.";
		} else {
			grafo.eliminarPunto(punto);
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

	@Override
	public Retorno mapaEstado() {
		Retorno ret = new Retorno();

		String urlMapa = "http://maps.googleapis.com/maps/api/staticmap?center=Durazno,Uruguay&zoom=7&size=2400x1200&maptype=roadmap&";

		ArrayList<Punto> ListaSilos = instancia.grafo.buscarPuntosPorTipo(Sistema.TipoPunto.SILO);
		ArrayList<Punto> ListaCiudades = instancia.grafo.buscarPuntosPorTipo(Sistema.TipoPunto.CIUDAD);
		ArrayList<Punto> ListaPlantacion = instancia.grafo.buscarPuntosPorTipo(Sistema.TipoPunto.PLANTACION);

		for (Punto p : ListaSilos) {

			urlMapa += "&markers=color:green%7Clabel:Silo%7C" + p.getCoordX().toString() + ","
					+ p.getCoordY().toString();
		}

		for (Punto p : ListaCiudades) {

			urlMapa += "&markers=color:red%7Clabel:Ciudad%7C" + p.getCoordX().toString() + ","
					+ p.getCoordY().toString();
		}

		for (Punto p : ListaPlantacion) {

			urlMapa += "&markers=color:yellow%7Clabel:Plantacion%7C" + p.getCoordX().toString() + ","
					+ p.getCoordY().toString();
		}

		try {
			Desktop.getDesktop().browse(new URL(urlMapa).toURI());
			ret.resultado = Retorno.Resultado.OK;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public Retorno rutaASiloMasCercano(Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		Punto punto = grafo.buscarPunto(coordX, coordY);

		if (punto == null || !punto.getTipo().equals(TipoPunto.PLANTACION)) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "Error: no exite una plantaci�n en las coordenadas " + coordX + " y " + coordY + ".";
		} else {
			Plantacion plantacion = (Plantacion) punto;
			int capacidadRequerida = plantacion.getCapacidad();

			CaminosMinimos caminos = grafo.buscarCaminosMinimos(plantacion, capacidadRequerida);
			if (caminos.getObjetivo() == -1) {
				ret.resultado = Resultado.ERROR_2;
				ret.valorString = "Error: no exite un silo que pueda en este momento contener la capacidad requerida.";
			} else {
				Silo silo = (Silo) grafo.buscarPunto(caminos.getObjetivo());

				silo.reservar(capacidadRequerida);
				ArrayList<Integer> resInverso = caminos.resultadoOrdenadoInverso();
				String resString = "";
				Punto p;
				for (int i = 0; i < resInverso.size(); i++) {
					p = grafo.buscarPunto(resInverso.get(i));
					resString = p.getCoordX() + ";" + p.getCoordY() + "|" + resString;
				}

				ret.resultado = Resultado.OK;
				ret.valorString = resString;
			}
		}

		return ret;
	}

	@Override
	public Retorno listadoDePlantacionesEnCiudad(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
       
		String urlMapa = "";

		Punto p = instancia.grafo.buscarPunto(coordX, coordY);
		CaminosMinimos caminos;
		
		try {
		 caminos = instancia.grafo.buscarCaminosMinimosPlantacion(p, 20);
		} catch (Exception e)
		{
			/*Puede dar null, si es null tiramos error*/
			ret.resultado = Resultado.ERROR_1;
			return ret;
		}
			
	
		
		for (int i = 0; i < caminos.getCostos().length; i++) {

			try {
				Punto p2 = instancia.getGrafo().getPuntos().getVectorHash()[i].getPunto();
				int[] indiceCostos = caminos.getCostos();
				int indice = indiceCostos[i];

				if (p2.getTipo().equals(TipoPunto.PLANTACION) && indice < 20) {
					urlMapa += p2.getCoordX().toString() + ";" + p2.getCoordY().toString() + "|";
				
				}
				
				ret.resultado = Resultado.OK;
			} catch (Exception e) {
				ret.resultado = Resultado.ERROR_1;
			}

		}

	
		return ret;
	}

	@Override
	public Retorno listadoDeSilos() {
		Retorno ret = new Retorno();
		String listado = "";
		ArrayList<Punto> puntosFiltrados = grafo.buscarPuntosPorTipo(TipoPunto.SILO);
		Silo s;
		for (Punto p : puntosFiltrados) {
			s = (Silo) p;
			listado += s.getCoordX() + ";" + s.getCoordY() + ";" + s.getCapacidad() + ";" + s.getCapacidadRemanente()
					+ "|";
		}

		ret.valorString = listado;
		ret.resultado = Resultado.OK;

		return ret;
	}

	@Override
	public Retorno listadoProductores() {
		Retorno ret = new Retorno();

		String listado = productoresArbol.listarAscendente();

		ret.valorString = listado;
		ret.resultado = Resultado.OK;

		return ret;
	}
	

}
