package com.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] opciones = { "piedra", "papel", "tijera" };

        System.out.println("BIENVENIDO A PIEDRA, PAPEL O TIJERA!");
        System.out.println("Dime tu nombre:");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre);

        sc.close();
    }
}