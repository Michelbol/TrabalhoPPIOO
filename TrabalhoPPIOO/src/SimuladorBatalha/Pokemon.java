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
public class Pokemon {
    private int level;
    private double hpAtual;
    private double hpMax;
    private double atk;
    private double def;
    private double spe;
    private double spd;
    private int modifierAccuracy;
    private int modifierEvasion;
    private int modifierAtk;
    private int modifierDef;
    private int modifierSpe;
    private int modifierSpd;
    private boolean confusion;
    private boolean flinch;

    //Geters
    public int getLevel() {
        return level;
    }

    public double getHpAtual() {
        return hpAtual;
    }

    public double getHpMax() {
        return hpMax;
    }

    public double getAtk() {
        return atk;
    }

    public double getDef() {
        return def;
    }

    public double getSpe() {
        return spe;
    }

    public double getSpd() {
        return spd;
    }

    public int getModifierAccuracy() {
        return modifierAccuracy;
    }

    public int getModifierEvasion() {
        return modifierEvasion;
    }

    public int getModifierAtk() {
        return modifierAtk;
    }

    public int getModifierDef() {
        return modifierDef;
    }

    public int getModifierSpe() {
        return modifierSpe;
    }

    public int getModifierSpd() {
        return modifierSpd;
    }

    public boolean isConfusion() {
        return confusion;
    }

    public boolean isFlinch() {
        return flinch;
    }

    //Seters
    public void setLevel(int level) {
        this.level = level;
    }

    public void setHpAtual(double hpAtual) {
        this.hpAtual = hpAtual;
    }

    public void setHpMax(double hpMax) {
        this.hpMax = hpMax;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public void setSpe(double spe) {
        this.spe = spe;
    }

    public void setSpd(double spd) {
        this.spd = spd;
    }

    public void setModifierAccuracy(int modifierAccuracy) {
        this.modifierAccuracy = modifierAccuracy;
    }

    public void setModifierEvasion(int modifierEvasion) {
        this.modifierEvasion = modifierEvasion;
    }

    public void setModifierAtk(int modifierAtk) {
        this.modifierAtk = modifierAtk;
    }

    public void setModifierDef(int modifierDef) {
        this.modifierDef = modifierDef;
    }

    public void setModifierSpe(int modifierSpe) {
        this.modifierSpe = modifierSpe;
    }

    public void setModifierSpd(int modifierSpd) {
        this.modifierSpd = modifierSpd;
    }

    public void setConfusion(boolean confusion) {
        this.confusion = confusion;
    }

    public void setFlinch(boolean flinch) {
        this.flinch = flinch;
    }
    
    public double valorAtributo(){
       double valorAtributo = 0;
        return valorAtributo;
    }
}
