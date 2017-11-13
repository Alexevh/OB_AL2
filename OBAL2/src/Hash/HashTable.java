package Hash;

import Dominio.Punto;
import Hash.HashNode.Estado;

public class HashTable {

	private int cant;
	private int limite;
	private int tamanio;
	private HashNode[] vectorHash;

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public HashNode[] getVectorHash() {
		return vectorHash;
	}

	public void setVectorHash(HashNode[] vectorHash) {
		this.vectorHash = vectorHash;
	}

	public HashTable(int limite) {
		this.limite = limite;
		this.tamanio = calcTamanio(limite);
		this.cant = 0;
		this.vectorHash = new HashNode[this.tamanio];
		for (int i = 0; i < vectorHash.length; i++) {
			vectorHash[i] = new HashNode(null,-1);
		}
	}

	public void agregar(Punto p) {
		if (cant != limite) {
			int indCoord = getNombreInterno(p.getCoordX(), p.getCoordY());
			int pos = indCoord;
			int i = 1;
			while (vectorHash[pos].estado.equals(Estado.OCUPADO) && i <= tamanio) {
				pos = (indCoord + i) % tamanio;
				i++;
			}
			if (!this.vectorHash[pos].estado.equals(Estado.OCUPADO)) {
				this.vectorHash[pos] = new HashNode(p, pos);
				this.cant++;
			}
		}
	}

	public int eliminar(Double cX, Double cY) {
		int indCoord = getNombreInterno(cX, cY);
		int pos = indCoord;

		Punto p = new Punto(cX, cY);
		int i = 1;

		while (((this.vectorHash[pos].estado.equals(Estado.OCUPADO) && !this.vectorHash[pos].getPunto().equals(p)) || this.vectorHash[pos].estado.equals(Estado.SUPRIMIDO)) && i <= tamanio) {
			pos = (indCoord + i) % tamanio;
			i++;
		}

		if (this.vectorHash[pos].estado.equals(Estado.OCUPADO) && this.vectorHash[pos].getPunto().equals(p)) {
			this.vectorHash[pos] = new HashNode(null,-1,Estado.SUPRIMIDO);
			this.cant--;
			return pos;
		} else {
			return -1;
		}
	}

	public int buscarIndice(Double cX, Double cY) {
		int indCoord = getNombreInterno(cX, cY);
		int pos = indCoord;
		Punto p = new Punto(cX, cY);
		int i = 1;
		while (((this.vectorHash[pos].estado.equals(Estado.OCUPADO) && !this.vectorHash[pos].getPunto().equals(p)) || this.vectorHash[pos].estado.equals(Estado.SUPRIMIDO)) && i <= tamanio) {
			pos = (indCoord + i) % tamanio;
			i++;
		}
		if (this.vectorHash[pos].estado.equals(Estado.OCUPADO) && this.vectorHash[pos].getPunto().equals(p)) {
			return pos;
		} else {
			return -1;
		}
	}

	public int getNombreInterno(Double cX, Double cY) {
		Double resultado = Double.sum(cX, cY);
		resultado = (resultado >= 0) ? resultado * 1000 : resultado * (-1000);

		return resultado.intValue() % tamanio;
	}

	private int calcTamanio(int tamanioBase) {
		while (!esPrimo(++tamanioBase))
			;
		return tamanioBase;
	}

	private boolean esPrimo(int nro) {
		if (nro < 1)
			return false;

		for (int i = 2; i < nro / 2; i++)
			if (nro % i == 0)
				return false;
		return true;
	}
	

}
