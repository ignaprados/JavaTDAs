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

		/*// simulacro
		ColaTDA origen = new ColaPI();
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

		mostrarCola(origen);*/
		/*System.out.println("HOLA");
		EliminarRepetidosConcurrentes(origen);
		mostrarCola(origen);*/

		// simulacro 2 final
		ColaTDA cola = new ColaPI();
		cola.InicializarCola();

		cola.Acolar(1);
		cola.Acolar(3);
		cola.Acolar(2);
		cola.Acolar(5);
		cola.Acolar(4);
		cola.Acolar(3);
		cola.Acolar(4);
		cola.Acolar(5);
		cola.Acolar(7);

		System.out.println(MaxSec(cola));


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
		ColaTDA aux2 = new ColaPU();	// crear una cola auxiliar
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
	
	// funcion para concatenar una cola y eliminar los repetidos - Ejercicio Simulacro Final ---------------
	public static ColaTDA ConcatenarColaRep(ColaTDA cola1, ColaTDA cola2) {
		
		ColaTDA destino = new ColaLD();		// crear cola destino
		destino.InicializarCola();
		ColaTDA colaaux = new ColaLD();		// crear cola auxiliar
		colaaux.InicializarCola();
		ColaTDA colaaux2 = new ColaLD();	// crear cola auxiliar2
		colaaux2.InicializarCola();		
		ConjuntoTDA aux = new ConjuntoA();	// crear conjunto auxiliar
		aux.InicializarConjunto();
		
		while (!cola1.ColaVacia()) {	// acolar la cola 1 en la cola auxiliar
			int x = cola1.Primero();
			aux.Agregar(x);
			colaaux.Acolar(x);
			cola1.Desacolar();
		}
		while (!cola2.ColaVacia()) {	// acolar la cola 2 en la cola auxiliar2
			int y = cola1.Primero();
			aux.Agregar(y);
			colaaux2.Acolar(y);
			cola1.Desacolar();
		}
		
		while (!colaaux.ColaVacia()) {	// acolar la cola auxiliar en la cola destino
			int z = colaaux.Primero();
			
			if (aux.Pertenece(z)) {	// si el elemento esta en el conjunto auxiliar, acolar en destino y origen
				destino.Acolar(z);
				cola1.Acolar(z);
				aux.Sacar(z);		// sacar el elemento del conjunto auxiliar
				
			} else {
				cola1.Acolar(z);	// si no esta en el conjunto auxiliar, acolar solo en origen
				colaaux.Desacolar();
			}
		}
		while (!colaaux2.ColaVacia()) {	// acolar la cola auxiliar2 en la cola destino
			int r = colaaux2.Primero();
			
			if (aux.Pertenece(r)) {	// si el elemento esta en el conjunto auxiliar, acolar en destino y origen
				destino.Acolar(r);
				cola2.Acolar(r);
				aux.Sacar(r);	// sacar el elemento del conjunto auxiliar
				
			} else {
				cola2.Acolar(r);	// si no esta en el conjunto auxiliar, acolar solo en origen2
				colaaux2.Desacolar();
			}
		}
		return destino;
	}
	
	// funcion para eliminar de una Cola C las repeticiones de elementos, dejando un representante de cada uno de los elementos ---------------
	// presentes originalmente. Se deberá respetar el orden original de los elementos, y en el caso de los repetidos 
	// se conservará el primero que haya ingresado en C - TP3 Ejercicio 2a
	public static ColaTDA EliminarRepetidos(ColaTDA origen) {
		ColaTDA aux = new ColaLD();
		aux.InicializarCola();// crear cola auxiliar

		ConjuntoTDA elem = new ConjuntoA();
		elem.InicializarConjunto();	// crear conjunto elementos

		while (!origen.ColaVacia()) {	// acolar la cola origen en la cola auxiliar y agregar los elementos al conjunto
			int x = origen.Primero();
			elem.Agregar(x);
			aux.Acolar(x);
			origen.Desacolar();
		}

		while (!aux.ColaVacia()) {	// acolar la cola auxiliar en la cola origen
			int y = aux.Primero();

			if (elem.Pertenece(y)) {	// si el elemento esta en el conjunto elementos, acolar en origen y sacar del conjunto
				origen.Acolar(y);
				aux.Desacolar();
				elem.Sacar(y);
			} else {
				aux.Desacolar();	// si no esta en el conjunto elementos, no acolar
			}
		}
		return origen;
	}

	// funcion para repartir una Cola C en dos mitades M1 y M2 de elementos consecutivos, respetando el orden. ---------------
	// Asumir que la cantidad de elementos de C es par. - TP3 Ejercicio 2b
	public static void RepartirCola(ColaTDA origen, ColaTDA M1, ColaTDA M2) {
		ColaTDA aux = new ColaLD();
		aux.InicializarCola();	// crear cola auxiliar
		
		int cant = 0;	// cantidad de elementos

		while (!origen.ColaVacia()) {	// acolar la cola origen en la cola auxiliar y contar los elementos
			int x = origen.Primero();
			aux.Acolar(x);
			origen.Desacolar();
			cant++;
		}

		for (int i = 0; i < cant/2; i++) {	// acolar la mitad de la cola auxiliar en la cola M1
			int y = aux.Primero();
			M1.Acolar(y);
			aux.Desacolar();
		}

		while (!aux.ColaVacia()) {	// acolar el resto de la cola auxiliar en la cola M2
			int z = aux.Primero();
			M2.Acolar(z);
			aux.Desacolar();
		}
	}

	// funcion para generar el conjunto de elementos que se repiten en una Cola - TP3 Ejercicio 2c ---------------
	public static ConjuntoTDA ColaRepetidos(ColaTDA origen) {

		ConjuntoTDA aux = new ConjuntoA();	// crear conjunto aux
		aux.InicializarConjunto();

		ConjuntoTDA rep = new ConjuntoA();	// crear conjunto rep
		rep.InicializarConjunto();


		while (!origen.ColaVacia()) {	// acolar la cola origen en la cola auxiliar
			int x = origen.Primero();
			if (aux.Pertenece(x)) {	// si el elemento esta en el conjunto auxiliar, acolar en rep
				rep.Agregar(x);
			}
			aux.Agregar(x);
			origen.Desacolar();
		}

		return rep;
	}


	// funcion para generar un método que tome como entrada la cola Entrada y devuelva una cola Salida conformada como sigue: ---------------
	// Los valores que estén por encima del promedio general de las entradas se acolarán en la cola Salida.... - Ejercicio 1 Simulacro 10 Parcial 1
	public static ColaTDA Separar(ColaTDA entrada) {
		ColaTDA aux = new ColaLD();
		aux.InicializarCola();	// crear cola auxiliar

		ColaTDA mayores = new ColaLD();	// crear cola mayores
		mayores.InicializarCola();

		ColaTDA menores = new ColaLD();	// crear cola menores
		menores.InicializarCola();

		ColaTDA iguales = new ColaLD();	// crear cola iguales
		iguales.InicializarCola();

		ColaTDA salida = new ColaLD();	// crear cola salida
		salida.InicializarCola();
		
		int cant = 0;	// cantidad de elementos
		int suma = 0;	// suma de elementos
		int prom = 0;	// promedio de elementos
		
		while (!entrada.ColaVacia()) {	// acolar la cola entrada en la cola auxiliar y contar los elementos, etc
			int x = entrada.Primero();
			aux.Acolar(x);
			entrada.Desacolar();
			cant++;
			suma += x;
		}
		
		prom = suma/cant;
		
		while (!aux.ColaVacia()) {	// acolar la cola auxiliar en las colas correspondientes y en entrada
			int y = aux.Primero();
			entrada.Acolar(y);

			if (y > prom) {	// si el elemento es mayor al promedio, acolar en salida
				mayores.Acolar(y);
			} else if (y < prom) {	// si el elemento es menor al promedio, acolar en menores
				mayores.Acolar(y);
			} else {	// si el elemento es igual al promedio, acolar en iguales
				iguales.Acolar(y);
			}
			aux.Desacolar();
		}

		while (!mayores.ColaVacia()) {	// acolar la cola mayores en la cola salida
			int z = mayores.Primero();
			salida.Acolar(z);
			mayores.Desacolar();
		}
		salida.Acolar(0);	// acolar el 0 (separador) en la cola salida

		while (!iguales.ColaVacia()) {	// acolar la cola iguales en la cola salida
			int z = iguales.Primero();
			salida.Acolar(z);
			iguales.Desacolar();
		}
		salida.Acolar(0);	// acolar el 0 (separador) en la cola salida

		while (!menores.ColaVacia()) {	// acolar la cola menores en la cola salida
			int z = menores.Primero();
			salida.Acolar(z);
			menores.Desacolar();
		}
		salida.Acolar(0);	// acolar el 0 (separador) en la cola salida

		return salida;
	}

	// funcion para calcular el promedio de los dos máximos elementos y los dos mínimos elementos de C - Ejercicio 4 Simulacro 11 Parcial 1 ---------------
	public static float PromedioMaxMin(ColaTDA C, int max, int min) {		
		int suma = 0;	// suma de elementos
		float prom = 0;	// promedio de elementos
		
		int max1 = 0;	// máximo 1
		int max2 = 0;	// máximo 2
		int min1 = 0;	// mínimo 1
		int min2 = 0;	// mínimo 2
		
		while (!C.ColaVacia()) {	// agregar los elementos de la cola en las variables correspondientes
			int y = C.Primero();
			if (y > max1) {	// si el elemento es mayor al máximo 1, cambiar el máximo 1
				max2 = max1;
				max1 = y;
			} else if (y > max2) {	// si el elemento es mayor al máximo 2, cambiar el máximo 2
				max2 = y;
			}
			if (y < min1) {	// si el elemento es menor al mínimo 1, cambiar el mínimo 1
				min2 = min1;
				min1 = y;
			} else if (y < min2) {	// si el elemento es menor al mínimo 2, cambiar el mínimo 2
				min2 = y;
			}
			C.Desacolar();
		}

		suma = max1 + max2 + min1 + min2;	// sumar los 4 elementos

		prom = suma/4;	// calcular el promedio

		return prom;

	}

	// funcion para generar un método que tome como entrada una cola y devuelva la maxima secuencia ascendente - Ejercicio 4 Simulacro 2 Final ---------------
	public static int MaxSec(ColaTDA cola) {

		int max = 1;	// máximo

		// si la cola es 1,3,2,7 la max secuencia ascendente es 2
		// si la cola es 1,3,2,7,4,5,6,8 la max secuencia ascendente es 4
		// si la cola es 1,3,2,7,4,5,6,8,9 la max secuencia ascendente es 5
		// si la cola es 1,3,2,7,4,5,6,8,9,10 la max secuencia ascendente es 6

		int anterior = cola.Primero();
		cola.Desacolar();

		while (!cola.ColaVacia()) {	// agregar los elementos de la cola en las variables correspondientes
			int nuevo = cola.Primero();

			if (nuevo > anterior) {	// si el nuevo elemento es mayor al anterior, sumar 1 al máximo
				max++;
			} else {	// si el nuevo elemento es menor al anterior, reiniciar el máximo
				max = 1;
			}

			anterior = nuevo;
			cola.Desacolar();
		}

		return max;

	}

}

