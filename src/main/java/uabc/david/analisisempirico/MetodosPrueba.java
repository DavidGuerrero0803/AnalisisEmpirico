package uabc.david.analisisempirico;

public class MetodosPrueba {
    /**
     * Solución iterativa de la sumatoria de n números.
     * @param n números.
     * @return la sumatoria de n números.
     */
    public static long sumatoriaIterativa(long n) {
        long sumatoria = 0;
        for (int i = 0; i <= n; i++) {
            sumatoria += i;
        }
        return sumatoria;
    }

    /**
     * Solución de Gauss de la sumatoria de n números.
     * @param n números.
     * @return la sumatoria de n números.
     */
    public static long sumatoriaGauss(long n) {
        return ((n * (n + 1)) / 2);
    }

    /**
     * Solución recursiva de la sumatoria de n números.
     * @param n números.
     * @return la sumatoria de n números.
     */
    public static long sumatoriaRecursiva(long n) {
        if (n == 1) {
            return n;
        }
        return n + (sumatoriaRecursiva(n - 1));
    }


}
