package conjuntos;

public interface ConjuntoTDA {
    void InicializarConjunto();

    void Agregar(int x); // pre: conjunto inicializado

    int Elegir(); // pre: conjunto inicializado y no vacio

    boolean ConjuntoVacio(); // pre: conjunto inicializado

    void Sacar(int x); // pre: conjunto inicializado
    
    boolean Pertenece(int x); // pre: conjunto inicializado

    /* --------------------- EXTRAS -------------------------- */
    String Mostrarconjunto(); // metodo extra para ver la cola

    boolean TodosPertenecen(ConjuntoTDA origen); // metodo extra para verificar si un conjunto pertenece (simulacro)

    void SacarTodos(ConjuntoTDA origen); // metodo extra para sacar todos los elementos de un conjunto (simulacro)

}
