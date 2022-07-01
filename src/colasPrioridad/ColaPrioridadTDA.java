package colasPrioridad;

public interface ColaPrioridadTDA {
    void InicializarCola(); // pre: no aplica

    void AcolarPrioridad(int x, int prioridad); // pre: cola inicializada

    void Desacolar(); // pre: cola inicializada y no vacia

    boolean ColaVacia(); // pre: cola inicializada

    int Primero(); // pre: cola inicializada y no vacia

    int Prioridad(); // pre: cola inicializada y no vacia

    /* ---------------------EXTRAS-------------------------- */
    String MostrarcolaPrioridad(); // metodo extra para ver la cola
}
