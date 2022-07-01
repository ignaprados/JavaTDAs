package conjuntos;

// Implementacion estatica de un conjunto

public class ConjuntoA implements ConjuntoTDA {
    private int[] a;    // conjunto -> array desordenado
    private int cant;   // cantidad de elementos en el conjunto

    public void InicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    public void Agregar(int x) {
        if (!this.Pertenece(x)) { // verifica que no pertenezca
            a[cant] = x;
            cant++; // incrementa cantidad de elementos
        }
    }

    public int Elegir() {
        return a[cant - 1]; // elige el ultimo por conveniencia
    }

    public boolean ConjuntoVacio() {
        return (cant == 0);
    }

    public void Sacar(int x) {
        int i = 0;
        while (i < cant && a[i] != x) { // busca la posicion del elemento
            i++;
        }
        if (i < cant) { // encontro el elemento
            a[i] = a[cant - 1]; // reemplaza en la pos del elemento a eliminar por el ultimo del array (tapa el hueco)
            cant--;
        }
    }

    public boolean Pertenece(int x) {
        int i = 0;
        while (i < cant && a[i] != x) { // busca la posicion del elemento
            i++;
        }
        return (i < cant);  // retorna true si lo encontro
    }

    
    /* --------------------- EXTRAS -------------------------- */
    public String Mostrarconjunto() {   // metodo extra para ver el conjunto
        
        String s = "";
        for (int i = 0; i < cant; i++) {
            s += a[i] + " ";
        }
        return s;

    }

    // crear una funcion que recibe como parametro un conjunto y devuelve true si todos sus
    // elementos pertenecen al conjunto. Este metodo debe preservar el conjunto recibido como parametro (simulacro 1 Ej2)
    public boolean TodosPertenecen(ConjuntoTDA origen) {

        Boolean pertenece = true; // Pertenecer es siempre verdadero al menos que se demuestre lo contrario
        ConjuntoA aux = new ConjuntoA();
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
 
    // Metodo que saca los valores del conjunto que esten en el conjunto origen (simulacro 1 Ej2)
    public void SacarTodos(ConjuntoTDA origen) {

        ConjuntoA aux = new ConjuntoA();

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
