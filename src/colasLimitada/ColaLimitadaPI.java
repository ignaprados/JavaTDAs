package colasLimitada;

public class ColaLimitadaPI implements ColaLimitadaTDA {
    int[] arr; // arreglo que contiene la info de la colas
    int inx; // cantidad de elementos en la cola
    int limite; // limite de la cola
    public void InicializarCola(int x) {
        arr = new int[x];
        inx = 0;
        limite = x; // limite igual a x
    }

    public int Acolar(int x) {
        if (inx < limite) {
            arr[inx] = x;
            inx++;
            return 0;	// devuelve 0 si se acolo
        } else {
            return 1; // devuelve 1 si no se acolo pq esta llena
        }
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

    public boolean ColaLlena() { // si la cola est� llena devuelve true
        if (inx == limite) {
            return true;
        } else {
            return false;
        }
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

        while (!ColaVacia() && x > 0) {    // si la cola no esta vacia
            Desacolar();
            x--;
        }
     }
}
