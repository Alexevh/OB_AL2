package Pruebas;

import org.junit.Test;

import Dominio.Sistema;
import Utiles.Retorno;
import junit.framework.Assert;

public class PruebasSistema {

	
	@Test
	public void obtenerInstanciaSistema()
	{
	
		Sistema sis = Sistema.getInstancia();
		boolean tengoSistema = sis!=null;
		Assert.assertEquals(true, tengoSistema);
	}
	
	
	@Test
	public void destruirSistema() {
		
		Sistema sis = Sistema.getInstancia();
		
		Retorno ret = new Retorno();
		
		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		int n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");
		// DESTRUIR EL SISTEMA
				System.out.println("DESTRUIR EL SISTEMA");
				ret = sis.destruirSistema();
				System.out.println("DESTRUCCI�N: " + ret.resultado);
				System.out.println("");
				
	Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
		
	}
	
}
