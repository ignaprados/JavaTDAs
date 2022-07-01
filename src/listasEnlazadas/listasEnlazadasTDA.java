package listasEnlazadas;

public interface listasEnlazadasTDA {

    void inicializarLista();

    boolean listaVacia(); // pre: lista inicializada

    void agregarF(int valor); // pre: lista inicializada

    void eliminarPos(int pos); // pre: lista inicializada y no vacia
    
    void eliminarValor(int valor); // pre: lista inicializada y no vacia

    void obtener(int pos); // pre: lista inicializada y no vacia

    void insertar(int valor, int pos); // pre: lista inicializada

    void buscar(int valor); // pre: lista inicializada y no vacia
    
    void mostrar(); // pre: lista inicializada y no vacia
    
    void ordenar(); // pre: lista inicializada y no vacia
}
