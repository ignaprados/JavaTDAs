package arbolABB;

public interface TDAABB {
    int Raiz(); // PRE: arbol inicializado y no vacio

	TDAABB HijoIzq();   // PRE: arbol inicializado y no vacio

	TDAABB HijoDer();   // PRE: arbol inicializado y no vacio

	boolean ArbolVacio();   // PRE: arbol inicializado

	void InicializarArbol();

	void AgregarElem(int x);    // PRE: arbol inicializado

	void EliminarElem(int x);   // PRE: arbol inicializado


}
