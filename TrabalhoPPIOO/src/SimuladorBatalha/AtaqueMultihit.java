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
    //métodos
    @Override
    public void efeito(){
        
    }
}
