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
public class AtaqueStatus extends Ataque {
    private String status;
    private int chance;
    
    //geters
    public String getStatus() {
        return status;
    }

    public int getChance() {
        return chance;
    }
    //seters
    public void setStatus(String status) {
        this.status = status;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    @Override
    public String toString() {
        return "AtaqueStatus{" + "id=" + getId() + ", nome=" + getNome() + ", tipo=" + getTipo() + ", ppMax=" + 
                getPpMax() + ", ppAtual=" + getPpAtual() + ", power=" + getPower() + ", accuracy=" + getAccuracy() +
                ", status:" + status + ", chance:" + chance + '}' + "\n";
    }
    //métodos
    @Override
    public void efeito(){
        
    }
    public AtaqueStatus copiaAtaque(Ataque ataque){
        AtaqueStatus ataquestatus = new AtaqueStatus();
        ataquestatus.setId(ataque.getId());
        ataquestatus.setNome(ataque.getNome());
        ataquestatus.setTipo(ataque.getTipo());
        ataquestatus.setPpAtual(ataque.getPpAtual());
        ataquestatus.setPower(ataque.getPower());
        ataquestatus.setAccuracy(ataque.getAccuracy());
        return ataquestatus;
    }
    public boolean verificaAtaqueStatus(Object o){
        AtaqueStatus ataque = new AtaqueStatus();
        if(o.equals(ataque)){
            return true;
        }else{
            return false;
        }           
    }
}
