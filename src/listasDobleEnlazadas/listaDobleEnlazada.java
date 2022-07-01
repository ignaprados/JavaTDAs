package listasDobleEnlazadas;

public class listaDobleEnlazada implements listasDobleEnlazadasTDA {

    NodoDoble origen;

    public void inicializarListaDoble() { // inicializa la lista

        origen = null;

    }

    public boolean listaVacia() { // si origen es null, la lista esta vacia

        if (this.origen == null) {

            return true;

        } else {

            return false;

        }

    }

    public void agregarF(int valor) { // agrega un elemento al final de la lista

        NodoDoble nuevo = new NodoDoble();
        nuevo.dato = valor;
        nuevo.sig = null; // el nuevo nodo apunta a null para que sea el ultimo

        if (this.listaVacia()) { // si la lista esta vacia, el nuevo nodo sera el origen

            this.origen = nuevo;

        } else {

            NodoDoble aux = this.origen;

            while (aux.sig != null) { // mientras el siguiente nodo no sea null, avanza

                aux = aux.sig;

            }

            aux.sig = nuevo; // el ultimo nodo apunta al nuevo nodo
            nuevo.prev = aux; // el nuevo nodo apunta al ultimo nodo

        }

    }

    public void eliminarPos(int pos) {

        // si la lista esta vacia, no se puede eliminar
        if (this.listaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // eliminar
            NodoDoble aux = new NodoDoble();
            aux = this.origen;

            if (pos == 0) { // si se quiere eliminar el primer nodo de la lista

                if (this.origen.sig == null) { // si  hay un solo elemento en la lista, eliminar origen

                    origen = null;
                
                } else { // si hay mas de un elemento en la lista, se cambia el origen por el siguiente

                    this.origen = aux.sig;
                    this.origen.prev = null;
                }

            } else {

                for (int i = 0; i < pos - 1; i++) { // recorre la lista hasta encontrar el nodo anterior al nodo a eliminar

                    aux = aux.sig;

                }

                NodoDoble aux2 = new NodoDoble(); // se crea un nuevo nodo auxiliar para guardar el nodo a eliminar
                aux2 = aux.sig; // se guarda el nodo a eliminar

                aux.sig = aux2.sig; // el nodo anterior apunta al siguiente nodo
                (aux2.sig).prev = aux; // el siguiente nodo apunta al nodo anterior

            }

        }
    }

    public void eliminarValor(int valor) {

        // si la lista esta vacia, no se puede eliminar
        if (this.listaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // eliminar
            NodoDoble aux = new NodoDoble();
            aux = this.origen;

            if (aux.dato == valor) { // si el valor del nodo a eliminar es el origen

                if (this.origen.sig == null) { // si  hay un solo elemento en la lista, eliminar origen

                    origen = null;
                
                } else { // si hay mas de un elemento en la lista, se cambia el origen por el siguiente

                    this.origen = aux.sig;
                    this.origen.prev = null;
                }

            } else {

                // recorre la lista hasta encontrar el nodo a eliminar
                while (aux.sig != null && aux.dato != valor) {

                    aux = aux.sig;

                }

                if (aux.sig == null && aux.dato != valor)  { // si el nodo a eliminar no se encuentra en la lista

                    System.out.println("El valor no se eliminó porque no encuentra en la lista");

                } else if (aux == this.origen) {  // si el nodo a eliminar es el primero

                        this.origen = aux.sig;
                        this.origen.prev = null;

                } else if (aux.sig == null) {  // si el nodo a eliminar es el ultimo

                    (aux.prev).sig = null;

                } else { // si el nodo a eliminar se encuentra en medio de la lista

                    (aux.prev).sig = aux.sig;
                    (aux.sig).prev = aux.prev;

                }

            }

        }
    }

    public void obtener(int pos) {

        // si la lista esta vacia, no se puede obtener
        if (this.listaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a obtener
            NodoDoble aux = new NodoDoble();
            aux = this.origen;

            for (int i = 0; i < pos; i++) { // recorre la lista hasta encontrar el nodo a obtener

                aux = aux.sig;

            }

            System.out.println("El valor del nodo en la posicion " + pos + " es: " + aux.dato);

        }

    }

    public void insertar(int valor, int pos) {

        NodoDoble nuevo = new NodoDoble();
        nuevo.dato = valor;

        // si la lista esta vacia, se agrega el nodo al inicio
        if (this.listaVacia()) {

            this.origen = nuevo;
            nuevo.sig = null; // el nuevo nodo apunta a null para que sea el ultimo
            this.origen.prev = null;

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo
            // anterior al que se
            // quiere insertar
            NodoDoble aux = new NodoDoble();
            aux = this.origen;

            if (pos == 0) { // si se quiere insertar el primer nodo de la lista se cambia origen por el
                            // nuevo nodo

                nuevo.sig = aux;
                this.origen = nuevo;
                this.origen.prev = null;

            } else {

                for (int i = 0; i < pos - 1; i++) { // encontrar el nodo anterior al que se quiere insertar
                    aux = aux.sig;
                }
                // se inserta el nodo
                nuevo.sig = aux.sig;
                aux.sig = nuevo;
                nuevo.prev = aux;
                (aux.sig).prev = nuevo;

            }

        }
    }

    public void buscar(int valor) {

        // si la lista esta vacia, no se puede buscar
        if (this.listaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // buscar
            NodoDoble aux = new NodoDoble();
            aux = this.origen;
            while (aux.dato != valor && aux.sig != null) {
                aux = aux.sig;
            }
            // se obtiene el valor del nodo
            if (aux.dato == valor) {
                System.out.println("El valor se encuentra en la lista");
            } else {
                System.out.println("El valor no se encuentra en la lista");
            }
        }

    }

    public void mostrar() {

        // si la lista esta vacia, no se puede imprimir
        if (this.listaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // imprimir
            NodoDoble aux = new NodoDoble();
            aux = this.origen;
            System.out.print("[");
            while (aux.sig != null) {
                System.out.print(aux.dato + "-");
                aux = aux.sig;
            }
            System.out.print(aux.dato + "]");

        }

    }

    public void ordenar() {

        // ordenar lista por valor ascendente

        if (this.listaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // ordenar elementos de la lista por valor ascendente (ord por metodo burbujeo) 
            NodoDoble aux = new NodoDoble();
            aux = this.origen;
            int aux2;
            boolean cambio = true;

            while (cambio) { // mientras haya cambios en el orden de los elementos

                cambio = false;
                while (aux.sig != null) { // recorre la lista hasta encontrar el ultimo elemento

                    if (aux.dato > aux.sig.dato) { // si el elemento actual es mayor que el siguiente

                        aux2 = aux.dato;  // se invierte el orden de los elementos
                        aux.dato = aux.sig.dato;    
                        aux.sig.dato = aux2;
                        cambio = true;  // se cambio el orden de los elementos

                    }
                    aux = aux.sig; // se avanza al siguiente nodo

                }
                aux = this.origen; // se vuelve al primer nodo de la lista

            }

        }

    }

}
