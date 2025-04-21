package com.example;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;

public class helpScreen extends JFrame {

    private JPanel contentPane;

    public helpScreen() {
        setTitle("STREET FIGHTER LITE - HELP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 56, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel labelInstructions = new JLabel("INSTRUCTIONS");
        labelInstructions.setForeground(Color.WHITE);
        labelInstructions.setFont(new Font("Tahoma", Font.BOLD, 30));
        labelInstructions.setBounds(180, 20, 300, 40);
        contentPane.add(labelInstructions);

        JLabel jugador1 = new JLabel("RYU - PLAYER 1");
        jugador1.setFont(new Font("Tahoma", Font.BOLD, 22));
        jugador1.setBounds(50, 80, 300, 30);
        jugador1.setForeground(new Color(240, 240, 240));
        contentPane.add(jugador1);

        JLabel labelVkupIncrease = new JLabel("Key (W): Jump");
        labelVkupIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkupIncrease.setBounds(50, 120, 300, 30);
        labelVkupIncrease.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkupIncrease);

        JLabel labelVkrightIncrease = new JLabel("Key (A): Move Left");
        labelVkrightIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrightIncrease.setBounds(50, 160, 300, 30);
        labelVkrightIncrease.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkrightIncrease);

        JLabel labelVkdownDecrease = new JLabel("Key (D): Move Right");
        labelVkdownDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkdownDecrease.setBounds(50, 200, 300, 30);
        labelVkdownDecrease.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkdownDecrease);

        JLabel labelVkleftDecrease = new JLabel("Key (G): Punch");
        labelVkleftDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkleftDecrease.setBounds(50, 240, 300, 30);
        labelVkleftDecrease.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkleftDecrease);

        JLabel labelVkrIncrease = new JLabel("Key (H): Kick");
        labelVkrIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrIncrease.setBounds(50, 280, 300, 30);
        labelVkrIncrease.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkrIncrease);

        JLabel labelVklDecrease = new JLabel("Key (E): Defend");
        labelVklDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVklDecrease.setBounds(50, 320, 300, 30);
        labelVklDecrease.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVklDecrease);

        JLabel jugador2 = new JLabel("KEN - PLAYER 2");
        jugador2.setFont(new Font("Tahoma", Font.BOLD, 22));
        jugador2.setBounds(350, 80, 300, 30);
        jugador2.setForeground(new Color(240, 240, 240));
        contentPane.add(jugador2);

        JLabel labelVkupIncrease2 = new JLabel("Arrow Key: Jump");
        labelVkupIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkupIncrease2.setBounds(350, 120, 300, 30);
        labelVkupIncrease2.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkupIncrease2);

        JLabel labelVkrightIncrease2 = new JLabel("Arrow Key: Move Left");
        labelVkrightIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrightIncrease2.setBounds(350, 160, 300, 30);
        labelVkrightIncrease2.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkrightIncrease2);

        JLabel labelVkleftDecrease2 = new JLabel("Arrow Key: Move Right");
        labelVkleftDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkleftDecrease2.setBounds(350, 200, 300, 30);
        labelVkleftDecrease2.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkleftDecrease2);

        JLabel labelVkrIncrease2 = new JLabel("NumPad (1): Punch");
        labelVkrIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrIncrease2.setBounds(350, 240, 300, 30);
        labelVkrIncrease2.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVkrIncrease2);

        JLabel labelVklDecrease2 = new JLabel("NumPad (2): Kick");
        labelVklDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVklDecrease2.setBounds(350, 280, 300, 30);
        labelVklDecrease2.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVklDecrease2);

        JLabel labelVklPoderespecial2 = new JLabel("NumPad (3): Defend");
        labelVklPoderespecial2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVklPoderespecial2.setBounds(350, 320, 300, 30);
        labelVklPoderespecial2.setForeground(new Color(240, 240, 240));
        contentPane.add(labelVklPoderespecial2);

        JButton buttonExit = new JButton("BACK");
        buttonExit.addActionListener(e -> exit());
        buttonExit.setFocusable(false);
        buttonExit.setFont(new Font("Tahoma", Font.BOLD, 20));
        buttonExit.setBackground(new Color(255, 216, 56));
        buttonExit.setForeground(new Color(240, 240, 240));
        buttonExit.setBounds(230, 400, 120, 40);
        contentPane.add(buttonExit);
    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
        Main frame = new Main();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}