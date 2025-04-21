package es.cide.programacio.examen;

import java.awt.*;

import javax.swing.ImageIcon;

class NauEspacial {
    private int x, y; // Posició de la nau espacial
    private final int ample = 20; // Ample de la nau espacial
    private final int alt = 20; // Alt de la nau espacial
    private Image imagen;

    public NauEspacial(int x, int y, String rutaImagen) {//Constructor al cual añadimos su posición y la RUTA
        this.x = x;
        this.y = y;
        this.imagen = new ImageIcon(getClass().getResource(rutaImagen)).getImage();//Convertir el String a imagen
    }

    public void moureEsquerra() {
        x -= 5; // Mou la nau cap a l'esquerra
    }

    public void moureDreta() {
        x += 5; // Mou la nau cap a la dreta
    }

    public void moverArriba(){//Método para mover hacia arriba la nave
        y -=5;
    }

    public void moverAbajo(){//Método para mover hacia abajo la nave
        y += 5;
    }

    public void dibuixar(Graphics g) {
        g.setColor(Color.GREEN); // Color de la nau espacial
        g.drawImage(imagen, x, y, ample *2, alt*2, null);//Dibuja la nave usando la imagen
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAmple() {
        return ample;
    }

    public int getAlt() {
        return alt;
    }
}