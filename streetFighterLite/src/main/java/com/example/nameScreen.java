package com.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class nameScreen extends JFrame {

    private JTextField nombreJugador1;
    private JTextField nombreJugador2;

    public nameScreen() {
        setTitle("STREET FIGHTER LITE - CUSTOMIZE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(255, 56, 56));
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);

        JLabel titulo = new JLabel("CUSTOMIZE PLAYERS");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(130, 30, 400, 40);
        panelPrincipal.add(titulo);

        JLabel jugador1 = new JLabel("PLAYER 1:");
        jugador1.setFont(new Font("Tahoma", Font.BOLD, 22));
        jugador1.setForeground(Color.WHITE);
        jugador1.setBounds(100, 120, 150, 30);
        panelPrincipal.add(jugador1);

        nombreJugador1 = new JTextField();
        nombreJugador1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nombreJugador1.setBounds(220, 120, 250, 30);
        panelPrincipal.add(nombreJugador1);

        JLabel jugador2 = new JLabel("PLAYER 2:");
        jugador2.setFont(new Font("Tahoma", Font.BOLD, 22));
        jugador2.setForeground(Color.WHITE);
        jugador2.setBounds(100, 180, 150, 30);
        panelPrincipal.add(jugador2);

        nombreJugador2 = new JTextField();
        nombreJugador2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nombreJugador2.setBounds(220, 180, 250, 30);
        panelPrincipal.add(nombreJugador2);

        JButton botonGuardar = new JButton("SAVE");
        botonGuardar.setFont(new Font("Tahoma", Font.BOLD, 22));
        botonGuardar.setForeground(new Color(255, 56, 56));
        botonGuardar.setBackground(new Color(255, 216, 56));
        botonGuardar.setBounds(80, 280, 200, 50);
        botonGuardar.addActionListener(e -> guardar());
        panelPrincipal.add(botonGuardar);

        JButton botonSalir = new JButton("BACK");
        botonSalir.setFont(new Font("Tahoma", Font.BOLD, 22));
        botonSalir.setForeground(new Color(255, 56, 56));
        botonSalir.setBackground(new Color(255, 216, 56));
        botonSalir.setBounds(300, 280, 200, 50);
        botonSalir.addActionListener(e -> salir());
        panelPrincipal.add(botonSalir);
    }

    public void guardar() {
        String jugadorNombre1 = nombreJugador1.getText().trim();
        String jugadorNombre2 = nombreJugador2.getText().trim();

        if (jugadorNombre1.isEmpty() || jugadorNombre2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter names to continue", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        juego juego = new juego(this);
        juego.setPlayerNames(jugadorNombre1.toUpperCase(), jugadorNombre2.toUpperCase());
        JFrame game = new JFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(800, 600);
        game.setLocationRelativeTo(null);
        game.add(juego);
        game.setVisible(true);

        this.setVisible(false);
        this.dispose();
    }

    public void salir() {
        this.setVisible(false);
        this.dispose();
        Main frame = new Main();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}