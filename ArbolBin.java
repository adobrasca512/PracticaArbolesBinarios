package PracticaExamen2;

import java.util.*;
// el lado izquierdo siempre va a ser menor.
// no seria un arbol binario porque no se pueden repetir valores .
public class ArbolBin<T> {
	class NodoBin {
		T info;
		NodoBin hijoIzq;
		NodoBin hijoDcho;

		NodoBin(NodoBin hIzq, T info, NodoBin hDcho) {
			this.hijoIzq = hIzq;
			this.hijoDcho = hDcho;
			this.info = info;
		}
	}

	private NodoBin raiz;

	public ArbolBin() {
		raiz = null;
	}

	public boolean buscar_datos_ABIN(ArbolBin<Integer> a, int dato) {
		if (a.esVacio()) {
			return false;
		} else {
			if (a.raiz() == dato) {

				return true;
			} else {
				if (dato < a.raiz()) {
					return buscar_datos_ABIN(a.hijoizquierdo(), dato);
				} else {
					return buscar_datos_ABIN(a.hijoderecho(), dato);
				}
			}
		}

	}

	public ArbolBin<T> hijoderecho() {
		ArbolBin<T> subDcho = new ArbolBin<T>();
		subDcho.raiz = this.raiz.hijoDcho;

		return subDcho;
	}

	public ArbolBin<T> sethijoderecho(NodoBin x) {
		ArbolBin<T> subDcho = new ArbolBin<T>();
		this.raiz.hijoDcho = x;
		subDcho.raiz = this.raiz.hijoDcho;
		return subDcho;
	}

	public ArbolBin<T> hijoizquierdo() {
		ArbolBin<T> subIzq = new ArbolBin<T>();
		subIzq.raiz = this.raiz.hijoIzq;
		return subIzq;
	}

	public ArbolBin<T> sethijoizquierdo(NodoBin x) {
		ArbolBin<T> subIzq = new ArbolBin<T>();
		this.raiz.hijoIzq = x;
		subIzq.raiz = this.raiz.hijoIzq;
		return subIzq;
	}

	public ArbolBin(ArbolBin<T> subIzq, T infoRaiz, ArbolBin<T> subDcho) {

		NodoBin izq = subIzq == null ? null : subIzq.raiz;
		NodoBin dcho = subDcho == null ? null : subDcho.raiz;
		this.raiz = new NodoBin(izq, infoRaiz, dcho);
	}

	public boolean esVacio() {
		return raiz == null;
	}

	public T raiz() {
		return this.raiz.info;
	}

	public static ArbolBin<Integer> buscar(ArbolBin<Integer> a, int dato) {
		if (a.esVacio()) {
			return a;
		} else if (dato == a.raiz()) {
			return a;
		} else if (dato > a.raiz()) {
			return buscar(a.hijoderecho(), dato);
		} else {
			return buscar(a.hijoizquierdo(), dato);
		}
	}

	/**
	 * Punto en donde quede atorada en este problema: logre capturar los nodos
	 * finales pero...el asunto es eliminarlos En los que considere dos opciones
	 * pero me aculille porque no quiero hacer trabajo extra asi que le consultare
	 * al profesor. Opcion 1: cada vez que encuentro un nodo final, buscar esos
	 * nodos finales y cepillarlos. Opcion 2: En los else if voy creando un arbol
	 * auxiliar que vaya añadiendo todos los nodos a excepcion de los finales (no se
	 * como hacer ninguno de los dos)
	 * 
	 * @param a
	 * @return
	 */

