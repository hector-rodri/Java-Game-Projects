package com.example;//El paquete donde se encuentra la clase

import javax.swing.*;//Importamos las librerias necesarias
import java.awt.*;
import java.awt.event.*;

public class poong extends JPanel implements ActionListener {
    
    //BOLA
    private int x = 400;//Posición inicial de la bola
    private int y = 300;
    private int velocidadX = 5;//Velocidad de la bola
    private int velocidadY = 5;
    private final int tamanoBola = 30;//Tamaño de la bola
    
    //TIMER
    private Timer timer;//Temporizador para controlar la animacion

    public static void main(String[] args) {//Método principal 
        JFrame ventana = new JFrame("Poong");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.add(new poong());
        ventana.setVisible(true);
        
    }

    public poong() {//Constructor de la clase
        timer = new Timer(10, this);//Temporizador para controlar la animación
        timer.start();//Inicio el temporizador

        addKeyListener(new KeyAdapter() {//Añadir un KeyListener para controlar las barras
            @Override
            public void keyPressed(KeyEvent e) {//Cuando se clicka una tecla
                
            }

            @Override
            public void keyReleased(KeyEvent e) {//Cuando se suelta la tecla clickada
                
            }
        });

        setBackground(Color.WHITE);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {//Método para dibujar los elementos
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //BOLA
        g.setColor(Color.BLUE);//Color de la bola
        g.fillOval(x, y, tamanoBola, tamanoBola);//Dibujar la bola
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {//Método para controlar la lógica del juego
        
        
    }

    

}