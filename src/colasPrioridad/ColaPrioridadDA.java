package colasPrioridad;

// Cola prioridad estrategia 1 - Utiliza 2 arrays separados

public class ColaPrioridadDA implements ColaPrioridadTDA {
	int[] elementos; // los valores de la cola
	int[] prioridades; // las prioridades de la cola
	int indice; // la cantidad de elementos

	public void InicializarCola() {
		elementos = new int[100];
		prioridades = new int[100];
		indice = 0;
	}

	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		while (j > 0 && prioridades[j - 1] > prioridad) {
			elementos[j] = elementos[j - 1]; // Desplazamiento paralelo
			prioridades[j] = prioridades[j - 1]; // Desplazamiento paralelo
			j--;
		}
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice++;
	}

	public void Desacolar() {
		indice--;
	}

	public boolean ColaVacia() {
		return (indice == 0);
	}

	public int Primero() {
		return elementos[indice - 1];
	}

	public int Prioridad() {
		return prioridades[indice - 1];
	}


	/* --------------------- EXTRAS -------------------------- */
	public String MostrarcolaPrioridad() {	// Metodo extra para ver los elementos de la cola
		String cola = ""; // string que contiene la cola

		for (int i = 0; i < indice; i++) {
			cola = cola + (elementos[i] + ","); // concatena los elementos de la cola
		}
		cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
		return cola; // Se muestra de izquierda a derecha [ultimo, medio, primero]
	}

}
