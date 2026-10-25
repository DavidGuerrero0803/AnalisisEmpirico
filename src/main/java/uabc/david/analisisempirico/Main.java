package uabc.david.analisisempirico;

public class Main {
    public static void main(String[] args) {
        long MAX = 100000000;

        // Prueba con la sumatoria iterativa.
        System.out.println("SUMATORIA ITERATIVA");
        for (long i = 100; i <= MAX; i *= 10) {
            long startTime = System.nanoTime();
            long resultado = MetodosPrueba.sumatoriaIterativa(i);
            long endTime = System.nanoTime();
            System.out.println("N = " + i + ", Resultado: " + resultado + ", Tiempo: " + (endTime - startTime) + " ns");
        }

        // Prueba con la sumatoria de Gauss.
        System.out.println("\nSUMATORIA DE GAUSS");
        for (long i = 100; i <= MAX; i *= 10) {
            long startTime = System.nanoTime();
            long resultado = MetodosPrueba.sumatoriaGauss(i);
            long endTime = System.nanoTime();
            System.out.println("N = " + i + ", Resultado: " + resultado + ", Tiempo: " + (endTime - startTime) + " ns");
        }
    }
}
