package colas;

import pilas.*;
import conjuntos.*;

public class app {
	
    /*--------------------------------- MAIN ---------------------------------*/
	public static void main(String[] args) throws Exception {

        /*// crete a new ColaPU object
        ColaTDA cola = new ColaLD();

        // inicializar cola
        cola.InicializarCola();

        // Acolar los elementos 1 2 3 4 5 6 7 8 9 10
        cola.Acolar(1);
        cola.Acolar(2);
        cola.Acolar(3);
        cola.Acolar(4);
        cola.Acolar(5);
        cola.Desacolar();

        // mostrar cola
        System.out.println(cola.Mostrarcola());
        System.out.println(cola.Primero());
        System.out.println(mostrarCola(cola));
        System.out.println(cola.Primero());*/

		// simulacro
		ColaTDA origen = new ColaLD();
		origen.InicializarCola();

		origen.Acolar(1);
		origen.Acolar(2);
		origen.Acolar(2);
		origen.Acolar(2);
		origen.Acolar(3);
		origen.Acolar(1);
		origen.Acolar(3);
		origen.Acolar(5);
		origen.Acolar(3);
		origen.Acolar(3);
		origen.Acolar(2);

		origen.Multidesacolar(9);

		mostrarCola(origen);
		/*System.out.println("HOLA");
		EliminarRepetidosConcurrentes(origen);
		mostrarCola(origen);*/


    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/


    // crear una funcion para imprimir la cola sin perder la original usando ColaTDA ---------------
    public static void mostrarCola(ColaTDA cola) {
        String resultado = "[ ";
        ColaTDA aux = new ColaPU();
        aux.InicializarCola();

        while (!cola.ColaVacia()) { // mientras no este vacia la cola, acolar a la pila auxiliar
            resultado += cola.Primero() + " ";  // imprimir el elemento de la cola
            aux.Acolar(cola.Primero());
            cola.Desacolar();
        }
        resultado += "]";   // cerrar el string

        while (!aux.ColaVacia()) { // mientras no este vacia la cola, acolar a la pila original
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
        System.out.println(resultado);
    }

    // crear una funcion para pasar una Cola a otra - TP1 Ejercicio 4a ---------------
    public static void pasarCola(ColaTDA origen, ColaTDA destino) {
		while(!origen.ColaVacia()) {    // mientras no este vacia la cola
			destino.Acolar(origen.Primero());   // acolar el primer elemento de la cola origen en la cola destino
			origen.Desacolar();  // desacolar el primer elemento de la cola origen
		}
	}

    // crear una funcion para invertir el contenido de una Cola (pueden usarse Pilas auxiliares) - TP1 Ejercicio 4b ---------------
    public static void invertirColaConAUX(ColaTDA origen) {
		PilaTDA aux = new PilaTF(); // crear una pila auxiliar
		aux.InicializarPila();

		while (!origen.ColaVacia()) {   // mientras no este vacia la cola, apilar a la pila auxiliar
			aux.Apilar(origen.Primero());   
			origen.Desacolar();
		}

		while (!aux.PilaVacia()) {  // mientras no este vacia la pila, acolar a la cola origen
			origen.Acolar(aux.Tope());
			aux.Desapilar();
		}
	}

    // crear una funcion para invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares) - TP1 Ejercicio 4c ---------------
    public static void invertirColaSinAux(ColaTDA origen) {
		ColaTDA aux = new ColaPU();
		ColaTDA destino = new ColaPU(); // crear una cola auxiliar, y otra destino
		aux.InicializarCola();
		destino.InicializarCola();
    
		int cantidad = 0;   // cantidad de elementos en la cola

		while (!origen.ColaVacia()) {   // Obtenemos la cantidad de elementos en la cola
			aux.Acolar(origen.Primero());
			origen.Desacolar();
			cantidad++;
		}

		for (int i = 0; i < (cantidad / 2); i++) {  // se guardan 2 elementos de la cola en la cola destino, cuando se pasa a la origen, y desp a la auxiliar
			for (int j = cantidad - (i * 2); j > 1; j--) {	// mientras no se hayan acolado todos los elementos de la cola
				origen.Acolar(aux.Primero());            
				aux.Desacolar();						// acola todo el contenido menos el ultimo elemento de la cola auxiliar en la cola origen
			}
			destino.Acolar(aux.Primero());				// guarda el ultimo elemento de la cola auxiliar en la cola destino
			aux.Desacolar();

			for (int j = cantidad - (i * 2) - 1; j > 1; j--) {
				aux.Acolar(origen.Primero());
				origen.Desacolar();					// acola todo el contenido menos el ultimo elemento de la cola origen en la cola auxiliar
			}
			destino.Acolar(origen.Primero());		// guarda el ultimo elemento de la cola origen en la cola destino
			origen.Desacolar();
		}

		while (!destino.ColaVacia()) {  // mientras no este vacia la cola, acolar a la cola origen
			origen.Acolar(destino.Primero());
			destino.Desacolar();
		}
	}

	// crear una funcion para determinar si el final de la Cola C1 coincide o no con la Cola C2 - TP1 Ejercicio 4d ---------------
	public static boolean finalIguales(ColaTDA origen1, ColaTDA origen2) {
		int n1 = 0;
		int n2 = 0;

		while (!origen1.ColaVacia()) {		
			n1 = origen1.Primero();	// desacolo la cola origen1, y guardo el ultimo elemento en n1
			origen1.Desacolar();
		}

		while (!origen2.ColaVacia()) {
			n2 = origen2.Primero();	// desacolo la cola origen2, y guardo el ultimo elemento en n2
			origen2.Desacolar();
		}
		return (n1 == n2);	// retorna true si los elementos n1 y n2 son iguales
	}
	
	// crear una funcion para determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir  ---------------
	// que el primer elemento es igual al último, el segundo igual al penúltimo, etc - TP1 Ejercicio 4e
	public static boolean esCapicua(ColaTDA origen) {
		PilaTDA aux = new PilaTF();		// crear una pila auxiliar
		ColaTDA aux2 = new ColaPU();	// crear una colas auxiliar
		aux.InicializarPila();
		aux2.InicializarCola();

		boolean capicua = false;

		while (!origen.ColaVacia()) {	
			aux.Apilar(origen.Primero());	// apilar en la pila auxiliar la cola origen (para invertir la cola)
			aux2.Acolar(origen.Primero());	// acolar en la cola auxiliar la cola origen (para comparar)
			origen.Desacolar();
		}

		while (!aux2.ColaVacia()) {
			if (aux.Tope() == aux2.Primero()) {	// si el tope de la pila auxiliar es igual al primer elemento de la cola auxiliar
				capicua = true;
			} else {
				capicua = false;
			}
			aux.Desapilar();
			aux2.Desacolar();
		}

		while (!aux2.ColaVacia()) {			// acolar en la cola auxiliar la cola origen (no perder el contenido)
			origen.Acolar(aux2.Primero());
			aux2.Desacolar();
		}
		return capicua;
	}

	// crear una funcion para determinar si la Cola C1 es la inversa de la Cola C2 (sin perder las colas) - TP1 Ejercicio 4f ---------------
	public static boolean esInversa(ColaTDA or1, ColaTDA or2) {
		PilaTDA aux = new PilaTF();
		ColaTDA aux2 = new ColaPU();	// crear una cola auxiliar
		PilaTDA aux3 = new PilaTF();	// crear dos pilas auxiliares
		aux.InicializarPila();
		aux2.InicializarCola();
		aux3.InicializarPila();

		boolean inversa = true;

		int cant1 = 0;
		int cant2 = 0;

		while (!or1.ColaVacia()) { 	// apilar la cola 1 en la pila aux (invierte el orden)
			aux.Apilar(or1.Primero());
			or1.Desacolar();
			cant1++;				// contar la cantidad de elementos de la cola 1
		}

		while (!or2.ColaVacia()) { // acolar la cola 2 en la cola aux2 (NO invierte el orden)
			aux2.Acolar(or2.Primero());
			or2.Desacolar();
			cant2++;			// contar la cantidad de elementos de la cola 2
		}

		if (cant1 == cant2) {	// si ambas colas tienen la misma cantidad de elementos
			while (!aux.PilaVacia()) {
				if (aux.Tope() != aux2.Primero()) {	// si el tope de la pila aux es diferente al primer elemento de la cola aux2
					inversa = false;
				}
				aux3.Apilar(aux.Tope());		// apilar la pila aux en la pila aux3 (para invertir el orden de nuevo) - v1
				aux.Desapilar();				
				or2.Acolar(aux2.Primero());	// acolar la cola aux2 en la cola 2 (para no perder la cola origen) - v1
				aux2.Desacolar();
			}
		} else {
			inversa = false;

			while (!aux.PilaVacia()) {
				aux3.Apilar(aux.Tope());	// apilar la pila aux en la pila aux3 (para invertir el orden de nuevo) - v2
				aux.Desapilar();
			}

			while (!aux2.ColaVacia()) {
				or2.Acolar(aux2.Primero());	// acolar la cola aux2 en la cola 2 (para no perder la cola origen1) - v2
				aux2.Desacolar();
			}
		}

		while (!aux3.PilaVacia()) {	// acolar la pila aux3 en la cola 1 (para no perder la cola origen2)
			or1.Acolar(aux3.Tope());
			aux3.Desapilar();
		}
		return inversa;	// retorna true si ambas colas son inversas
	}

	// crear una funcion para eliminar todas las ocurrencias de números consecutivos iguales dejando sólo uno (Simulacro 4 Ej 1) ---------------
	public static ColaTDA EliminarRepetidosConcurrentes(ColaTDA origen) {
		ColaTDA aux = new ColaLD();
		aux.InicializarCola();	// crear cola auxiliar
		int g;	// guardar el elemento anterior

		while(!origen.ColaVacia()) {	// mientras la cola origen no este vacia
			g = origen.Primero();
			aux.Acolar(g);

			while(!origen.ColaVacia() && origen.Primero() == g) {	// mientras la cola origen no este vacia y el primer elemento sea igual al anterior
				origen.Desacolar();
			}
		}

		while (!aux.ColaVacia()) {	// acolar la cola auxiliar en la cola origen
			origen.Acolar(aux.Primero());
			aux.Desacolar();
		}

		return origen;
	}
	
	// funcion para concatenar una cola y eliminar los repetidos - Ejercicios Simulacro Final ---------------
	public static ColaTDA ConcatenarColaRep(ColaTDA cola1, ColaTDA cola2) {
		
		ColaTDA destino = new ColaLU();
		destino.InicializarCola();
		
		ColaTDA colaaux = new ColaLU();
		colaaux.InicializarCola();
		
		ColaTDA colaaux2 = new ColaLU();
		colaaux2.InicializarCola();
		
		ConjuntoTDA aux = new ConjuntoA();
		aux.InicializarConjunto();
		
		while (!cola1.ColaVacia()) {
			int x = cola1.Primero();
			aux.Agregar(x);
			colaaux.Acolar(x);
			cola1.Desacolar();
		}
		
		while (!cola2.ColaVacia()) {
			int y = cola1.Primero();
			aux.Agregar(y);
			colaaux2.Acolar(y);
			cola1.Desacolar();
		}
		
		while (!colaaux.ColaVacia()) {
			int z = colaaux.Primero();
			
			if (aux.Pertenece(z)) {
				destino.Acolar(z);
				cola1.Acolar(z);
				aux.Sacar(z);
				
			} else {
				cola1.Acolar(z);
				colaaux.Desacolar();
			}
		}
		
		while (!colaaux2.ColaVacia()) {
			int r = colaaux2.Primero();
			
			if (aux.Pertenece(r)) {
				destino.Acolar(r);
				cola2.Acolar(r);
				aux.Sacar(r);
				
			} else {
				cola1.Acolar(r);
				colaaux.Desacolar();
			}
			
		}
		
		return destino;
	}
	

}
