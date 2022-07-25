package pilasLimitada;

public class PilaLimitadaTF implements PilaLimitadaTDA {
    int[] arr; // Arreglo que contiene los elementos de la pila
    int inx; // Cantidad de elementos en la pila
    int max; // Capacidad de la pila

    public void InicializarPila(int x) {
        max = x;
        arr = new int[max];
        inx = 0; // posicion libre de la pila
    }

    public void Apilar(int x) {

        if (PilaLlena() == true) {
            for (int i = 0; i < (inx - 1); i++) { // eliminar el primer elemento desplazando todos los elementos hacia la izquierda
                arr[i] = arr[i + 1];
            }
            arr[inx - 1] = x;   // agregar el nuevo elemento al final de la pila

        } else {
            arr[inx] = x;
            inx++;
        }
    }

    public void Desapilar() {
        inx--;
    }

    public boolean PilaVacia() {
        return (inx == 0);
    }

    public int Tope() {
        return (arr[inx - 1]); // posicion libre - 1 == ultimo elemento
    }

    public boolean PilaLlena() {    // si la posicion libre es igual a la capacidad de la pila, entonces esta llena
        return (inx == max);
    }

    public int Capacidad() {    // devuelve la capacidad de la pila
        return (max);
    }

    
    /* --------------------- EXTRAS -------------------------- */
	 public String Mostrarpila() {    // Metodo extra para ver los elementos de la pila 
		
		String pila = ""; // string que contiene la pila
        for (int i = 0; i < inx; i++) {
            pila = pila + (arr[i] + ","); // concatena los elementos de la pila
        }
        pila = "[" + (pila.substring(0, pila.length() - 1)) + "]"; // quita la coma del final de la pila y lo muestra
                                                                    // como un array
        return pila; // Se muestra de derecha a izquierda [primero, medio, ultimo]
		
	}

}
