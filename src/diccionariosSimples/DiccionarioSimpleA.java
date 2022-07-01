package diccionariosSimples;

import conjuntos.ConjuntoA;
import conjuntos.ConjuntoTDA;

// Implementacion estatica de un diccionario simple

public class DiccionarioSimpleA implements DiccionarioSimpleTDA {
	private Elemento[] elementos;
	private int cant;	// cantidad de elementos

	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cant = 0;
	}

	public void Agregar(int clave, int valor) {
		int pos = Clave2Ind(clave);	// busca la pos de la clave en el array
		if (pos == -1) {	// si no existe la clave, crea un nuevo elemento
			pos = cant;	
			elementos[pos] = new Elemento();
			elementos[pos].clave = clave;
			cant++;
		}
		elementos[pos].valor = valor;	// si existe la clave, actualiza el valor
	}

	private int Clave2Ind(int clave) {	// devuelve la posicion de la clave en el array (metodo privado de la implementación)
		int i = cant - 1;
		while (i >= 0 && elementos[i].clave != clave) {
			i--;
		}
		return i;	
	}

	public void Eliminar(int clave) {
		int pos = Clave2Ind(clave);	// posicion en el array
		if (pos != -1) {	// si existe la clave
			elementos[pos] = elementos[cant - 1];	// reemplaza el elemento por el ultimo del array (tapa el hueco)
			cant--;	// decrementa la cantidad de elementos
		}
	}

	public int Recuperar(int clave) {
		int pos = Clave2Ind(clave);	// pos de la clave en el array
		return elementos[pos].valor;	// devuelve el valor en esa pos
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoA();
		c.InicializarConjunto();
		for (int i = 0; i < cant; i++) {	// recorre el array
			c.Agregar(elementos[i].clave);	// agrega la clave al conjunto
		}
		return c;	// devuelve el conjunto de claves del diccionario
	}

	
	/* --------------------- EXTRAS -------------------------- */
	public ConjuntoTDA Valores() {
		ConjuntoTDA c = new ConjuntoA();
		c.InicializarConjunto();
		for (int i = 0; i < cant; i++) {	// recorre el array
			c.Agregar(elementos[i].valor);	// agrega el valor al conjunto
		}
		return c;	// devuelve el conjunto de valores del diccionario
	}

	public String Mostrardiccionario() {

		String s = "";
		for (int i = 0; i < cant; i++) {	// recorre el array
			s += elementos[i].clave + ": " + elementos[i].valor + "\n";	// agrega el valor al conjunto
		}
		return s;	// devuelve el conjunto de valores del diccionario
	}

}
