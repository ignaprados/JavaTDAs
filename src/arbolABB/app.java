package arbolABB;
import conjuntos.*;


public class app {

    /*--------------------------------- MAIN ---------------------------------*/
    public static void main(String[] args) {
        TDAABB arbol = new ABB();
        arbol.InicializarArbol();
        arbol.AgregarElem(5);
        arbol.AgregarElem(3);
        arbol.AgregarElem(4);
        arbol.AgregarElem(2);
        arbol.AgregarElem(1);

        /*TDAABB arbol2 = new ABB();
        arbol2.InicializarArbol();
        System.out.println("ARBOL1: ");
        ImprimirArbol(arbol);
        arbol2 = Copiar(arbol, arbol2);
        System.out.println("ARBOL1 POST: ");
        ImprimirArbol(arbol);
        System.out.println("ARBOL2: ");
        ImprimirArbol(arbol2);*/

        //System.out.print(Altura(arbol));
    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

    // funcion para imprimir arbol ABB --------------
    public static void ImprimirArbol(TDAABB arbol) {
        if (arbol.ArbolVacio()) {
            System.out.println("Arbol vacio");
        } else {
            System.out.println("Raiz: " + arbol.Raiz());
            ImprimirArbol(arbol.HijoIzq());
            ImprimirArbol(arbol.HijoDer());
        }
    }

    // funcion para buscar un elemento en el ABB - Ejercicio del PPT --------------- 
    public static TDAABB BuscarElementoEnABB(TDAABB arbol, int x) {
        if (arbol.ArbolVacio()) {   // si el arbol esta vacio, devuelve null
            return null;
        } else if (arbol.Raiz() == x) { // si la raiz es igual al dato, devuelve la raiz
            return arbol;

        } else if (arbol.Raiz() > x ) {    // si la raiz es mayor que el dato, busca en el hijo izquierdo
            return BuscarElementoEnABB(arbol.HijoIzq(), x);
        } else {    // si la raiz es menor que el dato, busca en el hijo derecho
            return BuscarElementoEnABB(arbol.HijoDer(), x);
        }
    }

    // funcion para determinar si un elemento está o no en un ABB - TP4 Ejercicio 3a ---------------
    public static boolean Pertenece(int n, TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no pertenece.
            return false;
        } else if (arbol.Raiz() == n) { // si el elemento es la raiz, pertenece.
            return true;

        } else if (arbol.Raiz() > n) {  // si el elemento es menor que la raiz, se busca en el hijo izquierdo.
            return Pertenece(n, arbol.HijoIzq());
        } else {    // si el elemento es mayor que la raiz, se busca en el hijo derecho.
            return Pertenece(n, arbol.HijoDer());
        }
    }

