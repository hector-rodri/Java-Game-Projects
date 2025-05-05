package com.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] opciones = { "piedra", "papel", "tijera" };
        boolean jugar = true;

        System.out.println("BIENVENIDO A PIEDRA, PAPEL O TIJERA!");
        System.out.println("Dime tu nombre:");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre);

        while (jugar) {
            System.out.print("Elige (piedra, papel, tijera): ");
            String jugador = sc.nextLine().toLowerCase();

            if (!jugador.equals("piedra") && !jugador.equals("papel") && !jugador.equals("tijera")) {
                System.out.println("Opción inválida. Intenta otra vez.");
                continue;
            }

            String ordenador = opciones[random.nextInt(3)];
            System.out.println("El ordenador eligió: " + ordenador);

            if (jugador.equals(ordenador)) {
                System.out.println("¡Empate!");
            } else if ((jugador.equals("piedra") && ordenador.equals("tijera")) ||
                    (jugador.equals("papel") && ordenador.equals("piedra")) ||
                    (jugador.equals("tijera") && ordenador.equals("papel"))) {
                System.out.println("¡Enhorabuena has ganado!");
            } else {
                System.out.println("Perdiste :(");
            }
        }
        sc.close();
    }
}