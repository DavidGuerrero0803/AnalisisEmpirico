package uabc.david.analisisempirico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GraficaSumatoria extends Application {
    @Override
    public void start(Stage primaryStage) {
        long MAX = 100000000;

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Valor calculado (N)");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Tiempo (ns)");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Solución Iterativa vs Gauss vs Recursiva");
        chart.setCreateSymbols(true);

        XYChart.Series<Number, Number> serieIterativa = new XYChart.Series<>();
        serieIterativa.setName("Iterativa");

        XYChart.Series<Number, Number> serieGauss = new XYChart.Series<>();
        serieGauss.setName("Gauss");

        XYChart.Series<Number, Number> serieRecursiva = new XYChart.Series<>();
        serieRecursiva.setName("Recursiva");

        for (long i = 100; i <= MAX; i *= 10) {
            // Solución iterativa.
            long startIterativa = System.nanoTime();
            MetodosPrueba.sumatoriaIterativa(i);
            long endIterativa = System.nanoTime();
            serieIterativa.getData().add(new XYChart.Data<>(i, (endIterativa - startIterativa)));

            // Solución de Gauss.
            long startGauss = System.nanoTime();
            MetodosPrueba.sumatoriaGauss(i);
            long endGauss = System.nanoTime();
            serieGauss.getData().add(new XYChart.Data<>(i, (endGauss - startGauss)));

            // Solución recursiva (se usa dentro de un try-catch por desbordamiento de la pila).
            try {
                long startRecursiva = System.nanoTime();
                MetodosPrueba.sumatoriaRecursiva(i);
                long endRecursiva = System.nanoTime();
                serieRecursiva.getData().add(new XYChart.Data<>(i, (endRecursiva - startRecursiva)));
            } catch (StackOverflowError e) {
                // Si ocurre desbordamiento, no se agrega punto a la gráfica.
                System.out.println("No se pudo graficar Recursiva para N=" + i + " (StackOverflowError)");
            }
        }
        chart.getData().addAll(serieIterativa, serieGauss, serieRecursiva);

        VBox root = new VBox(chart);
        root.setPrefSize(900, 400);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Gráfica de desempeño");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}