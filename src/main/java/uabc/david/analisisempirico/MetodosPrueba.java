package uabc.david.analisisempirico;

public class MetodosPrueba {
    public static long sumatoria0aN(long n) {
        long sumatoria = 0;
        for (int i = 0; i <= n; i++) {
            sumatoria += i;
        }
        return sumatoria;
    }

    public static long sumatoriaGauss(long n) {
        return ((n * (n + 1)) / 2);
    }

    public static long sumatoriaRecursiva(long n) {
        if (n == 1) {
            return n;
        }
        return n + (sumatoriaRecursiva(n - 1));
    }


}
