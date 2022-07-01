package diccionariosMultiples;

import conjuntos.ConjuntoLD;
import conjuntos.ConjuntoTDA;

// Implementacion dinamica de un diccionario multiple

public class DiccionarioMultipleL implements DiccionarioMultipleTDA {
	private class NodoClave {	// estructura de un nodo de la lista de claves
		int clave;	// clave
		NodoValor valores;	// lista de valores asociados a la clave
		NodoClave sigClave;	// referencia a la siguiente clave
	}

	private class NodoValor {	// estructura de un nodo de la lista de valores
		int valor;	// valor
		NodoValor sigValor;	// referencia al siguiente valor
	}

	private NodoClave origen;	// origen de la lista de claves

	public void InicializarDiccionario() {
		origen = null;
	}

	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave) {	// busca la clave en la lista
			aux = aux.sigClave;
		}
		return aux;	// devuelve el nodo de la clave o null si no existe
	}

	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);	// busca la clave en la lista
		if (nc == null) {	// si no existe la clave
			nc = new NodoClave();	// creo un nuevo nodo de clave
			nc.clave = clave;
			nc.sigClave = origen;	// lo agrego al principio de la lista
			origen = nc;	// actualizo el origen
		}
		NodoValor aux = nc.valores;
		while (aux != null && aux.valor != valor) {	// busca el valor en la lista
			aux = aux.sigValor;
		}
		if (aux == null) {	// si no existe el valor
			NodoValor nv = new NodoValor();	// creo un nuevo nodo de valor en la lista de clave
			nv.valor = valor;
			nv.sigValor = nc.valores;	// lo agrego al principio de la lista de valores
			nc.valores = nv;	// actualizo la lista de valores en el nodo de clave
		}
	}

	public void Eliminar(int clave) {	// elimina la clave y todos sus valores
		if (origen != null) {	// si la lista no esta vacia
			if (origen.clave == clave) {	// si la clave es la primera
				origen = origen.sigClave;	// actualizo el origen
			} else {	// si la clave no es la primera
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {	// busca la clave en la lista (con nodo viajero)
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {	// si la clave esta en medio o al final
					aux.sigClave = aux.sigClave.sigClave;	// elimino el nodo de la clave
				}
			}
		}
	}

	private void EliminarValorEnNodo(NodoClave nodo, int valor) {	// elimina el valor en el nodo de la clave
		if (nodo.valores != null) {	// si la lista de valores no esta vacia
			if (nodo.valores.valor == valor) {	// si el valor es el primero
				nodo.valores = nodo.valores.sigValor;
			} else {	// si el valor no es el primero
				NodoValor aux = nodo.valores;
				while (aux.sigValor != null && aux.sigValor.valor != valor) {	// busca el valor en la lista (con nodo viajero)
					aux = aux.sigValor;
				}
				if (aux.sigValor != null) {	// si el valor esta en medio o al final
					aux.sigValor = aux.sigValor.sigValor;	// elimino el nodo del valor
				}
			}
		}
	}

	public void EliminarValor(int clave, int valor) {	// elimina el valor de la lista  del nodo de la clave
		if (origen != null) {	// si la lista no esta vacia
			if (origen.clave == clave) {	// si la clave es la primera
				EliminarValorEnNodo(origen, valor);
				if (origen.valores == null) {	// si la lista de valores del nodo de la clave esta vacia
					origen = origen.sigClave;	// actualizo el origen
				}
			} else {	// si la clave no es la primera
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {	// busca la clave en la lista (con nodo viajero)
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {	// si la clave esta en medio o al final
					EliminarValorEnNodo(aux.sigClave, valor);	// elimino el valor en el nodo de la clave
					if (aux.sigClave.valores == null) {	// si la lista de valores del nodo de la siguiente clave esta vacia
						aux.sigClave = aux.sigClave.sigClave;	// elimino el nodo de la clave
					}
				}
			}

		}
	}

	public ConjuntoTDA Recuperar(int clave) {
		NodoClave nc = Clave2NodoClave(clave);	// busca la clave en la lista
		ConjuntoTDA c = new ConjuntoLD();	
		c.InicializarConjunto();
		if (nc != null) {	// si la clave existe
			NodoValor aux = nc.valores;
			while (aux != null) {	// recorro la lista enlazada de valores
				c.Agregar(aux.valor);	// agrego el valor al conjunto
				aux = aux.sigValor;
			}
		}
		return c;	// devuelve el conjunto de valores de la clave
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoClave aux = origen;
		while (aux != null) {	// recorro la lista enlazada de claves
			c.Agregar(aux.clave);	// agrego la clave al conjunto
			aux = aux.sigClave;
		}
		return c;	// devuelve el conjunto de claves
	}

}
