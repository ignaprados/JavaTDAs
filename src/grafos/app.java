package grafos;
import conjuntos.*;
import diccionariosSimples.*;

public class app {

     /*--------------------------------- MAIN ---------------------------------*/
     public static void main(String[] args) {
        
            ConjuntoTDA c = new ConjuntoA();
            c.InicializarConjunto();
            GrafoTDA grafo = new GrafoMA();
            grafo.InicializarGrafo();
            DiccionarioSimpleTDA d = new DiccionarioSimpleA();
            d.InicializarDiccionario();
            grafo.AgregarVertice(1);
            grafo.AgregarVertice(2);
            grafo.AgregarVertice(3);
            grafo.AgregarArista(1, 2, 7);
            grafo.AgregarArista(1, 3, 5);
            grafo.AgregarArista(2, 3, 9);
            d = SumaPesos(grafo);
            mostrarDiccionario(d);

    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/


    // funcion para determinar si un elemento está o no en un ABB - TP6 Ejercicio 4 --------------
    public static ConjuntoTDA AdyacentesDobles(GrafoTDA grafo, int v) {
        ConjuntoTDA aux = new ConjuntoA();
        ConjuntoTDA aux2 = new ConjuntoA();
        ConjuntoTDA c = new ConjuntoA();    // crear conjuntos auxiliares y destino
        aux.InicializarConjunto();
        aux2.InicializarConjunto();
        c.InicializarConjunto();    

        aux = grafo.Vertices(); // obtener conjunto de vertices
        aux2 = grafo.Vertices();
        aux.Sacar(v);   // sacar el valor v de los conjuntos auxiliares
        aux2.Sacar(v);
        int v2;
        int v3;

        while (!aux.ConjuntoVacio()) {  // comparar los vertices de los conjuntos auxiliares con el valor v
            v2 = aux.Elegir();  
            aux2 = grafo.Vertices();    
            aux2.Sacar(v);
            if (grafo.ExisteArista(v, v2)) {    // si existe arista entre v y v2, iterar sobre v2, para ver si llega a otro vertice
                while (!aux2.ConjuntoVacio()) {
                    v3 = aux2.Elegir();
                    if (grafo.ExisteArista(v2, v3) && v2 != v3) {   // si existe arista entre v2 y v3, agregar v3 al conjunto destino
                        c.Agregar(v3);
                    }
                    aux2.Sacar(v3);
                }
            }
            aux.Sacar(v2);
        }
        return c;
    }

    // funcion para calcular el mayor de los costos de las aristas salientes de un vertice v - TP6 Ejercicio 5 --------------
    public static int MayCost(GrafoTDA grafo, int v) {
        ConjuntoTDA aux = new ConjuntoA();  
        aux.InicializarConjunto();
        aux = grafo.Vertices(); // obtener conjunto de vertices

        int v2;
        int mayor = 0;  // inicializar mayor a 0

        while (!aux.ConjuntoVacio()) {  // iterar sobre los vertices del conjunto auxiliar
            v2 = aux.Elegir();
            if (grafo.ExisteArista(v, v2)) {    // si existe arista entre v y v2, verificar si el costo de la arista es mayor al mayor
                if (grafo.PesoArista(v, v2) > mayor) {  // si el costo de la arista es mayor, actualizar el mayor
                    mayor = grafo.PesoArista(v, v2);
                }
            }
            aux.Sacar(v2);
        }
        return mayor;
    }

    // funcion para obtener el conjunto de los Predecesores del vértice v en G. - TP6 Ejercicio 6 --------------
    public static ConjuntoTDA Predecesor(GrafoTDA grafo, int v) {
        ConjuntoTDA aux = new ConjuntoA();
        aux.InicializarConjunto();
        ConjuntoTDA c = new ConjuntoA();    // crear conjuntos auxiliares y destino
        c.InicializarConjunto();
        aux = grafo.Vertices(); // obtener conjunto de vertices

        int v2;

        while (!aux.ConjuntoVacio()) {  // iterar sobre los vertices del conjunto auxiliar
            v2 = aux.Elegir();
            if (grafo.ExisteArista(v2, v)) {    // si existe arista entre v2 y v, agregar v2 al conjunto destino
                c.Agregar(v2);
            }
            aux.Sacar(v2);
        }
        return c;
    }

    // funcion para obtener el conjunto de los vértices aislados del grafo. - TP6 Ejercicio 7 --------------
    public static ConjuntoTDA Aislados(GrafoTDA grafo) {
        ConjuntoTDA aux = new ConjuntoA();
        aux.InicializarConjunto();
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        ConjuntoTDA aux2 = new ConjuntoA(); // crear conjuntos auxiliares y destino
        aux2.InicializarConjunto();
        aux = grafo.Vertices(); // obtener conjunto de vertices

        int v;
        int v2;
        boolean EsAislado;

        while (!aux.ConjuntoVacio()) {  // iterar sobre los vertices del conjunto auxiliar
            aux2 = grafo.Vertices();
            v = aux.Elegir();
            EsAislado = true;
            while (EsAislado == true && !aux2.ConjuntoVacio()) {    // iterar sobre los vertices del conjunto auxiliar2
                v2 = aux2.Elegir();
                if ((grafo.ExisteArista(v, v2) || grafo.ExisteArista(v2, v)) && (v != v2)) {    // si existe arista entre v y v2, verificar si v es aislado
                    EsAislado = false;
                }
                aux2.Sacar(v2);
            }
            if (EsAislado == true) {    // si v es aislado, agregar v al conjunto destino
                c.Agregar(v);
            }
            aux.Sacar(v);
        }
        return c;
    }

    // funcion para  escribir un método que permita obtener el conjunto de todos los vértices puente entre v y v2. - TP6 Ejercicio 8 --------------
    public static ConjuntoTDA Puentes(GrafoTDA grafo,int v,int v2) {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        ConjuntoTDA aux = new ConjuntoA();  // crear conjuntos auxiliares y puentes
        aux.InicializarConjunto();
        aux = grafo.Vertices();   // obtener conjunto de vertices

        int g;

        while(!aux.ConjuntoVacio()) {   // iterar sobre los vertices del conjunto auxiliar
            g = aux.Elegir();
            if (grafo.ExisteArista(v, g) && grafo.ExisteArista(g, v2) && (v!=v2)) {   // si existe arista entre v y g, verificar si existe arista entre g y v2, y verificar que v y v2 no sean iguales
                c.Agregar(g);   // agregar g al conjunto puentes
            }
            aux.Sacar(g);
        }
        return c;
    }

    // funcion para calcular el grado de v - TP6 Ejercicio 9 --------------
    public static int Grado(GrafoTDA grafo, int v) {
        int grado = 0;
        int g;
        ConjuntoTDA aux = new ConjuntoA();  // crear conjuntos auxiliar con vertices
        aux.InicializarConjunto();
        aux = grafo.Vertices();

        while (!aux.ConjuntoVacio()) {  // iterar sobre los vertices del conjunto auxiliar
            g = aux.Elegir();
            if (grafo.ExisteArista(v, g)) {   // si existe arista entre v y g, sumar 1 al grado
                grado++;
            }
            if (grafo.ExisteArista(g, v)) { // si existe arista entre g y v, restar 1 al grado
                grado--;
            }
            aux.Sacar(g);
        }
        return grado;
    }

    // funcion para hacer un arbol bidireccional - Ejercicio PPT --------------
    public static GrafoTDA Bi(GrafoTDA grafo) {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        c = grafo.Vertices();
        ConjuntoTDA c2 = new ConjuntoA();   // crear conjuntos aux de vertices
        c2.InicializarConjunto();

        int v;
        int v2;
        int p;

        while (!c.ConjuntoVacio()) {    // itera sobre el primer conjunto de vertices
            v = c.Elegir();
            c2 = grafo.Vertices(); // vuelve a rellenar c2
            while (!c2.ConjuntoVacio()) {   // itera sobre el segundo conjunto
                v2 = c2.Elegir();
                if (grafo.ExisteArista(v, v2) && !grafo.ExisteArista(v2, v)) {  // si existe una arista de v a v2, agregar arista de v2 a v
                    p = grafo.PesoArista(v, v2);
                    grafo.AgregarArista(v2, v, p);
                }
                c2.Sacar(v2);
            }
            c.Sacar(v);
        }
        return grafo;
    }

    // funcion para obtener un conjunto de vertices predecesores de v1 y v2 a la vez (que le llegan a v1 y v2) - Ejercicio Simulacro Parcial 2 --------------
    public static ConjuntoTDA PredecesoresComunes(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        ConjuntoTDA aux = new ConjuntoA();  // creo 2 conjuntos
        aux.InicializarConjunto();
        aux = grafo.Vertices();
        int g;

        while (!aux.ConjuntoVacio()) {  // itero en los vertices
            g = aux.Elegir();
            if (grafo.ExisteArista(g, v1) && grafo.ExisteArista(g, v2)) { // pregunto si hay una arista que vaya de g a v1, y de g a v2
                c.Agregar(g);
            }
            aux.Sacar(g);

        }
        return c;
    }

    // funcion para obtener un conjunto de vertices que estan a distancia igual o menor a 2 del vertice v - Ejercicio Simulacro Parcial 2 --------------
    public static ConjuntoTDA DistanciaDos(GrafoTDA grafo, int v) {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        ConjuntoTDA aux = new ConjuntoA();
        aux.InicializarConjunto();
        ConjuntoTDA aux2 = new ConjuntoA(); // creo 2 conjuntos
        aux2.InicializarConjunto();
        int g;
        int g2;

        aux = grafo.Vertices();
        while (!aux.ConjuntoVacio()) {  // itero en los vertices
            g = aux.Elegir();
            if (grafo.ExisteArista(v, g)) { // pregunto si hay una arista que vaya de v a g
                c.Agregar(g);
                aux2 = grafo.Vertices();
                while (!aux2.ConjuntoVacio()) { // itero en los vertices de nuevo
                    g2 = aux2.Elegir();
                    if (grafo.ExisteArista(g, g2)) {    // pregunto si hay una arista que vaya de g a g2
                        c.Agregar(g2);
                    }
                    aux2.Sacar(g2);
                }
            }
            aux.Sacar(g);
        }
        return c;
    }
    
    // funcion para generar una matriz de adyacencia a partir de un grafo - Ejercicio Simulacro Final --------------
    public static class nodomatriz {
    	int[][] ady;
    	int[] vertices;
    }
    
    public static nodomatriz MatrizAdyacencia(GrafoTDA grafo) {
    	
    	ConjuntoTDA vertices = grafo.Vertices();
    	
    	int cant = 0;
    	
    	while(!vertices.ConjuntoVacio()) {
    		cant++;
    		vertices.Sacar(vertices.Elegir());
    	}
    	
    	nodomatriz matriz = new nodomatriz();
    	matriz.ady = new int[cant][cant];
    	matriz.vertices = new int[cant];
    	
    	vertices = grafo.Vertices();
    	
    	int x;
    	int y;
    	
    	for (int i = 0; i <= cant; i++) {
    		x = vertices.Elegir();
    	
    		matriz.vertices[i] = x;
    		vertices.Sacar(x);
    	}
    	
    	for (int i = 0; i <= cant; i++) {
    		
    		x = matriz.vertices[i];
  
        	for (int j = 0; j <= cant; j++) {
        		y = vertices.Elegir();
        		
        		if (grafo.ExisteArista(x, y)) {
        			matriz.ady[i][j] = grafo.PesoArista(x, y);
        		} else {
        			matriz.ady[i][j] = 0;
        		} 	
        	}
    	}
    	return matriz;
    }
    
    
    // funcion para obterner un diccionario con la suma de los pesos de las aristas del vertice - Ejercicio Simulacro Parcial 2 --------------
    public static DiccionarioSimpleTDA SumaPesos(GrafoTDA grafo) {
        DiccionarioSimpleTDA d = new DiccionarioSimpleA();
        d.InicializarDiccionario();
        ConjuntoTDA aux = new ConjuntoA();
        ConjuntoTDA aux2 = new ConjuntoA(); // crear conjuntos auxiliares y diccionario
        aux.InicializarConjunto();
        aux = grafo.Vertices(); // obtener conjunto de vertices
        aux2.InicializarConjunto();
        aux2 = grafo.Vertices();

        int v;
        int v2;
        int suma;

        while (!aux.ConjuntoVacio()) {  // iterar sobre los vertices del conjunto auxiliar
            suma = 0;
            v = aux.Elegir();
            aux2 = grafo.Vertices();
            while (!aux2.ConjuntoVacio()) { // iterar sobre los vertices del conjunto auxiliar2
                v2 = aux2.Elegir();
                if (grafo.ExisteArista(v, v2)) {    // si existe arista entre v y v2, sumar el peso de la arista a la suma
                    suma += grafo.PesoArista(v, v2);
                }
                aux2.Sacar(v2);
            }
            d.Agregar(v, suma); // agregar suma y clave al diccionario
            aux.Sacar(v);
        }
        return d; 
    }


    /*--------------------------------- METODOS DICCIONARIO ---------------------------------*/

    // crear funcion para mostrar el diccionario usando DiccionarioSimpleTDA ---------------
    public static void mostrarDiccionario(DiccionarioSimpleTDA dicc) {
        String diccionario = "";
        ConjuntoTDA claves = dicc.Claves();
        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            int clave = claves.Elegir();
            diccionario += clave + ": " + dicc.Recuperar(clave) + "\n";
            claves.Sacar(clave);
        }
        System.out.println(diccionario);
    }

}
