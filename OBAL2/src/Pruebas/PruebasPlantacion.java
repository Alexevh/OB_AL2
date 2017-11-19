package Pruebas;

import org.junit.Test;

import Dominio.Sistema;
import Utiles.Retorno;
import junit.framework.Assert;

public class PruebasPlantacion {

	@Test
	public void registrarPlantacion() {

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);

		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);

	}

	@Test
	public void registrarPlantacionEnCoordenadasOcupadas() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// REGISTRO DOS PLANTACIONES

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);

		// INTENTO REGISTRAR UNA PLANTACI�N EN COORDENADAS OCUPADAS

		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);

		Assert.assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
	}

	@Test
	public void registrarPlantacionCapacidadCero() {

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO DOS PRODUCTORES

		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");

		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");

		// INTENTO REGISTRAR UNA PLANTACI�N CON CAPACIDAD IGUAL A 0

		ret = sis.registrarPlantacion("PlantacionB", 300.50, 300.50, "1.111.111-1", 0);

		Assert.assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
	}

}
