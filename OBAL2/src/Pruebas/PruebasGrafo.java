package Pruebas;

import org.junit.Test;

import Dominio.Sistema;
import Utiles.Retorno;
import Utiles.Retorno.Resultado;
import junit.framework.Assert;

public class PruebasGrafo {

	@Test
	public void registrarTramo() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");

		// REGISTRO DOS CIUDADES
		System.out.println("REGISTRO DOS CIUDADES");
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		System.out.println("");
		// REGISTRO DOS PLANTACIONES
		System.out.println("REGISTRO DOS PLANTACIONES");
		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 1
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);

	}

	@Test
	public void registrarTramoPesoCero() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");

		// REGISTRO DOS CIUDADES
		System.out.println("REGISTRO DOS CIUDADES");
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		System.out.println("");
		// REGISTRO DOS PLANTACIONES
		System.out.println("REGISTRO DOS PLANTACIONES");
		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO CON PESO 0
		System.out.println("REGISTRO TRAMO CON PESO 0");
		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 0);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado + " [" + ret.valorString + "]");
		System.out.println("");

		Assert.assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

	}

	@Test
	public void eliminarUnTramo() {

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");

		// REGISTRO DOS CIUDADES
		System.out.println("REGISTRO DOS CIUDADES");
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		System.out.println("");
		// REGISTRO DOS PLANTACIONES
		System.out.println("REGISTRO DOS PLANTACIONES");
		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 1
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// ELIMINO UN TRAMO
		System.out.println("ELIMINO UN TRAMO");
		ret = sis.eliminarTramo(100.50, 100.50, 150.50, 150.50);
		System.out.println("ELIMINAR TRAMO: " + ret.resultado);
		System.out.println("");

		Assert.assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void eliminarUnTramoInexistente() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");

		// REGISTRO DOS CIUDADES
		System.out.println("REGISTRO DOS CIUDADES");
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		System.out.println("");
		// REGISTRO DOS PLANTACIONES
		System.out.println("REGISTRO DOS PLANTACIONES");
		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 1
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// ELIMINO UN TRAMO
		System.out.println("ELIMINO UN TRAMO");
		ret = sis.eliminarTramo(100.50, 100.50, 150.50, 151.50);
		System.out.println("ELIMINAR TRAMO: " + ret.resultado);
		System.out.println("");

		Assert.assertEquals(Resultado.ERROR_1, ret.resultado);
	}

	@Test
	public void rutaAlSiloMasCercanoConCapacidad() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");

		// REGISTRO DOS CIUDADES
		System.out.println("REGISTRO DOS CIUDADES");
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		System.out.println("");
		// REGISTRO DOS PLANTACIONES
		System.out.println("REGISTRO DOS PLANTACIONES");
		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 1
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 5
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 9);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 1 AL 4
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(150.50, 150.50, 300.50, 300.50, 7);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 1 AL 2
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(150.50, 150.50, 200.50, 200.50, 5);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 2 AL 3
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(200.50, 200.50, 250.50, 250.50, 3);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 3 AL 4
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(250.50, 250.50, 300.50, 300.50, 1);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 4 AL 5
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(300.50, 300.50, 350.50, 350.50, 2);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 4
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 300.50, 300.50, 10);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		System.out.println("RUTA AL SILO MAS CERCANO DESDE PLANTACI�N 2 (CON 15 DE CAPACIDAD REQUERIDA)");
		ret = sis.rutaASiloMasCercano(250.50, 250.50);
		System.out.println("RUTA: " + ret.resultado + " [" + ret.valorString + "]");
		System.out.println("");

		Assert.assertEquals(Resultado.OK, ret.resultado);

	}
	
	@Test
	public void rutaAsiloMasCercanoPeroSinCapcidadSuficiente()
	{
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");

		// REGISTRO DOS CIUDADES
		System.out.println("REGISTRO DOS CIUDADES");
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		System.out.println("");
		// REGISTRO DOS PLANTACIONES
		System.out.println("REGISTRO DOS PLANTACIONES");
		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 1
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 5
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 9);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 1 AL 4
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(150.50, 150.50, 300.50, 300.50, 7);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 1 AL 2
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(150.50, 150.50, 200.50, 200.50, 5);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 2 AL 3
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(200.50, 200.50, 250.50, 250.50, 3);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 3 AL 4
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(250.50, 250.50, 300.50, 300.50, 1);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 4 AL 5
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(300.50, 300.50, 350.50, 350.50, 2);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// REGISTRO TRAMO DEL PUNTO 0 AL 4
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(100.50, 100.50, 300.50, 300.50, 10);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");

		// RUTA AL SILO MAS CERCANO DESDE PLANTACI�N 1 (CON 10 DE CAPACIDAD REQUERIDA) PERO CON SILOS SIN CAPACIDAD SUFICIENTE
				System.out.println("RUTA AL SILO MAS CERCANO DESDE PLANTACI�N 1 (CON 10 DE CAPACIDAD REQUERIDA) PERO CON SILOS SIN CAPACIDAD SUFICIENTE");
				ret = sis.rutaASiloMasCercano(200.50, 200.50);
				System.out.println("RUTA: " + ret.resultado + " [" + ret.valorString + "]");
				System.out.println("");

		Assert.assertEquals(Resultado.OK, ret.resultado);
	}

}
