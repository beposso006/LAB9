/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_linsyposso;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author 29164
 */
public class Palindromo {

    private ArrayList<Integer> numeros = new ArrayList<>();
    private Scanner Leer = new Scanner(System.in);

    public Palindromo() {

    }

    public void generarArraylist() {
        Scanner scanner = new Scanner(System.in);
        int random = (int) (Math.random() * 8) + 3;

        System.out.println("Su random es: " + random);

        for (int i = 1; i <= random; i++) {
            System.out.print(i + ". Ingrese numero: ");
            int num = scanner.nextInt();
            numeros.add(num);
        }
    }

    public void mostrarArraylist() {
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public boolean determinarPalindromo() {
        return esPalindromoRecursivo(0, numeros.size() - 1);
    }

    private boolean esPalindromoRecursivo(int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }
        if (numeros.get(inicio) == numeros.get(fin)) {
            return esPalindromoRecursivo(inicio + 1, fin - 1);
        }
        return false;
    }
}
