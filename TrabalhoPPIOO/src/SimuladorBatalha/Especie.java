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
public class Especie {
    private int id;
    private String nome;
    private double baseHp;
    private double baseAtk;
    private double baseDef;
    private double baseSpe;
    private double baseSpd;
    
    //geters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getBaseHp() {
        return baseHp;
    }

    public double getBaseAtk() {
        return baseAtk;
    }

    public double getBaseDef() {
        return baseDef;
    }

    public double getBaseSpe() {
        return baseSpe;
    }

    public double getBaseSpd() {
        return baseSpd;
    }
    
    //seters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBaseHp(double baseHp) {
        this.baseHp = baseHp;
    }

    public void setBaseAtk(double baseAtk) {
        this.baseAtk = baseAtk;
    }

    public void setBaseDef(double baseDef) {
        this.baseDef = baseDef;
    }

    public void setBaseSpe(double baseSpe) {
        this.baseSpe = baseSpe;
    }

    public void setBaseSpd(double baseSpd) {
        this.baseSpd = baseSpd;
    }
    
    //métodos
    public double calcularAtributo(){
        int calcularAtributo = 0;
        return calcularAtributo;
    }
}
