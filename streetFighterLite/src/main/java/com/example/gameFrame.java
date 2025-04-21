package com.example;

import javax.swing.JFrame;

public class gameFrame extends JFrame implements gameUtils { // Define la clase GameFrame1 que extiende JFrame e implementa GameUtils1, se utiliza para construir el frame del juego
	public gameFrame() { 
		setSize(FRAME_WIDTH, FRAME_HEIGHT); 
		setTitle(TITLE); 
		setLocationRelativeTo(null); 
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		juego juego = new juego(this); 
		this.add(juego);
		setVisible(true); 

	}
	

}
