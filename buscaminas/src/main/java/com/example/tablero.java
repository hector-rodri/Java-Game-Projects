package com.example;

import java.util.*;

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
        }
        generarMinas();
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
        actualizarNumerosMinasAlrededor();
    }

    private void imprimirTablero() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j].isMina() ? "*" : "0");
            }
            System.out.println("");
        }
    }

    private void imprimirPistas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j].getNumeroMinasAlrededor());
            }
            System.out.println("");
        }
    }


    private void actualizarNumerosMinasAlrededor() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                if (casillas[i][j].isMina()) {
                    List<casilla> casillasAlrededor = obtenerCasillasAlrededor(i, j);
                    casillasAlrededor.forEach((c) -> c.incrementarNumeroMinasAlrededor());
                }
            }
        }
    }

    private List<casilla> obtenerCasillasAlrededor(int posFila, int posColumna) {
        List<casilla> listaCasillas = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            int tmpPosFila = posFila;
            int tmpPosColumna = posColumna;
            switch (i) {
                case 0:
                    tmpPosFila--;
                    break; 
                case 1:
                    tmpPosFila--;
                    tmpPosColumna++;
                    break;
                case 2:
                    tmpPosColumna++;
                    break; 
                case 3:
                    tmpPosColumna++;
                    tmpPosFila++;
                    break; 
                case 4:
                    tmpPosFila++;
                    break; 
                case 5:
                    tmpPosFila++;
                    tmpPosColumna--;
                    break; 
                case 6:
                    tmpPosColumna--;
                    break; 
                case 7:
                    tmpPosFila--;
                    tmpPosColumna--;
                    break; 
            }

            if (tmpPosFila >= 0 && tmpPosFila < this.casillas.length
                    && tmpPosColumna >= 0 && tmpPosColumna < this.casillas[0].length) {
                listaCasillas.add(this.casillas[tmpPosFila][tmpPosColumna]);
            }

        }
        return listaCasillas;
    }


    public static void main(String[] args) {
        tablero miTablero = new tablero(5, 5, 5);
        miTablero.imprimirTablero();
        System.out.println("Pistas:");
        miTablero.imprimirPistas();
    }
}
