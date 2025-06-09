package com.example;

import java.util.*;

public class jugador {
    private ArrayList<carta> mano;

    public jugador() {
        mano = new ArrayList<>();
    }

    public void nuevaCarta(carta carta) {
        mano.add(carta);
    }

    public int getPuntuacion() {
        int totalPuntos = 0;
        int ases = 0;

        for (carta carta : mano) {
            int valor = carta.getValor();
            totalPuntos += valor;
            if (valor == 11) {
                ases++;
            }
        }

        while (totalPuntos > 21 && ases > 0) {
            totalPuntos -= 10;
            ases--;
        }

        return totalPuntos;
    }

    public void infoMano() {
        for (carta carta : mano) {
            System.out.println(carta.infoCarta());
        }
        System.out.println("Puntuación: " + getPuntuacion());
    }

    public boolean eliminado() {
        return getPuntuacion() > 21;
    }

    public carta getCarta(int indice) {
        return mano.get(indice);
    }

    public void resetMano() {
        mano.clear();
    }
}
