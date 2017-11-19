package Hash;

import Dominio.Punto;

public class PruebaHash {

	public static void main(String[] args) {

		HashTable HT = new HashTable(10);

		Punto p1 = new Punto(200.00, 200.00);
		Punto p2 = new Punto(300.00, 200.00);
		Punto p3 = new Punto(400.00, 200.00);
		Punto p4 = new Punto(500.00, 200.00);
		Punto p5 = new Punto(600.00, 200.00);
		HT.agregar(p1);
		HT.agregar(p2);
		HT.agregar(p3);
		HT.agregar(p4);
		HT.agregar(p5);

		System.out.println(HT.getVectorHash()[0].estado);
		System.out.println(HT.getVectorHash()[1].estado);
		System.out.println(HT.getVectorHash()[2].estado);
		System.out.println(HT.getVectorHash()[3].estado);
		System.out.println(HT.getVectorHash()[4].estado);
		System.out.println(HT.getVectorHash()[5].estado);
		System.out.println(HT.getVectorHash()[6].estado);
		System.out.println(HT.getVectorHash()[7].estado);
		System.out.println(HT.getVectorHash()[8].estado);
		System.out.println(HT.getVectorHash()[9].estado);

		HT.eliminar(p3.getCoordX(), p3.getCoordY());

		System.out.println(HT.buscarIndice(200.00, 200.00));
		System.out.println(HT.buscarIndice(300.00, 200.00));
		System.out.println(HT.buscarIndice(400.00, 200.00));
		System.out.println(HT.buscarIndice(500.00, 200.00));
		System.out.println(HT.buscarIndice(600.00, 200.00));
		System.out.println("-----------------------------");
		System.out.println(HT.getNombreInterno(200.00, 200.00));
		System.out.println(HT.getNombreInterno(300.00, 200.00));
		System.out.println(HT.getNombreInterno(400.00, 200.00));
		System.out.println(HT.getNombreInterno(500.00, 200.00));
		System.out.println(HT.getNombreInterno(600.00, 200.00));

		Punto p = HT.buscarPunto(300.00, 200.00);
		System.out.println(p.getCoordX());

	}

}
