package Pruebas;

import org.junit.Test;

import Dominio.Sistema;
import Utiles.Retorno;
import junit.framework.Assert;

public class PruebaSilo {

	@Test
	public void agregarSilo()
	{
		
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
	
		n = 6;
		ret = sis.inicializarSistema(n);
		

		// REGISTRO DOS SILOS
	
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		
		
		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
		
	}
	
	
	@Test
	public void registrarSiloenCoordOcupadas() {
		
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		
		n = 6;
		ret = sis.inicializarSistema(n);
		
		

		// REGISTRO DOS SILOS
		
		ret = sis.registrarSilo("SiloA", 200.50, 200.50, 10);
		
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		
		
		// INTENTO REGISTRAR UN SILO EN COORDENADAS OCUPADAS
		
		ret = sis.registrarSilo("SiloA", 200.50, 200.50, 10);
		
		
		
		Assert.assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
	}
	
	
	@Test
	public void registrarSiloSinCapacidad()
	{
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		
		n = 6;
		ret = sis.inicializarSistema(n);
		
		
		
		// INTENTO REGISTRAR UN SILO CON CAPACIDAD IGUAL A 0
				
				ret = sis.registrarSilo("SiloA", 300.50, 300.50, 0);
				
				
				
				Assert.assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
	}
	
}


