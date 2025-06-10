package com.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                JButton boton = crearBoton(i, j);
                botones[i][j] = boton;
                add(boton);
            }
        }
    }

    private JButton crearBoton(int fila, int columna) {
        JButton boton = new JButton();
        boton.setPreferredSize(new Dimension(40, 40));
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if (boton.getText().equals("🚩")) {
                        boton.setText("");
                    } else if (boton.isEnabled()) {
                        boton.setText("🚩");
                    }
                } else if (SwingUtilities.isLeftMouseButton(e)) {
                    
                }
            }
        });
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            juego ventana = new juego();
            ventana.setVisible(true);
        });
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