	public ArbolBin<Integer> buscarUltimaposicion(ArbolBin<Integer> a) {

		if (a.hijoderecho().esVacio() && a.hijoizquierdo().esVacio()) {
			// System.out.println("-------------------------------------");
			System.out.println("-------------------------------------");
			System.out.println("He encontrado un ultimo nodo!");
			System.out.println("el ultimo valor es:" + a.raiz());
			// System.out.println("el ultimo valor es:" + a.raiz());

			// System.out.println("verifico que borre la raiz"+a.raiz());
			return a;
		} else {
			if (a.raiz() != null) {
				// System.out.println("Raiz:"+a.raiz());

			}
			if (!a.hijoizquierdo().esVacio()) {

				// System.out.println("Hijo izquierdo:"+a.hijoizquierdo().raiz());
				buscarUltimaposicion(a.hijoizquierdo());
			}
			if (!a.hijoderecho().esVacio()) {
				// .out.println("Hijo derecho:"+a.hijoderecho().raiz());
				buscarUltimaposicion(a.hijoderecho());
			}
			// redactarContenido(a.hijoderecho());

			// redactarContenido(a.hijoderecho());
		}
		return a;

		/*
		 * else{ System.out.println("no esta vacio");
		 * System.out.println("miramos el hijo derecho");
		 * nuevo=buscarUltimaposicion(a.hijoderecho()); }
		 * System.out.println("-----------");
		 */
		// buscarUltimaposicion(a.hijoizquierdo());

	}

	public ArbolBin<Integer> redactarContenido(ArbolBin<Integer> a, int nivel) {
		if (a.hijoderecho().esVacio() && a.hijoizquierdo().esVacio()) {
			return a;
		} else {
			System.out.println("Estas en el nivel: " + nivel);
			if (a.raiz() != null) {
				System.out.println("Raiz:" + a.raiz());

			}
			if (!a.hijoizquierdo().esVacio()) {

				System.out.println("Hijo izquierdo:" + a.hijoizquierdo().raiz());

			}
			if (!a.hijoderecho().esVacio()) {
				System.out.println("Hijo derecho:" + a.hijoderecho().raiz());

			}
			redactarContenido(a.hijoizquierdo(), nivel + 1);
			if (!a.hijoderecho().esVacio()) {
				redactarContenido(a.hijoderecho(), nivel + 1);
			}
		}
		return a;

	}

	public int contarNodos(ArbolBin<Integer> a, int contador) {
		if (a.hijoderecho().esVacio() && a.hijoizquierdo().esVacio()) {
			System.out.println("En total hay: " + contador + " nodos.");
			return contador;
		} else {
			if (!a.hijoizquierdo().esVacio()) {
				contador++;
				System.out.println("contando hijo izq: " + contador);
			}
			if (!a.hijoderecho().esVacio()) {
				contador++;
				System.out.println("contando hijo der: " + contador);
			}
			int x = contarNodos(a.hijoizquierdo(), contador);
			if (!a.hijoderecho().esVacio()) {
				contarNodos(a.hijoderecho(), x);
			}

			return (contador);
		}
	}

	public int contarTerminales(ArbolBin<Integer> a, int contadorterminales) {

		if (a.hijoderecho().esVacio() && a.hijoizquierdo().esVacio()) {
			contadorterminales = contadorterminales + 1;
			return (contadorterminales);
		} else {

			int x = 0;
			int y = 0;
			x = contarTerminales(a.hijoizquierdo(), contadorterminales);
			if (!a.hijoderecho().esVacio()) {

				y = contarTerminales(a.hijoderecho(), contadorterminales);
			}

			return (x + y);
		}

	}

	/**
	 * Honestamente este ejercicio yo le llamo habilidades de programacion unicas
	 * que desarrolle porque no tengo ni idea como llega a la conclusion de esto
	 * funcionaria.
	 * 
	 * @param a
	 * @param sumatorio
	 * @return
	 */
	public int sumarElementos(ArbolBin<Integer> a, int sumatorio) {
		// System.out.println("Sumatorio:"+a.raiz()+"+"+sumatorio+"="+(a.raiz()+sumatorio));
		sumatorio = a.raiz() + sumatorio;
		if (!a.hijoizquierdo().esVacio()) {
			int x = sumarElementos(a.hijoizquierdo(), sumatorio);
			if (!a.hijoderecho().esVacio()) {
				return sumarElementos(a.hijoderecho(), (x));

			}
		}

		return sumatorio;

	}

