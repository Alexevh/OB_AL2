package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dominio.Punto;
import Dominio.Sistema;
import Dominio.Sistema.TipoPunto;
import Grafo.CaminosMinimos;
import Utiles.Retorno;
import junit.framework.Assert;

public class TestMapaGoogle {

	@SuppressWarnings("deprecation")
	@Test
	public void testMapaGoogle() {

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		

		// INICIO EL SISTEMA

		n = 6;
		sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS SILOS

		sis.registrarSilo("SiloA", -34.1, -56.17, 10);

		sis.registrarSilo("SiloB", -34.90, -55.17, 20);

		sis.registrarCiudad("Salto", -31.23, -57.57);

		sis.registrarCiudad("CiudadB", -34.88, -56.17);

		// REGISTRO DOS PLANTACIONES

		sis.registrarPlantacion("PlantacionA", -33.13, -54.22, "1.111.111-1", 10);

		sis.registrarPlantacion("PlantacionB", -31.28, -57.50, "2.222.222-2", 15);

		ret = Sistema.getInstancia().mapaEstado();
		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);

	}

	@Test
	public void testPlantaciona20kmCiudad() {

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 8;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS CIUDADES

		sis.registrarCiudad("Salto", -31.23, -57.57);

		sis.registrarCiudad("CiudadB", -34.88, -56.17);

		// REGISTRO DOS PRODUCTORES

		sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO PLANTACIONES

		sis.registrarPlantacion("PlantacionDaiman", -30.56, -57.31, "1.111.111-1", 10);

		sis.registrarPlantacion("PlantacionB", -31.30, -58.01, "2.222.222-2", 15);

		sis.registrarPlantacion("PlantacionC", -34.58, -56.50, "2.222.222-2", 19);

		// INTENTO REGISTRAR UN SILO

		sis.registrarSilo("SiloA", -31.50, -57.30, 10);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 8KM

		sis.registrarTramo(-31.50, -57.30, -30.56, -57.31, 8);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 15KM

		sis.registrarTramo(-31.50, -57.30, -31.30, -58.01, 15);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 25KM

		sis.registrarTramo(-31.50, -57.30, -34.58, -56.50, 25);

		ret = sis.listadoDePlantacionesEnCiudad(-31.50, -57.30);
		String mapa = ret.valorString;
		System.out.println(mapa);

	}
	
	@Test
	public void testPlantaciona20kmCiudadNoExiste() {

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 8;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS CIUDADES

		sis.registrarCiudad("Salto", -31.23, -57.57);

		sis.registrarCiudad("CiudadB", -34.88, -56.17);

		// REGISTRO DOS PRODUCTORES

		sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO PLANTACIONES

		sis.registrarPlantacion("PlantacionDaiman", -30.56, -57.31, "1.111.111-1", 10);

		sis.registrarPlantacion("PlantacionB", -31.30, -58.01, "2.222.222-2", 15);

		sis.registrarPlantacion("PlantacionC", -34.58, -56.50, "2.222.222-2", 19);

		// INTENTO REGISTRAR UN SILO

		sis.registrarSilo("SiloA", -31.50, -57.30, 10);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 8KM

		sis.registrarTramo(-31.50, -57.30, -30.56, -57.31, 8);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 15KM

		sis.registrarTramo(-31.50, -57.30, -31.30, -58.01, 15);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 25KM

		sis.registrarTramo(-31.50, -57.30, -34.58, -56.50, 25);

		assertEquals(Retorno.Resultado.ERROR_1, sis.listadoDePlantacionesEnCiudad(0.0, 0.0).resultado);

	}
	
	

}
