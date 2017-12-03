/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.pokemon.Pokemon;
import javax.swing.JOptionPane;

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
    public double efeito(Pokemon pokemonUsuario, Pokemon pokemonOponente,double matriz[][]){
        this.setPpAtual(this.getPpAtual()-1);
        double dano = 0;
        if(calculoAcerto(pokemonUsuario.getModifierAccuracy(), pokemonOponente.getModifierEvasion())){
            //calcula dano
            dano = calculoDano(pokemonUsuario, pokemonOponente, matriz, false);
            pokemonOponente.setHpAtual(pokemonOponente.getHpAtual() - dano);
            double activeEfeito = this.chance/100;
            System.out.println("ActiveEfeito: " + activeEfeito);
            System.out.println("Math.random:" + Math.random());
            System.out.println("Status:" + this.status);
            if(activeEfeito > Math.random()){
                if(this.status.equals(Status.Fainted.name())
                        || this.status.equals(Status.Burn.name())
                        || this.status.equals(Status.Frozen.name())
                        || this.status.equals(Status.Paralysis.name())
                        || this.status.equals(Status.Poison.name())
                        || this.status.equals(Status.Sleep.name())
                        ){
                    JOptionPane.showMessageDialog(null, "O pokemon recebeu status: " + this.status);
                    pokemonOponente.setStatusPrimario(Status.valueOf(this.status));
                }
            }else if(this.status.equals("Flinch")){
                pokemonOponente.setFlinch(true);
            }else if(this.status.equals("Confusion")){
                pokemonOponente.setConfusion(true);
            }
        }else{
            System.out.println("Errou o ataque!");
        }
        return dano;
    }

    public AtaqueStatus(String status, int chance, int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.status = status;
        this.chance = chance;
    }

    public AtaqueStatus() {
    }
    

}
