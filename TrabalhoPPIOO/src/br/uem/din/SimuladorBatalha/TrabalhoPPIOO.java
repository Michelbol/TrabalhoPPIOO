/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;

import br.uem.din.SimuladorBatalha.Jogador.Jogador;
import java.util.ArrayList;
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
        List tabelas = new ArrayList();
        Batalha batalha = new Batalha();
        tabelas = batalha.carregarTabelas();
        System.out.println(tabelas);
//        jogador1 = batalha.inicializarJogadores(args, tabelas);
//        jogador2 = batalha.inicializarJogadores(args, tabelas);
    }
    
}
