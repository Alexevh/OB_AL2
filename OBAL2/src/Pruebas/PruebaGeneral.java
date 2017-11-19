package Pruebas;

import Dominio.Punto;
import Dominio.Sistema;
import Grafo.CaminosMinimos;
import Grafo.GrafoLista;
import Interface.ISistema;
import Utiles.Retorno;

public class PruebaGeneral {

	public static void main(String[] args) {
		Retorno ret = new Retorno();
		Sistema sis = Sistema.getInstancia();
		int n = 6;
		
		sis.inicializarSistema(n);
		
		sis.registrarProductor("1.111.111-1", "elProductor", "calle", "mail@mail.com", "097222222");
		sis.registrarProductor("2.222.222-2", "elProductor", "calle", "mail@mail.com", "097222222");
		sis.registrarCiudad("CiudadA", 100.50, 100.50);
		sis.registrarCiudad("CiudadB", 150.50, 150.50);
		sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
		sis.registrarSilo("SiloA", 300.50, 300.50, 10);
		sis.registrarSilo("SiloB", 350.50, 350.50, 20);
		
		Punto p1 = sis.getGrafo().buscarPunto(100.50, 100.50);
		System.out.println(p1.getNombre());
		Punto p2 = sis.getGrafo().buscarPunto(150.50, 150.50);
		System.out.println(p2.getNombre());
		Punto p3 = sis.getGrafo().buscarPunto(200.50, 200.50);
		System.out.println(p3.getNombre());
		Punto p4 = sis.getGrafo().buscarPunto(250.50, 250.50);
		System.out.println(p4.getNombre());
		Punto p5 = sis.getGrafo().buscarPunto(300.50, 300.50);
		System.out.println(p5.getNombre());
		Punto p6 = sis.getGrafo().buscarPunto(350.50, 350.50);
		System.out.println(p6.getNombre());
		

//		// INTENTO INICIAR EL SISTEMA CON N IGUAL A 0
//		System.out.println("INTENTO INICIAR EL SISTEMA CON N IGUAL A 0");
//		n = 0;
//		ret = sis.inicializarSistema(n);
//		System.out.println("INICIALIZACIÓN: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INICIO EL SISTEMA
//		System.out.println("INICIO EL SISTEMA");
//		n = 6;
//		ret = sis.inicializarSistema(n);
//		System.out.println("INICIALIZACIÓN: " + ret.resultado);
//		System.out.println("");
//
//		// INTENTO REGISTRAR UN PRODUCTOR CON FORMATO INCORRECTO DE CEDULA
//		System.out.println("INTENTO REGISTRAR UN PRODUCTOR CON FORMATO INCORRECTO DE CEDULA");
//		ret = sis.registrarProductor("1.111111-1", "ProductorA", "DirecciónA", "mailA@mail.com", "091234678");
//		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INTENTO REGISTRAR UN PRODUCTOR CON FORMATO INCORRECTO DE CELULAR
//		System.out.println("INTENTO REGISTRAR UN PRODUCTOR CON FORMATO INCORRECTO DE CELULAR");
//		ret = sis.registrarProductor("1.111.111-1", "ProductorA", "DirecciónA", "mailA@mail.com", "0912334678");
//		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INTENTO REGISTRAR UN PRODUCTOR CON FORMATO INCORRECTO DE EMAIL
//		System.out.println("INTENTO REGISTRAR UN PRODUCTOR CON FORMATO INCORRECTO DE EMAIL");
//		ret = sis.registrarProductor("1.111.111-1", "ProductorA", "DirecciónA", "mailmail.com", "091234678");
//		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// REGISTRO DOS PRODUCTORES
//		System.out.println("REGISTRO DOS PRODUCTORES");
//		ret = sis.registrarProductor("1.111.111-1", "ElProductor1", "DirecciónA", "mail1@mail.com", "091111111");
//		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
//		ret = sis.registrarProductor("2.222.222-2", "ElProductor2", "DirecciónA", "mail2@mail.com", "092222222");
//		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado);
//		System.out.println("");
//		System.out.println("");
//		
//		// LISTADO DE PRODUCTORES
//		System.out.println("LISTADO DE PRODUCTORES");
//		ret = sis.listadoProductores();
//		System.out.println("PRODUCTORES: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INTENTO REGISTRAR UN PRODUCTOR DE CEDULA YA EXISTENTE
//		System.out.println("INTENTO REGISTRAR AL MISMO PRODUCTOR");
//		ret = sis.registrarProductor("1.111.111-1", "ProductorA", "DirecciónA", "mailA@mail.com", "091234678");
//		System.out.println("REGISTRAR PRODUCTOR: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// REGISTRO DOS CIUDADES
//		System.out.println("REGISTRO DOS CIUDADES");
//		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
//		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
//		ret = sis.registrarCiudad("CiudadB", 150.50, 150.50);
//		System.out.println("REGISTRAR CIUDAD: " + ret.resultado);
//		System.out.println("");
//
//		// INTENTO REGISTRAR UNA CIUDAD EN COORDENADAS OCUPADAS
//		System.out.println("INTENTO REGISTRAR UNA CIUDAD EN COORDENADAS OCUPADAS");
//		ret = sis.registrarCiudad("CiudadA", 100.50, 100.50);
//		System.out.println("REGISTRAR CIUDAD: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// REGISTRO DOS PLANTACIONES
//		System.out.println("REGISTRO DOS PLANTACIONES");
//		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
//		System.out.println("REGISTRAR PLANTACIÓN: " + ret.resultado);
//		ret = sis.registrarPlantacion("PlantacionB", 250.50, 250.50, "2.222.222-2", 15);
//		System.out.println("REGISTRAR PLANTACIÓN: " + ret.resultado);
//		System.out.println("");
//
//		// INTENTO REGISTRAR UNA PLANTACIÓN EN COORDENADAS OCUPADAS
//		System.out.println("INTENTO REGISTRAR UNA PLANTACIÓN EN COORDENADAS OCUPADAS");
//		ret = sis.registrarPlantacion("PlantacionA", 200.50, 200.50, "1.111.111-1", 10);
//		System.out.println("REGISTRAR PLANTACIÓN: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INTENTO REGISTRAR UNA PLANTACIÓN CON CAPACIDAD IGUAL A 0
//		System.out.println("INTENTO REGISTRAR UNA PLANTACIÓN CON CAPACIDAD IGUAL A 0");
//		ret = sis.registrarPlantacion("PlantacionB", 300.50, 300.50, "1.111.111-1", 0);
//		System.out.println("REGISTRAR PLANTACIÓN: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INTENTO REGISTRAR UN SILO CON CAPACIDAD IGUAL A 0
//		System.out.println("INTENTO REGISTRAR UN SILO CON CAPACIDAD IGUAL A 0");
//		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 0);
//		System.out.println("REGISTRAR SILO: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INTENTO REGISTRAR UN SILO EN COORDENADAS OCUPADAS
//		System.out.println("INTENTO REGISTRAR UN SILO EN COORDENADAS OCUPADAS");
//		ret = sis.registrarSilo("SiloA", 200.50, 200.50, 10);
//		System.out.println("REGISTRAR SILO: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// REGISTRO DOS SILOS
//		System.out.println("REGISTRO DOS SILOS");
//		ret = sis.registrarSilo("SiloA", 300.50, 300.50, 10);
//		System.out.println("REGISTRAR SILO: " + ret.resultado);
//		ret = sis.registrarSilo("SiloB", 350.50, 350.50, 20);
//		System.out.println("REGISTRAR SILO: " + ret.resultado);
//		System.out.println("");
//
//		// INTENTO REGISTRAR UN PUNTO MÁS DE LA CAPACIDAD DEL SISTEMA
//		System.out.println("INTENTO REGISTRAR UN PUNTO MÁS DE LA CAPACIDAD DEL SISTEMA");
//		ret = sis.registrarSilo("SiloC", 400.50, 400.50, 10);
//		System.out.println("REGISTRAR SILO: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// REGISTRO TRAMO CON PESO 0
//		System.out.println("REGISTRO TRAMO CON PESO 0");
//		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 0);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 0 AL 1
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(100.50, 100.50, 150.50, 150.50, 8);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 0 AL 5
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(100.50, 100.50, 350.50, 350.50, 9);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 1 AL 4
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(150.50, 150.50, 300.50, 300.50, 7);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 1 AL 2
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(150.50, 150.50, 200.50, 200.50, 5);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 2 AL 3
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(200.50, 200.50, 250.50, 250.50, 3);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 3 AL 4
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(250.50, 250.50, 300.50, 300.50, 1);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 4 AL 5
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(300.50, 300.50, 350.50, 350.50, 2);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// REGISTRO TRAMO DEL PUNTO 0 AL 4
//		System.out.println("REGISTRO TRAMO");
//		ret = sis.registrarTramo(100.50, 100.50, 300.50, 300.50, 10);
//		System.out.println("REGISTRAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// ELIMINO UN TRAMO
//		System.out.println("ELIMINO UN TRAMO");
//		ret = sis.eliminarTramo(100.50, 100.50, 300.50, 300.50);
//		System.out.println("ELIMINAR TRAMO: " + ret.resultado);
//		System.out.println("");
//
//		// INTENTO ELIMINAR UN TRAMO INEXISTENTE
//		System.out.println("INTENTO ELIMINAR UN TRAMO INEXISTENTE");
//		ret = sis.eliminarTramo(100.50, 100.50, 250.50, 250.50);
//		System.out.println("ELIMINAR TRAMO: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// INTENTO ELIMINAR UN TRAMO DONDE NO EXISTE UNO DE LOS PUNTOS
//		System.out.println("INTENTO ELIMINAR UN TRAMO DONDE NO EXISTE UNO DE LOS PUNTOS");
//		ret = sis.eliminarTramo(120.50, 120.50, 150.50, 150.50);
//		System.out.println("ELIMINAR TRAMO: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");

//		// LISTADO DE PRODUCTORES
//		System.out.println("LISTADO DE PRODUCTORES");
//		ret = sis.listadoProductores();
//		System.out.println("PRODUCTORES: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// LISTADO DE SILOS
//		System.out.println("LISTADO DE SILOS");
//		ret = sis.listadoDeSilos();
//		System.out.println("SILOS: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// RUTA AL SILO MAS CERCANO DESDE PLANTACIÓN 2 (CON 15 DE CAPACIDAD REQUERIDA)
//		System.out.println("RUTA AL SILO MAS CERCANO DESDE PLANTACIÓN 2 (CON 15 DE CAPACIDAD REQUERIDA)");
//		ret = sis.rutaASiloMasCercano(250.50, 250.50);
//		System.out.println("RUTA: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//		
//		// RUTA AL SILO MAS CERCANO DESDE PLANTACIÓN 1 (CON 10 DE CAPACIDAD REQUERIDA)
//		System.out.println("RUTA AL SILO MAS CERCANO DESDE PLANTACIÓN 1 (CON 10 DE CAPACIDAD REQUERIDA)");
//		ret = sis.rutaASiloMasCercano(200.50, 200.50);
//		System.out.println("RUTA: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//		
//		// RUTA AL SILO MAS CERCANO DESDE PLANTACIÓN 1 (CON 10 DE CAPACIDAD REQUERIDA) PERO CON SILOS SIN CAPACIDAD SUFICIENTE
//		System.out.println("RUTA AL SILO MAS CERCANO DESDE PLANTACIÓN 1 (CON 10 DE CAPACIDAD REQUERIDA) PERO CON SILOS SIN CAPACIDAD SUFICIENTE");
//		ret = sis.rutaASiloMasCercano(200.50, 200.50);
//		System.out.println("RUTA: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// RUTA AL SILO MAS CON COORDENADAS DE UN PUNTO QUE NO ES PLANTACIÓN O QUE NO EXISTE
//		System.out.println("RUTA AL SILO MAS CON COORDENADAS DE UN PUNTO QUE NO ES PLANTACIÓN");
//		ret = sis.rutaASiloMasCercano(300.50, 300.50);
//		System.out.println("RUTA: " + ret.resultado + " [" + ret.valorString + "]");
//		System.out.println("");
//
//		// DESTRUIR EL SISTEMA
//		System.out.println("DESTRUIR EL SISTEMA");
//		ret = sis.destruirSistema();
//		System.out.println("DESTRUCCIÓN: " + ret.resultado);
//		System.out.println("");
	}

}
