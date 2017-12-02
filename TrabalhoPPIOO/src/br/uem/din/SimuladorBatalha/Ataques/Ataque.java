    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.Enum.Tipo;
import br.uem.din.SimuladorBatalha.Jogador.Jogador;
import br.uem.din.SimuladorBatalha.pokemon.Pokemon;
import java.util.Random;
import javax.swing.JOptionPane;

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
    //toString
    @Override
    public String toString() {
        return "AtaqueComum{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", ppMax=" + ppMax + ", ppAtual=" +
                ppAtual + ", power=" + power + ", accuracy=" + accuracy + '}';
    }
    //contrutores
    public Ataque(int id, String nome, String tipo, double ppMax, double ppAtual, int power, int accuracy) {
        this.id = id;
        this.nome = nome;
        try{
            this.tipo = Tipo.valueOf(tipo);
        }catch(Exception e){
//            System.out.println(e.getMessage() + " " + "Valor da Tabela: " + tipo);
        }      
        this.ppMax = ppMax;
        this.ppAtual = ppAtual;
        this.power = power;
        this.accuracy = accuracy;
    }

    public Ataque() {
    }
    
    public Ataque(String ataque) {
        System.out.println("Ataque não informado");
    }
    
    //métodos
    public double efeito(Pokemon pokemonUsuario, Pokemon pokemonOponente,double matriz[][]){
        this.ppAtual = this.ppAtual -1;
        double dano = 0;
        if(calculoAcerto(pokemonUsuario.getModifierAccuracy(), pokemonOponente.getModifierEvasion())){
            //calcula dano
            dano = calculoDano(pokemonUsuario, pokemonOponente, matriz, false);
            pokemonOponente.setHpAtual((pokemonOponente.getHpAtual() - dano));
            return dano;
        }else{
            System.out.println("Errou o ataque!");
            return 0;
        }
    }
    
    public boolean calculoCritico(Double spdUsuario){
        double isCritico = spdUsuario/512;
        if(isCritico > Math.random()){
            JOptionPane.showMessageDialog(null, "Ataque Crítico!!!");
            return true;
        }else{
          return false;  
        }
    }
    
    public boolean calculoAcerto(double modifierAccuracy, double modifierEvasion){
        System.out.println("Accuracy: " + modifierAccuracy + "\nEvasion: " + modifierEvasion + "\nAccuracy: " + this.accuracy);
        double isHit = this.accuracy * (modifierAccuracy/modifierEvasion);
        if(isHit > Math.random()){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "O Ataque falhou!!!");
          return false;
        }
    }
    
    public double calculoDano(Pokemon pokemonUsuario, Pokemon pokemonOponente, double matriz[][],boolean isMulthit){
        int L = pokemonUsuario.getLevel(), P = this.power;
        double A = 0, D = 0;
        
        if(this.tipo == Tipo.valueOf("None") 
                || this.tipo == Tipo.valueOf("Fighting") 
                || this.tipo == Tipo.valueOf("Flying")
                || this.tipo == Tipo.valueOf("Poison") 
                || this.tipo == Tipo.valueOf("Ground") 
                || this.tipo == Tipo.valueOf("Rock")
                || this.tipo == Tipo.valueOf("Bug") 
                || this.tipo == Tipo.valueOf("Ghost") ){
            A = (pokemonUsuario.getAtk() < 0) ? 0 : pokemonUsuario.getAtk();
            D = pokemonOponente.getDef();
        }else if(this.tipo == Tipo.valueOf("Fire") 
                || this.tipo == Tipo.valueOf("Water") 
                || this.tipo == Tipo.valueOf("Electric")
                || this.tipo == Tipo.valueOf("Grass") 
                || this.tipo == Tipo.valueOf("Ice") 
                || this.tipo == Tipo.valueOf("Psychic")
                || this.tipo == Tipo.valueOf("Dragon")){
            A = (pokemonUsuario.getSpe() < 0) ? 0 : pokemonUsuario.getSpe();
            D = pokemonOponente.getSpe();
        }
        if(calculoCritico(pokemonUsuario.getSpd()) && isMulthit == false){
            L *= 2;
        }
        if(isMulthit == true){
            L *= 2;
        }
        if(pokemonUsuario.getStatusPrimario() == Status.valueOf("BURN")){
            A = (A < 0) ? 0 : (A/2);
        }
        double dano = (L * A * P / D / 50) + 2;
        if(this.tipo == pokemonUsuario.getEspecie().getTipo1() || this.tipo == pokemonUsuario.getEspecie().getTipo2()){
            dano *= 1.5;
        }
        dano = dano*matriz[this.tipo.nroEnum][pokemonUsuario.getEspecie().getTipo1().nroEnum]*matriz[this.tipo.nroEnum][pokemonUsuario.getEspecie().getTipo2().nroEnum];
        Random rand = new Random();
        int R = (rand.nextInt(38)+217);
        dano = (dano * R)/255;
        System.out.println("Dano: " + dano);
        return dano;
    }
    
    
}
