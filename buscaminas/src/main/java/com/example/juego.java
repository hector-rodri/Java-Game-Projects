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
                    descubrirCasilla(fila, columna);
                }
            }
        });
        return boton;
    }

    private void descubrirCasilla(int fila, int columna) {
        casilla casilla = tableroJuego.getCasillas()[fila][columna];
        if (casilla.isDescubierta())
            return;
        casilla.setDescubierta(true);

        if (casilla.isMina()) {
            botones[fila][columna].setText("💣");
            botones[fila][columna].setBackground(Color.RED);
            mostrarTodasLasMinas();
            JOptionPane.showMessageDialog(this, "¡Has perdido!");
            reiniciarJuego();
        } else {
            int minasAlrededor = casilla.getNumeroMinasAlrededor();
            botones[fila][columna].setText(minasAlrededor > 0 ? String.valueOf(minasAlrededor) : "");
            botones[fila][columna].setEnabled(false);
            if (minasAlrededor == 0) {
                descubrirVecinas(fila, columna);
            }
            if (comprobarVictoria()) {
                mostrarTodasLasMinas();
                JOptionPane.showMessageDialog(this, "¡Has ganado!");
                reiniciarJuego();
            }
        }
    }

    private void descubrirVecinas(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nf = fila + i;
                int nc = columna + j;
                if (nf >= 0 && nf < numFilas && nc >= 0 && nc < numColumnas) {
                    if (!tableroJuego.getCasillas()[nf][nc].isDescubierta()) {
                        descubrirCasilla(nf, nc);
                    }
                }
            }
        }
    }

    private void mostrarTodasLasMinas() {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if (tableroJuego.getCasillas()[i][j].isMina()) {
                    botones[i][j].setText("💣");
                    botones[i][j].setBackground(Color.RED);
                }
            }
        }
    }

    private boolean comprobarVictoria() {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                casilla c = tableroJuego.getCasillas()[i][j];
                if (!c.isMina() && !c.isDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void reiniciarJuego() {
        tableroJuego = new tablero(numFilas, numColumnas, numMinas);
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                botones[i][j].setText("");
                botones[i][j].setEnabled(true);
                botones[i][j].setBackground(null);
            }
        }
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
