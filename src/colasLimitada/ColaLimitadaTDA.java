package colasLimitada;

public interface ColaLimitadaTDA {
    void InicializarCola(int x); // pre: no aplica

    int Acolar(int x); // pre: cola inicializada

    void Desacolar(); // pre: cola inicializada y no vacia

    boolean ColaVacia(); // pre: cola inicializada

    int Primero(); // pre: cola inicializada y no vacia
    
    boolean ColaLlena(); // pre: cola inicializada

    /* --------------------- EXTRAS -------------------------- */
    String Mostrarcola(); // metodo extra para ver la cola

    void Multidesacolar(int n); // pre: cola inicializada y no vacia

}
