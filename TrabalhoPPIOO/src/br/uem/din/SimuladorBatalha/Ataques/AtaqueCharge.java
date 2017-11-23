/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

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
    public void efeito(){
        
    }

    public AtaqueCharge(int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
    }

    public AtaqueCharge() {
    }
    
}
