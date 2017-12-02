/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Jogador;

import br.uem.din.SimuladorBatalha.Enum.Status;
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
    
 
    
    public void setPokemon(Pokemon pokemon) {
        //verificar se existe cada pokemon e inserir pokemon caso exista alguma vaga
            if(this.getPokemon1() == null){
                this.pokemon1 = pokemon;
//                System.out.println("Adicionou pokemon1");
            }else if(this.getPokemon2() == null){
                this.pokemon2 = pokemon;
//                System.out.println("Adicionou pokemon2");
            }else if(this.getPokemon3() == null){
                this.pokemon3 = pokemon;
//                System.out.println("Adicionou pokemon3");
            }else if(this.getPokemon4() == null){
                this.pokemon4 = pokemon;
//                System.out.println("Adicionou pokemon4");
            }else if(this.getPokemon5() == null){
                this.pokemon5 = pokemon;
//                System.out.println("Adicionou pokemon5");
            }else if(this.getPokemon6() == null){
                this.pokemon6 = pokemon;
//                System.out.println("Adicionou pokemon6");
            }else{
                JOptionPane.showMessageDialog(null, "O time já está cheio!");
            } 
    }

    @Override
    public String toString() {
        return "Time{" + "numeroPokemonsTime=" + numeroPokemonsTime + ",\n pokemon1=" + pokemon1 + ",\n pokemon2=" + pokemon2 + 
                ",\n pokemon3=" + pokemon3 + ",\n pokemon4=" + pokemon4 + ", pokemon5=" + pokemon5 + ",\n pokemon6=" + pokemon6 + 
                '}';
    }

    public Time(int numeroPokemonsTime, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5,
            Pokemon pokemon6) {
        this.numeroPokemonsTime = numeroPokemonsTime;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        this.pokemon5 = pokemon5;
        this.pokemon6 = pokemon6;
    }

    public Time() {
    }
    
    public boolean verificaTime(){
        if(this.pokemon1.getStatusPrimario() != Status.FAINTED
                || this.pokemon2.getStatusPrimario() != Status.FAINTED
                || this.pokemon3.getStatusPrimario() != Status.FAINTED
                || this.pokemon4.getStatusPrimario() != Status.FAINTED
                || this.pokemon5.getStatusPrimario() != Status.FAINTED
                || this.pokemon6.getStatusPrimario() != Status.FAINTED){
            return true;
        }else{
            System.out.println("Este time perdeu!");
            return false;
        }
    }
    
    
    
}
