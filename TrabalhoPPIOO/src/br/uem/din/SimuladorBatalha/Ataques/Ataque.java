    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Ataques;

import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.Enum.Tipo;
import br.uem.din.SimuladorBatalha.Pokemon;
import com.sun.xml.internal.ws.api.message.Packet;

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
        System.out.println("Ataque não informado");;
    }
    
    
    
    //métodos
    public Status efeito(){
        return Status.valueOf("BURN");
    }
    public boolean calculoCritico(Pokemon pokemon){
        double isCritico = pokemon.getSpd()/512;
        //não entendi
        return false;
    }
    public void calculoAcerto(){
        
    }
    public double calculoDano(Pokemon pokemonUsuario, Pokemon pokemonOponente){
        int spd = 0, L = pokemonUsuario.getLevel(), P = this.power;
        double A = ((pokemonUsuario.getAtk() < 0) ? 0 : pokemonUsuario.getAtk()), D = pokemonUsuario.getDef();
        
        if(this.tipo == Tipo.valueOf("None") || this.tipo == Tipo.valueOf("Fighting") || this.tipo == Tipo.valueOf("Flying")
                || this.tipo == Tipo.valueOf("Poison") || this.tipo == Tipo.valueOf("Ground") || this.tipo == Tipo.valueOf("Rock")
                || this.tipo == Tipo.valueOf("Bug") || this.tipo == Tipo.valueOf("Ghost") ){
            A = (pokemonUsuario.getAtk() < 0) ? 0 : pokemonUsuario.getAtk();
            D = pokemonOponente.getDef();
        }else if(this.tipo == Tipo.valueOf("Fire") || this.tipo == Tipo.valueOf("Water") || this.tipo == Tipo.valueOf("Electric")
                || this.tipo == Tipo.valueOf("Grass") || this.tipo == Tipo.valueOf("Ice") || this.tipo == Tipo.valueOf("Psychic")
                || this.tipo == Tipo.valueOf("Dragon")){
            A = (pokemonUsuario.getSpe() < 0) ? 0 : pokemonUsuario.getSpe();
            D = pokemonOponente.getSpe();
        }else if(calculoCritico(pokemonUsuario)){
            L *= 2;
        }else if(efeito() == Status.valueOf("BURN")){
            A = (A < 0) ? 0 : (A/2);
        }
        double dano = (L * A * P / D / 50) + 2;
        if(this.tipo == pokemonUsuario.getEspecie().getTipo1() || this.tipo == pokemonUsuario.getEspecie().getTipo2()){
            dano *= 1.5;
        }
        return dano;
    }
    
}
