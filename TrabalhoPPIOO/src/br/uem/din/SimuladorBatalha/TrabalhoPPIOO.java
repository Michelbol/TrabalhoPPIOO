/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;


import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.Jogador.Jogador;
import java.util.ArrayList;
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
        Jogador jogador1;
        Jogador jogador2;
        List listaAtaques = new ArrayList();
        List listaEspecies = new ArrayList();
        List listaMultAtk = new ArrayList();
        Batalha batalha = new Batalha();
        listaEspecies.addAll(batalha.carregarTabelas(0));
        listaAtaques.addAll(batalha.carregarTabelas(1));
        listaMultAtk.addAll(batalha.carregarTabelas(4));
        double matriz[][] = batalha.formatArray(listaMultAtk);
        jogador1 = batalha.inicializarJogadores(args, 1, listaAtaques, listaEspecies);
        jogador2 = batalha.inicializarJogadores(args, 2, listaAtaques, listaEspecies);
        int sair = 0;
        int rodada=1;
        while(jogador1.getTime().verificaTime() == true && jogador2.getTime().verificaTime() == true){
            if(jogador1.getTime().getPokemon1().getStatusPrimario().equals(Status.FAINTED)){
                JOptionPane.showMessageDialog(null, "Atenção Jogador1 !!!\nSeu pokemon precisa de cuidados escolha outro para subistitui-lo");
                jogador1.trocaPokemon();
            }
            if(jogador2.getTime().getPokemon1().getStatusPrimario().equals(Status.FAINTED)){
               JOptionPane.showMessageDialog(null, "Atenção Jogador2!!!\nSeu pokemon precisa de cuidados escolha outro para subistitui-lo");
               jogador2.trocaPokemon(); 
            }
            batalha.mensagemInicioBatalha(rodada, jogador1, jogador2);
            //iniciando batalha
            sair = batalha.executarTurno(jogador1,jogador2,matriz);
            //terminou batalha
            rodada++;
            if(jogador1.getTime().verificaTime() == false){
                JOptionPane.showMessageDialog(null, "O Jogador 1 Perdeu!!!!!");
            }else if(jogador2.getTime().verificaTime() == false){
                JOptionPane.showMessageDialog(null, "O Jogador 2 Perdeu!!!!!");
            }
            if(sair == -1){
                JOptionPane.showMessageDialog(null, "Saindo do sistema");
                break;
            }
        }
    }    
}