	public boolean compararArboles(ArbolBin<Integer> a, ArbolBin<Integer> b) {
		// comparo si la raiz es igual a la raiz del segundo arbol
		if (a.raiz() != b.raiz()) {
			return false;
		} else {
			// miramos el lado derecho de ambos arboles
			if (!a.hijoderecho().esVacio() && !b.hijoderecho().esVacio()) {
				return compararArboles(a.hijoderecho(), b.hijoderecho());

			}
			// miramos el lado izquierdo de ambos arboles
			if (!a.hijoizquierdo().esVacio() && !b.hijoizquierdo().esVacio()) {
				return compararArboles(a.hijoizquierdo(), b.hijoizquierdo());

			}
		}

		return true;

	}
public int caminoCorto(ArbolBin<Integer> a,int nodos,int minimo) {
	//lo que voy a hacer es ir verificando los nodos vacios
	//el primero nudo que me pille le saco el nivel
	//si aun no lo encontramos
		if(a.hijoderecho().esVacio() && a.hijoizquierdo().esVacio()) {
			//Aqui ya me he pillado al primer nodo vacio totalmente
			int x=Math.min(nodos, minimo);
			
			
		return x;
			 
			
		}
		 nodos=nodos+1;
		 int x=0;
		if(!a.hijoizquierdo().esVacio()  ) {
			x=caminoCorto(a.hijoizquierdo(),nodos,minimo);
			 		}
		if(!a.hijoderecho().esVacio()) {
			return caminoCorto(a.hijoderecho(),nodos,x  );
		}
		return nodos;
	
	
	
}
public ArbolBin<Integer> insertar(ArbolBin<Integer> a,int valor) {
	if (a.esVacio()) {
		ArbolBin<Integer> nuevo=new ArbolBin<>(new ArbolBin<Integer>() , valor, new ArbolBin<Integer>());
		return  nuevo;
	}
	else if(valor==a.raiz()){
		return a;
	}
	else if(valor<a.raiz()) {
		ArbolBin<Integer> nuevo=new ArbolBin<>(insertar(a.hijoizquierdo(),valor), a.raiz(), a.hijoderecho());
		
		return nuevo;
	}
	else {
ArbolBin<Integer> nuevo=new ArbolBin<>(a.hijoizquierdo(), a.raiz(), insertar(a.hijoderecho(),valor));
		
		return nuevo;
	}
	
	
}
/**
 * Lo unico de este metodo es que no funciona si uno de los arboles es de distinto tamaño
 * @param a
 * @param b
 */
public void sumarArboles(ArbolBin<Integer> a,ArbolBin<Integer> b) {
	ArbolBin<Integer> arbolA = a;
	ArbolBin<Integer> arbolB = b;
	ArbolBin<Integer> nuevo = new ArbolBin<Integer>();
	Stack<ArbolBin<Integer>> pila = new Stack<> ();
	Stack<ArbolBin<Integer>> pila2 = new Stack<> ();
	
		int nodo=arbolA.raiz();
	while((!arbolA.esVacio() || !pila.empty()) && (!arbolB.esVacio() || !pila2.empty())) {
		
		
		if(!arbolA.esVacio()) {
			
			int sumar=arbolA.raiz()+arbolB.raiz();
			nuevo=insertar(nuevo, sumar);
			pila.push(arbolA);
			arbolA=arbolA.hijoizquierdo();
			pila2.push(arbolB);
			arbolB=arbolB.hijoizquierdo();
		}
		else  {
			arbolA=pila.pop();
			arbolA=arbolA.hijoderecho();
			arbolB=pila2.pop();
			arbolB=arbolB.hijoderecho();
		}		
	}
		System.out.println("Arbol binario resultante:");
		nuevo.dibujar(0);
	}
	public int nodosPornivel(ArbolBin<Integer>a,int nivel,int contadornivel) {
		 if(a.esVacio()) {
				return 0;
			}
	
		
			
		contadornivel++;
		 if(nivel==contadornivel) {
			
				System.out.println("Los valores en el nivel "+nivel+" son:"+a.raiz());
				return a.raiz();
		 }
		int x=nodosPornivel(a.hijoizquierdo(), nivel, (contadornivel));
		nodosPornivel(a.hijoderecho(), nivel, (contadornivel));
			return a.raiz();
			
			
			
	}
	public int contadorNiveles(ArbolBin<Integer> a,int niveles) {
		if(a.esVacio()) {
			return niveles;
		}
		
		niveles++;
	
		int x=contadorNiveles( a.hijoizquierdo(),niveles);
		
		int y=contadorNiveles( a.hijoderecho(),niveles);
		
		return y;
		
	}
	public int contadorNodos(ArbolBin<Integer> a) {
		ArbolBin<Integer> arbolA = a;
		
		
		Stack<ArbolBin<Integer>> pila = new Stack<> ();
		//es un contador de nodos
		int contador=0;
		while((!arbolA.esVacio() || !pila.empty())) {
			
			
			if(!arbolA.esVacio()) {
				
			contador++;
				pila.push(arbolA);
				arbolA=arbolA.hijoizquierdo();
				
			}
			else  {
				arbolA=pila.pop();
				arbolA=arbolA.hijoderecho();
				
			}
		}
		return contador;
		}
	public boolean verificarLleno(ArbolBin<Integer>a) {
		//se le suma 1 porque es el nivel de la raiz.
		//System.out.println("total niveles:"+contadorNiveles(a,1));
		//System.out.println("total nodos:"+contadorNodos(a));
		//System.out.println("es igual "+(Math.pow(2,contadorNiveles(a,1))-1)+" a "+contadorNodos(a));
		return (Math.pow(2,contadorNiveles(a,1))-1)==contadorNodos(a);
	}
	public void dibujar(int nivel) {
		//System.out.println("iniciando a dibujar");
		if (!this.esVacio()) {
			for (int i = 1; i <= nivel; i++) {
				System.out.print(" x ");
			}
			System.out.println(this.raiz());
			this.hijoizquierdo().dibujar(nivel + 1);
			this.hijoderecho().dibujar(nivel + 1);

		}
	}
	

