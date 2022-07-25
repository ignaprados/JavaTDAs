package pilasLimitada;

public class app {
	
	/*--------------------------------- MAIN ---------------------------------*/
    public static void main(String[] args) throws Exception {
        
        // crear pila limitada
        PilaLimitadaTF pila = new PilaLimitadaTF();
        pila.InicializarPila(4);

        // apilar elementos
        pila.Apilar(1);
        pila.Apilar(2);
        pila.Apilar(3);

        System.out.println(pila.PilaLlena());

        pila.Apilar(4);

        System.out.println(pila.PilaLlena());

        System.out.println(pila.Mostrarpila());

        System.out.println("holis");

        pila.Apilar(5);

        System.out.println(pila.Mostrarpila());

        pila.Apilar(6);

        System.out.println(pila.Mostrarpila());

        System.out.println(pila.Capacidad());


    }

    /*--------------------------------- METODOS EXTRA ---------------------------------*/

}
