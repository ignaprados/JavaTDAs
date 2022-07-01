package pilas;

//Esta implementacion utiliza la posicion 0 del array para el tope de la pila.
public class PilaTF2 implements PilaTDA {
    int[] arr;

    public void InicializarPila() {
        arr = new int[100];
        arr[0] = 0; // cantidad de elementos en la pila
    }

    public void Apilar(int x) {
        arr[arr[0] + 1] = x; // posicion libre + 1 == posicion siguiente
        arr[0]++;
    }

    public void Desapilar() {
        arr[0]--; // decrementa cantidad de elementos en la pila
    }

    public boolean PilaVacia() {
        return (arr[0] == 0);
    }

    public int Tope() {
        return arr[arr[0]];
    }

    
    /* --------------------- EXTRAS -------------------------- */
	public String Mostrarpila() {  // Metodo extra para ver los elementos de la pila @IgnacioPrados
		
		String pila = ""; // string que contiene la pila
        for (int i = 0; i < arr[0]; i++) {
            pila = pila + (arr[i + 1] + ","); // concatena los elementos de la pila
        }
        pila = "[" + (pila.substring(0, pila.length() - 1)) + "]"; // quita la coma del final de la pila y lo muestra
                                                                     // como un array
        return pila; // Se muestra de izquierda a derecha [ultimo, medio, primero]
		
	}

}
