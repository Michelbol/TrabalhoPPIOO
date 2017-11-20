/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Jogador;

import br.uem.din.SimuladorBatalha.Pokemon;

/**
 *
 * @author miche
 */
public class Time {
    private int numeroPokemonsTime;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private Pokemon pokemon5;
    private Pokemon pokemon6;
    //geters

    public int getNumeroPokemonsTime() {
        return numeroPokemonsTime;
    }
    
    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public Pokemon getPokemon4() {
        return pokemon4;
    }

    public Pokemon getPokemon5() {
        return pokemon5;
    }

    public Pokemon getPokemon6() {
        return pokemon6;
    }
    //seters

    public void setNumeroPokemonsTime(int numeroPokemonsTime) {
        this.numeroPokemonsTime = numeroPokemonsTime;
    }
    
    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

    public void setPokemon4(Pokemon pokemon4) {
        this.pokemon4 = pokemon4;
    }

    public void setPokemon5(Pokemon pokemon5) {
        this.pokemon5 = pokemon5;
    }

    public void setPokemon6(Pokemon pokemon6) {
        this.pokemon6 = pokemon6;
    }
    
}
