package Hash;

import Dominio.Punto;

public class HashNode {
	private Punto punto;
	public Estado estado;

	public enum Estado {
		OCUPADO, LIBRE, SUPRIMIDO
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		if (punto != null) {
			this.punto = punto;
			this.estado = estado.OCUPADO;
		}
	}

	
	public HashNode(Punto punto) {
		this.punto = punto;
		if (punto == null) {
			this.estado = estado.LIBRE;
		} else {
			this.estado = estado.OCUPADO;
		}
	}

	public HashNode(Punto punto, int ind, Estado estado) {
		this.punto = punto;
		this.estado = estado;
	}

	public void vaciar() {
		this.punto = null;
		this.estado = estado.SUPRIMIDO;
	}

}
