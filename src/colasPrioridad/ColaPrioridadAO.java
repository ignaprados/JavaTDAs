package colasPrioridad;

// Cola prioridad estrategia 2 - Utiliza un unico array de Elemento (con su atributo valor y prioridad)

public class ColaPrioridadAO implements ColaPrioridadTDA {
    Elemento[] elementos; // el contenido de la colas
    int indice; // la cantidad de elementos de la cola

    public void InicializarCola() {
        elementos = new Elemento[100];
        indice = 0;
    }

    public void AcolarPrioridad(int x, int prioridad) {

        int j = indice;
        while (j > 0 && elementos[j - 1].prioridad > prioridad) {   // Desplazamiento paralelo
            elementos[j] = elementos[j - 1];
            j--;
        }
        elementos[j] = new Elemento(); // crea un nuevo elemento y se inserta en la posicion j
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        indice++;

    }

    public void Desacolar() {
        indice--;
    }

    public boolean ColaVacia() {
        return (indice == 0);
    }

    public int Primero() {	// valor del elemento que va a salir primero
        return elementos[indice - 1].valor;
    }

    public int Prioridad() {	// prioridad del elemento que va a salir primero
        return elementos[indice - 1].prioridad;
    }


    /* --------------------- EXTRAS -------------------------- */
    public String MostrarcolaPrioridad() {  // Metodo extra para ver los elementos de la cola
        String cola = ""; // string que contiene la cola

        for (int i = 0; i < indice; i++) {
            cola = cola + (elementos[i].valor + ","); // concatena los elementos de la cola
        }
        cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
        return cola; // Se muestra de izquierda a derecha [ultimo, medio, primero]
    }

}

