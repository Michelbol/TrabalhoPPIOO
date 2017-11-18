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
public class AtaqueHP extends Ataque {
    private int valor;
    private int porcentagem;
    
    //geters
    public int getValor() {
        return valor;
    }
    
    public int getPorcentagem() {
        return porcentagem;
    }
    //seters
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }
    
    @Override
    public String toString() {
        return "AtaqueHP{" + "id=" + getId() + ", nome=" + getNome() + ", tipo=" + getTipo() + ", ppMax=" + 
                getPpMax() + ", ppAtual=" + getPpAtual() + ", power=" + getPower() + ", accuracy=" + getAccuracy() + 
                ", valor=" + valor + ", porcentagem=" + porcentagem + '}' + "\n";
    }
    //métodos
    @Override
    public void efeito(){
        
    }
    
    public AtaqueHP copiaAtaque(Ataque ataque){
        AtaqueHP ataquehp = new AtaqueHP();
        ataquehp.setId(ataque.getId());
        ataquehp.setNome(ataque.getNome());
        ataquehp.setTipo(ataque.getTipo());
        ataquehp.setPpAtual(ataque.getPpAtual());
        ataquehp.setPower(ataque.getPower());
        ataquehp.setAccuracy(ataque.getAccuracy());
        return ataquehp;
    }
}
