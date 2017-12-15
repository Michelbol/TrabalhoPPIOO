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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        return -1;
    }
    
    public void trocaPokemon(){
        View view = new View();
        Pokemon PokemonEscolhido = null;
        int PokemonEscolhidoMaquina = 0;
        int troca = 0;
        //um dos comandos que o usuário pode escolher é trocar pokemon
        while(troca <= 0){
            if(troca == -1){
                view.mensagemGenerica("Você selecionou um pokemon inválido escolha outro.");
            }
            if(this.getClass() == Humano.class){
                PokemonEscolhido = view.trocaPokemon(this);
            }else if(this.getClass() == Computador.class){
                Computador computador = (Computador) this;
                PokemonEscolhidoMaquina = computador.escolhePokemon();
                view.mensagemGenerica("O computador Trocou de Computador! Agora ele está com o Pokemon: " + PokemonEscolhidoMaquina);
            }
            Pokemon temp = null;
            if(this.getTime().getPokemon2()== PokemonEscolhido || PokemonEscolhidoMaquina == 2){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon2());
                this.getTime().setPokemon2(temp);
            }  
            if(this.getTime().getPokemon3()== PokemonEscolhido || PokemonEscolhidoMaquina == 3){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon3());
                this.getTime().setPokemon3(temp);
            }  
            if(this.getTime().getPokemon4()== PokemonEscolhido || PokemonEscolhidoMaquina == 4){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon4());
                this.getTime().setPokemon4(temp);
            }  
            if(this.getTime().getPokemon5()== PokemonEscolhido || PokemonEscolhidoMaquina == 5){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon5());
                this.getTime().setPokemon5(temp);
            }
            if(this.getTime().getPokemon6()== PokemonEscolhido || PokemonEscolhidoMaquina == 6){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon6());
                this.getTime().setPokemon6(temp);
            }
            if(this.getTime().getPokemon1().getStatusPrimario().equals(Status.Fainted) || PokemonEscolhidoMaquina == 1){
                troca = -1;
            }else{
                troca = 1; 
            }
        }
    }
    
    public void usarAtaque(Pokemon pokemonUsuario,Pokemon pokemonOponente,double matriz[][],Ataque ataqueEscolhido){
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque1()){
            pokemonUsuario.getAtaque1().efeito(pokemonUsuario, pokemonOponente, matriz);
        }
        
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque2()){
            pokemonUsuario.getAtaque2().efeito(pokemonUsuario, pokemonOponente, matriz);
        }
        
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque3()){
            pokemonUsuario.getAtaque3().efeito(pokemonUsuario, pokemonOponente, matriz);
        }
        
        if(ataqueEscolhido == this.time.getPokemon1().getAtaque4()){
            pokemonUsuario.getAtaque4().efeito(pokemonUsuario, pokemonOponente, matriz);
        }

    }

    public void trocaFainted(){
        Pokemon temp = null;
        int indice=0;
        List<Pokemon> list = new ArrayList();
        if(this.time.getNumeroPokemonsTime() > 1){
            if(this.time.getPokemon2() != null && this.time.getPokemon2().getStatusPrimario() != Status.Fainted){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon2());
                this.getTime().setPokemon2(temp); 
                indice = 1;
            }else if(this.time.getPokemon3() != null && this.time.getPokemon3().getStatusPrimario() != Status.Fainted){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon2());
                this.getTime().setPokemon3(temp); 
                indice = 2;
            }else if(this.time.getPokemon4() != null && this.time.getPokemon4().getStatusPrimario() != Status.Fainted){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon2());
                this.getTime().setPokemon4(temp);
                indice = 3;
            }else if(this.time.getPokemon5() != null && this.time.getPokemon5().getStatusPrimario() != Status.Fainted){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon2());
                this.getTime().setPokemon5(temp); 
                indice = 4;
            }else if(this.time.getPokemon6() != null && this.time.getPokemon6().getStatusPrimario() != Status.Fainted){
                temp = this.getTime().getPokemon1();
                this.getTime().setPokemon1(this.getTime().getPokemon2());
                this.getTime().setPokemon6(temp); 
                indice = 5;
            }
            list.add(this.time.getPokemon1());
            list.add(this.time.getPokemon2());
            list.add(this.time.getPokemon3());
            list.add(this.time.getPokemon4());
            list.add(this.time.getPokemon5());
            list.add(this.time.getPokemon6());
            System.out.println("Jogador: "+ this);
            for(int i = indice; i<time.getNumeroPokemonsTime(); i++){
                int j = i;
                list.add(i, list.get(j));
                list.remove(j);
            }
            
            this.getTime().setPokemon1(list.get(0));
            this.getTime().setPokemon2(list.get(1));
            this.getTime().setPokemon3(list.get(2));
            this.getTime().setPokemon4(list.get(3));
            this.getTime().setPokemon5(list.get(4));
            this.getTime().setPokemon6(list.get(5));
           
        }
        }
}
