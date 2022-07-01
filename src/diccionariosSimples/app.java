package diccionariosSimples;

import conjuntos.*;
import pilas.*;
import colas.*;

public class app {

    /*--------------------------------- MAIN ---------------------------------*/
    public static void main(String[] args) throws Exception {

        /*// crete a new ConjuntoA object
        DiccionarioSimpleL dicc = new DiccionarioSimpleL();

        // inicializar conjunto
        dicc.InicializarDiccionario();

        // Agregar los elementos 1 2 3 4 5 6 7 8 9 10
        dicc.Agregar(1,10);
        dicc.Agregar(2,20);
        dicc.Agregar(3,30);
        dicc.Agregar(4,40);
        dicc.Agregar(5,50);
       
        System.out.println(dicc.Recuperar(4));

        System.out.println(dicc.Claves());
        
        System.out.println(dicc.Valores());

        System.out.println(dicc.Mostrardiccionario());

        dicc.Eliminar(5);

        System.out.println(dicc.Mostrardiccionario());

        System.out.println(cantidadValores(dicc));
        System.out.println(cantidadClaves(dicc));

        System.out.println(mostrarDiccionario(dicc));


        PilaTDA valores = new PilaTF();
        valores.InicializarPila();

        PasajePila(dicc, valores);*/

        DiccionarioSimpleTDA dic1 = new DiccionarioSimpleA();
        DiccionarioSimpleTDA dic2 = new DiccionarioSimpleA();

        dic1.InicializarDiccionario();
        dic2.InicializarDiccionario();

        dic1.Agregar(1, 10);
        dic1.Agregar(2, 15);
        dic1.Agregar(4, 100);


        dic2.Agregar(1, 5);
        dic2.Agregar(2, 30);
        dic2.Agregar(3, 3);
        dic2.Agregar(4, 100);

    
        CombinarDiccionarios(dic1, dic2);

    

    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

    // crear una funcion para obtener la cantidad de claves usando DiccionarioSimpleTDA ---------------
    public static int cantidadClaves(DiccionarioSimpleTDA dicc) {
        int cantidad = 0;
        ConjuntoTDA claves = dicc.Claves();
        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            claves.Sacar(claves.Elegir());
            cantidad++;
        }
        return cantidad;
    }

    // crear una funcion para obtener la cantidad de valores usando DiccionarioSimpleTDA ---------------
    public static int cantidadValores(DiccionarioSimpleTDA dicc) {
        int cantidad = 0;
        ConjuntoTDA valores = dicc.Valores();
        while (!valores.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            valores.Sacar(valores.Elegir());
            cantidad++;
        }
        return cantidad;
    }

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

    // crear funcion para pasar los valores de un diccionario simple a una pila usando DiccionarioSimpleTDA y PilaTDA ---------------
    public static PilaTDA PasajePila(DiccionarioSimpleTDA dic, PilaTDA valores) {
        ConjuntoTDA claves = dic.Claves();
        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            int x = claves.Elegir();
            valores.Apilar(dic.Recuperar(x));
            claves.Sacar(x);
        }
        return valores;
    }

    // crear funcion para pasar los valores de un diccionario simple a una cola usando DiccionarioSimpleTDA y ColaTDA ---------------
    public static ColaTDA PasajeCola(DiccionarioSimpleTDA dic, ColaTDA valores) {
        ConjuntoTDA claves = dic.Claves();
        while (!claves.ConjuntoVacio()) {  // mientras no este vacio el conjunto
            int x = claves.Elegir();
            valores.Acolar(dic.Recuperar(x));
            claves.Sacar(x);
        }
        return valores;
    }

    // crear una funcion para combinar 2 diccionarios simples, si una clave se repite, se pone el valor mas bajo (Simulacro 4 Ej 2) ---------------
    public static DiccionarioSimpleTDA CombinarDiccionarios(DiccionarioSimpleTDA dic1, DiccionarioSimpleTDA dic2 ) {

        DiccionarioSimpleTDA dic3 = new DiccionarioSimpleA();
        dic3.InicializarDiccionario();

        ConjuntoTDA claves1 = dic1.Claves(); // creo un conjunto con las claves del diccionario 1
        ConjuntoTDA claves2 = dic2.Claves(); // creo un conjunto con las claves del diccionario 2


        while (!claves1.ConjuntoVacio()) {

            int clave = claves1.Elegir();

            if (claves2.Pertenece(clave)) { // si la clave pertenece a ambos conjuntos

                claves2.Sacar(clave); // sacar la clave del segundo conjunto

                int valor1 = dic1.Recuperar(clave);
                int valor2 = dic2.Recuperar(clave);
                

                if (valor1 >= valor2){  // si el valor de dic1 es mayor o igual que el valor de dic2
                    dic3.Agregar(clave, valor2);
                    System.out.println("se agregó clave del dicc2 - comparado");


                } else {             // si el valor de dic1 es menor que el valor de dic2
                    dic3.Agregar(clave, valor1);
                    System.out.println("se agregó clave del dicc1 - comparado");

                }

            } else {
                dic3.Agregar(clave, dic1.Recuperar(clave));
                System.out.println("se agregó clave del dicc1");
            }
            claves1.Sacar(clave);
            }

        while (!claves2.ConjuntoVacio()) {  // se agrega el valor del diccionario 2
            int clave = claves2.Elegir();

            dic3.Agregar(clave, dic2.Recuperar(clave));
            System.out.println("se agregó clave del dicc2");  
            claves2.Sacar(clave);
        }

        mostrarDiccionario(dic3);
        return dic3;
    }

}
