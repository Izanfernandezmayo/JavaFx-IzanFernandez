package com.mycompany.fx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX extends Application {

    @Override
    public void start(Stage stage) {

        ObservableList<Integer> datos =
                FXCollections.observableArrayList(10, 25, 15, 40, 30);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Estadisticas");

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        int i = 1;
        for (Integer valor : datos) {
            series.getData().add(
                    new XYChart.Data<>("dato " + i++, valor)
            );
        }

        chart.getData().add(series);

        Boton btnPdf = new Boton("Generar PDF");

        btnPdf.setOnAction(e ->
                PDF.generar(chart)
        );

        VBox root = new VBox(15, chart, btnPdf);

        stage.setTitle("Izan Fernandez");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}