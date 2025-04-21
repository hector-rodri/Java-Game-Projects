package es.cide.programacio.examen;

import javax.swing.*;

public class Joc {
    public static void main(String[] args) {
        // Crea la finestra principal
        JFrame finestra = new JFrame("El corredor de Kessel");//Nombre del juego
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setSize(800, 600); // Mida de la finestra
        finestra.add(new JocPanel()); // Afegeix el panell del joc
        finestra.setLocationRelativeTo(null); // Centra la finestra
        finestra.setVisible(true); // Fa que la finestra sigui visible
        finestra.setResizable(false);//La ventana no se puede ajustar de tamaño, su tamaño siempre es el mismo
    }
}