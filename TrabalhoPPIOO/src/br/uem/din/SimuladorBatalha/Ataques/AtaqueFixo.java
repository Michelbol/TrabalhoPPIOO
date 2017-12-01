/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.Pokemon;

/**
 *
 * @author miche
 */
public class AtaqueFixo extends Ataque {
    private int val;
    
    //geters
    public int getVal() {
        return val;
    }
    //seters
    public void setVal(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return "AtaqueFixo{" + "id=" + getId() + ", nome=" + getNome() + ", tipo=" + getTipo() + ", ppMax=" + 
                getPpMax() + ", ppAtual=" + getPpAtual() + ", power=" + getPower() + ", accuracy=" + getAccuracy() + 
                ", val=" + val + '}' + "\n";
    }
    //métodos
     @Override
    public double efeito(Pokemon pokemonUsuario, Pokemon pokemonOponente,double matriz[][]){
        this.setPpAtual(this.getPpAtual()-1);
        double dano = 0;
        if(calculoAcerto(pokemonUsuario.getModifierAccuracy(), pokemonOponente.getModifierEvasion())){
            //calcula dano
            if(this.val == 0){
                dano = pokemonUsuario.getLevel();
                pokemonOponente.setHpAtual(pokemonOponente.getHpAtual() - dano);
            }else{
                dano = this.val;
                pokemonOponente.setHpAtual(pokemonOponente.getHpAtual() - dano);
            }
        }else{
            System.out.println("Errou o ataque!");
        }
        return dano;
    }
    //Construtores
    public AtaqueFixo(int val, int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.val = val;
    }

    public AtaqueFixo() {
    }
    
}
