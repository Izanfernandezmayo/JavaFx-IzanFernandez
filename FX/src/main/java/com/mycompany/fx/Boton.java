package com.mycompany.fx;

import javafx.scene.control.Button;

public class Boton extends Button {

    public Boton(String text) {
        super(text);
        inicializar();
    }

    private void inicializar() {

        this.setStyle("""
                -fx-background-color: #2ecc71;
                -fx-text-fill: white;
                -fx-font-size: 14px;
                -fx-background-radius: 8;
                """);

        this.setOnMouseEntered(e ->
                this.setStyle("""
                        -fx-background-color: #27ae60;
                        -fx-text-fill: white;
                        -fx-font-size: 14px;
                        -fx-background-radius: 8;
                        """));

        this.setOnMouseExited(e ->
                this.setStyle("""
                        -fx-background-color: #2ecc71;
                        -fx-text-fill: white;
                        -fx-font-size: 14px;
                        -fx-background-radius: 8;
                        """));
    }
}