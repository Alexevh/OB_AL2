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
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");
		
		// REGISTRO DOS PRODUCTORES
				System.out.println("REGISTRO DOS PRODUCTORES");
				ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
				System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
				ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
				System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
				System.out.println("");
				System.out.println("");
		
		// REGISTRO DOS SILOS
				System.out.println("REGISTRO DOS SILOS");
				ret = sis.registrarSilo("SiloA", -34.1, -56.17, 10);
				System.out.println("REGISTRAR SILO: " + ret.resultado);
				ret = sis.registrarSilo("SiloB", -34.90, -55.17, 20);
				System.out.println("REGISTRAR SILO: " + ret.resultado);
				System.out.println("");
				
				
				// REGISTRO DOS CIUDADES
				System.out.println("REGISTRO DOS CIUDADES");
				ret = sis.registrarCiudad("Salto", -31.23, -57.57);
				System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
				ret = sis.registrarCiudad("CiudadB", -34.88, -56.17);
				System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
				System.out.println("");
	
				// REGISTRO DOS PLANTACIONES
				System.out.println("REGISTRO DOS PLANTACIONES");
				ret = sis.registrarPlantacion("PlantacionA", -33.13, -54.22, "1.111.111-1", 10);
				System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
				ret = sis.registrarPlantacion("PlantacionB", -31.28, -57.50, "2.222.222-2", 15);
				System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
				System.out.println("");
				
				
				String recibido = sis.getGrafo().mostrarMapa();
				String esperado = "http://maps.googleapis.com/maps/api/staticmap?center=Tacuarembo,Uruguay&zoom=13&size=2400x1200&maptype=roadmap&&markers=color:red|label:Silo|-34.91, -56.17|label:Silo|-34.90, -56.17";
				System.out.println(recibido);
	}
	

	@Test
	public void testPlantaciona20kmCiudad()
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
		
		// REGISTRO DOS CIUDADES
		System.out.println("REGISTRO DOS CIUDADES");
		ret = sis.registrarCiudad("Salto", -31.23, -57.57);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		ret = sis.registrarCiudad("CiudadB", -34.88, -56.17);
		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
		System.out.println("");

		// REGISTRO DOS PRODUCTORES
				System.out.println("REGISTRO DOS PRODUCTORES");
				ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
				System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
				ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
				System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
				System.out.println("");
				System.out.println("");
		
		// REGISTRO DOS PLANTACIONES
		System.out.println("REGISTRO DOS PLANTACIONES");
		ret = sis.registrarPlantacion("PlantacionDaiman", -30.56, -57.31, "1.111.111-1", 10);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		ret = sis.registrarPlantacion("PlantacionB", -31.30, -58.01, "2.222.222-2", 15);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");
		ret = sis.registrarPlantacion("PlantacionC", -34.58, -56.50, "2.222.222-2", 19);
		System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
		System.out.println("");
	
		// INTENTO REGISTRAR UN SILO CON CAPACIDAD IGUAL A 0
		System.out.println("INTENTO REGISTRAR UN SILO CON CAPACIDAD IGUAL A 0");
		ret = sis.registrarSilo("SiloA", -31.50, -57.30, 10);
		System.out.println("REGISTRAR SILO: " + ret.resultado + " [" + ret.valorString + "]");
		System.out.println("");
		
		

		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 8KM
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(-31.50, -57.30, -30.56, -57.31, 8);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");
		
		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 15KM
		System.out.println("REGISTRO TRAMO");
		ret = sis.registrarTramo(-31.50, -57.30, -31.30, -58.01, 15);
		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
		System.out.println("");
		
		
		// REGISTRO TRAMO DEL PUNTO 0 AL 1 Salto a una plantacion a 25KM
				System.out.println("REGISTRO TRAMO");
				ret = sis.registrarTramo(-31.50, -57.30, -34.58, -56.50, 25);
				System.out.println("REGISTRAR TRAMO: " + ret.resultado);
				System.out.println("");
				

		
		String mapa = sis.getGrafo().listadoDePlantacionesEnCiudad(-31.50, -57.30);
		System.out.println(mapa);
		

		
	
		
	}
	
	
	
}
