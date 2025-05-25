package com.example;

public class casilla {
    private int posicionFila;
    private int posicionColumna;
    private boolean mina;
    private boolean descubierta;
    private int numeroMinasAlrededor;

    public casilla(int posicionFila, int posicionColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
        this.mina = false;
        this.descubierta = false;
        this.numeroMinasAlrededor = 0;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

    public void setPosicionColumna(int posicionColumna) {
        this.posicionColumna = posicionColumna;
    }

    public boolean isMina() {
        return mina;
    }
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public void setNumeroMinasAlrededor(int numeroMinasAlrededor) {
        this.numeroMinasAlrededor = numeroMinasAlrededor;
    }
    
}
