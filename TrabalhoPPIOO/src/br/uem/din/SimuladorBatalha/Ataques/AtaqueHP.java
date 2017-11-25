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
    public Status efeito(){
        return Status.valueOf("BURN");
    }

    public AtaqueHP(int valor, int porcentagem, int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.valor = valor;
        this.porcentagem = porcentagem;
    }

    public AtaqueHP() {
    }
    
}
