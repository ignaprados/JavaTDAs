package pilas;

public class PilaTFMejora1 implements PilaTDA{
    int[] arr;
    int inx;

    public void InicializarPila() {
        arr = new int[100];
        inx = 0;
    }

    public void Apilar(int x) {
        arr[inx] = x;
        inx++;
    }

    public void Desapilar() {

        if (inx == 0) {
            System.out.println("no se puede desapilar, pila vacia");
            
        } else {
            inx--;
        }
    }

    public boolean PilaVacia() {
        return inx == 0;
    }

    public int Tope() {
    	
    	if (inx == 0) {	 // se agregó la excepcion para cuando la pila esta vacia
    		throw new RuntimeException("no se puede desapilar, pila vacia");	
    		
        } else {
        	return arr[inx - 1];
        }
    	
        
    }

    
    /* --------------------- EXTRAS -------------------------- */
	 public String Mostrarpila() {  // Metodo extra para ver los elementos de la pila @IgnacioPrados
		
		String pila = ""; // string que contiene la pila
        for (int i = 0; i < inx; i++) {
            pila = pila + (arr[i] + ","); // concatena los elementos de la pila
        }
        pila = "[" + (pila.substring(0, pila.length() - 1)) + "]"; // quita la coma del final de la pila y lo muestra
                                                                    // como un array
        return pila; // Se muestra de derecha a izquierda [primero, medio, ultimo]
		
	}
    
}
