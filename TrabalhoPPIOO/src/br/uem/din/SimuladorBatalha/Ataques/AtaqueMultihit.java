/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Controladores.View;
import br.uem.din.SimuladorBatalha.pokemon.Pokemon;
import java.util.Random;

/**
 *
 * @author miche
 */
public class AtaqueMultihit extends Ataque {
    private int min;
    private int max;
    
    //geters
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
    //seters
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    @Override
    public String toString() {
        return "AtaqueMultihit{" + "id=" + getId() + ", nome=" + getNome() + ", tipo=" + getTipo() + ", ppMax=" + 
                getPpMax() + ", ppAtual=" + getPpAtual() + ", power=" + getPower() + ", accuracy=" + getAccuracy() +
                ", min:" + min + ", max:" + max + '}' + "\n";
    }
    //métodos
    @Override
    public double efeito(Pokemon pokemonUsuario, Pokemon pokemonOponente,double matriz[][]){
      this.setPpAtual(this.getPpAtual()-1);
      double dano = 0;
        if(calculoAcerto(pokemonUsuario.getModifierAccuracy(),
                pokemonOponente.getModifierEvasion(),
                pokemonUsuario.getStatusPrimario(),
                pokemonUsuario.isFlinch())){
            //calcula dano
            Random rand = new Random();
            int intervalo = ((this.max - this.min) == 0) ? this.max : (this.max - this.min);
            int nroTotAtaques = (rand.nextInt(intervalo)+this.min);
            int critico = (calculoCritico(pokemonUsuario.getSpd())) ? 2 : 1;
            for(int contAtaque = 1; contAtaque <= nroTotAtaques; contAtaque++){
                dano = (calculoDano(pokemonUsuario, pokemonOponente, matriz, true)*critico);
                pokemonOponente.setHpAtual(pokemonOponente.getHpAtual() - dano);
            }
        }else{
           View view = new View();
           view.mensagemGenerica("O ataque Falhou!"); 
        }
        return dano;
    }
    //Construtores
    public AtaqueMultihit(int min, int max, int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.min = min;
        this.max = max;
    }

    public AtaqueMultihit() {
    }
    
}
