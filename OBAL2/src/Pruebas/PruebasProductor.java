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
		Productor p2 = new Productor("2.222.222-2", "ElProductor2", "Calle123", "mail2@mail.com", "092222222");
		
		int recibido = p1.compareTo(p2);
		int esperado = 1;
		
		Assert.assertEquals(esperado, recibido);
		
		
	}
	
	
	@Test
	public void RegistrarProductores()
	{

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
	
		n = 6;
		ret = sis.inicializarSistema(n);
		
		
		/* Registro 2 productores */
		
		// REGISTRO DOS PRODUCTORES
		
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Calle123", "mail1@mail.com", "091111111");
		
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Calle123", "mail2@mail.com", "092222222");
		;
		
		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
		
	}
	
	@Test
	public void buscarProductorPorCI()
	{
		

		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
	
		n = 6;
		ret = sis.inicializarSistema(n);
		
		
		/* Registro 2 productores */
		
		// REGISTRO DOS PRODUCTORES
		
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Calle123", "mail1@mail.com", "091111111");
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Calle123", "mail2@mail.com", "092222222");
		
		
		
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
		
		n = 6;
		ret = sis.inicializarSistema(n);
		
		// REGISTRO PRODUCTORES
		
		sis.registrarProductor("4.444.444-4", "ElProductor4", "Calle123", "mail2@mail.com", "094444444");
		sis.registrarProductor("8.888.888-8", "ElProductor8", "Calle123", "mail2@mail.com", "098888888");
		sis.registrarProductor("1.111.111-1", "ElProductor1", "Calle123", "mail1@mail.com", "091111111");
		sis.registrarProductor("2.222.222-2", "ElProductor2", "Calle123", "mail2@mail.com", "092222222");
		sis.registrarProductor("5.555.555-5", "ElProductor5", "Calle123", "mail2@mail.com", "095555555");
		sis.registrarProductor("6.666.666-6", "ElProductor6", "Calle123", "mail2@mail.com", "096666666");
		sis.registrarProductor("7.777.777-7", "ElProductor7", "Calle123", "mail2@mail.com", "097777777");
		sis.registrarProductor("3.333.333-3", "ElProductor3", "Calle123", "mail2@mail.com", "093333333");
		
		ret = sis.listadoProductores();
		
		String esperado = "1.111.111-1;ElProductor1;091111111|2.222.222-2;ElProductor2;092222222|3.333.333-3;ElProductor3;093333333|4.444.444-4;ElProductor4;094444444|5.555.555-5;ElProductor5;095555555|6.666.666-6;ElProductor6;096666666|7.777.777-7;ElProductor7;097777777|8.888.888-8;ElProductor8;098888888|";
		
		Assert.assertEquals(Retorno.Resultado.OK, ret.resultado);
		Assert.assertEquals(ret.valorString, esperado);
		
	}
	
	
	@Test
	public void registrarProductorCedulaExistente()
	{
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		
		n = 6;
		ret = sis.inicializarSistema(n);
		
		
		/* Registro 2 productores */
		
		// REGISTRO DOS PRODUCTORES
		
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Calle123", "mail1@mail.com", "091111111");
	
		ret = sis.registrarProductor("1.111.111-1", "ElProductor2", "Calle123", "mail2@mail.com", "092222222");
	
		
		
		Assert.assertEquals(Retorno.Resultado.ERROR_4, ret.resultado);
	}
	
	
	
	@Test
	public void borrarProductor() {
		
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n;
		
		// INICIO EL SISTEMA
		
		n = 6;
		ret = sis.inicializarSistema(n);
		
		/* Registro 2 productores */
		
		// REGISTRO PRODUCTORES
		ret = sis.registrarProductor("4.444.444-4", "ElProductor4", "Calle123", "mail2@mail.com", "094444444");
		ret = sis.registrarProductor("8.888.888-8", "ElProductor8", "Calle123", "mail2@mail.com", "098888888");
		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "Calle123", "mail1@mail.com", "091111111");
		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "Calle123", "mail2@mail.com", "092222222");
		ret = sis.registrarProductor("5.555.555-5", "ElProductor5", "Calle123", "mail2@mail.com", "095555555");
		ret = sis.registrarProductor("6.666.666-6", "ElProductor6", "Calle123", "mail2@mail.com", "096666666");
		ret = sis.registrarProductor("7.777.777-7", "ElProductor7", "Calle123", "mail2@mail.com", "097777777");
		ret = sis.registrarProductor("3.333.333-3", "ElProductor3", "Calle123", "mail2@mail.com", "093333333");
		
	
		
		/* Vemos cuantos tenemos */
		sis.getProductoresArbol().listarAscendente();
		
		/*Obtengo el productor a borrar*/
		Productor p = sis.getProductoresArbol().buscarPorCedula("4.444.444-4").getDato();
		
		/* Lo eliminino del arbol*/
		sis.getProductoresArbol().borrarElemento(p);
		
		/*Veo que no este mas el prod*/
		sis.getProductoresArbol().listarAscendente();
		
		
		
	}
	
}
