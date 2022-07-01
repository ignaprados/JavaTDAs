package conjuntos;

import listasEnlazadas.*;

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

    // crear una funcion para imprimir el conjunto usando ConjuntoTDA ---------------
    public static String mostrarConjunto(ConjuntoTDA conjunto) {
        String resultado = "";
        while (!conjunto.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            resultado += conjunto.Elegir() + " ";
            conjunto.Sacar(conjunto.Elegir());
        }
        return resultado;
    }

    // crear una funcion para agregar elementos de una lista enlaza a un conjunto eliminando las repeticiones de valores ---------------
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

}
