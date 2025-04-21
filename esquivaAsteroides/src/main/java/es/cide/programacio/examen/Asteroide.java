package es.cide.programacio.examen;

import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;

class Asteroide {
    private int x, y; // Posició de l'asteroide
    private final int radi = 10; // Radi de l'asteroide
    private int velocitat; // Velocitat de l'asteroide
    private Image imagen;

    public Asteroide(int amplePanell, String rutaImagen) {//Constructor al cual añadimos la RUTA
        this.imagen = new ImageIcon(getClass().getResource(rutaImagen)).getImage();;//Convertir el String a imagen
        Random aleatori = new Random();
        x = aleatori.nextInt(amplePanell - radi * 2) + radi; // Posició x aleatòria
        y = 0; // Comença a la part superior del panell
        
        velocitat = aleatori.nextInt(3) + 1; // Velocitat aleatòria entre 1 i 3
    }

    public void moure() {
        y += velocitat; // Mou l'asteroide cap avall
    }

    public void dibuixar(Graphics g) {
        //INTENTO FALLIDO DEL PUNTO 7
        // Random random = new Random(); 
        // g.drawImage(imagen, x, y, radi * random.nextInt(3)+1,random.nextInt(3), null);
        g.setColor(Color.RED); // Color de l'asteroide
        g.drawImage(imagen, x, y, radi * 2, radi * 2, null);//Dibuja el asteroide usando la imagen

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadi() {
        return radi;
    }
}
