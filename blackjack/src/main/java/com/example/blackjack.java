package com.example;

import java.util.*;

public class blackjack {
    public static void main(String[] args) {
        musica.reproducir("blackjack\\src\\main\\java\\com\\example\\“Luigi’s Casino” Theme Jazz Cover Super Mario 64 DS.wav");
        Scanner sc = new Scanner(System.in);
        baraja baraja = new baraja();
        jugador jugador = new jugador();
        jugador crupier = new jugador();

        while (true) {
            jugador.resetMano();
            crupier.resetMano();
            baraja = new baraja();
            System.out.println("Bienvenido al Blackjack!");
            System.out.print("Quieres ver las normas del juego? (s/n): ");
            String normas = sc.nextLine().toLowerCase();
            if (normas.equals("s")) {
                System.out.println("Normas del Blackjack:");
                System.out.println("- El objetivo es acercarse lo más posible a 21 puntos sin pasarse");
                System.out.println("- Las cartas del 2 al 10 valen su valor");
                System.out.println("- Las figuras (J, Q, K) valen 10 puntos");
                System.out.println("- El As puede valer 1 o 11 puntos, según convenga");
                System.out.println("- Si te pasas de 21 puntos, pierdes automáticamente");
                System.out.println("- El crupier debe pedir carta hasta llegar a 17 puntos o más");
                System.out.println("- Ganas si tienes más puntos que el crupier sin pasarte de 21");
                System.out.println("- ¡Buena suerte!");
                continuar(sc);
            }

            jugador.nuevaCarta(baraja.repartir());
            jugador.nuevaCarta(baraja.repartir());
            crupier.nuevaCarta(baraja.repartir());
            crupier.nuevaCarta(baraja.repartir());

            System.out.println("Mano del Jugador:");
            jugador.infoMano();
            System.out.println("Carta visible del crupier: " + crupier.getCarta(0).infoCarta());
            System.out.println("Puntuación del crupier: " + crupier.getCarta(0).getValorString());

            while (true) {
                System.out.print("Quieres otra carta? (s/n): ");
                String respuesta = sc.nextLine().toLowerCase();
                if (respuesta.equals("s")) {
                    jugador.nuevaCarta(baraja.repartir());
                    jugador.infoMano();
                    if (jugador.eliminado()) {
                        System.out.println("Te has pasado! Has perdido");
                        System.out.print("Quieres jugar otra vez? (s/n): ");
                        String jugarOtraVez = sc.nextLine().toLowerCase();
                        if (!jugarOtraVez.equals("s")) {
                            System.out.println("Gracias por jugar!");
                            sc.close();
                            return;
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }

            while (crupier.getPuntuacion() < 17) {
                crupier.nuevaCarta(baraja.repartir());
            }
            System.out.println("Mano del crupier:");
            crupier.infoMano();

            if (crupier.eliminado() || jugador.getPuntuacion() > crupier.getPuntuacion()) {
                System.out.println("Felicidades! Has ganado");
            } else if (jugador.getPuntuacion() < crupier.getPuntuacion()) {
                System.out.println("El crupier ha ganado");
            } else {
                System.out.println("Empate!");
            }

            System.out.print("Quieres jugar otra vez? (s/n): ");
            String jugarOtraVez = sc.nextLine().toLowerCase();
            if (!jugarOtraVez.equals("s")) {
                System.out.println("Gracias por jugar!");
                break;
            }
        }
        sc.close();
    }

    public static void continuar(Scanner sc) {
        System.out.println("\nPulsa Enter para continuar...");
        sc.nextLine();
    }
}