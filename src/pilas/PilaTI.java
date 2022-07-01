package pilas;

public class PilaTI implements PilaTDA {
    int[] arr; // Arreglo que contiene los elementos de la pila
    int inx; // Cantidad de elementos en la pila

    public void InicializarPila() {
        arr = new int[100];
        inx = 0;
    }

    public void Apilar(int x) { // mueve todos los elementos a la derecha e inserta uno nuevo en pos 0.
        for (int i = inx - 1; i >= 0; i--) {
            arr[i + 1] = arr[i]; // en pos 1 pone el valor de pos 0
        }

        arr[0] = x;
        inx++;

    }

    public void Desapilar() { // mueve todo los elementos a la izquierda
        for (int i = 0; i < inx; i++) {
            arr[i] = arr[i + 1]; // en pos 0 pone el valor de pos 1
        }
        inx--;
    }

    public boolean PilaVacia() {
        return inx == 0;
    }

    public int Tope() {
        return arr[0];
    }


    /* --------------------- EXTRAS -------------------------- */
	 public String Mostrarpila() {      // Metodo extra para ver los elementos de la pila
		
		String pila = ""; // string que contiene la pila
        for (int i = 0; i < inx; i++) {
            pila = pila + (arr[i] + ","); // concatena los elementos de la pila
        }
        pila = "[" + (pila.substring(0, pila.length() - 1)) + "]"; // quita la coma del final de la pila y lo muestra
                                                                     // como un array
        return pila; // Se muestra de izquierda a derecha [ultimo, medio, primero]
		
	}

}
