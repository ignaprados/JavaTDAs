package colasCirircularesInversibles;

import pilas.*;


public class ColaCircularInversiblePU implements ColaCircularInversibleTDA {

    int[] arr; // arreglo que contiene los elementos de la cola
    int inx; // cantidad de elementos de la cola

    public void InicializarCola() {
        arr = new int[100]; // inicializa el array con 100 elementos
        inx = 0; // el numero de elementos inicia en 0
    }

    public void Acolar(int x) {
        arr[inx] = x;   // agrega el elemento al final de la cola
        inx++;       // incrementa el numero de elementos en 1
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



    public void Invertir() { // Metodo extra para invertir la cola
        PilaTDA aux = new PilaLD();
        aux.InicializarPila();

        while (!ColaVacia()) {  // Apilo la cola para invertir el orden
            aux.Apilar(Primero());
            Desacolar();
        }

        while (!aux.PilaVacia()) {  // Paso los elementos de la pila a la cola para volver a la cola
            Acolar(aux.Tope());
            aux.Desapilar();
        }
    }

    public void Circular() { // Metodo extra para circular la cola

        PilaTDA aux = new PilaLD();
        aux.InicializarPila();

        PilaTDA aux2 = new PilaLD();
        aux2.InicializarPila();


        // guardo el primer elemento de la cola
        int primero = Primero();

        while (!ColaVacia()) {  // Apilo la cola para invertir el orden
            aux.Apilar(Primero());
            Desacolar();
        }

        while (!aux.PilaVacia()) {  // Paso los elementos de la pila a la pila 2 para volver al orden original
            aux2.Apilar(Primero());
            aux.Desapilar();
        }

        aux2.Desapilar(); // quito el ultimo elemento de la pila

        while (!aux2.PilaVacia()) {  // Paso los elementos de la pila a la cola para volver a la cola
            Acolar(aux2.Tope());
            aux2.Desapilar();
        }

        Acolar(primero); // agrego el primer elemento al final de la cola

    }

    /*
    // PASO EL ULTIMO ELEMENTO A LA PRIMERA POSICION DE LA COLA
    public void Circular() { // Metodo extra para circular la cola

        PilaTDA aux = new PilaLD();
        aux.InicializarPila();

        ColaTDA aux2 = new ColaPU();
        aux2.InicializarCola();


        while (!ColaVacia()) {  // Apilo la cola para invertir el orden
            aux.Apilar(Primero());
            aux2.Acolar(Primero()); // Acolar el elemento en la cola aux para no perder la cola original
            Desacolar();
        }

        while (!aux2.ColaVacia()) {  // Paso los elementos de la cola aux a la cola original
            Acolar(aux2.Primero());
            aux2.Desacolar();
        }

        int x = aux.Tope(); // Guardo el elemento del tope de la pila para ciruclar la cola
        
        for (int i = inx - 1; i >= 0; i--) { // recorre la cola entera, desplazando los elementos una posicion a la
                                             // derecha +.
            arr[i + 1] = arr[i]; // mueve el elemnto una posicion a la derecha +
        }
        arr[0] = x; // establece el ultimo elemento de la cola en la pocision 0
    }
    */


}
