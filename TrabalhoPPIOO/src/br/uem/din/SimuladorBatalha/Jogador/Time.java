/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Jogador;

import br.uem.din.SimuladorBatalha.Pokemon;
import javax.swing.JOptionPane;

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
    
    public void setPokemon(Pokemon pokemon, Time time) {
        //verificar se existe cada pokemon e inserir pokemon caso exista alguma vaga
            if(time.getPokemon1() == null){
                time.pokemon1 = pokemon;
                System.out.println("Adicionou pokemon1");
            }else if(time.getPokemon2() == null){
                time.pokemon2 = pokemon;
                System.out.println("Adicionou pokemon2");
            }else if(time.getPokemon3() == null){
                time.pokemon3 = pokemon;
                System.out.println("Adicionou pokemon3");
            }else if(time.getPokemon4() == null){
                time.pokemon4 = pokemon;
                System.out.println("Adicionou pokemon4");
            }else if(time.getPokemon5() == null){
                time.pokemon5 = pokemon;
                System.out.println("Adicionou pokemon5");
            }else if(time.getPokemon6() == null){
                time.pokemon6 = pokemon;
                System.out.println("Adicionou pokemon6");
            }else{
                JOptionPane.showMessageDialog(null, "O time já está cheio!");
            } 
    }
    
}
