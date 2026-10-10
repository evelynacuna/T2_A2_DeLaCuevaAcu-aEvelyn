class EjerciciosRecursividad {

	//Dado un numero natural N, se pide implementar
	//un metodo recursivo que permita saber la cantidad 
	//de digitos que tiene dicho numero
	public static int digitosNumero(int n) {

		if (n < 10)
			return 1;
		else
			return digitosNumero(n / 10) + 1;
	}

	//Implementar un metodo recursivo que permita saber cual es 
	//en N-simo termino de la serie Fibonacci.
	
	public static int nEsimoFibonacci(int n) {

		if (n == 0) //O(1)
			return 0; //O(1)
		else if (n == 1)
			return 1;
		else
			return nEsimoFibonacci(n - 1) + nEsimoFibonacci(n - 2);
	}

	// Dados dos numeros enteros positivos, implementar un metodo
	// recursivo que permita realiz               --ar la operacion aritmetica
	// de multiplicacion mediante sumas sucesivas
	public static int multiplicacionMedianteSumas(int multiplicando, int multiplicador) {

		if (multiplicador == 0)
			return 0;
		else if (multiplicador == 1) {
			return multiplicando;
		} else
			return multiplicando + multiplicacionMedianteSumas(multiplicando, multiplicador - 1);
	}

	// Dado un numero entero, no negativo, implementar
	// un metodo recursivo, que permita saber la cantidad de divisores
	// de dicho numero
	public static int divisoresNumero(int n) {
		int candidato = 2;
		int res;
		if (n == 1) {
			res = 1;
		} else {
			res = 2 + divisoresNumero(n, candidato);
		}
		return res;

	}

	private static int divisoresNumero(int n, int div) {
		int cont;
		if (div > (n / 2)) {
			cont = 0;
		} else {
			int aux = 0;
			if (n % div == 0) {
				aux = 1;
			}
			cont = aux + divisoresNumero(n, div + 1);
		}
		return cont;
	}

	// Implementar un metodo recursivo que permita transformar
	// un numero (expresado en base 10) a su equivalente en binario
	public static int numeroBinario(int n) {

		int base = 10;
		int exp = 0;

		return numeroBinario(n, base, exp);
	}

	private static int numeroBinario(int n, int base, int exp) {
		int res;
		if (n == 0) {
			res = 0;
		} else {
			int residuo = n % 2;
			n = n / 2;
			res = residuo * (int) (Math.pow(base, exp)) + numeroBinario(n, base, exp + 1);

		}
		return res;
	}

	// Dado un caracter y una cadena (String) Implementar un metodo
	// recursivo que permita saber la cantidad de ocurrencias de
	// ese caracter dentro de la cadena
	public static int contarOcurrencias(char c, String cad) {
		int pos = 0;
		return contarOcurrencias(c, cad,pos);
	}
	
	private static int contarOcurrencias(char c, String cad, int pos) {
		int res; 
		if(pos == cad.length()) {
			res = 0;
		}else {
			char actual = cad.charAt(pos);
			int aux = 0;
			if(actual == c) {
				aux = 1;
			}
			 res = aux + contarOcurrencias(c, cad, pos + 1);
		}
		return res;
			
	}
	//Dado una cadena (String) Implementar un metodo recursivo 
	//que te permita saber si dicha cadena es, o no, un Palindromo 
	public static String verificarCadena(String cad) {
		cad = normalizarCadena(cad);
		int izq = 0;
		int der = cad.length()-1;
		return verificarCadena(cad, izq, der);
	}
	private static String verificarCadena(String cad, int izq, int der ) {
		String res;
		if (der < izq) {
			res = " SI es palindromo";
		}else {
			char actIzq = cad.charAt(izq);
			char actDer = cad.charAt(der);
			if(actIzq != actDer) {
				res = " NO es palindromo";
				
			}else {
				res = verificarCadena(cad, izq + 1, der-1);
			}
		
		}
		return res;
		
	}
	private static String normalizarCadena(String cad) {
		String res = "";
		for (int i=0; i<cad.length(); i++) {
			char actual = cad.charAt(i);
			if(actual != ' ' && actual != ',') {
				res = res + actual; 
			}
			
		}
		return res.toLowerCase();
	}
	
}


public class ProgramasRecursividad {

	public static void main(String[] args) {

		
		System.out.println("===== EJERCICIO 1: DIGITOS DE UN NUMERO =====");
		int n = 512478;
		System.out.println("El numero " + n + " tiene " + EjerciciosRecursividad.digitosNumero(n) + " digitos");
		System.out.println("\n===== EJERCICIO 3: Numero N-esimo de la serie Fibonacci =====");
		int n1 = 12;
		System.out.println("El numero N-esimo de " + n1 + " es: " + EjerciciosRecursividad.nEsimoFibonacci(n1));
		System.out.println("\n===== Ejercicio 5: Multiplicacion mediante sumas sucesivas =====");
		int mult = 9;
		int multi = 4;
		System.out.println("El resultado de multiplicar " + mult + " X " + multi + " es: " + EjerciciosRecursividad.multiplicacionMedianteSumas(mult, multi));
		System.out.println("\n===== Ejercicio 7: Cantidad de divisores =====");
		int div = 82;
		System.out.println("El numero " + div + " tiene " + EjerciciosRecursividad.divisoresNumero(div) + " divisores");
		System.out.println("\n===== Ejercicio 9: Transformas un numero a binario =====");
		int numero = 426;
		System.out.println("El numero binario de " + numero + " es: " + EjerciciosRecursividad.numeroBinario(numero));
		System.out.println("\n===== Ejercicio 11: Contar ocurrencias en una cadena =====");
		char c = 'a';
		String cad = "Calamar";
		System.out.println("La letra " + c + " se repite " + EjerciciosRecursividad.contarOcurrencias(c, cad)+ " veces en la palabra " + cad);
		System.out.println("\n===== Ejercicio 13: Verificar si una palabra es PALINDROMO ===== ");
		String cad1 = "Luz azul";
		System.out.println("La frase " + cad1 + EjerciciosRecursividad.verificarCadena(cad1));
		String cad2 = "Paloma";
		System.out.println("La palabra " + cad2 + EjerciciosRecursividad.verificarCadena(cad2));
		
		
	}
	

}
