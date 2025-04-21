package es.cide.programacio.examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class JocPanel extends JPanel {
    private NauEspacial nau; // Nau espacial del jugador
    private List<Asteroide> asteroides; // Llista d'asteroides
    private int puntuacio; // Puntuació del jugador
    private boolean jocActiu; // Indica si el joc està actiu
    ArrayList<Estrella> estrelles = new ArrayList<>();//ArrayList de estrellas

    public JocPanel() {
        nau = new NauEspacial(350, 500, "/mf.png"); //Posición de la nave y ruta de la imagen
        asteroides = new ArrayList<>(); // Inicialitza la llista d'asteroides
        puntuacio = 0; // Inicialitza la puntuació
        jocActiu = true; // El joc comença actiu

        // Configura el panell
        setBackground(Color.BLACK); // Fons negre
        setFocusable(true); // Permet que el panell rebi el focus
        requestFocusInWindow(); // Demana el focus per rebre les tecles

        // Afegeix un KeyListener per controlar la nau
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    nau.moureEsquerra(); // Mou la nau a l'esquerra
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    nau.moureDreta(); // Mou la nau a la dreta
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {//Mueve hacia arriba
                    nau.moverArriba();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {//Mueve hacia abajo
                    nau.moverAbajo();
                }
            }
        });

        // Crea un Timer per actualitzar el joc
        Timer temporitzador = new Timer(20, e -> {
            if (jocActiu) {
                actualitzarJoc(); // Actualitza l'estat del joc
                repaint(); // Redibuixa el panell
            }
        });
        temporitzador.start(); // Inicia el temporitzador
    }

    private void actualitzarJoc() {
        // Genera asteroides aleatoris
        if (Math.random() < 0.02) {
            asteroides.add(new Asteroide(getWidth(), "/a.png")); //Asteroide con ruta de imagen
        }

        if (Math.random() < 0.20) {//Genera estrellas aleatorias
            afegirEstrella();//Llama al método añadir estrellas
        }
        
        for (Estrella estrella : estrelles) {//Hace que se muevan las estrellas
            estrella.moure(getWidth(), getHeight());
        }

        // Mou els asteroides i comprova les col·lisions
        for (int i = asteroides.size() - 1; i >= 0; i--) {
            Asteroide asteroide = asteroides.get(i);
            asteroide.moure(); // Mou l'asteroide

            // Comprova si l'asteroide col·lisiona amb la nau
            if (collisio(nau, asteroide)) {
                jocActiu = false; // El joc acaba
            }

            // Comprova si l'asteroide ha sortit de la pantalla
            if (asteroide.getY() > getHeight()) {
                asteroides.remove(i); // Elimina l'asteroide
                puntuacio++; // Augmenta la puntuació
            }
        }

    }

    private boolean collisio(NauEspacial nau, Asteroide asteroide) {
        // Comprova si hi ha col·lisió entre la nau i l'asteroide
        int nauX = nau.getX();
        int nauY = nau.getY();
        int asteroideX = asteroide.getX();
        int asteroideY = asteroide.getY();
        int radiAsteroide = asteroide.getRadi();
        int ampleNau = nau.getAmple();
        int altNau = nau.getAlt();
        

        return nauX < asteroideX + radiAsteroide &&
                nauX + ampleNau > asteroideX - radiAsteroide &&
                nauY < asteroideY + radiAsteroide &&
                nauY + altNau > asteroideY - radiAsteroide;
    }

    public void afegirEstrella() {//Método para añadir las estrellas
        int x = new Random().nextInt(getWidth() - 100);//Random para añadir la posición de la estrella
        estrelles.add(new Estrella(x, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuixa la nau espacial
        nau.dibuixar(g);

        // Dibuixa els asteroides
        for (Asteroide asteroide : asteroides) {
            asteroide.dibuixar(g);
        }

        //Dibuja las estrellas 
        for (Estrella e : estrelles) {
            e.dibuixar(g);
        }

        // Dibuixa la puntuació
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntuació: " + puntuacio, 10, 30);

        // Dibuixa el missatge de final de joc
        if (!jocActiu) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            String missatge = "Fi del joc";
            int ampleMissatge = g.getFontMetrics().stringWidth(missatge);
            g.drawString(missatge, getWidth() / 2 - ampleMissatge / 2, getHeight() / 2);
        }
    }
}