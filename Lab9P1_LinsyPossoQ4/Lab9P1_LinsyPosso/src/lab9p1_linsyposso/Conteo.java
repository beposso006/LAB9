/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_linsyposso;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 29164
 */
public class Conteo {

    static Scanner Leer = new Scanner(System.in);
    private ArrayList<String> palabras;

    public Conteo(ArrayList<String> palabras) {
        this.palabras = palabras;

    }

    public void contarLetrasRecurrentes() {
        for (String palabra : palabras) {
            System.out.println("Letras de la palabra: " + palabra);

            int[] conteoLetras = new int[256]; // Se asume un conjunto de caracteres ASCII
            int maxApariciones = 0;

            for (char letra : palabra.toCharArray()) {
                if (letra != ' ') {
                    int indice = (int) letra;
                    conteoLetras[indice]++;
                    if (conteoLetras[indice] > maxApariciones) {
                        maxApariciones = conteoLetras[indice];
                    }
                }
            }

            for (char letra : palabra.toCharArray()) {
                if (letra != ' ') {
                    int indice = (int) letra;
                    System.out.println(letra + ": " + conteoLetras[indice]);
                }
            }

            char letraMasRecurrente = obtenerLetraMasRecurrente(conteoLetras);

            if (letraMasRecurrente != 0) {
                System.out.println("Letra más recurrente es la '" + letraMasRecurrente + "', aparece "
                        + maxApariciones + " veces");
            } else {
                System.out.println("No hay una única letra más recurrente");
            }

            System.out.println();
        }
    }

    public void ingresarPalabras() {
        Random random = new Random();
        int numPalabras = random.nextInt(3) + 3;

        System.out.println("El random es: " + numPalabras);

        for (int i = 0; i < numPalabras; i++) {
            System.out.print((i + 1) + ". Ingrese palabra: ");
            String palabra = Leer.nextLine();
            palabras.add(palabra);
        }
    }

    public char obtenerLetraMasRecurrente(int[] conteoLetras) {
        char letraMasRecurrente = 0;
        int maxApariciones = 0;

        for (int i = 0; i < conteoLetras.length; i++) {
            if (conteoLetras[i] > maxApariciones) {
                letraMasRecurrente = (char) i;
                maxApariciones = conteoLetras[i];
            } else if (conteoLetras[i] == maxApariciones) {
                letraMasRecurrente = 0;
            }
        }
        return letraMasRecurrente;
    }

}
