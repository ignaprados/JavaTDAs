package grafos;

import conjuntos.*;

public class GrafoMA implements GrafoTDA {
	static int n = 100;
	int[][] MAdy;			// Matriz de adyacencia
	int[] Etiqs;			// Etiquetas de los nodos
	int cantNodos;

	public void InicializarGrafo() {	
		MAdy = new int[n][n];	
		Etiqs = new int[n];
		cantNodos = 0;
	}	

	public void AgregarVertice(int v) {		// agrega un nodo al grafo
		Etiqs[cantNodos] = v;	// agrega v a la ultima posicion de la lista de vertices (etiquetas)
		for (int i = 0; i <= cantNodos; i++) {	// sobreescribe la matriz de adyacencia (la ultima fila y columna) con ceros, por si habia algo antes
			MAdy[cantNodos][i] = 0;	
			MAdy[i][cantNodos] = 0;
		}
		cantNodos++;	// incrementa la cantidad de nodos
	}

	private int Vert2Indice(int v) {	// devuelve el indice del nodo v en la lista de etiquetas
		int i = cantNodos - 1;	// i es el indice del ultimo nodo
		while (i >= 0 && Etiqs[i] != v) {	// busca el nodo v en la lista de etiquetas
			i--;
		}
		return i;
	}

	public void EliminarVertice(int v) {	// elimina un nodo del grafo
		int ind = Vert2Indice(v);
		for (int i = 0; i < cantNodos; i++) {	// sobreescribe col del nodo que queres eliminar por col del ultimo nodo de la matriz
			MAdy[i][ind] = MAdy[i][cantNodos - 1];
		}
		for (int i = 0; i < cantNodos; i++) {	// sobreescribe la fila del nodo que queres eliminar por la fila del ultimo nodo de la matriz
			MAdy[ind][i] = MAdy[cantNodos - 1][i];
		}
		Etiqs[ind] = Etiqs[cantNodos - 1];	// sobreescribe la etiqueta del nodo que queres eliminar por la etiqueta del ultimo nodo de la lista de etiquetas
		cantNodos--;
	}

	public void AgregarArista(int v1, int v2, int p) {	// agrega una arista al grafo entre los nodos v1 y v2 con peso p
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = p;
	}

	public void EliminarArista(int v1, int v2) {	// elimina una arista del grafo entre los nodos v1 y v2, sobreescribiendo el peso de la arista por 0
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = 0;
	}

	public int PesoArista(int v1, int v2) {	// devuelve el peso de la arista entre los nodos v1 y v2
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return (MAdy[o][d]);
	}

	public ConjuntoTDA Vertices() {	// devuelve un conjunto con todos los nodos (vertices) del grafo
		ConjuntoTDA Vert = new ConjuntoLD();
		Vert.InicializarConjunto();
		for (int i = 0; i < cantNodos; i++) {	// agrega todos los nodos al conjunto
			Vert.Agregar(Etiqs[i]);
		}
		return Vert;
	}

	public boolean ExisteArista(int v1, int v2) {	// devuelve true si existe una arista entre los nodos v1 y v2
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return (MAdy[o][d] != 0);
	}

}
