package com.example;

import javax.swing.JFrame;

public class gameFrame extends JFrame implements gameUtils { // Define la clase GameFrame1 que extiende JFrame 
																//e implementa GameUtils1, se utiliza para construir el frame del juego
	public gameFrame() { // Constructor de la clase
		setSize(FRAME_WIDTH, FRAME_HEIGHT); // Establece el tamaño del frame
		setTitle(TITLE); // Establece el título del frame
		setLocationRelativeTo(null); // Establece la posición del frame en el centro
		setResizable(false); // Evita que el frame sea redimensionable
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establece la operación por defecto al cerrar el frame
		juego juego = new juego(this); // Crea un nuevo objeto de la clase Board1
		this.add(juego); // Añadimos el objeto al frame
		setVisible(true); // Hacemos visible el frame

	}
	

}
