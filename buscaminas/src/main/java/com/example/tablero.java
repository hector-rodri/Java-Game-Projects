package com.example;

public class tablero {
    
    private casilla[][] casillas;
    private int numeroFilas;
    private int numeroColumnas;
    private int numeroMinas;
    
    public tablero(int numeroFilas, int numeroColumnas, int numeroMinas) {
        this.numeroFilas = numeroFilas;
        this.numeroColumnas = numeroColumnas;
        this.numeroMinas = numeroMinas;
        inicializarCasillas();
    }

    public void inicializarCasillas() {
        casillas = new casilla[numeroFilas][numeroColumnas];
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                casillas[i][j] = new casilla(i, j);
            }
            generarMinas();
        }
    }

    public void generarMinas(){
        int minasgeneradas = 0;
        while(minasgeneradas != numeroMinas) {
            int fila = (int) (Math.random() * numeroFilas);
            int columna = (int) (Math.random() * numeroColumnas);
            if (!casillas[fila][columna].isMina()) {
                casillas[fila][columna].setMina(true);
                minasgeneradas++;

            }
        }
    }

}
