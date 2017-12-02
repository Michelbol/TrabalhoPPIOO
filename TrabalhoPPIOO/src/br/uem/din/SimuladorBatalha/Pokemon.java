/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Enum.Status;
import static java.lang.Double.max;
import javax.swing.JOptionPane;

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
    private Status statusPrimario;
    private Especie especie;
    private Ataque ataque1;
    private Ataque ataque2;
    private Ataque ataque3;
    private Ataque ataque4;

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

    public double getModifierAccuracy() {
        return calculaModifier(modifierAccuracy);
    }

    public double getModifierEvasion() {
        return calculaModifier(modifierEvasion);
    }

    public double getModifierAtk() {
        return calculaModifier(modifierAtk);
    }

    public double getModifierDef() {
        return calculaModifier(modifierDef);
    }

    public double getModifierSpe() {
        return calculaModifier(modifierSpe);
    }

    public double getModifierSpd() {
        return calculaModifier(modifierSpd);
    }

    public boolean isConfusion() {
        return confusion;
    }

    public boolean isFlinch() {
        return flinch;
    }

    public Status getStatusPrimario() {
        return statusPrimario;
    }

    public Especie getEspecie() {
        return especie;
    }

    public Ataque getAtaque1() {
        return ataque1;
    }

    public Ataque getAtaque2() {
        return ataque2;
    }

    public Ataque getAtaque3() {
        return ataque3;
    }

    public Ataque getAtaque4() {
        return ataque4;
    }
    //Seters
    public void setLevel(int level) {
        this.level = level;
    }

    public void setHpAtual(double hpAtual) {
        if(hpAtual <= this.hpMax){
            this.hpAtual = hpAtual;
        }else{
            System.out.println("Vida do pokemon está completa!");
        }
        if(this.hpAtual <= 0){
            this.hpAtual = 0;
            this.statusPrimario = Status.FAINTED;
        }
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
        if(this.modifierAccuracy > 6){
            this.modifierAccuracy = 6;
        }else if(this.modifierAccuracy < -6){
            this.modifierAccuracy = -6;
        }else{
           this.modifierAccuracy = modifierAccuracy; 
        }
    }

    public void setModifierEvasion(int modifierEvasion) {
        if(this.modifierEvasion > 6){
            this.modifierEvasion = 6;
        }else if(this.modifierEvasion < -6){
            this.modifierEvasion = -6;
        }else{
           this.modifierEvasion = modifierEvasion; 
        }
    }

    public void setModifierAtk(int modifierAtk) {
        if(this.modifierAtk > 6){
            this.modifierAtk = 6;
        }else if(this.modifierAtk < -6){
            this.modifierAtk = -6;
        }else{
           this.modifierAtk = modifierAtk; 
        }
    }

    public void setModifierDef(int modifierDef) {
        if(this.modifierDef > 6){
            this.modifierDef = 6;
        }else if(this.modifierDef < -6){
            this.modifierDef = -6;
        }else{
           this.modifierDef = modifierDef; 
        }
    }

    public void setModifierSpe(int modifierSpe) {
        if(this.modifierSpe > 6){
            this.modifierSpe = 6;
        }else if(this.modifierSpe < -6){
            this.modifierSpe = -6;
        }else{
           this.modifierSpe = modifierSpe; 
        }
    }

    public void setModifierSpd(int modifierSpd) {
        if(this.modifierSpd > 6){
            this.modifierSpd = 6;
        }else if(this.modifierSpd < -6){
            this.modifierSpd = -6;
        }else{
           this.modifierSpd = modifierSpd; 
        }
    }

    public void setConfusion(boolean confusion) {
        this.confusion = confusion;
    }

    public void setFlinch(boolean flinch) {
        this.flinch = flinch;
    }
    
    public void setStatusPrimario(Status statusPrimario) {
        this.statusPrimario = statusPrimario;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }   

    public void setAtaque1(Ataque ataque1) {
        this.ataque1 = ataque1;
    }

    public void setAtaque2(Ataque ataque2) {
        this.ataque2 = ataque2;
    }

    public void setAtaque3(Ataque ataque3) {
        this.ataque3 = ataque3;
    }

    public void setAtaque4(Ataque ataque4) {
        this.ataque4 = ataque4;
    }

    @Override
    public String toString() {
        return "Nome: "+especie.getNome()+"   HP Atual: "+this.hpAtual;
        
    }
    

    public Pokemon(int level, Especie especie, Ataque ataque1, Ataque ataque2, Ataque ataque3, Ataque ataque4) {
        this.level = level;
        this.hpAtual = especie.calcularAtributoHpAtual(level);
        this.hpMax = especie.calcularAtributoHpAtual(level);
        this.atk = especie.calcularAtributoAtk(level);
        this.def = especie.calcularAtributoDef(level);
        this.spe = especie.calcularAtributoSpe(level);
        this.spd = especie.calcularAtributoSpd(level);
        this.modifierAccuracy = 0;
        this.modifierEvasion = 0;
        this.modifierAtk = 0;
        this.modifierDef = 0;
        this.modifierSpe = 0;
        this.modifierSpd = 0;
        this.confusion = false;
        this.flinch = false;
        this.statusPrimario = Status.valueOf("OK");
        this.especie = especie;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.ataque3 = ataque3;
        this.ataque4 = ataque4;
    }

    public Pokemon() {
    }
    
    
    //métodos
    public double valorAtributoAtk(){       
       return this.atk*(max(2, 2 + this.modifierAtk)/max(2,2-this.modifierAtk));
    }
    public double valorAtributoDef(){       
       return this.def*(max(2, 2 + this.modifierDef)/max(2,2-this.modifierDef));
    }
    public double valorAtributoSpe(){       
       return this.spe*(max(2, 2 + this.modifierSpe)/max(2,2-this.modifierSpe));
    }
    public double valorAtributoSpd(){       
       return this.spd*(max(2, 2 + this.modifierSpd)/max(2,2-this.modifierSpd));
    }
    public double calculaModifier(int modifier){
        double permodifier = 0;
        switch (modifier) {
            case -6:
                permodifier = 33;
                break;
            case -5:
                permodifier = 37;
                break;
            case -4:
                permodifier = 43;
                break;
            case -3:
                permodifier = 50;
                break;
            case -2:
                permodifier = 60;
                break;
            case -1:
                permodifier = 75;
                break;
            case 0:
                permodifier = 100;
                break;
            case 1:
                permodifier = 133;
                break;
            case 2:
                permodifier = 166;
                break;
            case 3:
                permodifier = 200;
                break;
            case 4:
                permodifier = 233;
                break;
            case 5:
                permodifier = 266;
                break;
            case 6:
                permodifier = 300;
                break;
        }
        return permodifier;
    }
}
