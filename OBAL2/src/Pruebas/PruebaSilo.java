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
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");
		

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");
		
		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
		
	}
	
	
	@Test
	public void registrarSiloenCoordOcupadas() {
		
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");
		

		// REGISTRO DOS SILOS
		System.out.println("REGISTRO DOS SILOS");
		ret = sis.registrarSilo("SiloA", 200.50, 200.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		System.out.println("REGISTRAR SILO: " + ret.resultado);
		System.out.println("");
		
		// INTENTO REGISTRAR UN SILO EN COORDENADAS OCUPADAS
		System.out.println("INTENTO REGISTRAR UN SILO EN COORDENADAS OCUPADAS");
		ret = sis.registrarSilo("SiloA", 200.50, 200.50, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado + " [" + ret.valorString + "]");
		System.out.println("");
		
		
		Assert.assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
	}
	
	
	@Test
	public void registrarSiloSinCapacidad()
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
		
		
		// INTENTO REGISTRAR UN SILO CON CAPACIDAD IGUAL A 0
				System.out.println("INTENTO REGISTRAR UN SILO CON CAPACIDAD IGUAL A 0");
				ret = sis.registrarSilo("SiloA", 300.50, 300.50, 0);
				System.out.println("REGISTRAR SILO: " + ret.resultado + " [" + ret.valorString + "]");
				System.out.println("");
				
				
				Assert.assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
	}
	
}


