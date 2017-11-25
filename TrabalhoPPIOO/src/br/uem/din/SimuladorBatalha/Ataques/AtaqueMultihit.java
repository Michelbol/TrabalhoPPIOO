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
    public Status efeito(){
        return Status.valueOf("BURN");
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
