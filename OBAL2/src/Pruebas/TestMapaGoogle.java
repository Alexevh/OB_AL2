package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dominio.Punto;
import Dominio.Sistema;
import Dominio.Sistema.TipoPunto;
import Grafo.CaminosMinimos;
import Utiles.Retorno;
import junit.framework.Assert;

public class TestMapaGoogle {

	@SuppressWarnings("deprecation")
	@Test
	public void testMapaGoogle() {
		
		
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		
		n = 160;
		ret = sis.inicializarSistema(n);
	
		// REGISTRO DOS PRODUCTORES
				
				ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
				
				ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
				
		
		// REGISTRO DOS SILOS
				
				ret = sis.registrarSilo("SiloA", -34.1, -56.17, 10);
			
				ret = sis.registrarSilo("SiloB", -34.90, -55.17, 20);
				
				
				
			
				ret = sis.registrarCiudad("Salto", -31.23, -57.57);
				
				ret = sis.registrarCiudad("CiudadB", -34.88, -56.17);
				
	
				// REGISTRO DOS PLANTACIONES
				
				ret = sis.registrarPlantacion("PlantacionA", -33.13, -54.22, "1.111.111-1", 10);
				
				ret = sis.registrarPlantacion("PlantacionB", -31.28, -57.50, "2.222.222-2", 15);
				
				ret = Sistema.getInstancia().mapaEstado();
				Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
			
	}
	

	@Test
	public void testPlantaciona20kmCiudad()
	{
		
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		
		n = 200;
		ret = sis.inicializarSistema(n);

		
		// REGISTRO DOS CIUDADES
		
		ret = sis.registrarCiudad("Salto", -31.23, -57.57);
		
		ret = sis.registrarCiudad("CiudadB", -34.88, -56.17);
		

		// REGISTRO DOS PRODUCTORES
				
				ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
			
				ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
				
		
		// REGISTRO  PLANTACIONES
	
		ret = sis.registrarPlantacion("PlantacionDaiman", -30.56, -57.31, "1.111.111-1", 10);
		
		ret = sis.registrarPlantacion("PlantacionB", -31.30, -58.01, "2.222.222-2", 15);
		
		ret = sis.registrarPlantacion("PlantacionC", -34.58, -56.50, "2.222.222-2", 19);
		
		// INTENTO REGISTRAR UN SILO
	
		ret = sis.registrarSilo("SiloA", -31.50, -57.30, 10);
	
		
		

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 8KM
		
		ret = sis.registrarTramo(-31.50, -57.30, -30.56, -57.31, 8);
	
		
		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 15KM
		
		ret = sis.registrarTramo(-31.50, -57.30, -31.30, -58.01, 15);
		
		
		
		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 25KM
			
				ret = sis.registrarTramo(-31.50, -57.30, -34.58, -56.50, 25);
			
				

		
		String mapa = sis.getGrafo().listadoDePlantacionesEnCiudad(-31.50, -57.30);
		System.out.println(mapa);
		

		
	
		
	}
	
	
	
}
