/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Jogador;

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
    public void trocaPokemon(){
        //um dos comandos que o usuário pode escolher é trocar pokemon
    }
    public void usarAtaque(){
        //um dos comandos que o usuário pode escolher vai atacar o outro pokemon
    }
}
