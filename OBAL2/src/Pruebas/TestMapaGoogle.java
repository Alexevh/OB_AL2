package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
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
				ret = sis.registrarSilo("SiloA", -34.91, -56.17, 10);
				System.out.println("REGISTRAR SILO: " + ret.resultado);
				ret = sis.registrarSilo("SiloB", -34.90, -56.17, 20);
				System.out.println("REGISTRAR SILO: " + ret.resultado);
				System.out.println("");
				
				
				// REGISTRO DOS CIUDADES
				System.out.println("REGISTRO DOS CIUDADES");
				ret = sis.registrarCiudad("CiudadA", -34.89, -56.17);
				System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
				ret = sis.registrarCiudad("CiudadB", -34.88, -56.17);
				System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
				System.out.println("");
	
				// REGISTRO DOS PLANTACIONES
				System.out.println("REGISTRO DOS PLANTACIONES");
				ret = sis.registrarPlantacion("PlantacionA", -34.86, -56.17, "1.111.111-1", 10);
				System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
				ret = sis.registrarPlantacion("PlantacionB", -34.87, -56.17, "2.222.222-2", 15);
				System.out.println("REGISTRAR PLANTACI�N: " + ret.resultado);
				System.out.println("");
				
				
				String recibido = sis.getGrafo().mostrarMapa();
				String esperado = "http://maps.googleapis.com/maps/api/staticmap?center=Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap&&markers=color:red|label:Silo|-34.91, -56.17|label:Silo|-34.90, -56.17";
				System.out.println(recibido);
	}
	

}
