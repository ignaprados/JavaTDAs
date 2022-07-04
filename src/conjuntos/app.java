package conjuntos;

import conjuntosConOp.*;
import listasEnlazadas.*;
import pilas.*;
import colas.*;

public class app {

    /*--------------------------------- MAIN ---------------------------------*/
	public static void main(String[] args) throws Exception {

        // crete a new ConjuntoA object
        ConjuntoA conjunto = new ConjuntoA();
        ConjuntoA conjunto2 = new ConjuntoA();

        // inicializar conjunto
        conjunto.InicializarConjunto();
        conjunto2.InicializarConjunto();
        
        System.out.println(conjunto.ConjuntoVacio());

        // Agregar los elementos 1 2 3 4 5 6 7 8 9 10
        conjunto.Agregar(1);
        conjunto.Agregar(2);
        conjunto.Agregar(3);
        conjunto.Agregar(4);

        conjunto2.Agregar(1);
        conjunto2.Agregar(2);
        conjunto2.Agregar(3);
        conjunto2.Agregar(5);

        System.out.println("Todos pertenecen: " + conjunto.TodosPertenecen(conjunto2));
        conjunto.SacarTodos(conjunto2);
        System.out.println(mostrarConjunto(conjunto));
        System.out.println(mostrarConjunto(conjunto2));
       
        //System.out.println(conjunto.Elegir());

        conjunto.Agregar(4);
        conjunto.Agregar(5);
        
        conjunto.Sacar(5);
        
        System.out.println(conjunto.Elegir());
        
        System.out.println(conjunto.Pertenece(1));
        System.out.println(conjunto.Pertenece(6));
        
        System.out.println(conjunto.ConjuntoVacio());

        //System.out.println(conjunto.Mostrarconjunto());

        System.out.println(mostrarConjunto(conjunto));

    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

    // funcion para imprimir el conjunto usando ConjuntoTDA ---------------
    public static String mostrarConjunto(ConjuntoTDA conjunto) {
        String resultado = "";
        while (!conjunto.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            resultado += conjunto.Elegir() + " ";
            conjunto.Sacar(conjunto.Elegir());
        }
        return resultado;
    }

    // funcion para agregar elementos de una lista enlaza a un conjunto eliminando las repeticiones de valores ---------------
    public static void agregarLista(Nodo origen) {
        ConjuntoTDA bolsa = new ConjuntoLD();
        bolsa.InicializarConjunto();    // crear conjunto
    
        if (origen != null) {   // si la lista no esta vacia agregar el primer elemento
            bolsa.Agregar(origen.dato);
            origen = origen.sig;
        }

        Nodo aux = new Nodo();
        aux = origen;   // auxiliar para recorrer la lista

        while (aux != null) {   
            if (bolsa.Pertenece(aux.sig.dato)) {    // si el elemento ya esta en el conjunto no se agrega
                aux.sig = aux.sig.sig;  // se elimina el elemento de la lista enlazada
            } else {
                bolsa.Agregar(aux.sig.dato);    // si el elemento no esta en el conjunto se agrega
                aux = aux.sig;
            }
        }
    }

    // funcion para calcular la diferencia simétrica entre dos conjuntos A y B - TP3 Ejercicio 3a ---------------
    // Diferencia Simetrica: es una operación cuyo resultado es otro conjunto que contiene a aquellos elementos que pertenecen a uno de los conjuntos iniciales, pero no a ambos a la vez.
    public static ConjuntoTDA DifSimetrica(ConjuntoTDA A, ConjuntoTDA B) {
		ConjuntoTDA DifSimetrica = new ConjuntoA();
		DifSimetrica.InicializarConjunto();

		while(!A.ConjuntoVacio() && !B.ConjuntoVacio()) {   // mientras no esten vacios los conjuntos
			int a = A.Elegir();
			int b = B.Elegir(); // se eligen dos elementos del conjunto

			if(!B.Pertenece(a)) {  // si el elemento no esta en el conjunto B se agrega
				DifSimetrica.Agregar(a);
            } else if(!A.Pertenece(b)) {    // si el elemento no esta en el conjunto A se agrega
                DifSimetrica.Agregar(b);
            }
			A.Sacar(a);
			B.Sacar(b);
		}
		return DifSimetrica;
	}

    // funcion para calcular la diferencia simétrica entre dos conjuntos A y B - TP3 Ejercicio 3b ---------------
    public static ConjuntoTDAOp UnionInterseccion(ConjuntoTDAOp A, ConjuntoTDAOp B,ConjuntoTDAOp union, ConjuntoTDAOp interseccion) {
		while(!A.ConjuntoVacio() && !B.ConjuntoVacio()) {
			union.Union(A, B, union);
			interseccion.Interseccion(A,B,interseccion);
		}
		return union;
	}
	public static ConjuntoTDAOp DiferenciaSimetrica(ConjuntoTDAOp union, ConjuntoTDAOp interseccion,ConjuntoTDAOp DifSimetrica) {
		while(!union.ConjuntoVacio() && !interseccion.ConjuntoVacio()) {
			DifSimetrica.Diferencia(union, interseccion, DifSimetrica);
		}
		return DifSimetrica;
	}

    // funcion para ver si dos conjuntos son iguales - TP3 Ejercicio 3d ---------------
    public static boolean Iguales(ConjuntoTDA A, ConjuntoTDA B) {

        while(!A.ConjuntoVacio() && !B.ConjuntoVacio()) {
            int a = A.Elegir();
            int b = B.Elegir(); // se eligen dos elementos del conjunto

            if(!B.Pertenece(a)) {   // si el elemento de A no esta en el conjunto B retorna false
                return false;
            } else if(!A.Pertenece(b)) {    // si el elemento de B no esta en el conjunto A retorna false
                return false;
            }
            A.Sacar(a);
            B.Sacar(b);
        }
        return true;
    }

    // funcion para calcular la cardinalidad (cantidad de elementos) de un conjunto - TP3 Ejercicio 3e ---------------
    public static int Cardinalidad(ConjuntoTDA conjunto) {
        int cardinalidad = 0;

        while(!conjunto.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            cardinalidad++; // se suma uno a la cardinalidad
            conjunto.Sacar(conjunto.Elegir());  // se saca el elemento del conjunto
        }
        return cardinalidad;
    }

    // funcion para generar el conjunto de elementos que están tanto en la Pila P y en la Cola C. - TP3 Ejercicio 3f ---------------
    public static ConjuntoTDA ConjuntoMismosElementos(PilaTDA P, ColaTDA C) {
        ConjuntoTDA conjunto = new ConjuntoLD();
        conjunto.InicializarConjunto();    // crear conjunto final

        ConjuntoTDA aux = new ConjuntoA();  // conjunto auxiliar para guardar los elementos de la pila
        aux.InicializarConjunto();
        ConjuntoTDA aux2 = new ConjuntoA(); // conjunto auxiliar para guardar los elementos de la cola
        aux2.InicializarConjunto();

        while(!P.PilaVacia()) {     // pasar los elementos de la pila a un conjunto
            aux.Agregar(P.Tope());
        }
        while(!C.ColaVacia()) {    // pasar los elementos de la cola a un conjunto
            aux2.Agregar(C.Primero());
        }

        while(!aux.ConjuntoVacio() && !aux2.ConjuntoVacio()) {   // mientras no esten vacios los conjuntos
            int a = P.Tope();
            int b = C.Primero(); // se eligen dos elementos del conjunto

            if(aux.Pertenece(b)) {  // si el elemento de la pila esta en el conjunto de la cola se agrega al conjunto final
                conjunto.Agregar(b);
            } else if(aux2.Pertenece(a)) {    // si el elemento de la cola esta en el conjunto de la pila se agrega al conjunto final
                conjunto.Agregar(a);
            }
            aux.Sacar(b);
            aux2.Sacar(a);
        }
        return conjunto;
    }

    // funcion para determinar si los elementos de una Pila P son los mismos que los de una Cola C. ---------------
    // No interesa el orden ni si están repetidos o no. - TP3 Ejercicio 3g 
    public static boolean Iguales(PilaTDA P, ColaTDA C) {
        ConjuntoTDA aux = new ConjuntoA();  // conjunto auxiliar para guardar los elementos de la pila
        aux.InicializarConjunto();
        ConjuntoTDA aux2 = new ConjuntoA(); // conjunto auxiliar para guardar los elementos de la cola
        aux2.InicializarConjunto();

        while(!P.PilaVacia()) {     // pasar los elementos de la pila a un conjunto
            aux.Agregar(P.Tope());
        }
        while(!C.ColaVacia()) {    // pasar los elementos de la cola a un conjunto
            aux2.Agregar(C.Primero());
        }

        while(!aux.ConjuntoVacio() && !aux2.ConjuntoVacio()) {  // mientras no esten vacios los conjuntos
            if(!aux.Pertenece(aux2.Elegir())) { // si el elemento del conjunto de la pila no esta en la conjunto de la cola retorna false
                return false;
            }
            aux.Sacar(aux.Elegir());
        }
        return true;    // si llega hasta aqui es porque los conjuntos son iguales
    }



}
