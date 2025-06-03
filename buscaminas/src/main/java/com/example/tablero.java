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
    }

    public void inicializarCasillas() {
        casillas = new casilla[numeroFilas][numeroColumnas];
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                casillas[i][j] = new casilla(i, j);
            }
        }
    }

    public void generarMinas(){
        
    }

}
