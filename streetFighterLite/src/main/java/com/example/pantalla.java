package com.example;

import java.awt.Graphics;

public class pantalla extends sprite { //Clase utilizada para manejar el fondo del juego
	public pantalla() { 
		loadImage(this);
		this.x = 0;
		this.y = 0;
		this.h = FRAME_HEIGHT; 
		this.w = FRAME_WIDTH; 
	}
	
	public void drawBG(Graphics g) { //Método para dibujar el fondo
		g.drawImage(img, 0, 0, w, h, null);
	}

}