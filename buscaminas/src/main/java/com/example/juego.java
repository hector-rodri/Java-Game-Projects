package com.example;

import java.awt.*;
import javax.swing.*;


public class juego extends JFrame {

    private int numFilas = 10;
    private int numColumnas = 10;
    private int numMinas = 10;
    private tablero tableroJuego;
    private JButton[][] botones;

    public juego() {
        setTitle("Buscaminas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        tableroJuego = new tablero(numFilas, numColumnas, numMinas);
        botones = new JButton[numFilas][numColumnas];
        setLayout(new GridLayout(numFilas, numColumnas));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            juego ventana = new juego();
            ventana.setVisible(true);
        });
    }
}
