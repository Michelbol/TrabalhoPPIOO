/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Controladores.View;
import br.uem.din.SimuladorBatalha.pokemon.Pokemon;

/**
 *
 * @author miche
 */
public class AtaqueCharge extends Ataque{

    @Override
    public String toString() {
        return "AtaqueCharge{" + "id=" + getId() + ", nome=" + getNome() + ", tipo=" + getTipo() + ", ppMax=" + 
                getPpMax() + ", ppAtual=" + getPpAtual() + ", power=" + getPower() + ", accuracy=" + getAccuracy() + '}'+"\n";
    }
    
    @Override
    public double efeito(Pokemon pokemonUsuario, Pokemon pokemonOponente,double matriz[][]){
        this.setPpAtual(this.getPpAtual()-1);
        double dano = 0;
        if(calculoAcerto(pokemonUsuario.getModifierAccuracy(),
                pokemonOponente.getModifierEvasion(),
                pokemonUsuario.getStatusPrimario(),
                pokemonUsuario.isFlinch())){
            //calcula dano
            dano = calculoDano(pokemonUsuario, pokemonOponente, matriz, false);
            pokemonOponente.setHpAtual(pokemonOponente.getHpAtual() - dano);
        }else{
          View view = new View();
          view.mensagemGenerica("O ataque Falhou!");
        }
        return dano;
    }

    public AtaqueCharge(int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
    }

    public AtaqueCharge() {
    }
    
}
