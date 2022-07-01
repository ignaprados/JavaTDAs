package pilas;

public class PilaTF implements PilaTDA {
    int[] arr; // Arreglo que contiene los elementos de la pila
    int inx; // Cantidad de elementos en la pila

    public void InicializarPila() {
        arr = new int[100];
        inx = 0; // posicion libre de la pila
    }

    public void Apilar(int x) {
        arr[inx] = x;
        inx++;
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
