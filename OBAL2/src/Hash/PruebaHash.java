package Hash;

import Dominio.Punto;

public class PruebaHash {

	public static void main(String[] args) {
		
		HashTable HT = new HashTable(10);

		
		Punto p1 = new Punto(200.00,200.00);
		Punto p2 = new Punto(300.00,200.00);
		Punto p3 = new Punto(400.00,200.00);
		Punto p4 = new Punto(500.00,200.00);
		Punto p5 = new Punto(600.00,200.00);
		HT.agregar(p1);
		HT.agregar(p2);
		HT.agregar(p3);
		HT.agregar(p4);
		HT.agregar(p5);
		
		HT.eliminar(p2.getCoordX(),p2.getCoordY());
		System.out.println(HT.buscarIndice(200.00, 200.00));
		System.out.println(HT.buscarIndice(300.00, 200.00));
		System.out.println(HT.buscarIndice(400.00, 200.00));
		System.out.println(HT.buscarIndice(500.00, 200.00));
		System.out.println(HT.buscarIndice(600.00, 200.00));
	
	}

}
