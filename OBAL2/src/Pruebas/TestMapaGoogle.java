package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Utiles.Retorno;

public class TestMapaGoogle {

	@Test
	public void testMapaGoogle() {
		
		
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
				ret = sis.registrarSilo("SiloA", -34.91, -56.17, 10);
				System.out.println("REGISTRAR SILO: " + ret.resultado);
				ret = sis.registrarSilo("SiloB", -34.90, -56.17, 20);
				System.out.println("REGISTRAR SILO: " + ret.resultado);
				System.out.println("");
	
				System.out.println(sis.getGrafo().mostrarMapa());
				
	}
	

}
