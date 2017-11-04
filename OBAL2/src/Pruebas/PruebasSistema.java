package Pruebas;

import org.junit.Test;

import Dominio.Sistema;
import junit.framework.Assert;

public class PruebasSistema {

	
	@Test
	public void obtenerInstanciaSistema()
	{
	
		Sistema sis = Sistema.getInstancia();
		boolean tengoSistema = sis!=null;
		Assert.assertEquals(true, tengoSistema);
	}
	
}
