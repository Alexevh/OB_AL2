package Pruebas;

import org.junit.Test;

import Dominio.Sistema;
import Utiles.Retorno;
import junit.framework.Assert;

public class PruebasSistema {

	@Test
	public void obtenerInstanciaSistema() {

		Sistema sis = Sistema.getInstancia();
		boolean tengoSistema = sis != null;
		Assert.assertEquals(true, tengoSistema);
	}

	@Test
	public void destruirSistema() {

		Sistema sis = Sistema.getInstancia();

		Retorno ret = new Retorno();

		// INICIO EL SISTEMA

		int n = 6;
		ret = sis.inicializarSistema(n);

		// DESTRUIR EL SISTEMA

		ret = sis.destruirSistema();

		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);

	}

}
