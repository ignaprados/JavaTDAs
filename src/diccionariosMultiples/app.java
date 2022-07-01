package diccionariosMultiples;

import diccionariosSimples.*;
import conjuntos.*;

public class app {

    /*--------------------------------- MAIN ---------------------------------*/
    public static void main(String[] args) throws Exception {

        /*// crete a new ConjuntoA object
        DiccionarioMultipleL dicc = new DiccionarioMultipleL();

        // inicializar conjunto
        dicc.InicializarDiccionario();

        // Agregar los elementos 1 2 3 4 5 6 7 8 9 10
        dicc.Agregar(1,10);
        dicc.Agregar(2,20);
        dicc.Agregar(2,21);
        dicc.Agregar(3,30);
        dicc.Agregar(4,40);
        dicc.Agregar(4,41);
        dicc.Agregar(4,42);
        dicc.Agregar(5,50);
        dicc.Agregar(6,10);

        dicc.Eliminar(6);
        dicc.EliminarValor(4, 40);


       
        System.out.println(dicc.Recuperar(4));

        System.out.println(dicc.Claves());

        mostrarDiccionario(dicc);

        System.out.println(cantidadClaves(dicc));*/

        DiccionarioMultipleTDA dicMul = new DiccionarioMultipleA();
        dicMul.InicializarDiccionario();

        DiccionarioSimpleTDA dicSim = new DiccionarioSimpleA();
        dicSim.InicializarDiccionario();

        dicMul.Agregar(1, 5);
        dicMul.Agregar(1, 3);
        dicMul.Agregar(1, 2);
        dicMul.Agregar(1, 4);

        dicMul.Agregar(2, -2);
        dicMul.Agregar(2, -5);
        dicMul.Agregar(2, 2);
        dicMul.Agregar(2, 1);

        dicMul.Agregar(3, 0);
        dicMul.Agregar(3, 0);

        dicSim.Agregar(1, 1);

        PasajeDicMul(dicMul, dicSim);
        // mostrarDiccionario(PasajeDicMul(dicMul, dicSim));


    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

    // crear funcion para pasar elementos de un diccionario simple a un diccionario multiple ---------------
    public static void Pasaje(DiccionarioSimpleTDA DicSim, DiccionarioMultipleTDA DicMul) {
        
        ConjuntoTDA claves;
        claves = DicSim.Claves();   // obtener conjunto claves del diccionario simple
        DicSim.InicializarDiccionario();
        while (!claves.ConjuntoVacio()) {   // obtener clave y valor
            int clave = claves.Elegir();
            int valor = DicSim.Recuperar(clave);
            DicMul.Agregar(clave, valor);   // agregar clave y valor al diccionario multiple
            DicSim.Eliminar(clave); // eliminar clave del diccionario simple
        }
    }

    /*// crear funcion para imprimir el diccionario usando DiccionarioMultipleTDA ---------------
    public static void mostrarDiccionario(DiccionarioMultipleTDA DicMul) {
        ConjuntoTDA claves;
        claves = DicMul.Claves();   // obtener conjunto claves del diccionario multiple
        while (!claves.ConjuntoVacio()) {   // obtener clave y valor
            int clave = claves.Elegir();
            ConjuntoTDA valores = DicMul.Recuperar(clave);  // obtener conjunto valores de la clave
            System.out.print("Clave: " + clave + " Valores: "); 
            while (!valores.ConjuntoVacio()) {  // imprimir valores
                System.out.print(valores.Elegir() + " ");   
                valores.Sacar(valores.Elegir());    // sacar valor del conjunto
            }
            System.out.println();   
            claves.Sacar(clave);    
        }
    }*/

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

     // crear una funcion para obtener la cantidad de claves usando DiccionarioMultipleTDA ---------------
     public static int cantidadClaves(DiccionarioMultipleTDA dicc) {
        int cantidad = 0;
        ConjuntoTDA claves = dicc.Claves();
        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            claves.Sacar(claves.Elegir());
            cantidad++;
        }
        return cantidad;
    } 

    // crear una funcion para pasar de un diccionario multiple a uno simple (Simulacro 6 Ej 1) ---------------
    // Si la suma de los valores del array de la clave es + o 0, se pone 1 en el valor del diccionario simple.
    // Si la suma de los valores del array de la clave es -, se pone -1 en el valor del diccionario simple.
    public static DiccionarioSimpleTDA PasajeDicMul( DiccionarioMultipleTDA dicMul, DiccionarioSimpleTDA dicSim) {

        ConjuntoTDA claves = dicMul.Claves();   // obtener conjunto claves del diccionario multiple

        while (!claves.ConjuntoVacio()) {
            
            int clave = claves.Elegir();    // obtener clave

            ConjuntoTDA valores = dicMul.Recuperar(clave);  // obtener conjunto valores de la clave

            int suma = 0;

            while (!valores.ConjuntoVacio()) { // sumar valores
                
                int valor = valores.Elegir();   
                suma += valor; 
                valores.Sacar(valor);
            }

            if (suma >= 0){ // si la suma es + o 0, se pone 1 en el valor del diccionario simple
                dicSim.Agregar(clave, 1);
            } else {    // si la suma es -, se pone -1 en el valor del diccionario simple
                dicSim.Agregar(clave, -1);
            }
            claves.Sacar(clave);
        }

        // mostrarDiccionario(dicSim);

        return dicSim;
    }


}
