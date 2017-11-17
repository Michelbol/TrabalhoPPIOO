/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorBatalha;

/**
 *
 * @author miche
 */
public class AtaqueStatus extends Ataque {
    private int status;
    private int chance;
    //geters
    public int getStatus() {
        return status;
    }

    public int getChance() {
        return chance;
    }
    //seters
    public void setStatus(int status) {
        this.status = status;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    //métodos
    @Override
    public void efeito(){
        
    }
}
