package listasEnlazadas;

import arbolABB.*;
import colas.*;

public class app {
	
    /*--------------------------------- MAIN ---------------------------------*/
	public static void main(String[] args) throws Exception {

        // crear objeto lista
        /*listaEnlazada lista = new listaEnlazada();

        lista.agregarF(2);
        lista.agregarF(4);
        lista.agregarF(8);
        lista.agregarF(6);
        lista.agregarF(7);
        lista.agregarF(1);
        
        lista.mostrar();
        
        lista.ordenar();
        lista.mostrar();*/

        // Ejercicio simularo
        Nodo uno = new Nodo();
        Nodo dos = new Nodo();
        Nodo tres = new Nodo();

        Nodo cuatro = new Nodo();
        Nodo cinco = new Nodo();
        Nodo seis = new Nodo();

        System.out.println(uno);

        uno.dato = 1;
        uno.sig = dos;
        dos.dato = 2;
        dos.sig = tres;
        tres.dato = 3;
        tres.sig = null;

        imprimirListaNodo(uno);


        cuatro.dato = 4;
        cuatro.sig = cinco;
        cinco.dato = 5;
        cinco.sig = seis;
        seis.dato = 6;
        seis.sig = null;

        
        imprimirListaNodo(cuatro);

        
        //listasEnlazadasTDA lista = MezclaABB(uno, cuatro);

        //lista.mostrar();

        

        imprimirListaNodo(Mezcla(uno, cuatro));

        /*// Ejercicio simularo
        Nodo uno = new Nodo();
        Nodo dos = new Nodo();
        Nodo tres = new Nodo();
        Nodo cuatro = new Nodo();

        uno.dato = 1;
        uno.sig = dos;
        dos.dato = 2;
        dos.sig = tres;
        tres.dato = 3;
        tres.sig = cuatro;
        cuatro.dato = 4;
        cuatro.sig = uno;

        imprimirListaCiclica(uno);*/


    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

    // crear una funcion para generar una lista enlazada que tome como párametro un  origen y un numero entero x ---------------
    // el metodo debe agregar un nodo con valor 0 antes del nodo que contenga el numero entero x, y agregar un nodo al final con
    // valor = cantidad de veces que se encontro el numero x en la lista (Simulacro 12 Ej 3)

    // ESTRATEGIA: recorrer la lista hasta encontrar el numero, si lo encuentro, se agrega un nodo con valor 0 antes del nodo que contenga el numero,
    // y se agrega un nodo al final con valor = cantidad de veces que se encontro el numero en la lista. El origen se trata aparte pq veo un nodo hacia delante
    
    public static Nodo generarLista(Nodo origen, int numero) {
        
        Nodo aux = new Nodo();
        aux = origen;

        int cant = 0;

                
        if (aux.dato == numero) {   // si el nodo es el origen, se agrega un nodo con valor 0 antes del nodo que contenga el numero

            Nodo nuevo = new Nodo();
            nuevo.dato = 0;
            nuevo.sig = aux;

            origen = nuevo;    // cambio el origen por el nuevo nodo

            cant++;
            System.out.println("Se agrego un nodo con valor 0 antes del nodo que contiene el numero - al inicio");
        }

        while (aux.sig != null) {

            if (aux.sig.dato == numero) {   // si el dato del nodo es igual al numero, se agrega un nodo con valor 0 antes del nodo que contenga el numero

                Nodo nuevo = new Nodo();
                nuevo.dato = 0;
                nuevo.sig = aux.sig;    // el nuevo nodo apunta al nodo que contiene el numero
                aux.sig = nuevo;    // el nodo anterior apunta al nuevo nodo
                cant++;
                System.out.println("Se agrego un nodo con valor 0 antes del nodo que contiene el numero - en medio");
                aux = aux.sig.sig; // se mueve el nodo aux al siguiente nodo (tengo que saltear el 0)
            } else {
                aux = aux.sig;  // si no, se mueve el nodo aux al siguiente nodo
            }
        }

        Nodo ultimo = new Nodo();   // se agrega un nodo al final con valor = cantidad de veces que se encontro el numero en la lista
        ultimo.sig = null;
        ultimo.dato = cant;

        System.out.println("Se creo un nodo al final con valor = cantidad de veces que se encontro el numero en la lista");

        aux.sig = ultimo;   // el ultimo nodo de la lista apunta al nuevo ultimo nodo con la cantidad de veces que se encontro el numero en la lista

        return origen;
    }

    // crear funcion para imprimir lista con nodo origen ---------------
    public static void imprimirListaNodo(Nodo origen) {

        Nodo aux = new Nodo();
        aux = origen;

        System.out.println("-");

        while (aux.sig != null) {
            System.out.println(aux.dato);
            aux = aux.sig;
        }
        System.out.println(aux.dato);
        System.out.println("-");
    }

    // crear una funcion para imprimir y agregar una lista enlazada ciclica (Simulacro 5 Ej2) ---------------
    public static void imprimirListaCiclica(Nodo origen) {

        Nodo aux = new Nodo();  // auxiliar para recorrer la lista
        aux = origen;

        while (aux.sig != origen) { // mientras el nodo siguiente no sea el origen, imprime el dato
            System.out.println(aux.dato);
            aux = aux.sig;
        }
        System.out.println(aux.dato); // imprime el dato del ultimo nodo  
    }

    public static void agregarListaCiclica(Nodo origen) { // agrega un nodo al final de la lista

        Nodo nuevo = new Nodo();  // nuevo nodo
        nuevo = origen;

        nuevo.sig = origen.sig; // el nuevo nodo apunta al nodo siguiente del origen
        origen.sig = nuevo;  // el nodo origen apunta al nuevo nodo
    }

    // funcion para concatenar dos listas enlazadas - Ejercicio3 Simulacro 11 Parcial 1 ---------------
    public static Nodo concatenarListas(Nodo origen1, Nodo origen2) {

        Nodo aux1 = new Nodo(); // auxiliar para recorrer la lista 1
        aux1 = origen1;
        Nodo aux2 = new Nodo(); // auxiliar para concatenar la lista 2
        aux2 = origen2;

        while (aux1.sig != null) {  // llego hasta el final de la lista 1
            aux1 = aux1.sig;
        }
        aux1.sig = aux2;    // el ultimo nodo de la lista 1 apunta al primer nodo de la lista 2
        return origen1;
    }


    // funcion para sumar los nodos de una lista de forma recursiva - Ejercicio 1 Recuperatorio Parcial 1 ---------------
    public static int sumarNodos(Nodo origen) {
        if (origen == null) {   // si el nodo es null, retorno -1 (lista vacia)
            return -1;
        } else if (origen.sig == null) {   // si el nodo es el ultimo, retorno el dato del nodo (o si hay un solo nodo)
            return origen.dato;
        } else {    // si no es el ultimo, sumo el dato del nodo con la funcion de sumar nodos
            return origen.dato + sumarNodos(origen.sig);
        }
    }

    // funcion para ordenar de manera ascendente una lista de forma recursiva ---------------
    public static Nodo ordenarLista(Nodo origen) {
        if (origen == null) {   // si el nodo es null, retorno null (lista vacia)
            return null;
        } else if (origen.sig == null) {   // si el nodo es el ultimo, retorno el nodo (o si hay un solo nodo)
            return origen;
        } else {    // si no es el ultimo, llamo a la funcion de ordenar lista con el nodo siguiente
            origen.sig = ordenarLista(origen.sig);
            if (origen.dato > origen.sig.dato) {   // si el dato del nodo es mayor al dato del nodo siguiente, intercambio los datos
                int aux = origen.dato;
                origen.dato = origen.sig.dato;
                origen.sig.dato = aux;
            }
            return origen;
        }
    }

    // funcion para concatenar 2 listas y ordenarlas de menor a mayor (Mezcla) - Simulacro 4 Final ---------------
    public static Nodo Mezcla(Nodo origen1, Nodo origen2) {

        concatenarListas(origen1, origen2); // concateno las listas

        ordenarLista(origen1); // ordeno la lista

        return origen1;
    }


    // funcion para pasar una lista a un ABB y insertar el recorrido inorden en una lista enlazada - Simulacro 4 Final ---------------
    public static listasEnlazadasTDA MezclaABB(Nodo origen1, Nodo origen2) {

        Nodo aux = new Nodo(); // auxiliar para recorrer la lista
        aux = origen1;

        ABB arbol = new ABB(); // arbol para insertar los nodos de la lista en orden
        arbol.InicializarArbol();
        
        while (aux.sig != null) { // inserta los nodos de la lista en orden en el arbol
            arbol.AgregarElem(aux.dato);
            aux = aux.sig;
        }
        arbol.AgregarElem(aux.dato);

        aux = origen2; // auxiliar para recorrer la lista 2

        while (aux.sig != null) { // inserta los nodos de la lista en orden en el arbol
            arbol.AgregarElem(aux.dato);
            System.out.println("se agrego el nodo: " + aux.dato);
            aux = aux.sig;
        }
        arbol.AgregarElem(aux.dato);

        ColaTDA cola = new ColaLD(); // cola para recorrer el arbol en inorden
        cola.InicializarCola();

        InOrden(arbol, cola);   // recorre el arbol en inorden y lo inserta en la cola

        System.out.println(cola.Mostrarcola()); // muestra la cola
        
        // agregar los elementos de la cola a la lista enlazada
        listasEnlazadasTDA melange = new listaEnlazada();
        melange.inicializarLista();

        while (!cola.ColaVacia()) {
            melange.agregarF(cola.Primero());
            cola.Desacolar();
        }

        return melange;
    }

    // recorrido INORDEN del ABB (Agregando los elementos en la cola) ---------------
    public static void InOrden(TDAABB arbol, ColaTDA cola) {
        if (!arbol.ArbolVacio()) {
            InOrden(arbol.HijoIzq(), cola);
            cola.Acolar(arbol.Raiz());
            InOrden(arbol.HijoDer(), cola);
        }
    }
        
}
