package com.example;

import java.util.*;

public class baraja {
    private ArrayList<carta> cartas;

    public baraja(){
        String[] tipos = {"♠", "♥", "♦", "♣"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        cartas = new ArrayList<>();
        
        for (String tipo : tipos) {
            for (String valor : valores) {
                cartas.add(new carta(valor,tipo));
            }
        }
        Collections.shuffle(cartas);//Método de java.util que mezcla los valores de un arraylist
    }

    public carta repartir() {
        return cartas.remove(0);
    }
}
