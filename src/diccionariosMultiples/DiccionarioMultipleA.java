package diccionariosMultiples;

import conjuntos.ConjuntoA;
import conjuntos.ConjuntoTDA;

// Implementacion estatica de un diccionario multiple

public class DiccionarioMultipleA implements DiccionarioMultipleTDA {
	class Elemento {	// estructura de un elemento del diccionario
		int clave;
		int[] valores;	// valores asociados a la clave
		int cantValores;	// cantidad de valores asociados a la clave
	}

	private Elemento[] elementos;
	private int cantClaves;

	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cantClaves = 0;
	}

	public void Agregar(int clave, int valor) {
		int PosC = Clave2Indice(clave);	// posicion de la clave en el array
		if (PosC == -1) {	// si no existe la clave
			PosC = cantClaves;	
			elementos[PosC] = new Elemento();	// creo un nuevo elemento en la ultima posicion
			elementos[PosC].clave = clave;
			elementos[PosC].cantValores = 0;
			elementos[PosC].valores = new int[100];
			cantClaves++;
		}
		Elemento e = elementos[PosC];	// obtengo el elemento
		int PosV = Valor2Indice(e, valor);	// posicion del valor en el array de la clave
		if (PosV == -1) {	// si no existe el valor
			e.valores[e.cantValores] = valor;	// agrego el valor al array
			e.cantValores++;
		}

	}

	public void Eliminar(int clave) {
		int PosC = Clave2Indice(clave);	// posicion de la clave en el array
		if (PosC != -1) {	// si existe la clave
			elementos[PosC] = elementos[cantClaves - 1];	// copio el ultimo elemento en el lugar de la clave (tapo el hueco)
			cantClaves--;
		}
	}

	public void EliminarValor(int clave, int valor) {
		int PosC = Clave2Indice(clave);	// posicion de la clave en el array
		if (PosC != -1) {	// si existe la clave
			Elemento e = elementos[PosC];
			int PosV = Valor2Indice(e, valor);	// posicion del valor en el array de la clave
			if (PosV != -1) {	// si existe el valor
				e.valores[PosV] = e.valores[e.cantValores - 1];	// copio el ultimo valor en el lugar del valor (tapo el hueco)
				e.cantValores--;
			}
			if (e.cantValores == 0) {	// si no hay valores en la clave
				Eliminar(clave);	// elimino la clave
			}
		}

	}

	private int Clave2Indice(int clave) {
		int i = cantClaves - 1;
		while (i >= 0 && elementos[i].clave != clave) {	// busco la clave en el array
			i--;
		}
		return i;	// devuelve la posicion de la clave en el array o -1 si no existe
	}

	private int Valor2Indice(Elemento e, int valor) {
		int i = e.cantValores - 1;
		while (i >= 0 && e.valores[i] != valor) {	// busco el valor en el array de la clave
			i--;
		}
		return i;	// devuelve la posicion del valor en el array de la clave o -1 si no existe
	}

	public ConjuntoTDA Recuperar(int clave) {
		ConjuntoTDA c = new ConjuntoA();
		c.InicializarConjunto();
		int PosC = Clave2Indice(clave);	// posicion de la clave en el array
		if (PosC != -1) {	// si existe la clave
			Elemento e = elementos[PosC];
			for (int i = 0; i < e.cantValores; i++) {	// recorro el array de valores de la clave
				c.Agregar(e.valores[i]);	// agrego el valor al nuevo conjunto de valores
			}
		}
		return c;	// devuelve el conjunto de valores asociados a la clave
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoA();
		c.InicializarConjunto();
		for (int i = 0; i < cantClaves; i++) {	// recorro el array
			c.Agregar(elementos[i].clave);	// agrego la clave al conjunto de claves
		}
		return c;	// devuelve el conjunto de claves
	}
}
