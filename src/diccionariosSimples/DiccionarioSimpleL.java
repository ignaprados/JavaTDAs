package diccionariosSimples;

import conjuntos.ConjuntoTDA;
import conjuntos.ConjuntoLD;

// Implementacion dinamica de un diccionario simple

public class DiccionarioSimpleL implements DiccionarioSimpleTDA {
	private class NodoClave {	// nodo de la lista
		int clave;
		int valor;
		NodoClave sigClave;	// referencia al siguiente nodo
	}

	private NodoClave origen;	// origen de la lista

	public void InicializarDiccionario() {
		origen = null;
	}

	public void Agregar(int clave, int valor) {	
		NodoClave nc = Clave2NodoClave(clave);	// busca la clave en la estructura
		if (nc == null) {	// si no existe la clave, crea un nuevo nodo
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;	// agrega el nuevo nodo al principio de la lista enlazada (origen)
			origen = nc;	// nuevo origen
		}
		nc.valor = valor;	// si existe la clave, actualiza el valor
	}

	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;	
		while (aux != null && aux.clave != clave) {	// busca la clave en la estructura
			aux = aux.sigClave;
		}
		return aux;	// devuelve el nodo de la clave, o null si no existe
	}

	public void Eliminar(int clave) {
		if (origen != null) {
			if (origen.clave == clave) {	// si el nodo a eliminar es el origen
				origen = origen.sigClave;
			} else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {	// si esta en el medio, busca la clave en la estructura
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {	// si existe la clave
					aux.sigClave = aux.sigClave.sigClave;	// elimina el nodo
				}
			}
		}
	}

	public int Recuperar(int clave) {	
		NodoClave nc = Clave2NodoClave(clave);	// busca la clave en la estructura
		return nc.valor;	// devuelve el valor de la clave, o null si no existe
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoClave aux = origen;
		while (aux != null) {
			c.Agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;	// devuelve un conjunto con las claves del diccionario
	}

	
	/* --------------------- EXTRAS -------------------------- */
	public ConjuntoTDA Valores() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoClave aux = origen;
		while (aux != null) {
			c.Agregar(aux.valor);
			aux = aux.sigClave;
		}
		return c;	// devuelve un conjunto con los valores del diccionario
	}

	public String Mostrardiccionario() {

		String s = "";
		NodoClave aux = origen;
		while (aux != null) {
			s += "(" + aux.clave + "," + aux.valor + ") ";
			aux = aux.sigClave;
		}
		return s;	// devuelve un string con el diccionario
	}

}
