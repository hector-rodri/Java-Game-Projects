package es.cide.programacio.examen;//Paquete donde se encuentra la clase estrella

import java.awt.*;//Librerias importadas
import java.util.Random;

class Estrella {//Clase estrella

    private int x;//Posición x e y
    private int y;
    private int dy;//Velocidad
    private int mida = 5;//Medida
    
    public Estrella(int x, int y) {//Constructor de la clase estrella, el cual le metemos su posición
        this.x = x;
        this.y = y;
        Random rand = new Random();
        dy = rand.nextInt(10) + 5;//Velocidad aleatoria
    }

    public void moure(int ample, int alt) {//Método para mover la estrella
        y += dy;

    }

    public void dibuixar(Graphics g) {//Método para dibujar las estrellas
        g.setColor(Color.WHITE);//Color
        g.fillOval(x, y, mida, mida);//Dibujo con su posicion y su medida para hacer estrellas (es una estrella aunque sea redonda)
    }
}