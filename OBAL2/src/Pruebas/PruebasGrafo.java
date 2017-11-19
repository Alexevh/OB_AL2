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

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS CIUDADES

		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);

		// REGISTRO DOS SILOS

		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);

		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1

		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);

		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);

	}

	@Test
	public void registrarTramoPesoCero() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS CIUDADES

		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);

		// REGISTRO DOS SILOS

		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);

		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);

		// REGISTRO TRAMO CON PESO 0

		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 0);

		Assert.assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

	}

	@Test
	public void eliminarUnTramo() {

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS CIUDADES

		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);

		// REGISTRO DOS SILOS

		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);

		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1

		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);

		// ELIMINO UN TRAMO

		ret = sis.eliminarTramo(100.50, 100.50, 150.50, 150.50);

		Assert.assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void eliminarUnTramoInexistente() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS CIUDADES

		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);

		// REGISTRO DOS SILOS

		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);

		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1

		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);

		// ELIMINO UN TRAMO

		ret = sis.eliminarTramo(100.50, 100.50, 150.50, 151.50);

		Assert.assertEquals(Resultado.ERROR_1, ret.resultado);
	}

	@Test
	public void rutaAlSiloMasCercanoConCapacidad() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS CIUDADES

		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);

		// REGISTRO DOS SILOS

		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);

		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1

		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);

		// REGISTRO TRAMO DEL PUNTO 0 AL 5

		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 9);

		// REGISTRO TRAMO DEL PUNTO 1 AL 4

		ret = sis.registrarTramo(150.50, 150.50, 300.50, 300.50, 7);

		// REGISTRO TRAMO DEL PUNTO 1 AL 2

		ret = sis.registrarTramo(150.50, 150.50, 200.50, 200.50, 5);

		// REGISTRO TRAMO DEL PUNTO 2 AL 3

		ret = sis.registrarTramo(200.50, 200.50, 250.50, 250.50, 3);

		// REGISTRO TRAMO DEL PUNTO 3 AL 4

		ret = sis.registrarTramo(250.50, 250.50, 300.50, 300.50, 1);

		// REGISTRO TRAMO DEL PUNTO 4 AL 5

		ret = sis.registrarTramo(300.50, 300.50, 350.50, 350.50, 2);

		// REGISTRO TRAMO DEL PUNTO 0 AL 4

		ret = sis.registrarTramo(100.50, 100.50, 300.50, 300.50, 10);

		ret = sis.rutaASiloMasCercano(250.50, 250.50);

		Assert.assertEquals(Resultado.OK, ret.resultado);

	}

	@Test
	public void rutaAsiloMasCercanoPeroSinCapcidadSuficiente() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS CIUDADES

		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 20);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 30);

		// REGISTRO DOS SILOS

		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);

		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 15);

		// REGISTRO TRAMO DEL PUNTO 0 AL 1

		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);

		// REGISTRO TRAMO DEL PUNTO 0 AL 5

		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 9);

		// REGISTRO TRAMO DEL PUNTO 1 AL 4

		ret = sis.registrarTramo(150.50, 150.50, 300.50, 300.50, 7);

		// REGISTRO TRAMO DEL PUNTO 1 AL 2

		ret = sis.registrarTramo(150.50, 150.50, 200.50, 200.50, 5);

		// REGISTRO TRAMO DEL PUNTO 2 AL 3

		ret = sis.registrarTramo(200.50, 200.50, 250.50, 250.50, 3);

		// REGISTRO TRAMO DEL PUNTO 3 AL 4

		ret = sis.registrarTramo(250.50, 250.50, 300.50, 300.50, 1);

		// REGISTRO TRAMO DEL PUNTO 4 AL 5

		ret = sis.registrarTramo(300.50, 300.50, 350.50, 350.50, 2);

		// REGISTRO TRAMO DEL PUNTO 0 AL 4

		ret = sis.registrarTramo(100.50, 100.50, 300.50, 300.50, 10);

		// RUTA AL SILO MAS CERCANO DESDE PLANTACI�N 1 (CON 10 DE CAPACIDAD REQUERIDA)
		// PERO CON SILOS SIN CAPACIDAD SUFICIENTE
		ret = sis.rutaASiloMasCercano(200.50, 200.50);

		Assert.assertEquals(Resultado.ERROR_2, ret.resultado);
	}

}
