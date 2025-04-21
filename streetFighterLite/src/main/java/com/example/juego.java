package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class juego extends JPanel {
    pantalla pantalla = new pantalla();
    ryu RYU1;
    ken KEN1;
    Timer timer;
    private boolean gameOver = false;
    private String winner = "";
    private JButton replayButton;
    private JButton homeButton;
    private JButton exitButton;
    private String player1Name = "RYU";
    private String player2Name = "KEN";
    private JFrame gameFrame;  // Para controlar el JFrame

    public void setPlayerNames(String player1, String player2) {
        this.player1Name = player1;
        this.player2Name = player2;
    }

    private void gameLoop() {
        timer = new Timer(90, (e) -> repaint());
        timer.start();
    }

    private void bindEvents() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A, KeyEvent.VK_D -> RYU1.setSpeed(0);
                    case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> KEN1.setSpeed(0);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver) return; // Evitar eventos si el juego terminó

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A -> RYU1.setSpeed(-10);
                    case KeyEvent.VK_D -> RYU1.setSpeed(10);
                    case KeyEvent.VK_W -> RYU1.jump();
                    case KeyEvent.VK_G -> RYU1.attackWithDelay(() -> {
                        RYU1.setMode(playerUtils.PUNCH);
                        if (isCollide(RYU1, KEN1) && RYU1.isCanDealDamage()) {
                            KEN1.setKencounter(KEN1.getKencounter() - 20 + (KEN1.getMode() == 5 ? 10 : 0));
                            RYU1.resetDamageCooldown(500);
                        }
                    }, 500);
                    case KeyEvent.VK_H -> RYU1.attackWithDelay(() -> {
                        RYU1.setMode(playerUtils.KICK);
                        if (isCollide(RYU1, KEN1)) {
                            KEN1.setKencounter(KEN1.getKencounter() - 30 + (KEN1.getMode() == 5 ? 15 : 0));
                        }
                    }, 500);
                    case KeyEvent.VK_E -> RYU1.setMode(playerUtils.DEFENCE);
                    case KeyEvent.VK_LEFT -> KEN1.setSpeed(-10);
                    case KeyEvent.VK_RIGHT -> KEN1.setSpeed(10);
                    case KeyEvent.VK_UP -> KEN1.jump();
                    case KeyEvent.VK_NUMPAD1 -> KEN1.attackWithDelay(() -> {
                        KEN1.setMode(playerUtils.PUNCH);
                        if (isCollide(KEN1, RYU1) && KEN1.isCanDealDamage()) {
                            RYU1.setRyucounter(RYU1.getRyucounter() - 20 + (RYU1.getMode() == 5 ? 10 : 0));
                            KEN1.resetDamageCooldown(500);
                        }
                    }, 500);
                    case KeyEvent.VK_NUMPAD2 -> KEN1.attackWithDelay(() -> {
                        KEN1.setMode(playerUtils.KICK);
                        if (isCollide(KEN1, RYU1)) {
                            RYU1.setRyucounter(RYU1.getRyucounter() - 30 + (RYU1.getMode() == 5 ? 15 : 0));
                        }
                    }, 500);
                    case KeyEvent.VK_NUMPAD3 -> KEN1.setMode(playerUtils.DEFENCE);
                }
                checkWinner();
            }
        });
    }

    private boolean isCollide(sprite attacker, sprite defender) {
        int xDistance = Math.abs(attacker.getX() - defender.getX());
        int yDistance = Math.abs(attacker.getY() - defender.getY());
        return xDistance <= Math.max(attacker.getW(), defender.getW()) - 10
                && yDistance <= Math.max(attacker.getH(), defender.getH()) - 10;
    }

    private void checkWinner() {
        if (gameOver) return; // Evitar múltiples llamadas si el juego ya terminó
    
        if (RYU1.getRyucounter() <= 0 && KEN1.getKencounter() <= 0) {
            gameOver = true;
            winner = "DRAW"; // Declarar empate si ambos llegan a 0
        } else if (RYU1.getRyucounter() <= 0) {
            gameOver = true;
            winner = player2Name + " WINNER";
        } else if (KEN1.getKencounter() <= 0) {
            gameOver = true;
            winner = player1Name + " WINNER";
        }
    }

    public juego(JFrame frame) {
        this.gameFrame = frame;  // Asignar el JFrame principal
        setSize(800, 600);
        RYU1 = new ryu(100, 100);
        KEN1 = new ken(600, 100);
        setFocusable(true);
        SwingUtilities.invokeLater(() -> requestFocusInWindow());
        bindEvents();
        gameLoop();
        setLayout(null);
        initReplayButton();
        initHomeButton();
        initExitButton();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        pantalla.drawBG(g);
        RYU1.draw(g);
        RYU1.move();
        KEN1.draw(g);
        KEN1.move();
        drawHUD(g);
        if (gameOver) {
            drawGameOver(g);
            replayButton.setVisible(true);
            homeButton.setVisible(true);
            exitButton.setVisible(true);
            replayButton.requestFocusInWindow();
        }
    }

    private void initReplayButton() {
        replayButton = new JButton("RESTART GAME");
        replayButton.setBounds(300, 250, 200, 60);
        replayButton.setForeground(Color.WHITE);
        replayButton.setBackground(new Color(44, 150, 57));
        replayButton.setFont(new Font("Verdana", Font.BOLD, 20));
        replayButton.setVisible(false);
        replayButton.addActionListener(e -> resetGame());
        add(replayButton);
    }

    private void initHomeButton() {
        homeButton = new JButton("HOME");
        homeButton.setBounds(300, 320, 200, 60);
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(44, 150, 57));
        homeButton.setFont(new Font("Verdana", Font.BOLD, 20));
        homeButton.setVisible(false);
        homeButton.addActionListener(e -> goToHomeScreen());
        add(homeButton);
    }

    private void initExitButton() {
        exitButton = new JButton("EXIT");
        exitButton.setBounds(300, 390, 200, 60);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(150, 44, 44));
        exitButton.setFont(new Font("Verdana", Font.BOLD, 20));
        exitButton.setVisible(false);
        exitButton.addActionListener(e -> System.exit(0));  // Cerrar aplicación
        add(exitButton);
    }

    private void resetGame() {
        gameOver = false;
        winner = "";
        RYU1.setRyucounter(300);
        KEN1.setKencounter(300);
        RYU1 = new ryu(100, 100);
        KEN1 = new ken(600, 100);
        replayButton.setVisible(false);
        homeButton.setVisible(false);
        exitButton.setVisible(false);
        requestFocusInWindow();
        repaint();
    }

    private void goToHomeScreen() {
        // Aquí puedes hacer que vuelva a la pantalla de inicio (gameScreen)
        gameFrame.getContentPane().removeAll();  // Limpiar la pantalla actual
        gameFrame.add(new juego(gameFrame));  // Agregar la pantalla de inicio
        gameFrame.revalidate();  // Revalidar cambios
        gameFrame.repaint();  // Repintar
    }

    private void drawHUD(Graphics g) {
        g.setColor(new Color(56, 255, 112));
        g.fillRect(40, 40, Math.max(0, RYU1.getRyucounter()), 40); // Evitar barra negativa
        g.fillRect(450, 40, Math.max(0, KEN1.getKencounter()), 40); // Evitar barra negativa
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        g.drawString(player1Name, 40, 72);
        g.drawString(player2Name, 450, 72);
    }

    private void drawGameOver(Graphics g) {
        g.setColor(new Color(44, 150, 57));
        g.setFont(new Font("Trebuchet Ms", Font.BOLD, 70));
        g.drawString(winner, getWidth() / 2 - 220, getHeight() / 2);
    }
}
