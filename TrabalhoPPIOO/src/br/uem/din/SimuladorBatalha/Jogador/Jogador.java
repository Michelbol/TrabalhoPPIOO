/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Jogador;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Pokemon;

/**
 *
 * @author miche
 */
public class Jogador {
    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Jogador{" + "time=" + time + '}';
    }
    
    public void escolherComando(){
        //o jogador vai escolher o comando que será executado.
    }
    public void trocaPokemon(Pokemon pokemon){
        //um dos comandos que o usuário pode escolher é trocar pokemon
        Pokemon temp = null;
        if(this.getTime().getPokemon1()== pokemon){
             System.out.println("este pokemon ja é o primeiro");
         }  
         if(this.getTime().getPokemon2()== pokemon){
             temp=this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon2());
             this.getTime().setPokemon2(temp);
         }  
         if(this.getTime().getPokemon3()== pokemon){
             temp=this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon3());
             this.getTime().setPokemon3(temp);
         }  
          if(this.getTime().getPokemon4()== pokemon){
             temp=this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon4());
             this.getTime().setPokemon4(temp);
         }  
          if(this.getTime().getPokemon5()== pokemon){
             temp=this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon5());
             this.getTime().setPokemon5(temp);
         }  
         
    }
    public void usarAtaque(Pokemon pokemonUsuario,Pokemon pokemonOponente,double matriz[][],Ataque ataqueEscolhido){
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque1()){
            //dentro da função efeito já é calculado o dano do ataque (Y)
//            pokemonUsuario.getAtaque1().calculoDano(pokemonUsuario, pokemonOponente, matriz, true);
            pokemonUsuario.getAtaque1().efeito(pokemonUsuario, pokemonOponente, matriz);
        }
        
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque2()){
            //dentro da função efeito já é calculado o dano do ataque (Y)
//            pokemonUsuario.getAtaque2().calculoDano(pokemonUsuario, pokemonOponente, matriz, true);
            pokemonUsuario.getAtaque2().efeito(pokemonUsuario, pokemonOponente, matriz);
        }
        
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque3()){
            //dentro da função efeito já é calculado o dano do ataque (Y)
//            pokemonUsuario.getAtaque3().calculoDano(pokemonUsuario, pokemonOponente, matriz, true);
            pokemonUsuario.getAtaque3().efeito(pokemonUsuario, pokemonOponente, matriz);
        }
        
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque4()){
            //dentro da função efeito já é calculado o dano do ataque (Y)
//            pokemonUsuario.getAtaque4().calculoDano(pokemonUsuario, pokemonOponente, matriz, true);
            pokemonUsuario.getAtaque4().efeito(pokemonUsuario, pokemonOponente, matriz);
        }
        
       
        
    }
}
