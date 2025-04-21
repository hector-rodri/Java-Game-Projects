package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Main extends JFrame {

    private JPanel panelPrincipal;
    Timer timer;
    int counter = 1;
    JProgressBar progressBar = new JProgressBar();

    private void animation() {//Animación para cargar el juego
        timer = new Timer(10, (e) -> {
            progressBar.setValue(counter);
            counter++;
            if (counter >= 100) {
                this.setVisible(false);
                this.dispose();
                timer.stop();
                gameFrame game = new gameFrame();
                game.setVisible(true);
                game.setLocationRelativeTo(null);
            }
        });
        timer.start();
    }

    private void help() {//Método para abrir la pantalla de ayuda
        this.setVisible(false);
        this.dispose();
        helpScreen help = new helpScreen();
        help.setVisible(true);
        help.setLocationRelativeTo(null);
    }

    private void customizePlayer() {//Método para abrir la pantalla de personalización
        this.setVisible(false);
        this.dispose();
        nameScreen customizeScreen = new nameScreen();
        customizeScreen.setVisible(true);
        customizeScreen.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {//Método main para ejecutar el programa
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        setTitle("STREET FIGHTER LITE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 370, 500);

        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(255, 56, 56));
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);
        setResizable(false);

        //Barra de progreso
        progressBar.setBackground(new Color(240, 240, 240));
        progressBar.setForeground(new Color(255, 216, 56));
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 14));
        progressBar.setString("Loading...");
        progressBar.setStringPainted(true);
        progressBar.setBounds(35, 200, 278, 28);
        progressBar.setVisible(false);
        panelPrincipal.add(progressBar);

        //Botón de inicio
        JButton btnStartGame = new JButton("START");
        btnStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animation();
                progressBar.setVisible(true);
            }
        });
        btnStartGame.setFocusable(false);
        btnStartGame.setBackground(new Color(255, 216, 56));
        btnStartGame.setForeground(new Color(240, 240, 240));
        btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnStartGame.setBounds(53, 237, 241, 55);
        panelPrincipal.add(btnStartGame);

        //Botón de personalización
        JButton btnCustomize = new JButton("CUSTOMIZE");
        btnCustomize.setFocusable(false);
        btnCustomize.addActionListener(e -> customizePlayer());
        btnCustomize.setForeground(new Color(240, 240, 240));
        btnCustomize.setBackground(new Color(255, 216, 56));
        btnCustomize.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnCustomize.setBounds(53, 313, 241, 55);
        panelPrincipal.add(btnCustomize);

        //Botón de ayuda
        JButton btnHelp = new JButton("HELP");
        btnHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                help();
            }
        });
        btnHelp.setFocusable(false);
        btnHelp.setBackground(new Color(255, 216, 56));
        btnHelp.setForeground(new Color(240, 240, 240));
        btnHelp.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnHelp.setBounds(53, 390, 241, 55);
        panelPrincipal.add(btnHelp);
    }
}