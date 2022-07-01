package colasPrioridad;

public class app {

    /*--------------------------------- MAIN ---------------------------------*/
	public static void main(String[] args) throws Exception {

        // crete a new ColaPU object
        ColaPrioridadLD cola = new ColaPrioridadLD();

        // inicializar cola
        cola.InicializarCola();
        System.out.println(cola.ColaVacia());

        // Acolar los elementos 30, 10
        cola.AcolarPrioridad(30,3);
        cola.AcolarPrioridad(10,2);
        
        System.out.println(cola.ColaVacia());
        
        System.out.println(cola.Primero());
        System.out.println(cola.Prioridad());

        // mostrar cola
        System.out.println(cola.MostrarcolaPrioridad());

        System.out.println(mostrarCola(cola));

    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

    // crear una funcion para imprimir la cola con prioridad usando ColaTDA (sin perder la cola original) ---------------
    public static String mostrarCola(ColaPrioridadTDA cola) {
        String resultado = "[ ";
        ColaPrioridadTDA aux = new ColaPrioridadLD();   // crear una cola auxiliar
        aux.InicializarCola();

        while (!cola.ColaVacia()) { // mientras no este vacia la cola, acolar a la cola auxiliar
            resultado += cola.Primero() + " ";  // imprimir el elemento de la cola
            aux.AcolarPrioridad(cola.Primero(),cola.Prioridad());
            cola.Desacolar();
        }
        resultado += "]";   // cerrar el string

        while (!aux.ColaVacia()) { // mientras no este vacia la cola, acolar a la cola original
            cola.AcolarPrioridad(aux.Primero(),aux.Prioridad());
            aux.Desacolar();
        }
        return resultado;
    }

    // crear una funcion para combinar dos colas con prioridades CP1 y CP2, generando una nueva cola con prioridades.
    // Considerar que a igual prioridad, los elementos de la CP1 son más prioritarios que los de la CP2 - TP1 Ejercicio 6a ---------------
    public static void combinarColas(ColaPrioridadTDA origen1, ColaPrioridadTDA origen2, ColaPrioridadTDA destino) {

		while (!origen2.ColaVacia()) {  // acolar la cola origen2 en la cola destino
			destino.AcolarPrioridad(origen2.Primero(), origen2.Prioridad());
			origen2.Desacolar();
		}   //NOTA: Ante igual prioridad, se adelanta al ultimo que llega (Por eso la cola origen1 esta abajo)

		while (!origen1.ColaVacia()) {  // acolar la cola origen1 en la cola destino
			destino.AcolarPrioridad(origen1.Primero(), origen1.Prioridad());
			origen1.Desacolar();
		}
	}

    // crear una funcion para determinar si dos Colas con prioridad son idénticas (sin perder las colas originales) - TP1 Ejercicio 6b ---------------
    public static boolean SonIdenticas(ColaPrioridadTDA origen1, ColaPrioridadTDA origen2) {
		ColaPrioridadTDA aux = new ColaPrioridadDA();
		ColaPrioridadTDA aux2 = new ColaPrioridadDA();
		aux.InicializarCola();  
		aux2.InicializarCola(); // Crear dos colas auxiliares para no perder las colas originales

		boolean identicas = true;

		int cant1 = 0;  // cantidad de elementos de ambas colas
		int cant2 = 0;

		while (!origen1.ColaVacia()) {  // acolar la cola origen1 en la cola aux
			aux.AcolarPrioridad(origen1.Primero(), origen1.Prioridad());
			origen1.Desacolar();
			cant1++;
		}

		while (!origen2.ColaVacia()) {  // acolar la cola origen2 en la cola aux2
			aux2.AcolarPrioridad(origen2.Primero(), origen2.Prioridad());
			origen2.Desacolar();
			cant2++;
		}

		if (cant1 == cant2) {   // si la cantidad de elementos de las dos colas es igual, comparar elemento a elemento
			while (!aux.ColaVacia() && !aux2.ColaVacia()) { // mientras no esten vacias

				if (aux.Primero() != aux2.Primero() || aux.Prioridad() != aux2.Prioridad()) {   // si los elementos son diferentes
					identicas = false;
				}
				origen1.AcolarPrioridad(aux.Primero(), aux.Prioridad());    // acolar la cola aux en la cola origen1 - v1
				origen2.AcolarPrioridad(aux2.Primero(), aux2.Prioridad());  // acolar la cola aux2 en la cola origen2 - v1
				aux.Desacolar();
				aux2.Desacolar();
			}
		} else {
			identicas = false;
			while (!aux.ColaVacia()) {
				origen1.AcolarPrioridad(aux.Primero(), aux.Prioridad()); // acolar la cola aux en la cola origen1 - v2
				aux.Desacolar();
			}

			while (!aux.ColaVacia()) {  
				origen2.AcolarPrioridad(aux2.Primero(), aux2.Prioridad()); // acolar la cola aux2 en la cola origen2 - v2
				aux2.Desacolar();
			}
		}
		return identicas;
	}

    
}
