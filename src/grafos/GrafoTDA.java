package grafos;
import conjuntos.*;

public interface GrafoTDA {
	public void InicializarGrafo();
	
	public void AgregarVertice(int v); // Pre: Grafo inicializado y no existe nodo v
	
	public void EliminarVertice(int v); // Pre: Grafo inicializado y existe nodo v
	
	public void AgregarArista(int v1, int v2, int p);	// Pre: Grafo inicializado y no existe arista (v1, v2)
	
	public void EliminarArista(int v1, int v2);	// Pre: Grafo inicializado y existe arista (v1, v2)
	
	public int PesoArista(int v1, int v2);	// Pre: Grafo inicializado y existe arista (v1, v2)
	
	public boolean ExisteArista (int v1, int v2);	// Pre: Grafo inicializado y existe arista (v1, v2)
	
	public ConjuntoTDA Vertices();	// Pre: Grafo inicializado y existen nodos v1, v2, ..., vn

}
