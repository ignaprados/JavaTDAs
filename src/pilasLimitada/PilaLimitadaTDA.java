package pilasLimitada;

public interface PilaLimitadaTDA {

    void InicializarPila(int x); // pre: no requiere

    void Apilar(int x); // pre: pila inicializada

    void Desapilar(); // pre: pila inicializada y no vacia

    boolean PilaVacia(); // pre: pila inicializada

    int Tope(); // pre: pila inicializada y no vacia

    boolean PilaLlena(); // pre: pila inicializada

    int Capacidad(); // pre: pila inicializada

    /* --------------------- EXTRAS -------------------------- */
    String Mostrarpila(); // metodo extra para ver la cola
}
