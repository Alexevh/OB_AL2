package Pruebas;

import org.junit.Test;

import Dominio.Productor;
import Dominio.Sistema;
import Utiles.Retorno;
import junit.framework.Assert;

public class PruebasProductor {

	
	@Test
	public void compararProductores()
	{
		
		Productor p1 = new Productor("1.111111-1", "ProductorA", "DireccionA", "mailA@mail.com", "091234678");
		Productor p2 = new Productor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		
		int recibido = p1.compareTo(p2);
		int esperado = -1;
		
		Assert.assertEquals(esperado, recibido);
		
	}
	
	
	@Test
	public void RegistrarProductores()
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
		
		/* Registro 2 productores */
		
		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");
		
		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
		
	}
	
	@Test
	public void buscarProductorPorCI()
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
		
		/* Registro 2 productores */
		
		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");
		
		
		/* AHora que tengo dos productores en el arbol busco uno por CI*/
		Productor p = sis.buscarProductor("1.111.111-1");
		
		String nombreEsperado = "ElProductor1";
		String nombreRecibido = p.getNombre();
		
		Assert.assertEquals(nombreEsperado, nombreRecibido);
		
		
		
	}
	
	@Test
	public void listarAscendente()
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
		
		/* Registro 2 productores */
		
		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");
		
		
		sis.getProductoresArbol().listarAscendente();
		
	}
	
	
	@Test
	public void borrarProductor() {
		
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		System.out.println("INICIO EL SISTEMA");
		n = 6;
		ret = sis.inicializarSistema(n);
		System.out.println("INICIALIZACI�N: " + ret.resultado);
		System.out.println("");
		
		/* Registro 2 productores */
		
		// REGISTRO DOS PRODUCTORES
		System.out.println("REGISTRO DOS PRODUCTORES");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Direcci�nA", "mail1@mail.com", "091111111");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Direcci�nA", "mail2@mail.com", "092222222");
		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
		System.out.println("");
		System.out.println("");
		
		/* Vemos cuantos tenemos */
		sis.getProductoresArbol().listarAscendente();
		
		/*Obtengo el productor a borrar*/
		Productor p = sis.getProductoresArbol().buscarPorCedula("1.111.111-1").getDato();
		
		/* Lo eliminino del arbol*/
		sis.getProductoresArbol().borrarElemento(p);
		
		/*Veo que no este mas el prod*/
		sis.getProductoresArbol().listarAscendente();
		
		
		
	}
	
}
