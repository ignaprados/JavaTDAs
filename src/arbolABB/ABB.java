package arbolABB;

public class ABB implements TDAABB {

	public class NodoABB {	//	nodo del arbol
		int dato;	
		TDAABB hijoIzq;
		TDAABB hijoDer;
	}

	NodoABB raiz;	//	raiz del arbol

	public void InicializarArbol() {	//	inicializa el arbol
		raiz = null;
	}

	public int Raiz() {		//	devuelve el dato de la raiz
		return raiz.dato;
	}

	public TDAABB HijoIzq() {	//	devuelve el arbol hijo izquierdo
		return raiz.hijoIzq;
	}

	public TDAABB HijoDer() {	//	devuelve el arbol hijo derecho
		return raiz.hijoDer;
	}

	public boolean ArbolVacio() {	//	devuelve true si el arbol esta vacio
		return (raiz == null);
	}

	public void AgregarElem(int x) {	//	agrega un elemento al arbol
		if (raiz == null) {		//	si el arbol esta vacio
			raiz = new NodoABB();
			raiz.dato = x;	//	agrega el dato a la raiz

			raiz.hijoIzq = new ABB();	//	crea el arbol hijo izquierdo
			raiz.hijoIzq.InicializarArbol();	
			raiz.hijoDer = new ABB();	//	crea el arbol hijo derecho
			raiz.hijoDer.InicializarArbol();

		} else if (raiz.dato > x) {	//	si el dato de la raiz es mayor que el dato a agregar
			raiz.hijoIzq.AgregarElem(x);

		} else if (raiz.dato < x) {	//	si el dato de la raiz es menor que el dato a agregar
			raiz.hijoDer.AgregarElem(x);
		}
	}

	public void EliminarElem(int x) {	//	elimina un elemento del arbol
		if (raiz != null) {
			if (raiz.dato == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {	//	si el dato de la raiz es igual al dato a eliminar y los dos hijos son vacios
				raiz = null;

			} else if (raiz.dato == x && !raiz.hijoIzq.ArbolVacio()) {	//	si el dato de la raiz es igual al dato a eliminar y el hijo izquierdo no es vacio
				raiz.dato = this.mayor(raiz.hijoIzq);	//	cambia la raiz por el mayor de los hijos izquierdos
				raiz.hijoIzq.EliminarElem(raiz.dato);	//	elimina el dato del mayor hijo izquierdo, en la posición vieja

			} else if (raiz.dato == x && raiz.hijoIzq.ArbolVacio()) {	//	si el dato de la raiz es igual al dato a eliminar y el hijo derecho no es vacio
				raiz.dato = this.menor(raiz.hijoDer);	//	cambia la raiz por el menor de los hijos derechos
				raiz.hijoDer.EliminarElem(raiz.dato);	//	elimina el dato del menor hijo derecho, en la posición vieja

			} else if (raiz.dato < x) {	//	si el dato de la raiz es menor que el dato a eliminar
				raiz.hijoDer.EliminarElem(x);	//	vuelve a iterar sobre hijo derecho
			} else {	//	si el dato de la raiz es mayor que el dato a eliminar
				raiz.hijoIzq.EliminarElem(x);	//	vuelve a iterar sobre hijo derecho
			}
		}
	}

	private int mayor(TDAABB a) {	//	devuelve el nodo mayor
		if (a.HijoDer().ArbolVacio()) {	
			return a.Raiz();
		} else {
			return mayor(a.HijoDer());
		}
	}

	private int menor(TDAABB a) {	//	devuelve el nodo menor
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		} else {
			return menor(a.HijoIzq());
		}
	}

}
