package Arbol;

import java.util.ArrayList;

import Dominio.Productor;
import Dominio.Punto;

public class Arbol {

	private NodoArbol raiz;

	public NodoArbol getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol raiz) {
		this.raiz = raiz;
	}

	/* Insertamos un elemento de manera ordenada */
	public void insertar(Productor x) {
		if (this.raiz == null) {
			NodoArbol nodo = new NodoArbol(x);
			raiz = nodo;
		} else {
			insertarElemento(x, raiz);
		}

	}

	/* Funcion recursiva que lo inserta */
	private void insertarElemento(Productor x, NodoArbol n) {

		/**/
		if (n.getDato().compareTo(x) == -1) {
			if (n.getNodoIzq() == null) {
				n.setNodoIzq(new NodoArbol(x));
			} else {
				insertarElemento(x, n.getNodoIzq());
			}

		} else {
			if (n.getNodoDer() == null) {
				n.setNodoDer(new NodoArbol(x));
			} else {
				insertarElemento(x, n.getNodoDer());
			}
		}

	}

	/* Saber si pertenece */

	public boolean pertenece(Productor x) {
		return pertenece(x, this.raiz);
	}

	/* Recursiva para saber si pertenece o no */
	public boolean pertenece(Productor x, NodoArbol n) {
		if (n == null) {
			return false;
		}

		if (n.getDato() == x) {
			return true;
		}

		if (n.getDato().compareTo(x) == -1) {
			return pertenece(x, n.getNodoIzq());
		} else {
			return pertenece(x, n.getNodoDer());
		}

	}

	/* Listar Ascendente -In order - */
	public ArrayList<String> listarAscendente() {
		if (this.esVacio()) {
			return null;
		} else {
			ArrayList<String> lista = new ArrayList();
			listarAscendente(this.raiz,lista);
			
			return lista;
		}
	}

	/* Recursiva para listar ascendente */
	private void listarAscendente(NodoArbol n,ArrayList<String> listaAux) {
		if (n != null) {
			listarAscendente(n.getNodoIzq(),listaAux);
			listaAux.add(n.getDato().getCedula() + ";" + n.getDato().getNombre() + ";" + n.getDato().getCelular() + "|");
			listarAscendente(n.getNodoDer(),listaAux);
		}
	}
	
	/* Destruir Arbol */
	public void destruirArbol() {
		if (raiz != null) {
			destruir(this.raiz);
			
		}
	}
	
	/* destruir recursivamente nodo por nodo */
	private void destruir(NodoArbol n) {
		if (n != null) {
			destruir(n.getNodoIzq());
			destruir(n.getNodoDer());
			n = null;			
		}
	}

	private boolean esVacio() {
		return raiz == null;
	}

	private void borrarMinimo() {
		raiz = eliminarMin(raiz);
	}

	private NodoArbol eliminarMin(NodoArbol a) {
		if (a == null) {
			return a;
		}

		if (a.getNodoIzq() != null) {
			a.setNodoIzq(eliminarMin(a.getNodoIzq()));
			return a;
		} else {
			return a.getNodoDer();
		}

	}

	/* Buscar por cedula */
	/* Metodo axuliar para buscar un elemtno con una firma */
	public NodoArbol buscarPorCedula(String elemento) {

		return buscar(raiz, elemento);
	}

	/* Buscar un nodo en el arbol */
	public NodoArbol buscar(NodoArbol a, String dato) {

		/*
		 * Casos base, si el nodo es null devolvemos null , pero si el nodo contiene el
		 * dato que estamos buscando devolvemos el dato
		 */
		if (a == null) {
			return a;
		}
		if (a.getDato().getCedula() == dato) {
			return a;

		}

		/*
		 * Recursiva La busqueda es sencilla, Creamos un nodoarbol llamado retorno y le
		 * asignamos el resultado de buscar dandole el nodoizquierdo como primer
		 * paramtero y el dato a buscar como el segundo. Si es null hacemos un return de
		 * la misma funcion pero con el derecho.
		 * 
		 */
		NodoArbol retorno = buscar(a.getNodoIzq(), dato);
		if (retorno == null) {
			return buscar(a.getNodoDer(), dato);
		} else {
			return retorno;
		}

	}

	/* Buscar un nodo en el arbol */
	public NodoArbol buscar(NodoArbol a, Productor dato) {

		/*
		 * Casos base, si el nodo es null devolvemos null , pero si el nodo contiene el
		 * dato que estamos buscando devolvemos el dato
		 */
		if (a == null) {
			return a;
		}
		if (a.getDato() == dato) {
			return a;

		}

		/*
		 * Recursiva La busqueda es sencilla, Creamos un nodoarbol llamado retorno y le
		 * asignamos el resultado de buscar dandole el nodoizquierdo como primer
		 * paramtero y el dato a buscar como el segundo. Si es null hacemos un return de
		 * la misma funcion pero con el derecho.
		 * 
		 */
		NodoArbol retorno = buscar(a.getNodoIzq(), dato);
		if (retorno == null) {
			return buscar(a.getNodoDer(), dato);
		} else {
			return retorno;
		}

	}

	/* Metodo axuliar para buscar un elemtno con una firma */
	private NodoArbol buscar(Productor elemento) {
		return buscar(raiz, elemento);
	}

	public boolean borrarElemento(Productor elem) {
		NodoArbol auxiliar = raiz;
		NodoArbol padre = raiz;

		boolean esHijoIzq = true;

		while (auxiliar.getDato() != elem) {
			padre = auxiliar;
			if (elem.compareTo(auxiliar.getDato()) == 1) {
				esHijoIzq = true;
				auxiliar = auxiliar.getNodoIzq();
			} else {
				esHijoIzq = false;
				auxiliar = auxiliar.getNodoDer();
			}

			if (auxiliar == null) {
				return false;
			}
		}

		/* El nodo es Hoja o unico nodo */
		if (auxiliar.getNodoIzq() == null && auxiliar.getNodoDer() == null) {
			if (auxiliar.getDato() == raiz.getDato()) {
				raiz = null;
			} else if (esHijoIzq) {
				padre.setNodoIzq(null);
			} else {
				padre.setNodoDer(null);
			}
		} else if (auxiliar.getNodoDer() == null) {
			if (auxiliar == raiz) {
				raiz = auxiliar.getNodoIzq();
			} else if (esHijoIzq) {
				padre.setNodoIzq(auxiliar.getNodoIzq());
			} else {
				padre.setNodoDer(auxiliar.getNodoIzq());
			}
		} else if (auxiliar.getNodoIzq() == null) {

			if (auxiliar == raiz) {
				raiz = auxiliar.getNodoDer();
			} else if (esHijoIzq) {
				padre.setNodoIzq(auxiliar.getNodoDer());
			} else {
				padre.setNodoDer(auxiliar.getNodoDer());
			}

		} else {
			NodoArbol reemplazo = obtenerNodoReemplazo(auxiliar);
			if (auxiliar == raiz) {
				raiz = reemplazo;
			} else if (esHijoIzq) {
				padre.setNodoIzq(reemplazo);
			} else {
				padre.setNodoDer(reemplazo);
			}

			reemplazo.setNodoIzq(auxiliar.getNodoIzq());
		}

		return true;
	}

	public NodoArbol obtenerNodoReemplazo(NodoArbol nodo) {
		NodoArbol reemplazarPadre = nodo;
		NodoArbol reemplazo = nodo;
		NodoArbol aux = nodo.getNodoDer();

		while (aux != null) {
			reemplazarPadre = reemplazo;
			reemplazo = aux;
			aux = aux.getNodoIzq();
		}

		if (reemplazo != nodo.getNodoDer()) {
			reemplazarPadre.setNodoIzq(reemplazo.getNodoDer());
			reemplazo.setNodoDer(nodo.getNodoDer());

		}

		return reemplazo;
	}

	/*
	 * public void borrarElemento(Productor elem) { NodoArbol aBorrar =
	 * buscar(elem);
	 * 
	 * NodoArbol aPadre = buscar(raiz.getDato());
	 * 
	 * 
	 * 
	 * if (aPadre.getNodoIzq()==aBorrar) { if (aBorrar.getNodoDer()==null) {
	 * aPadre.setNodoIzq(null); } else { aPadre.setNodoIzq(aBorrar.getNodoDer()); }
	 * 
	 * 
	 * } else {
	 * 
	 * NodoArbol hnoAnterior = aPadre.getNodoIzq(); NodoArbol aux =
	 * aPadre.getNodoIzq();
	 * 
	 * while (aux!=aBorrar) { //ACA AUX PUEDE SER NULL hnoAnterior=aux;
	 * 
	 * if (aux.getNodoDer()!=null) { aux = aux.getNodoDer(); }
	 * 
	 * }
	 * 
	 * hnoAnterior.setNodoDer(aBorrar.getNodoDer()); //hnoAnterior.setNodoDer(null);
	 * } }
	 * 
	 */

	// private NodoArbol borrarElemento (Productor x, NodoArbol a) {
	// if( a == null )
	// return a;
	// if( x.getCedula().compareTo(a.getDato().getCedula()) == -1)
	// a.setNodoIzq(borrarElemento(x, a.getNodoIzq()));
	// else if( x.getCedula().compareTo(a.getDato().getCedula()) == 1)
	// a.setNodoDer(borrarElemento(x, a.getNodoDer()));
	// else {
	// if( a.getNodoIzq() != null && a.getNodoDer() != null ) {
	//

	// a.setDato(a.getNodoDer().minimo());
	// a.setDer(a.getNodoDer().eliminarMin());
	// }
	// else
	// if (a.getNodoIzq() != null)
	// a = a.getNodoIzq();
	// else
	// a = a.getNodoDer();
	// }
	// return a;
	// }

}
