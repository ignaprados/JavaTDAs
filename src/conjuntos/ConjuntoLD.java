package conjuntos;

// Implementacion dinamica de un conjunto -> siempre hay que recorrer la estructura

public class ConjuntoLD implements ConjuntoTDA {
    private class Nodo {   
        int info;
        Nodo sig;
    }

    private Nodo c; // cabeza de la lista (primer nodo)

    public void InicializarConjunto() {
        c = null;
    }

    public void Agregar(int x) {
        if (!this.Pertenece(x)) {   // verifica que no pertenezca
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = c;  // agrega al principio (apuntando al la cabeza actual)
            c = nuevo;   // cambia la cabeza (origen)
        }
    }

    public int Elegir() {
        return c.info;  // elige el primer elemento por conveniencia
    }

    public boolean ConjuntoVacio() {
        return (c == null);
    }

    public void Sacar(int x) {
        if (c != null) {
            if (c.info == x) {  // si es el primer elemento
                c = c.sig;
            }
            else {
                Nodo aux = c;
                while (aux.sig != null && aux.sig.info != x) {  // si es otro, busca el nodo (parado desde el anterior)
                    aux = aux.sig;
                }
                if (aux.sig != null) {  // si lo encontro
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    public boolean Pertenece(int x) {
        Nodo aux = c;
        while (aux != null && aux.info != x) {  // busca el nodo
            aux = aux.sig;
        }
        return (aux != null);   // retorna true si lo encontro
    }

    
    /* --------------------- EXTRAS -------------------------- */
    public String Mostrarconjunto() {   // metodo extra para ver el conjunto
        
        String s = "";
        Nodo aux = c;
        while (aux != null) {   // recorre la lista
            s += aux.info + " ";
            aux = aux.sig;
        }
        return s; 
    }

    // crear una funcion que recibe como parametro un conjunto y devuelve true si todos sus
    // elementos pertenecen al conjunto. Este metodo debe preservar el conjunto recibido como parametro (simulacro)
    public boolean TodosPertenecen(ConjuntoTDA origen) {

        Boolean pertenece = true; // Pertenece es siempre verdadero al menos que se demuestre lo contrario
        ConjuntoLD aux = new ConjuntoLD();
        aux.InicializarConjunto();
        while (origen.ConjuntoVacio() == false && pertenece == true) {  // mientras el conjunto no este vacio y pertenece sea true

            int indice = origen.Elegir();   // elige el primer elemento
            origen.Sacar(indice);   // saca el elemento del conjunto original
            aux.Agregar(indice);    // agrega el elemento al conjunto auxiliar

            if (!this.Pertenece(indice)) {  // si no pertenece al conjunto
                pertenece = false;
            }
        }

        while (!aux.ConjuntoVacio()) {  // vuelve a agregar los elementos al conjunto original
            int indice = aux.Elegir();
            aux.Sacar(indice);
            origen.Agregar(indice);
        }
        return pertenece;   // retorna true si todos los elementos pertenecen al conjunto
    }

    // Metodo que saca los valores del conjunto que esten en el conjunto origen
    public void SacarTodos(ConjuntoTDA origen) {

        ConjuntoLD aux = new ConjuntoLD();

        aux.InicializarConjunto();

        while (!origen.ConjuntoVacio()) {   // mientras el conjunto no este vacio

            int indice = origen.Elegir();   // elige el primer elemento
            origen.Sacar(indice);   // saca el elemento del conjunto original
            aux.Agregar(indice);    // agrega el elemento al conjunto auxiliar

            if (this.Pertenece(indice)) {   // si pertenece al conjunto
                this.Sacar(indice);
            }
        }

        while (!aux.ConjuntoVacio()) {  // vuelve a agregar los elementos al conjunto original
            int indice = aux.Elegir();
            aux.Sacar(indice);
            origen.Agregar(indice);
        }
    }

}

