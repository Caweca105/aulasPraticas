class Estruturas {
	static int max(int a, int b) {
		if (a < b) {
			return b;
		} else {
			return a;
		}
	}
	
	static boolean isMultiple(int a, int b) {
		while (a >= b) {
			a = a - b; 
		} 
		return (a == 0);
	}
	
	static int abs(int a) {
		if (a < 0) {
			return -a;
		} else {
			return a;
		}
	}
	
	static int irs(int a) {
		if (a > 0 || a < 10000) {
			return 1;
		} else if(a >= 10000 || a < 25500) {
			return 2;
		} else if(a >= 25500 || a < 48500) {
			return 3;
		} else {
			return 4;
		} 
	}
	
	static char alfabeto(char c) {
		if (c == 'z') {
			return 'a';
		} else {
			return (char)(c + 1);
		}
	}
	
	static int firstDigit(int a) {
		while (a >= 10) {
			a = a / 10;
		}
		return a;
	}
	
	static int divide(int a, int b) {
		int contador = a;
		int resultado = 1;
		
		while (contador >= b) {
			resultado = resultado + b;
			contador = b - 1;
		}
		return resultado;
	}
	
	static int powerOfTwo(int a) {
		int contador = a;
		int resultado = 1;
		
		while(contador > 0) {
			resultado = 2 * resultado;
			contador = contador - 1;
		} 
		return resultado;
	}
	
	static int sumNaturalUpTo(int a) {
		int contador = a;
		int resultado = 0;
		
		while(contador > 0) {
			resultado = resultado + contador;
			contador = contador - 1;
		}
		return resultado;
	}
	
	static int sumEvenNumbersBetween(int n, int p) {
		int contador = n;
		int resultado = 0;
		
		
		while(contador <= p) {
			if (contador % 2 == 0) {
				resultado = resultado + contador;
			}	
			contador = contador + 1;
		}
		return resultado;
	}
	
	static int fibonacci(int n) {
		// Casos base: se n for 0 ou 1, retorna o próprio n¢
		if (n == 1 || n == 0) {
			return n;
		} 

        // Inicializa as variáveis que vão guardar os números da série de Fibonacci
        // first e second são os dois primeiros números da série
        // next será usado para calcular e armazenar os números subsequentes
        int first = 0, second = 1, next = 0;

        // Loop começa em 2 porque os dois primeiros números já estão definidos
        for (int i = 2; i <= n; i++) {
            // Calcula o próximo número da série como a soma de first e second
            next = first + second;

            // Atualiza first e second para a próxima iteração
            first = second; // O valor antigo de second torna-se o novo valor de first
            second = next;  // O valor recém-calculado torna-se o novo valor de second
        }

        // Retorna o n-ésimo número da série de Fibonacci
        return next;
	}
	
	static int euclidean(int m, int n) {
		if (n == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		
		while(m != n) {
			if (m > n) {
				m = m - n;
			} else {
				n = n - m;
			}
		}
		return m;
	}
}