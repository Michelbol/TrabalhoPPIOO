/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.pokemon;

import br.uem.din.SimuladorBatalha.Enum.Tipo;
import java.util.List;

/**
 *
 * @author miche
 */
public class Especie {
    private int id;
    private String nome;
    private Tipo tipo1;
    private Tipo tipo2;
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

    public Tipo getTipo1() {
        return tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
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
    
    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
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
    //tooString
    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nome=" + nome + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", baseHp=" + baseHp + 
                ", baseAtk=" + baseAtk + ", baseDef=" + baseDef + ", baseSpe=" + baseSpe + ", baseSpd=" + baseSpd + '}';
    }

    public Especie(int id, String nome, String stringTipo1, String stringTipo2, double baseHp, double baseAtk, double baseDef, double baseSpe, double baseSpd) {
        this.id = id;
        this.nome = nome;
        Tipo tipo1 = Tipo.valueOf(stringTipo1);
        this.tipo1 = tipo1;
        if(stringTipo2.equals("")){
            stringTipo2 = "None";
        }
        Tipo tipo2 = Tipo.valueOf(stringTipo2);
        this.tipo2 = tipo2;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpe = baseSpe;
        this.baseSpd = baseSpd;
    }

    public Especie() {
    }
    

    //métodos
    public double calcularAtributoHpMax(int level){
        double hpMax = (2*this.baseHp*level)/(100+level+10);
        return hpMax;
    }
    public double calcularAtributoHpAtual(int level){
            double hpAtual = (2*this.baseHp*level)/(100+level+10);
            return hpAtual;
    }
    public double calcularAtributoAtk(int level){
            double atk = (2*this.baseAtk*level)/(100+5);
            return atk;
    }
    public double calcularAtributoDef(int level){
            double def = (2*this.baseDef*level)/(100+5);
            return def;
    }
    public double calcularAtributoSpe(int level){
            double spe = (2*this.baseSpe*level)/(100+5);
            return spe;
    }
    public double calcularAtributoSpd(int level){
            double spd = (2*this.baseSpe*level)/(100+5);
            return spd;
    }
}
