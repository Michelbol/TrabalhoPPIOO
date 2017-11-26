/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueCharge;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueFixo;
import br.uem.din.SimuladorBatalha.Jogador.Jogador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author miche
 */
public class TrabalhoPPIOO {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        List listaAtaques = new ArrayList();
        List listaEspecies = new ArrayList();
        List listaMultAtk = new ArrayList();
        Batalha batalha = new Batalha();
        listaEspecies.addAll(batalha.carregarTabelas(0));
        listaAtaques.addAll(batalha.carregarTabelas(1));
//        System.out.println(listaAtaques);
        listaMultAtk.addAll(batalha.carregarTabelas(4));
        double matriz[][] = batalha.formatArray(listaMultAtk);
        jogador1 = batalha.inicializarJogadores(args, 1, listaAtaques, listaEspecies);
        jogador2 = batalha.inicializarJogadores(args, 2, listaAtaques, listaEspecies);
        jogador1.getTime().getPokemon1().getAtaque1().calculoDano(jogador1.getTime().getPokemon1(), jogador2.getTime().getPokemon1(), matriz);
//        JOptionPane.showMessageDialog(null, jogador1.getTime().getPokemon1());
//        JOptionPane.showMessageDialog(null, jogador2.getTime().getPokemon1());
    }
    
}
