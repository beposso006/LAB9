/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_linsyposso;

/**
 *
 * @author 29164
 */
public class Pokemon {

    String nombrePokemon;
    String tipo;
    int poderAtaque;
    float defensa;
    int vidaMaxima;
    int vidaActual;

    public Pokemon(String nombre, String tipo, int poderAtaque, float defensa, int vidaMaxima) {
        this.nombrePokemon = nombre;
        this.tipo = tipo;
        this.poderAtaque = poderAtaque;
        this.defensa = defensa;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPoderdeAtaque() {
        return poderAtaque;
    }

    public void setPoderdeAtaque(int poderdeAtaque) {
        this.poderAtaque = poderdeAtaque;
    }

    public float getDefensa() {
        return defensa;
    }

    public void setDefensa(float defensa) {
        this.defensa = defensa;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

}
