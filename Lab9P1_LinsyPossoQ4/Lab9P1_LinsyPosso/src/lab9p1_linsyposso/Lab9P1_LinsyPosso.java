/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_linsyposso;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author 29164
 */
public class Lab9P1_LinsyPosso {

    static ArrayList<Pokemon> listaPokemon = new ArrayList<>();
    static ArrayList<String> palabras = new ArrayList<>();
    static Scanner Leer = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("--Menu bonito--");
            System.out.println("1. Arraylist Palindromo");
            System.out.println("2. Contar letras de palabras");
            System.out.println("3. Batalla Pokemon");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = Leer.nextInt();

            switch (opcion) {
                case 1:
                    Palindromo palindromo = new Palindromo();
                    palindromo.generarArraylist();
                    palindromo.mostrarArraylist();

                    if (palindromo.determinarPalindromo()) {
                        System.out.println("Si es palindromo");
                    } else {
                        System.out.println("No es palindromo");
                    }
                    break;

                case 2:
                    Conteo conteo = new Conteo(palabras);
                    conteo.ingresarPalabras();
                    conteo.contarLetrasRecurrentes();
                    break;

                case 3:
                    System.out.println("Bienvenido a Batalla Pokemon");
                    System.out.println("1. Crear Pokemon");
                    System.out.println("2. Batalla Pokemon");
                    System.out.println("3. Curar centro Pokemon");
                    System.out.print("Que quieres hacer: ");
                    int opsub = Leer.nextInt();
                    switch (opsub) {
                        case 1:
                            CrearPokemon();
                            break;

                        case 2:
                            System.out.println("BATALLA----------------------------");
                            if (listaPokemon.size() < 2) {
                                System.out.println("Debe haber al menos 2 Pokémon para la batalla.");
                            } else {
                                batallaPokemon();
                            }
                            break;

                        case 3:
                            curarPokemon();
                            break;

                        case 4:
                        default:
                            running = false;
                            System.out.println("Byee, tengan piedad de mi alma, graciassss :)");
                    }
            }
        }
    }

    public static void CrearPokemon() {
        System.out.println("Creación de Pokémon:");
        System.out.print("Nombre: ");
        String nombre = Leer.next();
        String tipo = "";
        System.out.println("Tipos:");
        System.out.println("0. FUEGO");
        System.out.println("1. AGUA");
        System.out.println("2. PLANTA");
        System.out.print("Elija un tipo (0-2): ");
        int tipoElegido = Leer.nextInt();
        switch (tipoElegido) {
            case 0:
                tipo = "FUEGO";
                break;
            case 1:
                tipo = "AGUA";
                break;
            case 2:
                tipo = "PLANTA";
                break;
        }
        System.out.print("Poder de Ataque (entre 1 y 100): ");
        int poderAtaque = Leer.nextInt();
        System.out.print("Defensa (entre 0.1 y 0.9): ");
        float defensa = Leer.nextFloat();

        Pokemon nuevoPokemon = new Pokemon(nombre, tipo, poderAtaque, defensa, 100);
        listaPokemon.add(nuevoPokemon);
        System.out.println("¡Pokemon creado con éxito!");
    }//case 3

    public static void batallaPokemon() {
        System.out.println("Selecciona dos Pokémon para la batalla:");

        for (int i = 0; i < listaPokemon.size(); i++) {
            System.out.println((i + 1) + ". " + listaPokemon.get(i).nombrePokemon);
        }

        System.out.print("Seleccione el primer Pokémon: ");
        int indicePokemon1 = validarRango(1, listaPokemon.size()) - 1;
        System.out.print("Seleccione el segundo Pokémon: ");
        int indicePokemon2 = validarRango(1, listaPokemon.size()) - 1;

        Pokemon pokemon1 = listaPokemon.get(indicePokemon1);
        Pokemon pokemon2 = listaPokemon.get(indicePokemon2);

        System.out.println("¡Comienza la batalla entre " + pokemon1.nombrePokemon + " y " + pokemon2.nombrePokemon + "!");
        batallaRecursiva(pokemon1, pokemon2, true, 0);
    }//case 3

    public static void batallaRecursiva(Pokemon atacante, Pokemon defensor, boolean turnoAtacante, int turnos) {
        if (atacante.vidaActual <= 0 || defensor.vidaActual <= 0) {
            System.out.println("La batalla ha terminado en " + turnos + " turnos.");
            System.out.print("¡El Pokémon ");
            if (defensor.vidaActual <= 0) {
                System.out.print(defensor.nombrePokemon);
            } else {
                System.out.print(atacante.nombrePokemon);
            }
            System.out.println(" perdió!");
            return;
        }

        float multiplicadorTipo = calcularMultiplicadorTipo(atacante.tipo, defensor.tipo);
        float dano = atacante.poderAtaque * (1 - defensor.defensa) * multiplicadorTipo;
        Random random = new Random();
        if (random.nextInt(14) == 7) {
            dano *= 2;
            System.out.println("¡Golpe crítico!");
        }
        defensor.vidaActual -= dano;

        System.out.println(atacante.nombrePokemon + " ataca a " + defensor.nombrePokemon + " y realiza " + dano
                + " puntos de daño. Vida restante de " + defensor.nombrePokemon + ": " + defensor.vidaActual);
        batallaRecursiva(defensor, atacante, !turnoAtacante, turnos + 1);
    }//case 3

    public static void curarPokemon() {
        System.out.println("POKE-CENTER--------------------------------");

        for (int i = 0; i < listaPokemon.size(); i++) {
            Pokemon pokemon = listaPokemon.get(i);
            System.out.println(i + " - " + pokemon.nombrePokemon + " - HP: " + pokemon.vidaActual);
        }

        System.out.print("Seleccione Pokémon a curar: ");
        int indicePokemon = validarRango(0, listaPokemon.size() - 1);

        Pokemon pokemonACurar = listaPokemon.get(indicePokemon);

        System.out.println("Curando Pokémon...");
        System.out.println("TUN TUN TUNTUN TUN");
        pokemonACurar.vidaActual = pokemonACurar.vidaMaxima;

        System.out.println("Pokémon ha sido curado");
        System.out.println(pokemonACurar.nombrePokemon + " - HP: " + pokemonACurar.vidaActual);
    }//case 3

    public static int validarRango(int min, int max) {
        int entradas;
        do {
            System.out.print("Ingrese un valor entre " + min + " y " + max + ": ");
            entradas = Leer.nextInt();
        } while (entradas < min || entradas > max);
        return entradas;
    }//case 3

    public static float calcularMultiplicadorTipo(String tipoAtacante, String tipoDefensor) {
        final float VENTAJA = 2.0f;
        final float DESVENTAJA = 0.5f;

        if ((tipoAtacante.equals("FUEGO") && tipoDefensor.equals("PLANTA"))
                || (tipoAtacante.equals("AGUA") && tipoDefensor.equals("FUEGO"))
                || (tipoAtacante.equals("PLANTA") && tipoDefensor.equals("AGUA"))) {
            return VENTAJA;
        } else if ((tipoAtacante.equals("PLANTA") && tipoDefensor.equals("FUEGO"))
                || (tipoAtacante.equals("FUEGO") && tipoDefensor.equals("AGUA"))
                || (tipoAtacante.equals("AGUA") && tipoDefensor.equals("PLANTA"))) {
            return DESVENTAJA;
        } else {
            return 1.0f;
        }
    }// case 3
}
