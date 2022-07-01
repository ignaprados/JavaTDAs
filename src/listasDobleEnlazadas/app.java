package listasDobleEnlazadas;

public class app {

    /*--------------------------------- MAIN ---------------------------------*/
    public static void main(String[] args) {

        /*listaDobleEnlazada lista = new listaDobleEnlazada();

        lista.inicializarListaDoble();

        lista.agregarF(2);
        lista.agregarF(1);
        lista.agregarF(4);
        lista.agregarF(3);

        listaDobleEnlazada lista2 = new listaDobleEnlazada();

        lista2.inicializarListaDoble();

        lista2.agregarF(2);
        lista2.agregarF(1);
        lista2.agregarF(4);
        lista2.agregarF(3);
        
        lista.mostrar();
        lista.ordenar();
        lista.mostrar(); */


        NodoDoble uno = new NodoDoble();
        NodoDoble dos = new NodoDoble();
        NodoDoble tres = new NodoDoble();
        NodoDoble cuatro = new NodoDoble();

        uno.dato = 1;
        uno.sig = dos;
        uno.prev = null;

        dos.dato = 2;
        dos.sig = tres;
        dos.prev = uno;

        tres.dato = 3;
        tres.sig = cuatro;
        tres.prev = dos;

        cuatro.dato = 4;
        cuatro.sig = null;
        cuatro.prev = tres;

        //agregarNodo(uno, cuatro, 1);

        //mostrar(uno);
        eliminarNodo(uno, cuatro, 4);
        

       

    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

    // crear una funcion para imprimir lista tomando como parametro el nodo origen ---------------
    public static void mostrar(NodoDoble cabeza) {
        NodoDoble aux = new NodoDoble();
        aux = cabeza;
        System.out.println("-");
        while (aux != null) {   // mientras el nodo no sea null imprime el dato
            System.out.println(aux.dato);
            aux = aux.sig;
        }
        System.out.println("-");
    }

   
    // crear una funcion para agregar y otra para eliminar un elemento a una lista doblemente enlazada, ---------------
    // que tome como entrada los elementos cabeza y cola (Simulacro 1 Ej 1)
    public static NodoDoble agregarNodo(NodoDoble cabeza, NodoDoble cola, int valor) {
        NodoDoble nuevo = new NodoDoble();
        nuevo.dato = valor;
        nuevo.prev = null;  // se inicializa prev a null para que se agregue al inicio

        mostrar(cabeza); // mostrar la lista antes de agregar

        if (cabeza == null && cola == null) { // si la lista esta vacia
            nuevo.sig = null;
            cola = nuevo;

        }

        if (cabeza == cola){    // si la lista tiene un solo elemento
            nuevo.sig = cola;
            cola.prev = nuevo;

        } else {    // si la lista tiene mas de un elemento
            nuevo.sig = cabeza;
            cabeza.prev = nuevo;
            
        }

        cabeza = nuevo;
        
        mostrar(cabeza); // mostrar la lista
        return nuevo;
    }

    public static NodoDoble eliminarNodo(NodoDoble cabeza, NodoDoble cola, int valor) {
        NodoDoble aux = new NodoDoble();

        mostrar(cabeza); // mostrar la lista antes de eliminar

        if (cabeza == cola && cabeza != null) { // si la lista tiene un solo elemento
            cabeza = null;
            cola = null;

        } else if (cabeza.dato == valor) { // si el valor es el primero
            cabeza = cabeza.sig;
            cabeza.prev = null;

        } else {
            aux = cabeza;

            while (aux.sig != null && aux.dato != valor) { // mientras el siguiente nodo no sea null, y no se haya encontrado el dato avanza
                aux = aux.sig;
            }

            if (aux.dato == valor && aux.sig == null) { // si se encontro el dato en el ultimo nodo
                cola = aux.prev;
                cola.sig = null;

            } else if (aux.dato == valor && aux.sig != null) { // si se encontro el dato en un nodo intermedio
                (aux.prev).sig = aux.sig;
                (aux.sig).prev = aux.prev;

            } else { // si no se encontro el dato
                System.out.println("No se encontro el dato");
            }
        }

        mostrar(cabeza); // mostrar la lista
        return cabeza;
    }


}
