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
    public void efeito(){
        
    }
    
    public AtaqueMultihit copiaAtaque(Ataque ataque){
        AtaqueMultihit ataquemultihit = new AtaqueMultihit();
        ataquemultihit.setId(ataque.getId());
        ataquemultihit.setNome(ataque.getNome());
        ataquemultihit.setTipo(ataque.getTipo());
        ataquemultihit.setPpAtual(ataque.getPpAtual());
        ataquemultihit.setPower(ataque.getPower());
        ataquemultihit.setAccuracy(ataque.getAccuracy());
        return ataquemultihit;
    }
}
