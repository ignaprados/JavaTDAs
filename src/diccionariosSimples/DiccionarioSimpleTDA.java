package diccionariosSimples;

import conjuntos.ConjuntoTDA;

public interface DiccionarioSimpleTDA {

	void InicializarDiccionario(); // pre: no requiere

	void Agregar(int clave, int valor); // pre:diccionario inicializado

	void Eliminar(int clave);	// pre: diccionario inicializado

	int Recuperar(int clave);	// pre: diccionario inicializado y clave existente

	ConjuntoTDA Claves();	// pre: diccionario inicializado
	
    /* --------------------- EXTRAS -------------------------- */
    ConjuntoTDA Valores(); // pre: diccionario inicializado 	// metodo extra para generar conjunto de valores

	String Mostrardiccionario(); // pre: diccionario inicializado y no vacio // metodo extra para mostrar el diccionario


}
