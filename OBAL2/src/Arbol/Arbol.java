package Arbol;

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
    public void insertar(Productor x)
    {
        if (this.raiz == null)
        {
            NodoArbol nodo = new NodoArbol(x);
            raiz = nodo;
        } else {
            insertarElemento(x, raiz);
        }
        
    }
    
    /* Funcion recursiva que lo inserta */
    private void insertarElemento(Productor x, NodoArbol n)  
    {
    		   		
    	/**/	   	
        if (n.getDato().compareTo(x)==-1)
        {
            if (n.getNodoIzq() ==null)
            {
                n.setNodoIzq(new NodoArbol(x));
            } else {
                insertarElemento(x, n.getNodoIzq());
            } 
                    
                    
        } else {
            if (n.getNodoDer() == null)
            {
                n.setNodoDer(new NodoArbol(x));
            } else {
                insertarElemento(x, n.getNodoDer());
            }
        }
        
        
    }
    
   /* Saber si pertenece */
    
    public boolean pertenece(Productor x)
    {
        return pertenece (x, this.raiz);
    }
    
    /* Recursiva para saber si pertenece o no*/
    public boolean pertenece(Productor x, NodoArbol n)
    {
        if (n==null)
        {
            return false;
        } 
        
        if (n.getDato() == x)
        {
            return true;
        }
        
        if (n.getDato().compareTo(x) ==-1)
        {
            return pertenece(x, n.getNodoIzq());
        } else {
            return pertenece(x, n.getNodoDer());
        }
        
    }
    
	

    /* Listar Acendente -In order -*/
    public void listarAscendente()
    {
        listarAscendente(this.raiz);
        
    }
    
    /* Recuersiva para listar ascndente  */
    private void listarAscendente(NodoArbol n)
    {
        if (n==null)
        {
            return;
            
        } else {
            listarAscendente(n.getNodoIzq());
            System.out.println(n.getDato());
            listarAscendente(n.getNodoDer());
        }
    }
    
    
    private void borrarMinimo()
    {
        raiz = eliminarMin(raiz);
    }
    
    private NodoArbol eliminarMin(NodoArbol a)
    {
        if(a ==null)
        {
            return a;
        }
        
        if (a.getNodoIzq() !=null)
        {
            a.setNodoIzq(eliminarMin(a.getNodoIzq()));
            return a;
        } else {
            return a.getNodoDer();
        }
       
    
    }
    
    
    /* Buscar por cedula */
    /* Metodo axuliar para buscar un elemtno con una firma*/
    public NodoArbol buscarPorCedula(String elemento) {
      
    	return buscar(raiz, elemento);
  }
    
    
    /* Buscar un nodo en el arbol*/
    public NodoArbol buscar(NodoArbol a, String dato) {

        /* Casos base, si el nodo es null devolvemos null , pero si el nodo
        contiene el dato que estamos buscando devolvemos el dato */
        if (a == null) {
            return a;
        }
        if (a.getDato().getCedula()==dato) {
            return a;

        }

        /* Recursiva 
        La busqueda es sencilla, Creamos un nodoarbol llamado retorno y le 
        asignamos el resultado de buscar dandole el nodoizquierdo como primer
        paramtero y el dato a buscar como el segundo. Si es null hacemos un return
        de la misma funcion pero con el derecho.
        
        */
        NodoArbol retorno = buscar(a.getNodoIzq(), dato);
        if (retorno == null) {
            return buscar(a.getNodoDer(), dato);
        } else {
            return retorno;
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
  /* Buscar un nodo en el arbol*/
  public NodoArbol buscar(NodoArbol a, Productor dato) {

      /* Casos base, si el nodo es null devolvemos null , pero si el nodo
      contiene el dato que estamos buscando devolvemos el dato */
      if (a == null) {
          return a;
      }
      if (a.getDato()==dato) {
          return a;

      }

      /* Recursiva 
      La busqueda es sencilla, Creamos un nodoarbol llamado retorno y le 
      asignamos el resultado de buscar dandole el nodoizquierdo como primer
      paramtero y el dato a buscar como el segundo. Si es null hacemos un return
      de la misma funcion pero con el derecho.
      
      */
      NodoArbol retorno = buscar(a.getNodoIzq(), dato);
      if (retorno == null) {
          return buscar(a.getNodoDer(), dato);
      } else {
          return retorno;
      }

  }
  

  /* Metodo axuliar para buscar un elemtno con una firma*/
    private NodoArbol buscar(Productor elemento) {
      return buscar(raiz, elemento);
  }
  
  
  public void borrarElemento(Productor elem)
  {
      NodoArbol aBorrar = buscar(elem);
      
      NodoArbol aPadre = buscar(raiz, elem);
      
      if (aPadre.getNodoIzq()==aBorrar) 
      {
    	  //ACA ESTÁS ELIMINADO OTROS NODOS POSIBLEMENTE.
          aPadre.setNodoIzq(aBorrar.getNodoDer());
      } else {
          NodoArbol hnoAnterior = aPadre.getNodoIzq();
          NodoArbol aux = aPadre.getNodoIzq();
          
          while (aux!=aBorrar)
          {
        	  //ACA AUX PUEDE SER NULL
              hnoAnterior=aux;
              aux = aux.getNodoDer();
          }
          
          hnoAnterior.setNodoDer(aBorrar.getNodoDer());
      }  
  }
  
//	private NodoArbol borrarElemento (Productor x, NodoArbol a) {
//	  if( a == null )
//	  return a;
//	  if(  x.getCedula().compareTo(a.getDato().getCedula()) == -1)
//	  a.setNodoIzq(borrarElemento(x, a.getNodoIzq()));
//	  else if( x.getCedula().compareTo(a.getDato().getCedula()) == 1)
//	  a.setNodoDer(borrarElemento(x, a.getNodoDer()));
//	  else {
//	  if( a.getNodoIzq() != null && a.getNodoDer() != null ) {
//		  
  
//	  a.setDato(a.getNodoDer().minimo());
//	  a.setDer(a.getNodoDer().eliminarMin());
//	  }
//	  else
//	  if (a.getNodoIzq() != null)
//	  a = a.getNodoIzq();
//	  else
//	  a = a.getNodoDer();
//	  }
//	  return a;
//	  }
    
    
	
}
