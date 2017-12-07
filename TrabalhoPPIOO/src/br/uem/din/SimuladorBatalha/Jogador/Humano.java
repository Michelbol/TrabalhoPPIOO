/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Jogador;

import br.uem.din.SimuladorBatalha.Controladores.View;

/**
 *
 * @author miche
 */
public class Humano extends Jogador {
    
    @Override
    public int escolherComando(int nroJogador){
        View view = new View();
        return view.viewEscolherComandos(nroJogador);
    }
}
