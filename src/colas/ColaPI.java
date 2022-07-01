package colas;

//Segunda implementacion de la cola

public class ColaPI implements ColaTDA {
    int[] arr; // arreglo que contiene la info de la colas
    int inx; // cantidad de elementos en la cola

    public void InicializarCola() {
        arr = new int[100];
        inx = 0;
    }

    public void Acolar(int x) {
        arr[inx] = x;
        inx++;
    }

    public void Desacolar() {

        for (int i = 0; i < inx - 1; i++) { // mueve los elementos hacia la izquierda
            arr[i] = arr[i + 1];
        }

        inx--;
    }

    public boolean ColaVacia() {
        return inx == 0;
    }

    public int Primero() {
        return arr[0];
    }

    /* --------------------- EXTRAS -------------------------- */
    public String Mostrarcola() { // Metodo extra para ver los elementos de la cola
        String cola = ""; // string que contiene la cola
        
        for (int i = 0; i < inx; i++) {
            cola = cola + (arr[i] + ","); // concatena los elementos de la cola
        }
        cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
        return cola; // Se muestra de derecha a izquierda [primero, medio, ultimo]
    }

    public void Multidesacolar(int x) { // Metodo extra para desacolar x elementos

		while (!ColaVacia() && x > 0) {	// si la cola no esta vacia
			Desacolar();
			x--;
		}
	 }

}
