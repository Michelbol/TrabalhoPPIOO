/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Jogador;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Controladores.View;
import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.pokemon.Pokemon;
import javax.swing.JOptionPane;

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
    
    public int escolherComando(int nroJogador){
        //o jogador vai escolher o comando que será executado.
        View view = new View();
        return view.viewEscolherComandos(nroJogador);
    }
    public void trocaPokemon(){
        View view = new View();
        int troca = 0;
        //um dos comandos que o usuário pode escolher é trocar pokemon
        System.out.println("Entrei troca!");
        while(troca <= 0){
            if(troca == -1){
                JOptionPane.showMessageDialog(null, "Você selecionou um pokemon que está com 0.00 de vida escolha outro.");
            }
            System.out.println("Entrei no while!");
            Pokemon PokemonEscolhido = view.trocaPokemon(this);
        Pokemon temp = null;
        if(this.getTime().getPokemon1() == PokemonEscolhido){
             System.out.println("este pokemon ja é o primeiro");
         }  
         if(this.getTime().getPokemon2()== PokemonEscolhido){
             temp = this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon2());
             this.getTime().setPokemon2(temp);
             System.out.println("Pokemon 1: " + this.getTime().getPokemon1());
             System.out.println("Pokemon 2: " + this.getTime().getPokemon2());
         }  
         if(this.getTime().getPokemon3()== PokemonEscolhido){
             temp = this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon3());
             this.getTime().setPokemon3(temp);
             System.out.println("Pokemon 1: " + this.getTime().getPokemon1());
             System.out.println("Pokemon 3: " + this.getTime().getPokemon3());
         }  
          if(this.getTime().getPokemon4()== PokemonEscolhido){
             temp = this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon4());
             this.getTime().setPokemon4(temp);
             System.out.println("Pokemon 1: " + this.getTime().getPokemon1());
             System.out.println("Pokemon 4: " + this.getTime().getPokemon4());
         }  
          if(this.getTime().getPokemon5()== PokemonEscolhido){
             temp = this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon5());
             this.getTime().setPokemon5(temp);
             System.out.println("Pokemon 1: " + this.getTime().getPokemon1());
             System.out.println("Pokemon 5: " + this.getTime().getPokemon5());
         }
          if(this.getTime().getPokemon6()== PokemonEscolhido){
             temp = this.getTime().getPokemon1();
             this.getTime().setPokemon1(this.getTime().getPokemon6());
             this.getTime().setPokemon6(temp);
             System.out.println("Pokemon 1: " + this.getTime().getPokemon1());
             System.out.println("Pokemon 6: " + this.getTime().getPokemon6());
         }
          if(this.getTime().getPokemon1().getStatusPrimario().equals(Status.Fainted)){
              troca = -1;
          }else{
             troca = 1; 
          }
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

    public void trocaFainted(Pokemon pokemon){
        
    }
}
