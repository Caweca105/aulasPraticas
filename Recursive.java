public class Recursive {
    // exercicio a
    static int divisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count = count + 1;
            }
        }
        return count;
    }

    // exercicio b
    static int sumDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) { 
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    // exercicio c
    static int perfectNumbersUpTo(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == sumDivisors(i)) {
                count = count + 1;
            }
        }
        return count;
    }

    // exercicio d
    static boolean isPrime(int n) {
        // Casos especiais: números menores que 2 não são primos
        // if (n < 2) {
        //     return false;
        // }
        
        // // Calcular a raiz quadrada inteira de n
        // int sqrtN = 0;
        // for (int i = 1; i * i <= n; i++) {
        //     sqrtN = i;
        // }

        // // Verificar se algum número de 2 até sqrtN divide n
        // for (int i = 2; i <= sqrtN; i++) {
        //     if (n % i == 0) {
        //         return false;
        //     }
        // }

        // return true;

        static boolean isPrime(int n) {
		if (divisor(n) == 2) {
			return true;
		}

        return false;
	}
    }

    // exercicio e
    static int sumPrimesSmallerThan(int n) {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum = sum + i;
            }
        }
        return sum;
    }

    // exercicio f
    static int countPrimesUpTo(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count = count + 1;
            }
        }
        return count;
    }

    // exercicio g
     static boolean existsPrimeBetween(int n, int p) {
        int count = 0;
		int i = 1;
		
		while (i < n) {
            if (isPrime(n)) {
            	count = count + i;
            }
            i = i + 1;
        }
        return count;
	}
    }

    // exercicio h
    static int fibonacci(int n) {
        // Casos base
        // Se n for 0, retorna 0
        if (n == 0) {
            return 0;
        }
        // Se n for 1, retorna 1
        if (n == 1) {
            return 1;
        }

        // Chamada recursiva
        // A chamada recursiva é feita para os dois números anteriores, utilizando a própria função
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // exercicio i
    static int factorial(int n) {
        // Caso base
        // Se n for 0 ou 1, retorna 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Chamada recursiva
        // A chamada recursiva é feita para o número anterior, utilizando a própria funçãoE 
        return n * factorial(n - 1);
    }

    // exercicio j
    static int gcd(int a, int b) {
        // Caso base
        if (b == 0) {
            return a;
        }

        // Chamada recursiva
        return gcd(b, a % b);
    }

    // exercicio k
    static int largerDifferenceBetweenPrimes(int n) {
        int maxDiff = 0;
        int prevPrime = -1;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    if (diff > maxDiff) {
                        maxDiff = diff;
                    }
                }
                prevPrime = i;
            }
        }

        return maxDiff;
    }
}
