package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Main extends JFrame {

    private JPanel panelPrincipal;
    private JLabel pressToStartLabel;
    private JProgressBar progressBar = new JProgressBar();
    private Timer timer;
    private Timer parpadeo;
    private int counter = 1;

    private void animation() {
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

    private void help() {
        this.setVisible(false);
        this.dispose();
        helpScreen help = new helpScreen();
        help.setVisible(true);
        help.setLocationRelativeTo(null);
    }

    private void customizePlayer() {
        this.setVisible(false);
        this.dispose();
        nameScreen customizeScreen = new nameScreen();
        customizeScreen.setVisible(true);
        customizeScreen.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
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

        //Logo del juego
        JLabel logoLabel = new JLabel("");
        logoLabel.setIcon(new ImageIcon(getClass().getResource("logo.png")));
        logoLabel.setBounds(30, 20, 300, 200);
        panelPrincipal.add(logoLabel);

        //Texto de inicio
        pressToStartLabel = new JLabel("Press any key to start");
        pressToStartLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pressToStartLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        pressToStartLabel.setForeground(Color.WHITE);
        pressToStartLabel.setBounds(35, 200, 278, 30);
        panelPrincipal.add(pressToStartLabel);

        //Parpadeo del texto
        parpadeo = new Timer(500, e -> {
            pressToStartLabel.setVisible(!pressToStartLabel.isVisible());
        });
        parpadeo.start();

        //Barra de progreso
        progressBar.setBackground(new Color(240, 240, 240));
        progressBar.setForeground(new Color(255, 216, 56));
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 14));
        progressBar.setString("Loading...");
        progressBar.setStringPainted(true);
        progressBar.setBounds(35, 200, 278, 28);
        progressBar.setVisible(false);
        panelPrincipal.add(progressBar);

        //Botón de personalización
        JButton btnCustomize = new JButton("CUSTOMIZE");
        btnCustomize.setFocusable(false);
        btnCustomize.addActionListener(e -> {
            parpadeo.stop();
            pressToStartLabel.setVisible(false);
            customizePlayer();
        });
        btnCustomize.setForeground(new Color(240, 240, 240));
        btnCustomize.setBackground(new Color(255, 216, 56));
        btnCustomize.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnCustomize.setBounds(53, 250, 241, 55);
        panelPrincipal.add(btnCustomize);

        //Botón de ayuda
        JButton btnHelp = new JButton("HELP");
        btnHelp.addActionListener(e -> {
            parpadeo.stop();
            pressToStartLabel.setVisible(false);
            help();
        });
        btnHelp.setFocusable(false);
        btnHelp.setBackground(new Color(255, 216, 56));
        btnHelp.setForeground(new Color(240, 240, 240));
        btnHelp.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnHelp.setBounds(53, 320, 241, 55);
        panelPrincipal.add(btnHelp);

        //Boton información
        JButton btnInfo = new JButton("!");
        btnInfo.setFocusable(false);
        btnInfo.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Street Fighter Lite v1.0\nDesarrollado por Hector", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        btnInfo.setForeground(new Color(240, 240, 240));
        btnInfo.setBackground(new Color(255, 216, 56)); 
        btnInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnInfo.setBounds(140, 390, 60, 40);
        panelPrincipal.add(btnInfo);

        //Listener de eventos para el panel principal
        panelPrincipal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!progressBar.isVisible()) {
                    parpadeo.stop();
                    pressToStartLabel.setVisible(false);
                    progressBar.setVisible(true);
                    animation();
                }
            }
        });

        panelPrincipal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!progressBar.isVisible()) {
                    parpadeo.stop();
                    pressToStartLabel.setVisible(false);
                    progressBar.setVisible(true);
                    animation();
                }
            }
        });
        panelPrincipal.setFocusable(true);
        panelPrincipal.requestFocusInWindow();
    }
}
