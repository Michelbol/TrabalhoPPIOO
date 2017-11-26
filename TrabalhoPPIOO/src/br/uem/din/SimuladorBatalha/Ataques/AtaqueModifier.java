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
public class AtaqueModifier extends Ataque {
    private String mod;
    private int n;
    private int chance;
    
    //geters
    public String getMod() {
        return mod;
    }

    public int getN() {
        return n;
    }

    public int getChance() {
        return chance;
    }
    //seters
    public void setMod(String mod) {
        this.mod = mod;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    @Override
    public String toString() {
        return "AtaqueModifier{" + "id=" + getId() + ", nome=" + getNome() + ", tipo=" + getTipo() + ", ppMax=" + 
                getPpMax() + ", ppAtual=" + getPpAtual() + ", power=" + getPower() + ", accuracy=" + getAccuracy() + 
                ", mod=" + mod + ", n=" + n + ", chance=" + chance + '}' + "\n";
    }
    //métodos
    @Override
    public void efeito(Pokemon pokemonUsuario, Pokemon pokemonOponente){
        int hasEfeito = (this.chance/100);
        
        if(hasEfeito > Math.random()){
            switch (this.mod) {
            case "Accuracy":
                if(this.n > 0){
                    pokemonUsuario.setModifierAccuracy(this.n);
                }else{
                  pokemonOponente.setModifierAccuracy(this.n);  
                }
                break;
            case "Evasion":
                if(this.n > 0){
                    pokemonUsuario.setModifierEvasion(this.n);
                }else{
                    pokemonOponente.setModifierEvasion(this.n);
                }
                break;
            case "ATK":
                if(this.n > 0){
                  pokemonUsuario.setModifierAtk(this.n);
                }else{
                  pokemonOponente.setModifierAtk(this.n);  
                }
                break;
            case "DEF":
                if(this.n > 0){
                    pokemonUsuario.setModifierDef(this.n);
                }else{
                  pokemonOponente.setModifierDef(this.n);  
                }
                break;
            case "SPE":
                if(this.n > 0){
                    pokemonUsuario.setModifierSpe(this.n);
                }else{
                    pokemonOponente.setModifierSpe(this.n);
                }
                break;
            case "SPD":
                if(this.n > 0){
                    pokemonUsuario.setModifierSpd(this.n);
                }else{
                    pokemonOponente.setModifierSpd(this.n);
                }
                break;
            }
        }
    }
    //Construtores
    public AtaqueModifier(String mod, int n, int chance, int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.mod = mod;
        this.n = n;
        this.chance = chance;
    }

    public AtaqueModifier() {
    }
    
}