	public static void main(String[] args) {
		ArbolBin<Integer> izq1 = new ArbolBin<Integer>(new ArbolBin<Integer>(), 4, new ArbolBin<Integer>());
		ArbolBin<Integer> der1 = new ArbolBin<Integer>(new ArbolBin<Integer>(), 9, new ArbolBin<Integer>());
		ArbolBin<Integer> der2 = new ArbolBin<Integer>(new ArbolBin<Integer>(), 7, new ArbolBin<Integer>());
		ArbolBin<Integer> izq3 = new ArbolBin<Integer>(new ArbolBin<Integer>(), 0, new ArbolBin<Integer>());

		ArbolBin<Integer> izq2 = new ArbolBin<Integer>(izq3, 8, new ArbolBin<Integer>());

		ArbolBin<Integer> izq = new ArbolBin<Integer>(izq1, 2, der2);
		ArbolBin<Integer> der = new ArbolBin<Integer>(izq2, 5, der1);

		ArbolBin<Integer> main = new ArbolBin<Integer>(izq, 3, der);
		System.out.println(main.buscar_datos_ABIN(main, 3));
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 1:");
		main.buscarUltimaposicion(main);
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 2:");
		main.redactarContenido(main, 1);
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 3:");
		// vigilar este despues
		System.out.println(main.contarNodos(main, 1));
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 4:");
		// a este no le entiendo a que se refiere con profundidad,
		// la profundidad no es el ultimo nivel?
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 5:");
		System.out.println("Total de nodos terminales: " + main.contarTerminales(main, 0));
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 6:");
		System.out.println("La suma de todos los nodos es de:" + main.sumarElementos(main, 0));
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 7:");
		System.out.println("¿Son Arbol A y Arbol B iguales?:" + main.compararArboles(main, main));
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 8:");
		//el ejercicio 8 no entendi lo que se pedia.
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 9:");
		//este ejercicio no estoy segura que funcione bien.
		System.out.println("El camino mas corto hay:"+main.caminoCorto(main,0,Integer.MAX_VALUE)+" nodos.");
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 10:");
		main.sumarArboles(main, main);
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 12:");
		main.nodosPornivel(main, 3,0);
		System.out.println("--------------------------");
		System.out.println("EJERCICIO 13:");
		System.out.println("Esta lleno el arbol? "+main.verificarLleno(main));
		
	}

}
