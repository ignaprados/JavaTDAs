package conjuntosConOp;

public class OperacionesConjunto implements ConjuntoTDAOp{
	private int[] a; //el contenido del conjunto
	private int cant; //la cantidad de elementos
	
	public void InicializarConjunto() {
		a = new int[100]; // TAMAÑO MÁXIMO ACOTADO
		cant = 0;
	}
	
	public void Agregar(int x) {
		if (!this.Pertenece(x)) { //verificacion de no pertenencia
			a[cant] = x;
			cant++;
		}
	}
	
	public boolean ConjuntoVacio() {
		return (cant == 0);
	}
	
	public int Elegir() {
		return a[cant - 1]; //es arbitrario, podría ser cualquiera
	}
	
	public boolean Pertenece(int x) {
		int i = 0;
		while (i < cant && a[i] != x)
			i++;
		return (i < cant);		
	}
	
	public void Sacar(int x) {
		int i = 0;
		while (i < cant && a[i] != x)
			i++;
		if (i < cant) { //elemento encontrado
			a[i] = a[cant-1];
			cant--;
		}
	}
	
	public ConjuntoTDAOp Union(ConjuntoTDAOp conj1, ConjuntoTDAOp conj2, ConjuntoTDAOp union) {
		while(!conj1.ConjuntoVacio()) {
			int x = conj1.Elegir();
			union.Agregar(x);
			conj1.Sacar(x);
		}
		while(!conj2.ConjuntoVacio()) {
			int x = conj2.Elegir();
			union.Agregar(x);
			conj2.Sacar(x);
		}
		return union;
	}
	
	public ConjuntoTDAOp Diferencia(ConjuntoTDAOp conj1, ConjuntoTDAOp conj2, ConjuntoTDAOp diferencia) {
		while(!conj1.ConjuntoVacio()) {
			int x = conj1.Elegir();
			if(!conj2.Pertenece(x)) {
				diferencia.Agregar(x);
				conj1.Sacar(x);
			}
		}
		return diferencia;
	}
	
	public ConjuntoTDAOp Interseccion(ConjuntoTDAOp conj1, ConjuntoTDAOp conj2,ConjuntoTDAOp interseccion) {
		while(!conj2.ConjuntoVacio()) {
			int x = conj1.Elegir();
			if(conj2.Pertenece(x))
				interseccion.Agregar(x);
			conj1.Sacar(x);
		}
		return interseccion;
	}

}
