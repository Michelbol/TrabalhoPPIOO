/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Enum.Tipo;

/**
 *
 * @author miche
 */
public class Ataque {
    private int id;
    private String nome;
    private Tipo tipo;
    private double ppMax;
    private double ppAtual;
    private int power;
    private int accuracy;

    //geters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getPpMax() {
        return ppMax;
    }

    public double getPpAtual() {
        return ppAtual;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }
    
    //seters

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setPpMax(double ppMax) {
        this.ppMax = ppMax;
    }

    public void setPpAtual(double ppAtual) {
        this.ppAtual = ppAtual;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Ataque{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", ppMax=" + ppMax + ", ppAtual=" + ppAtual + ", power=" + power + ", accuracy=" + accuracy + '}';
    }
    
    //métodos
    public void efeito(){
        
    }
    public void calculoCritico(){
        
    }
    public void calculoAcerto(){
        
    }
    public void calculoDano(){
        
    }
}
