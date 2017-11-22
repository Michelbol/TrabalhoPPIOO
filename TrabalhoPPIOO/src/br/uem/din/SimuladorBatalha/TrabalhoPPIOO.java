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
        Batalha batalha = new Batalha();
        listaAtaques.addAll(batalha.carregarTabelas(1));
        listaEspecies.addAll(batalha.carregarTabelas(0));
//        System.out.println(listaEspecies);
//        System.out.println(listaAtaques);
        jogador1 = batalha.inicializarJogadores(args, listaAtaques, listaEspecies);
//        jogador2 = batalha.inicializarJogadores(args, tabelas);        
    }
    
}
