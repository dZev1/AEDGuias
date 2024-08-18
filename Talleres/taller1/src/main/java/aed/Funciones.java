package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    boolean esPar(int n) {
        return n % 2 == 0;
    }

    boolean esBisiesto(int n) {
        boolean divide4 = n % 4 == 0;
        boolean divide10 = n % 10 == 0;
        boolean divide400 = n % 400 == 0;
        return (divide4 && !divide10) || divide400;

    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorialRecursivo(n - 1);
        }
    }

    boolean esPrimo(int n) {
        if (n == 1 || n == 0) {
            return false;
        }
        else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int n : numeros) {
            res += n;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = -1;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        for (int n : numeros) {
            if (esPrimo(n)) {
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int n : numeros) {
            if (!esPar(n)) {
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        else {
            int contador = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    contador++;
                }
            }
            return contador == s1.length();
        }
    }

    boolean esSufijo(String s1, String s2) {
        String s1Reverso = "";
        String s2Reverso = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            s1Reverso += s1.charAt(i);
        }
        for (int i = s2.length() - 1; i >= 0; i--) {
            s2Reverso += s2.charAt(i);
        }
        return esPrefijo(s1Reverso, s2Reverso);
    }
}
