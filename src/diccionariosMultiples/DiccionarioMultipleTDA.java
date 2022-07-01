package diccionariosMultiples;

import conjuntos.ConjuntoTDA;

public interface DiccionarioMultipleTDA {
	void InicializarDiccionario();	// pre: no requiere

	void Agregar(int clave, int valor);	// pre: diccionario inicializado

	void Eliminar(int clave);	// pre: diccionario inicializado

	void EliminarValor(int clave, int valor);	// pre: diccionario inicializado

	ConjuntoTDA Recuperar(int clave);	// pre: diccionario inicializado y claves existente

	ConjuntoTDA Claves();	// pre: diccionario inicializado
}
