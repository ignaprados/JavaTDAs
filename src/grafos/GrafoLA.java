package grafos;
import conjuntos.*;

public class GrafoLA implements GrafoTDA{
	
	class NodoVertice{	// clase de nodo de vertice
		int nodo;
		NodoArista arista;	// puntero a la lista de aristas
		NodoVertice sigNodo;
	}
	class NodoArista{	// clase de nodo de arista
		int peso;
		NodoVertice nodoDestino;
		NodoArista sigArista;
	}

	NodoVertice origen;
	

	public void InicializarGrafo() {
		origen = null;
	}


	public void AgregarVertice(int x) {	// agrego un nodo de vertice al grafo
		NodoVertice nuevo = new NodoVertice();	// El nuevo nodo se coloca al inicio
		nuevo.nodo = x;
		nuevo.arista = null;					// El nodo se agrega sin aristas inicialmente
		nuevo.sigNodo = origen;
		origen = nuevo;
	}
	

	public void EliminarVertice(int x) {	// elimino un nodo de vertice del grafo
		if (origen.nodo == x)					// El primer vertice es el que debe eliminarse
			origen = origen.sigNodo;
		NodoVertice aux = origen;				// Se define un nodo viajero
		while (aux != null) {					// El nodo "aux" recorre todos los vertices
			this.EliminarAristaEnNodo(aux, x);	// Se eliminan todas las aristas que llegan a x
			if (aux.sigNodo != null && aux.sigNodo.nodo == x) {
				aux.sigNodo = aux.sigNodo.sigNodo;	// circunvala el nodo vertice
			}
			aux = aux.sigNodo;
		}
	}

	private void EliminarAristaEnNodo(NodoVertice nodo, int v) {	// elimino todas las aristas del nodo que llegan a v
		NodoArista aux = nodo.arista;
		if (aux != null) {
			if (aux.nodoDestino.nodo == v) {		// La arista que debe eliminarse es la primera
				nodo.arista = aux.sigArista;
			} else {								// La arista que debe eliminarse es otra
				while(aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
					aux = aux.sigArista;
				if (aux.sigArista != null)			// Se encontro la arista
					aux.sigArista = aux.sigArista.sigArista;
			}
		}
	}
	
	private NodoVertice Vertice2Nodo(int x) {	// Devuelve el nodo del vertice o null 
		NodoVertice aux = origen;
		while(aux !=null && aux.nodo != x)
			aux = aux.sigNodo;
		return aux;
	}
	
	public void AgregarArista(int x, int y, int w) {	// agrega una arista al grafo entre x y y con peso w
		NodoVertice n1 = Vertice2Nodo(x);
		NodoVertice n2 = Vertice2Nodo(y);
		NodoArista nuevo = new NodoArista();
		nuevo.peso = w;
		nuevo.nodoDestino = n2;
		nuevo.sigArista = n1.arista;
		n1.arista = nuevo;
	}


	public void EliminarArista(int x, int y) {	// elimina la arista entre x y y
		NodoVertice n1= Vertice2Nodo(x);
		EliminarAristaEnNodo(n1,y);			// elimino la arista en el nodo x que apunta a y

	}

	public int PesoArista(int x, int y) {	// devuelve el peso de la arista entre x y y
		NodoVertice nodo = Vertice2Nodo(x);
		NodoArista aux = nodo.arista;
		while (aux.nodoDestino.nodo != y)	// busco la arista entre x y y
			aux = aux.sigArista;
		return aux.peso;
	}

	public boolean ExisteArista(int x, int y) {	// devuelve true si existe una arista entre x y y
		NodoVertice nodo = Vertice2Nodo(x);
		NodoArista aux = nodo.arista;
		while (aux != null && aux.nodoDestino.nodo != y)	// busco la arista entre x y y
			aux = aux.sigArista;
		return (aux != null);
	}

	public ConjuntoTDA Vertices() {	// devuelve un conjunto con todos los vertices del grafo
		ConjuntoTDA CNodos = new ConjuntoA();
		CNodos.InicializarConjunto();
		NodoVertice aux = origen;
		while (aux != null) {	// recorro todos los vertices
			CNodos.Agregar(aux.nodo);
			aux = aux.sigNodo;
		}
		return CNodos;
	}

}
