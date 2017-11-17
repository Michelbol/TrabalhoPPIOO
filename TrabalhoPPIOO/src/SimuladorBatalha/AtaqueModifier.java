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
public class AtaqueModifier extends Ataque {
    private int mod;
    private int n;
    private int chance;
    //geters
    public int getMod() {
        return mod;
    }

    public int getN() {
        return n;
    }

    public int getChance() {
        return chance;
    }
    //seters
    public void setMod(int mod) {
        this.mod = mod;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    //métodos
    @Override
    public void efeito(){
        
    }
}
