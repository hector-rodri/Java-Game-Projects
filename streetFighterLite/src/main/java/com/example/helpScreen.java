package com.example;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class helpScreen extends JFrame {

    private JPanel contentPane;

    public helpScreen() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 447);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(44, 150, 57));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel labelInstructions = new JLabel("INSTRUCTIONS");
        labelInstructions.setForeground(Color.black);
        labelInstructions.setFont(new Font("Tahoma", Font.BOLD, 25));
        labelInstructions.setBounds(157, 20, 200, 46);
        contentPane.add(labelInstructions);

        JLabel jugador1 = new JLabel("RYU PLAYER 1");
        jugador1.setFont(new Font("Tahoma", Font.BOLD, 19));
        jugador1.setBounds(20, 75, 304, 29);
        jugador1.setForeground(new Color(49, 47, 47));
        contentPane.add(jugador1);

        JLabel labelVkupIncrease = new JLabel("Key (W): Jump");
        labelVkupIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18)); 
        labelVkupIncrease.setBounds(20, 100, 304, 29); 
        labelVkupIncrease.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkupIncrease);

        JLabel labelVkrightIncrease = new JLabel("Key (A): Left");
        labelVkrightIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrightIncrease.setBounds(20, 135, 304, 29);
        labelVkrightIncrease.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkrightIncrease);

        JLabel labelVkdownDecrease = new JLabel("Key (D): Right");
        labelVkdownDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkdownDecrease.setBounds(20, 170, 304, 29);
        labelVkdownDecrease.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkdownDecrease);

        JLabel labelVkleftDecrease = new JLabel("Key (G): Punch");
        labelVkleftDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkleftDecrease.setBounds(20, 205, 304, 29);
        labelVkleftDecrease.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkleftDecrease);

        JLabel labelVkrIncrease = new JLabel("Key (H): Kick");
        labelVkrIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrIncrease.setBounds(20, 240, 304, 29);
        labelVkrIncrease.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkrIncrease);

        JLabel labelVklDecrease = new JLabel("Key (E): Defend");
        labelVklDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVklDecrease.setBounds(20, 275, 304, 29);
        labelVklDecrease.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVklDecrease);

        JLabel jugador2 = new JLabel("KEN PLAYER 2");
        jugador2.setFont(new Font("Tahoma", Font.BOLD, 19));
        jugador2.setBounds(280, 75, 304, 29);
        jugador2.setForeground(new Color(49, 47, 47));
        contentPane.add(jugador2);

        JLabel labelVkupIncrease2 = new JLabel("Arrow Key: Jump");
        labelVkupIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkupIncrease2.setBounds(280, 100, 304, 29);
        labelVkupIncrease2.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkupIncrease2);

        JLabel labelVkrightIncrease2 = new JLabel("Arrow Key: Left");
        labelVkrightIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrightIncrease2.setBounds(280, 135, 304, 29);
        labelVkrightIncrease2.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkrightIncrease2);
        
        JLabel labelVkleftDecrease2 = new JLabel("Arrow Key: Right");
        labelVkleftDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkleftDecrease2.setBounds(280, 170, 304, 29);
        labelVkleftDecrease2.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkleftDecrease2);
        
        JLabel labelVkrIncrease2 = new JLabel("NumPad (1): Punch");
        labelVkrIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVkrIncrease2.setBounds(280, 205, 304, 29);
        labelVkrIncrease2.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVkrIncrease2);
        
        JLabel labelVklDecrease2 = new JLabel("NumPad (2): Kick");
        labelVklDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVklDecrease2.setBounds(280, 240, 304, 29);
        labelVklDecrease2.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVklDecrease2);
        
        JLabel labelVklPoderespecial2 = new JLabel("NumPad (3): Defend");
        labelVklPoderespecial2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        labelVklPoderespecial2.setBounds(280, 275, 304, 29);
        labelVklPoderespecial2.setForeground(new Color(235, 235, 235));
        contentPane.add(labelVklPoderespecial2);
        
        JButton buttonExit = new JButton("EXIT");
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        buttonExit.setFont(new Font("Tahoma", Font.BOLD, 28));
        buttonExit.setBackground(new Color(235, 235, 235));
        buttonExit.setForeground(new Color(44, 150, 57));
        buttonExit.setBounds(177, 365, 150, 40);
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