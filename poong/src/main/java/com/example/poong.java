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

    //BARRAS
    private final int barraAncho = 20;//Ancho y largp de las barras
    private final int barraLargo = 100;
    private int barraIzquierdaY = 600 / 2 - barraLargo / 2;//Posición inicial de las barras
    private int barraDerechaY = 600 / 2 - barraLargo / 2;
    private boolean moverBarraIzquierdaArriba;//Booleanos para controlar el movimiento de las barras
    private boolean moverBarraIzquierdaAbajo;
    private boolean moverBarraDerechaArriba;
    private boolean moverBarraDerechaAbajo;
    private final int velocidadBarra = 10;//Velocidad de las barras
    
    //TIMER
    private Timer timer;//Temporizador para controlar la animacion

    //PUNTUACIÓN
    private int puntuacionIzquierda = 0;//Puntuación de los jugadores
    private int puntuacionDerecha = 0;

    //NOMBRES DE LOS JUGADORES
    private String nombreJugadorIzquierda = "JUGADOR 1";
    private String nombreJugadorDerecha = "JUGADOR 2";
    private String ganador = "";

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
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> moverBarraIzquierdaArriba = true;//Si se clicka la tecla la barra se mueve hacia la dirección qeu toca
                    case KeyEvent.VK_S -> moverBarraIzquierdaAbajo = true;
                    case KeyEvent.VK_UP -> moverBarraDerechaArriba = true;
                    case KeyEvent.VK_DOWN -> moverBarraDerechaAbajo = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {//Cuando se suelta la tecla clickada
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> moverBarraIzquierdaArriba = false;//Si se suelta la tecla la barra se para
                    case KeyEvent.VK_S -> moverBarraIzquierdaAbajo = false;
                    case KeyEvent.VK_UP -> moverBarraDerechaArriba = false;
                    case KeyEvent.VK_DOWN -> moverBarraDerechaAbajo = false;
                }
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
        
        //BARRAS
        g.setColor(Color.BLUE);//Color de las barras
        g.fillRect(10, barraIzquierdaY, barraAncho, barraLargo);//Dibujar la barra izquierda
        g.fillRect(getWidth() - 30, barraDerechaY, barraAncho, barraLargo);//Dibujar la barra derecha

        //PUNTUACIÓN
        g.setColor(Color.BLACK);//Color de la puntuación
        g.setFont(new Font("Arial", Font.BOLD, 30));//Fuente de la puntuación
        g.drawString(String.valueOf(puntuacionIzquierda), getWidth() / 2 - 50, 50);//Dibujar la puntuación de los jugadores
        g.drawString(String.valueOf(puntuacionDerecha), getWidth() / 2 + 20, 50);
        g.drawString(nombreJugadorIzquierda, 20, 50); //Nombre de los jugadores
        g.drawString(nombreJugadorDerecha, getWidth() - 200, 50);

        //LÍNEA DISCONTINUA EN EL CENTRO
        g2d.setColor(Color.GRAY); //Color de la línea
        float[] dashPattern = {10, 10}; //10 píxeles dibujados y 10 píxeles vacíos
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); //Dibujar la línea vertical en el centro
    }

    @Override
    public void actionPerformed(ActionEvent e) {//Método para controlar la lógica del juego
        
        //Mover la pelota
        x += velocidadX;
        y += velocidadY;

        //Rebote en los bordes verticales
        if (y <= 0 || y >= getHeight() - tamanoBola) {
            /*Si y es menor o igual a 0 
            o mayor o igual a la altura del panel menos el tamañ de la pelota,
            invierto la dirección*/
            velocidadY = -velocidadY;

        }

        //Rebote con la pala izquierda
        if (x <= 40 && velocidadX < 0 && y >= barraIzquierdaY && y <= barraIzquierdaY + barraLargo) {
            /*Si x está cerca del borde izquierdo la pelota se mueve hacia la izquierda,
            y la posición Y está dentro del rango de la pla izquierda,
            invierto la dirección*/
            velocidadX = -velocidadX;
        }

        //Rebote con la pala derecha
        if (x + tamanoBola >= getWidth() - 40 && velocidadX > 0 && y >= barraDerechaY
                && y <= barraDerechaY + barraLargo) {
            /*Si la posición de la pelota está cerca del borde derecho la pelota se mueve hacia la derecha,
            y la posición Y está dentro del rango de la paladerecha,
            invierto la dirección*/
            velocidadX = -velocidadX;
        }

        //Si la pelota sale por los lados horizontales, sumar punto y reiniciar
        if (x < 0) {
            puntuacionDerecha++;//Aumentar la puntuación del jugador de la derecha
            reiniciarPelota();
        }
        if (x > getWidth()) {
            puntuacionIzquierda++;//Aumentar la puntuación del jugador de la izquierda
            reiniciarPelota();
        }

        if (puntuacionIzquierda == 10) {//Si el jugador izquierda gana
            
            
            ganador = nombreJugadorIzquierda;//Asignar el nombre del jugador izquierdo al ganador
            JOptionPane.showMessageDialog(this, ganador + " HAS GANADO!!!", "Fin del juego", 1);//Mensaje de victoria
        
            //Reiniciar el juego y la puntuación
            puntuacionIzquierda = 0;
            puntuacionDerecha = 0;
            reiniciarPelota();
        }
        
        if (puntuacionDerecha == 10) { //Si el jugador derecho gana
            ganador = nombreJugadorDerecha;//Asign el nombre del jugador derecho al ganador
            JOptionPane.showMessageDialog(this, ganador + " HAS GANADO!!!", "Fin del juego", 1);//Mensaje de victoria
        
            //Reiniciar el juego y la puntuación
            puntuacionIzquierda = 0;
            puntuacionDerecha = 0;
            reiniciarPelota();
        }

        //Movimiento de las palas
        //IZQUIERDA
        if (moverBarraIzquierdaArriba && barraIzquierdaY > 0)//Si se clicka la tecla W y la barra no llega al borde de arriba
            barraIzquierdaY -= velocidadBarra;//La barra se mueve hacia arriba


        if (moverBarraIzquierdaAbajo && barraIzquierdaY < getHeight() - barraLargo)//Si se clicka la tecla S y la barra no llega al borde de abajo
            barraIzquierdaY += velocidadBarra;//La barra se mueve hacia abajo

        //DERECHA
        if (moverBarraDerechaArriba && barraDerechaY > 0)//Si se clicka la flecha arriba y la barra no llega al borde de arriba
            barraDerechaY -= velocidadBarra;//Mover la barra hacia arriba
        

        if (moverBarraDerechaAbajo && barraDerechaY < getHeight() - barraLargo)//Si se clicka la flecha abajo y la barra no llega al borde de abajo
            barraDerechaY += velocidadBarra;//Mover la barra hacia abajo


        repaint();
    }

    private void reiniciarPelota() {//Método para reiniciar la pelota
        x = getWidth() / 2;
        y = getHeight() / 2;
        velocidadX = -velocidadX;//Cambiar la dirección de la pelota
        velocidadY = -velocidadY;
    }   

}