    // funcion para determinar si un elemento es hoja de un ABB - TP4 Ejercicio 3b ---------------
    public static boolean EsHoja(int n, TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no es hoja.
            return false;
        } else if (arbol.Raiz() == n && arbol.HijoDer().ArbolVacio() && arbol.HijoIzq().ArbolVacio()) { // si el elemento es la raiz y los hijos son vacios, es hoja.
            return true;

        } else if (arbol.Raiz() > n) {  // si el elemento es menor que la raiz, se busca en el hijo izquierdo.
            return EsHoja(n, arbol.HijoIzq());
        } else {    // si el elemento es mayor que la raiz, se busca en el hijo derecho.
            return EsHoja(n, arbol.HijoDer());
        }
    }

    // funcion para calcular la profundidad de un elemento en el ABB - TP4 Ejercicio 3c ---------------
    public static int Profundidad(int n, TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no existe.
            return -1;
        } else if (arbol.Raiz() == n) { // si el elemento es la raiz, la profundidad es 0 (nivel cero).
            return 0;

        } else if (arbol.Raiz() > n) {  // si el elemento es menor que la raiz, se busca en el hijo izquierdo y suma 1 nivel.
            return (1 + Profundidad(n, arbol.HijoIzq()));
        } else {    // si el elemento es mayor que la raiz, se busca en el hijo derecho y suma 1 nivel.
            return (1 + Profundidad(n, arbol.HijoDer()));
        }
    }

    // funcion para obtener el valor del menor elemento de un ABB - TP4 Ejercicio 3d ---------------
    public static int Menor(TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no existe.
            return 0;

        } else if (arbol.HijoIzq().ArbolVacio()) {  // si el hijo izquierdo está vacio, el menor es la raiz.
            return (arbol.Raiz());
        } else {    // si el hijo izquierdo no está vacio, se busca en el hijo izquierdo.
            return (Menor(arbol.HijoIzq()));
        }
    }

    // funcion para calcular la cantidad de elementos que contiene un ABB - TP4 Ejercicio 3e ---------------
    public static int Elementos(TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no existe.
            return 0;

        } else {    
            return (1 + Elementos(arbol.HijoDer()) + Elementos(arbol.HijoIzq()));   // se suma 1 por la raiz y se suman la cant de elementos de los hijos.
        }
    }

    // funcion para calcular la suma de los elementos que contiene un ABB. - TP4 Ejercicio 3f ---------------
    public static int Suma(TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, tiene 0 elementos.
            return 0;

        } else {
            return (arbol.Raiz() + Suma(arbol.HijoDer()) + Suma(arbol.HijoIzq()));  // se suma la raiz y se suman los elementos de los hijos.
        }
    }

    // funcion para calcular el cantidad de hojas de un ABB - TP4 Ejercicio 3g ---------------
    public static int Hojas(TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, tiene 0 hojas.
            return 0;

        } else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {  // si los hijos son vacios, es una hoja (suma 1).
            return (1);
        } else {    // si los hijos no son vacios, se suman las hojas de los hijos.
            return (Hojas(arbol.HijoDer()) + Hojas(arbol.HijoIzq()));
        }
    }

    
    // funcion para calcular la altura de un ABB - TP4 Ejercicio 3h ---------------
    public static int Altura(TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no tiene niveles.
            return -1;

        } else if (Altura(arbol.HijoDer()) > Altura(arbol.HijoIzq())) {   // si la altura del hijo derecho es mayor que la izquierdo, se suma 1 y suma la altura del hijo derecho.
            return (Altura(arbol.HijoDer()) + 1);
        } else {    // si la altura del hijo izquierdo es mayor que la derecha, se suma 1 y suma la altura del hijo izquierdo.
            return (Altura(arbol.HijoIzq()) + 1);
        }
    }

    // funcion para comprobar si dos ABBs tienen la misma forma - TP4 Ejercicio 3i ---------------
    public static boolean Forma(TDAABB arbol,TDAABB arbol2) {
        if (arbol.ArbolVacio() && arbol2.ArbolVacio()) {    // si los dos arboles estan vacios, son iguales.
            return true;

        } else if ((arbol.ArbolVacio() && !arbol2.ArbolVacio()) || (!arbol.ArbolVacio() && arbol2.ArbolVacio()) ){  // si uno de los arboles esta vacio y el otro no, no son iguales.
            return false;
        }
        else if ((arbol.HijoDer().ArbolVacio()==arbol2.HijoDer().ArbolVacio()) && (arbol.HijoIzq().ArbolVacio()==arbol2.HijoIzq().ArbolVacio())) {  // si los hijos de los arboles son iguales, se comprueba con los hijos.
            return (Forma(arbol.HijoDer(),arbol2.HijoDer()) && Forma(arbol.HijoIzq(),arbol2.HijoIzq()));
        } else {
            return false;
        }
    }

     // funcion para comprobar si dos ABBs tienen la misma forma (Más eficiente, busca en la raiz) - TP4 Ejercicio 3i ---------------
    public static boolean Similares (TDAABB a1 , TDAABB a2) {

        if ((!a1.ArbolVacio()) && (!a2.ArbolVacio())) { // pregunta si los dos hijos son vacios
            return Similares(a1.HijoIzq(),a2.HijoIzq()) && Similares(a1.HijoDer(), a2.HijoDer()); // si no, vuelve a iterar en los hijos
        } else {
            return ((a1.ArbolVacio() && a2.ArbolVacio())); // retorna true si ambos son vacios o ambos tienen hijos
        }
    }

    // funcion para comprobar si dos ABBs son iguales - TP4 Ejercicio 3j ---------------
    public static boolean Iguales(TDAABB arbol,TDAABB arbol2) {
        if (arbol.ArbolVacio() && arbol2.ArbolVacio()) {    // si los dos arboles estan vacios, son iguales.
            return true;

        } else if ((arbol.ArbolVacio() && !arbol2.ArbolVacio()) || (!arbol.ArbolVacio() && arbol2.ArbolVacio()) || (arbol.Raiz()!=arbol2.Raiz()) ){ // si uno de los arboles esta vacio y el otro no, no son iguales.
            return false;
        }
        else if ((arbol.HijoDer().ArbolVacio() == arbol2.HijoDer().ArbolVacio()) && (arbol.HijoIzq().ArbolVacio() == arbol2.HijoIzq().ArbolVacio()) && (arbol.Raiz()==arbol2.Raiz()) ) {    // si los hijos de los arboles son iguales, se comprueba con los hijos.
            return (Iguales(arbol.HijoDer(),arbol2.HijoDer()) == Iguales(arbol.HijoIzq(),arbol2.HijoIzq()));
        } else {
            return false;
        }
    }


    // funcion para contar la cantidad de elementos que están en un cierto nivel N. - TP4 Ejercicio 3k ---------------
    public static int EnNivel(TDAABB arbol, int N) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, devuelve 0.
            return 0;

        } else if (N == 1) {    // se fija si esta en el nivel de arriba, y si tiene 2 hijos en el nivel N suma 2.
            if (!arbol.HijoDer().ArbolVacio() && !arbol.HijoIzq().ArbolVacio()) {
                return 2;
            } else if (!arbol.HijoDer().ArbolVacio() || !arbol.HijoIzq().ArbolVacio()) {    // si tiene un hijo, se suma 1.
                return 1;
            } else {    // si no tiene hijos, se suma 0.
                return 0;
            }

        } else if (N == 0) {    // si esta en el nivel N, corta la recursividad.
            return 0;
        } else {    // si no esta en el nivel de arriba, se fija si tiene hijos en el nivel N-1.
            return (EnNivel(arbol.HijoDer(), N - 1) + EnNivel(arbol.HijoIzq(), N - 1)); 
        }

    }

    // funcion para mostrar por pantalla todos los elementos que contiene un ABB - TP4 Ejercicio 3l ---------------

        // in-orden: hijo izquierdo, raiz, hijo derecho.
        public static void InOrden(TDAABB arbol) {
            if (!arbol.ArbolVacio()) {
                InOrden(arbol.HijoIzq());
                System.out.print(arbol.Raiz() + " ");
                InOrden(arbol.HijoDer());
            }
        }

        // pre-orden: raiz, hijo izquierdo, hijo derecho.
        public static void PreOrden(TDAABB arbol) {
            if (!arbol.ArbolVacio()) {
                System.out.print(arbol.Raiz() + " ");
                PreOrden(arbol.HijoIzq());
                PreOrden(arbol.HijoDer());
            }
        }
        
        // post-orden: hijo izquierdo, hijo derecho, raiz.
        public static void PostOrden(TDAABB arbol) {
            if (!arbol.ArbolVacio()) {
                PostOrden(arbol.HijoIzq());
                PostOrden(arbol.HijoDer());
                System.out.print(arbol.Raiz() + " ");
            }
        }
    
    // funcion para armar un conjunto con todos los elementos del ABB que son mayores que k - TP4 Ejercicio 3m ---------------
    public static ConjuntoTDA Mayores(TDAABB arbol, int k, ConjuntoTDA c) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no tiene elementos.
            return c;

        } else if (arbol.Raiz() > k) {  // si la raiz es mayor que k, se agrega al conjunto y itera en los hijos.
            c.Agregar(arbol.Raiz());
            Mayores(arbol.HijoDer(), k, c); 
            Mayores(arbol.HijoIzq(), k, c);
            return c;
        } else {    // si la raiz no es mayor que k, se itera en los hijos.
            Mayores(arbol.HijoDer(), k, c);
            Mayores(arbol.HijoIzq(), k, c);
            return c;
        }
    }

    // funcion para obtener el elemento del árbol que es inmediatamente anterior (en valor), al valor v (que está presente en el ABB). - TP4 Ejercicio 3n ---------------
    public static int Anterior(TDAABB arbol, int v) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no tiene elementos.
            return 0;

        } else if (!arbol.HijoDer().ArbolVacio() && arbol.HijoDer().Raiz() == v) {  // si el hijo derecho tiene un elemento con valor v, se devuelve la raiz.
            return (arbol.Raiz());
        } else if (!arbol.HijoIzq().ArbolVacio() && arbol.HijoIzq().Raiz() == v) {  // si el hijo izquierdo tiene un elemento con valor v, se devuelve la raiz.
            return (arbol.Raiz());
        } else {    // si no tiene elementos con valor v, se fija si tiene hijos con valor v.
            return (Anterior(arbol.HijoDer(), v) + Anterior(arbol.HijoIzq(), v));
        }
    }

    // funcion para devolver todos los elementos pares de un ABB - Ejercicio PPT ---------------
    public static ConjuntoTDA Pares(TDAABB arbol, ConjuntoTDA c) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no tiene elementos.
            return c;

        } else if (arbol.Raiz() % 2 == 0) { // si la raiz es par, se agrega al conjunto y itera en los hijos.
            c.Agregar(arbol.Raiz());
            Pares(arbol.HijoDer(), c);
            Pares(arbol.HijoIzq(), c);
            return c;
        } else {    // si la raiz no es par, se itera en los hijos.
            Pares(arbol.HijoDer(), c);
            Pares(arbol.HijoIzq(), c);
            return c;
        }
    }

    // funcion para copiar un ABB a otro - Ejercicio PPT ---------------
    public static TDAABB Copiar(TDAABB arbol, TDAABB arbol2) {
        if (!arbol.ArbolVacio()) {  // si el arbol no está vacio, se copia la raiz.
            arbol2.AgregarElem(arbol.Raiz());
            Copiar(arbol.HijoDer(), arbol2.HijoDer());  // se copian los hijos.
            Copiar(arbol.HijoIzq(), arbol2.HijoIzq());  // se copian los hijos.
            return arbol;

        } else {    // si el arbol está vacio, no hace nada.
            return arbol;
        }
    }

    // funcion para devolver el peso (cantidad de hojas) de un ABB - Ejercicio PPT ---------------
    public static int Peso(TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, tiene 0 hojas.
            return 0;

        } else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {  // si los hijos son vacios, es una hoja (suma 1).
            return (1);
        } else {    // si los hijos no son vacios, se suman las hojas de los hijos.
            return (Hojas(arbol.HijoDer()) + Hojas(arbol.HijoIzq()));
        }
    }

    // funcion para devolver los numeros de un arbol ABB ordenados de mayor a menor - Ejercicio PPT ---------------
    public static void MayMen(TDAABB arbol) {
        if (!arbol.ArbolVacio()) {  // si el arbol no está vacio, se busca el hijo derecho.
            MayMen(arbol.HijoDer());    
            System.out.print(arbol.Raiz() + " ");   // cuando llega al más de la derecha, se imprime la raiz.
            if (!arbol.HijoIzq().ArbolVacio()) {    // pregunta si hay hijo izquierdo, si hay se imprime, y vuelve a iterar MayMen
                MayMen(arbol.HijoIzq());    
            }
        }
    }

    // funcion para devolver los numeros de un arbol ABB ordenados de menor a mayor - Ejercicio PPT v2 ---------------
    public static void MenMay(TDAABB arbol) {
        if (!arbol.ArbolVacio()) {  // si el arbol no está vacio, se busca el hijo izquierdo.
            MenMay(arbol.HijoIzq());    
            System.out.print(arbol.Raiz() + " ");   // cuando llega al más de la izquierda, se imprime la raiz.
            if (!arbol.HijoDer().ArbolVacio()) {    // pregunta si hay hijo derecho, si hay se imprime, y vuelve a iterar MenMay
                MenMay(arbol.HijoDer());    
            }
        }
    }

    // funcion para devolver una lista enlazada con los nodos de un ABB ordenados de mayor a menor - Ejercicio Simulacro Parcial 2 ---------------
    public static class Nodo{   // clase nodo
        int info;
        Nodo sig;
    }
    public static Nodo MenMay2(TDAABB arbol, Nodo origen) {    // ordenar de menor a mayor y devolver la lista enlazada

        if (!arbol.ArbolVacio()) {
            MenMay2(arbol.HijoIzq(),origen);
            origen = AgregarNodo(arbol.Raiz(),origen);
            if(!arbol.HijoDer().ArbolVacio()) {
                origen = MenMay2(arbol.HijoDer(),origen);
            }
        }
        return origen;
    }
    public static Nodo AgregarNodo(int x, Nodo origen) {    // agregar nodo al final de la lista enlazada
        Nodo aux = new Nodo();
        aux = origen;
        Nodo aux2 = new Nodo();
        aux2.info = x;
        aux2.sig = null;
        if (origen == null) {
            origen = aux2;
        } else {
            while(aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = aux2;
        }
        return origen;
    }
    public static void MostrarLista(Nodo origen) {    // mostrar la lista en pantalla
        Nodo aux = new Nodo();
        aux = origen;
        while (aux != null) {
            System.out.print("[" + aux.info + "] -> ");
            aux = aux.sig;
        }
        System.out.print("Null");
    }
    
    // funcion para determinar si un arbol binario es un arbol de busqueda (ABB) - Ejercicio Simulacro 1 Final ---------------
    public static boolean EsABB(TDAABB arbol) {
        if (arbol.ArbolVacio()) {
            return true;
        } else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {
            return true;
        } else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().Raiz() > arbol.Raiz()) {
            return EsABB(arbol.HijoDer());
        } else if (arbol.HijoIzq().Raiz() < arbol.Raiz() && arbol.HijoDer().ArbolVacio()) {
            return EsABB(arbol.HijoIzq());
        } else if (arbol.HijoIzq().Raiz() < arbol.Raiz() && arbol.HijoDer().Raiz() > arbol.Raiz()) {
            return EsABB(arbol.HijoIzq()) && EsABB(arbol.HijoDer());
        } else {
            return false;
        }
    }

}
