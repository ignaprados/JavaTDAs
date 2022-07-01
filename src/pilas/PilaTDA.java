package pilas;

public interface PilaTDA {
    void InicializarPila(); // pre: no requiere

    void Apilar(int x); // pre: pila inicializada

    void Desapilar(); // pre: pila inicializada y no vacia

    boolean PilaVacia(); // pre: pila inicializada

    int Tope(); // pre: pila inicializada y no vacia

    /* --------------------- EXTRAS -------------------------- */
    String Mostrarpila(); // metodo extra para ver la cola
}
