/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.pokemon.Pokemon;

/**
 *
 * @author miche
 */
public class AtaqueHP extends Ataque {
    private String valor;
    private int porcentagem;
    
    //geters
    public String getValor() {
        return valor;
    }
    
    public int getPorcentagem() {
        return porcentagem;
    }
    //seters
    public void setValor(String valor) {
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
            if(this.valor.equals("dano")){
                pokemonUsuario.setHpAtual(pokemonUsuario.getHpAtual()+this.porcentagem);
            }else if(this.valor.equals("max_hp")){
                pokemonUsuario.setHpAtual(pokemonUsuario.getHpAtual()+(pokemonUsuario.getHpMax()*this.porcentagem));
            }
        }else{
            System.out.println("Errou o ataque!");
        }
        return dano;
    }

    public AtaqueHP(String valor, int porcentagem, int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.valor = valor;
        this.porcentagem = porcentagem;
    }

    public AtaqueHP() {
    }
    
}
