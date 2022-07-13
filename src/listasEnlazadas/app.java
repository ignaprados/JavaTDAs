package listasEnlazadas;

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

        System.out.println(uno);

        uno.dato = 2;
        uno.sig = dos;
        dos.dato = 2;
        dos.sig = tres;
        tres.dato = 2;
        tres.sig = cuatro;
        cuatro.dato = 2;
        cuatro.sig = null;

        imprimirListaNodo(generarLista(uno, 2));

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

}
