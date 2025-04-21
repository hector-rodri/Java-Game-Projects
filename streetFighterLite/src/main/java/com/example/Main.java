package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Main extends JFrame {

    private JPanel contentPane;
    Timer timer;
    int counter = 1;

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

    JProgressBar progressBar = new JProgressBar();

    public Main() {
        setTitle("STREET FIGHTER LITE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 370, 500);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 56, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        progressBar.setBackground(new Color(240, 240, 240));
        progressBar.setForeground(new Color(255, 216, 56));
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 14));
        progressBar.setString("Loading...");
        progressBar.setStringPainted(true);
        progressBar.setBounds(35, 200, 278, 28);
        progressBar.setVisible(false);
        contentPane.add(progressBar);

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
        contentPane.add(btnStartGame);

        JButton btnCustomize = new JButton("CUSTOMIZE");
        btnCustomize.setFocusable(false);
        btnCustomize.addActionListener(e -> customizePlayer());
        btnCustomize.setForeground(new Color(240, 240, 240));
        btnCustomize.setBackground(new Color(255, 216, 56));
        btnCustomize.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnCustomize.setBounds(53, 313, 241, 55);
        contentPane.add(btnCustomize);

        JButton btnNewButton = new JButton("HELP");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                help();
            }
        });
        btnNewButton.setFocusable(false);
        btnNewButton.setBackground(new Color(255, 216, 56));
        btnNewButton.setForeground(new Color(240, 240, 240));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnNewButton.setBounds(53, 390, 241, 55);
        contentPane.add(btnNewButton);
    }
}