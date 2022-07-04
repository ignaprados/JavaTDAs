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

    // funcion para pasar elementos de un diccionario simple a un diccionario multiple ---------------
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

    // funcion para imprimir el diccionario usando DiccionarioMultipleTDA ---------------
    public static void mostrarDiccionarioMul(DiccionarioMultipleTDA DicMul) {
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
    }

    // funcion para mostrar el diccionario usando DiccionarioSimpleTDA ---------------
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

     // funcion para obtener la cantidad de claves usando DiccionarioMultipleTDA ---------------
     public static int cantidadClaves(DiccionarioMultipleTDA dicc) {
        int cantidad = 0;
        ConjuntoTDA claves = dicc.Claves();
        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            claves.Sacar(claves.Elegir());
            cantidad++;
        }
        return cantidad;
    } 

    // funcion para pasar de un diccionario multiple a uno simple (Simulacro 6 Ej 1) ---------------
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

    // funcion para generar un DiccionarioMultipleTDA que contenga: las claves presentes en D1 y D2, ---------------
    // con todos los elementos asociados a cada clave - TP3 Ejercicio 5.1 a
    public static DiccionarioMultipleTDA ClavesValores(DiccionarioMultipleTDA dic1, DiccionarioMultipleTDA dic2) {
        ConjuntoTDA claves = new ConjuntoA();  // crear conjunto claves1
        claves.InicializarConjunto();
        ConjuntoTDA claves2 = new ConjuntoA();  // crear conjunto claves2
        claves2.InicializarConjunto();

        claves = dic1.Claves();    // obtener conjunto claves del diccionario 1
        claves2 = dic2.Claves();    // obtener conjunto claves del diccionario 2

        while (!claves2.ConjuntoVacio() ) {  // mientras no este vacio el conjunto de claves 2, agrego todo a claves.
            int x = claves2.Elegir();   // obtener clave

            claves.Agregar(x);  // agregar clave al conjunto claves1
            claves2.Sacar(x);
        }
        
        DiccionarioMultipleTDA dic = new DiccionarioMultipleA();  // crear diccionario multiple de claves y valores
        dic.InicializarDiccionario();

        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto, agrego las claves (agregar las claves y valores al dic nuevo)
            int clave = claves.Elegir();  // obtener clave
            ConjuntoTDA valores = dic1.Recuperar(clave); // obtener conjunto valores de la clave del dic1
            
            while (!valores.ConjuntoVacio()) {  // mientras no este vacio el conjunto (agregar los valores del dic1)
                int valor = valores.Elegir();  // obtener valor
                dic.Agregar(clave, valor);   // agregar valor al diccionario multiple
                valores.Sacar(valor);      // sacar valor del conjunto
            }

            valores = dic2.Recuperar(clave);  // obtener conjunto valores de la clave del dic2
        
            while (!valores.ConjuntoVacio()) {  // mientras no este vacio el conjunto (agregar los valores del dic2)
                int valor = valores.Elegir();  // obtener valor
                dic.Agregar(clave, valor);   // agregar valor al diccionario multiple
                valores.Sacar(valor);      // sacar valor del conjunto
            }

            claves.Sacar(clave);
        }

    return dic;
    }

    // funcion para generar un DiccionarioMultipleTDA que contenga: las claves presentes en D1 y D2, ---------------
    // con todos los elementos comunes a las claves de ambos - TP3 Ejercicio 5.1 b
    public static DiccionarioMultipleTDA ClavesValoresComunes(DiccionarioMultipleTDA dic1, DiccionarioMultipleTDA dic2) {
        ConjuntoTDA claves = new ConjuntoA();  // crear conjunto claves1
        claves.InicializarConjunto();
        ConjuntoTDA claves2 = new ConjuntoA();  // crear conjunto claves2
        claves2.InicializarConjunto();

        claves = dic1.Claves();    // obtener conjunto claves del diccionario 1
        claves2 = dic2.Claves();    // obtener conjunto claves del diccionario 2

        while (!claves2.ConjuntoVacio() ) {  // mientras no este vacio el conjunto de claves 2, agrego todo a claves.
            int x = claves2.Elegir();   // obtener clave

            claves.Agregar(x);  // agregar clave al conjunto claves1
            claves2.Sacar(x);
        }
        
        DiccionarioMultipleTDA dic = new DiccionarioMultipleA();  // crear diccionario multiple de claves comunes
        dic.InicializarDiccionario();

        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto, agrego las claves (agregar las claves y valores al dic nuevo)
            int clave = claves.Elegir();  // obtener clave

            ConjuntoTDA valores1 = dic1.Recuperar(clave); // obtener conjunto valores de la clave del dic1
            ConjuntoTDA valores2 = dic2.Recuperar(clave); // obtener conjunto valores de la clave del dic2
            
            while (!valores1.ConjuntoVacio() && !valores2.ConjuntoVacio()) {  // mientras no este vacio el conjunto (agregar los valores comunes)
                int y = valores2.Elegir();  // obtener valor2

                if (valores1.Pertenece(y)) {  // si los valores estan en ambos conjuntos
                    dic.Agregar(clave, y);   // agregar valor al diccionario multiple
                }
                valores2.Sacar(y);      // sacar valor del conjunto
            }
            claves.Sacar(clave);
        }

    return dic;
    }

    // funcion para generar un DiccionarioMultipleTDA que contenga: las claves comunes en D1 y D2, ---------------
    // con todos los elementos asociados a cada clave - TP3 Ejercicio 5.1 c
    public static DiccionarioMultipleTDA ClavesComunes(DiccionarioMultipleTDA dic1, DiccionarioMultipleTDA dic2) {
        ConjuntoTDA claves1 = new ConjuntoA();  // crear conjunto claves1
        claves1.InicializarConjunto();
        ConjuntoTDA claves2 = new ConjuntoA();  // crear conjunto claves2
        claves2.InicializarConjunto();

        ConjuntoTDA comunes = new ConjuntoA();  // conjunto de claves comunes
        comunes.InicializarConjunto();

        claves1 = dic1.Claves();    // obtener conjunto claves del diccionario 1
        claves2 = dic2.Claves();    // obtener conjunto claves del diccionario 2

        while (!claves1.ConjuntoVacio() && !claves2.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            int x = claves1.Elegir();   // obtener clave

            if (claves2.Pertenece(x)) {    // si la clave del conjunto 1 esta en el conjunto 2
                comunes.Agregar(x);     // agregar clave al conjunto de comunes
            }
            claves1.Sacar(x);
        }
        
        DiccionarioMultipleTDA dic = new DiccionarioMultipleA();  // crear diccionario multiple de claves comunes
        dic.InicializarDiccionario();

        while (!comunes.ConjuntoVacio()) {  // mientras no este vacio el conjunto, agrego las claves (agregar las claves y valores al dic nuevo)
            int clave = comunes.Elegir();  // obtener clave
            ConjuntoTDA valores = dic1.Recuperar(clave); // obtener conjunto valores de la clave del dic1
            
            while (!valores.ConjuntoVacio()) {  // mientras no este vacio el conjunto (agregar los valores del dic1)
                int valor = valores.Elegir();  // obtener valor
                dic.Agregar(clave, valor);   // agregar valor al diccionario multiple
                valores.Sacar(valor);      // sacar valor del conjunto
            }

            valores = dic2.Recuperar(clave);  // obtener conjunto valores de la clave del dic2
        
            while (!valores.ConjuntoVacio()) {  // mientras no este vacio el conjunto (agregar los valores del dic2)
                int valor = valores.Elegir();  // obtener valor
                dic.Agregar(clave, valor);   // agregar valor al diccionario multiple
                valores.Sacar(valor);      // sacar valor del conjunto
            }

            comunes.Sacar(clave);
        }

    return dic;
    }

    // funcion para generar un DiccionarioMultipleTDA que contenga: las claves comunes en D1 y D2, ---------------
    // con todos los elementos comunes a las claves de ambos - TP3 Ejercicio 5.1 d
    public static DiccionarioMultipleTDA ClavesComunesValoresComunes(DiccionarioMultipleTDA dic1, DiccionarioMultipleTDA dic2) {
        ConjuntoTDA claves1 = new ConjuntoA();  // crear conjunto claves1
        claves1.InicializarConjunto();
        ConjuntoTDA claves2 = new ConjuntoA();  // crear conjunto claves2
        claves2.InicializarConjunto();

        ConjuntoTDA comunes = new ConjuntoA();  // conjunto de claves comunes
        comunes.InicializarConjunto();

        claves1 = dic1.Claves();    // obtener conjunto claves del diccionario 1
        claves2 = dic2.Claves();    // obtener conjunto claves del diccionario 2

        while (!claves1.ConjuntoVacio() && !claves2.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            int x = claves1.Elegir();   // obtener clave

            if (claves2.Pertenece(x)) {    // si la clave del conjunto 1 esta en el conjunto 2
                comunes.Agregar(x);     // agregar clave al conjunto de comunes
            }
            claves1.Sacar(x);
        }
        
        DiccionarioMultipleTDA dic = new DiccionarioMultipleA();  // crear diccionario multiple de claves comunes
        dic.InicializarDiccionario();

        while (!comunes.ConjuntoVacio()) {  // mientras no este vacio el conjunto, agrego las claves (agregar las claves y valores al dic nuevo)
            int clave = comunes.Elegir();  // obtener clave

            ConjuntoTDA valores1 = dic1.Recuperar(clave); // obtener conjunto valores de la clave del dic1
            ConjuntoTDA valores2 = dic2.Recuperar(clave); // obtener conjunto valores de la clave del dic2
            
            while (!valores1.ConjuntoVacio() && !valores2.ConjuntoVacio()) {  // mientras no este vacio el conjunto (agregar los valores comunes)
                int y = valores2.Elegir();  // obtener valor2

                if (valores1.Pertenece(y)) {  // si los valores estan en ambos conjuntos
                    dic.Agregar(clave, y);   // agregar valor al diccionario multiple
                }
                valores2.Sacar(y);      // sacar valor del conjunto
            }
            comunes.Sacar(clave);
        }

    return dic;
    }

}
