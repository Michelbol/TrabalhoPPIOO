/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Enum.Status;

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
    public Status efeito(){
        return Status.valueOf("BURN");
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
