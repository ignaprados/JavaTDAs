package colas;

//Estrategia 3 de implementacion de la colas
//este metodo solo utiliza un arreglo para guardar tanto los
//elementos de la cola como la cantidad de elementos de la colas
//la cantidadd de elementos SIEMPRE se guardara en la posicion [0]
//del Array. Los datos de la cola seran almacenados a partir de la
//posicion [1]

public class ColaPU2 implements ColaTDA {
	
	int[] arr; // arreglo que contiene la info de la colas
	
	public void InicializarCola() {
		arr = new int[100];
		arr[0] = 0;
	}
	
	public void Acolar(int x) {
		for(int i = arr[0]; i > 0; i--) {
			arr[i+1] = arr[i];
		}
		arr[1] = x;
		arr[0]++;
	}
	
	public void Desacolar() {
		arr[0]--;
	}
	
	public boolean ColaVacia() {
		return (arr[0] == 0);
	}
	
	public int Primero() {
		return arr[arr[0]];
	}


 	/* --------------------- EXTRAS -------------------------- */
	public String Mostrarcola() {	// Metodo extra para ver los elementos de la cola
		String cola = ""; // string que contiene la cola
		for (int i = 1; i <= arr[0]; i++) {
			cola = cola + (arr[i] + ","); // concatena los elementos de la cola
		}
		cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
		return cola; // Se muestra de izquierda a derecha [ultimo, medio, primero]
	}

	public void Multidesacolar(int x) { // Metodo extra para desacolar x elementos

		while (!ColaVacia() && x > 0) {	// si la cola no esta vacia
			Desacolar();
			x--;
		}
	 }

}
