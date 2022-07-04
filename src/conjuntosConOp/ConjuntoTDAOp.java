package conjuntosConOp;

public interface ConjuntoTDAOp {

	void InicializarConjunto(); //pre:no aplica

	void Agregar(int x); //pre: conjunto inicializado

	int Elegir(); //pre: conjunto inicializado y no vacío

	boolean ConjuntoVacio(); //pre: conjunto inicializado

	void Sacar(int x); //pre: conjunto inicializado

	boolean Pertenece(int x); //pre: conjunto inicializado

	ConjuntoTDAOp Interseccion(ConjuntoTDAOp conj1, ConjuntoTDAOp conj2, ConjuntoTDAOp interseccion); // pre: conjuntos inicializados

	ConjuntoTDAOp Union(ConjuntoTDAOp conj1, ConjuntoTDAOp conj2,ConjuntoTDAOp union); //pre: conjuntos inicializados

	ConjuntoTDAOp Diferencia (ConjuntoTDAOp conj1, ConjuntoTDAOp conj2,ConjuntoTDAOp diferencia); //pre: conjuntos inicializados

}