package Hash;

import Dominio.Punto;

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
	
	public HashTable(int limite){
		this.limite = limite;
		this.tamanio = calcTamanio(limite);
		this.cant = 0;
		this.vectorHash = new HashNode[this.tamanio];
		for (int i = 0; i < vectorHash.length; vectorHash[i++] = null);
	}
	
	public void agregar(Punto p, int indiceInterno){
		if(cant != limite){
			int pos = getNombreInterno(p.getCoordX(),p.getCoordY());
			if(this.vectorHash[pos] == null)
				this.vectorHash[pos] = new HashNode(p, indiceInterno);
			else
				this.vectorHash[pos] = new HashNode(p, indiceInterno, this.vectorHash[pos]);
			this.cant++;
		}
	}
	
	public int eliminar(Double cX, Double cY){
		int ind = getNombreInterno(cX, cY);
		if(this.vectorHash[ind] != null){
			Punto p = new Punto(cX,cY);
			int indiceInterno = -1;
			if(this.vectorHash[ind].getPunto().equals(p)){
				indiceInterno = this.vectorHash[ind].getIndiceNodo(); 
				this.vectorHash[ind] = this.vectorHash[ind].getSig();
				this.cant--;
				return indiceInterno;
			}
			else{
				HashNode nodo = this.vectorHash[ind];
				while (nodo.getSig() != null && !nodo.getSig().getPunto().equals(p))
					nodo = nodo.getSig();
				if(nodo.getSig() != null){
					indiceInterno = nodo.getIndiceNodo();
					nodo.setSig(nodo.getSig().getSig());
					this.cant--;
					return indiceInterno;
				}
				else
					return indiceInterno;
			}
		}
		
		
		return -1;
	}
	
	public int buscarIndice(Double cX, Double cY){
		if(this.vectorHash != null){
			Punto p = new Punto(cX, cY);
			HashNode nodo = this.vectorHash[getNombreInterno(cX, cY)];
			
			if(nodo != null){
				while(!nodo.getPunto().equals(p) && nodo.getSig() != null)
					nodo = nodo.getSig();
				if(nodo.getPunto().equals(p))
					return nodo.getIndiceNodo();
			}
		}
		
		return -1;
	}
	
	private int getNombreInterno(Double cX, Double cY){
		Double resultado = Double.sum(cX, cY);
		resultado = (resultado >= 0) ? resultado *1000 : resultado * (-1000);
		 
		return resultado.intValue() % limite;
	}
	
 	
	private int calcTamanio(int tamanioBase){
		while(!esPrimo(++tamanioBase));
		return tamanioBase;
	}
	
	private boolean esPrimo(int nro){
		if(nro < 1)
			return false;
		
		for (int i = 2; i < nro/2; i++)
			if (nro % i == 0)
				return false;
		return true;
	}

	
}
