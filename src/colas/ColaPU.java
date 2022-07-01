package colas;

public class ColaPU implements ColaTDA {
    int[] arr; // arreglo que contiene los elementos de la cola
    int inx; // cantidad de elementos de la cola

    public void InicializarCola() {
        arr = new int[100]; // inicializa el array con 100 elementos
        inx = 0; // el numero de elementos inicia en 0
    }

    public void Acolar(int x) {

        for (int i = inx - 1; i >= 0; i--) { // recorre la cola entera, desplazando los elementos una posicion a la
                                             // derecha +.
            arr[i + 1] = arr[i]; // mueve el elemnto una posicion a la derecha +
        }

        arr[0] = x; // establece el elemento nuevo en la pocision 0 (ultimo que entro a la cola)
        inx++; // incrementa la cantidad de elementos
    }

    public void Desacolar() {
        inx--; // baja el indice para desencolar el proximo elemento
    }

    public boolean ColaVacia() {
        return (inx == 0); // retorna valor de la pocision 0
    }

    public int Primero() {
        return arr[inx - 1]; // devuelve el proximo elemento en salir de la cola
    }


    /* --------------------- EXTRAS -------------------------- */
    public String Mostrarcola() {   // Metodo extra para ver los elementos de la cola
        String cola = ""; // string que contiene la cola
        
        for (int i = 0; i < inx; i++) {
            cola = cola + (arr[i] + ","); // concatena los elementos de la cola
        }
        cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
        return cola;    // Se muestra de izquierda a derecha [ultimo, medio, primero]
    }

    public void Multidesacolar(int x) { // Metodo extra para desacolar x elementos

		while (!ColaVacia() && x > 0) {	// si la cola no esta vacia
			Desacolar();
			x--;
		}
	 }

}

