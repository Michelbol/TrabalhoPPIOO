/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import java.util.ArrayList;
import java.util.List;
import br.uem.din.SimuladorBatalha.Especie;

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
        Especie especie;
        List<Especie> tabelas = new ArrayList();
        Batalha batalha = new Batalha();
        tabelas = batalha.carregarTabelas();
        System.out.println(tabelas.toString());
    }
    
}
