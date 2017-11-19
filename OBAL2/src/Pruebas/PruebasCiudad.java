package Pruebas;

import org.junit.Test;

import Dominio.Sistema;
import Utiles.Retorno;
import junit.framework.Assert;

public class PruebasCiudad {

	@Test
	public void registrarCiudad() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		
		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO una ciudad
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
	}

	@Test
	public void registrarCiudadEnCoordenadasOcupadas() {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;

		// INICIO EL SISTEMA

		n = 6;
		ret = sis.inicializarSistema(n);

		// REGISTRO una ciudad
		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);

		// INTENTO REGISTRAR UNA CIUDAD EN COORDENADAS OCUPADAS

		ret = sis.registrarCiudad("CiudadB", 100.50, 100.50);

		Assert.assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
	}

}
