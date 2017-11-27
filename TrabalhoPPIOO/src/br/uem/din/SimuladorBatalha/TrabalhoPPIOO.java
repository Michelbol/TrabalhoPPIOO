/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;


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
        jogador1.getTime().getPokemon1().getAtaque1().calculoDano(jogador1.getTime().getPokemon1(), jogador2.getTime().getPokemon1(), matriz);
       
        int rodada=1;
        while(1==1){
             JOptionPane.showMessageDialog(null,"Rodada"+rodada);
            
            
            if(rodada%2==1){
                JOptionPane.showMessageDialog(null,"É a vez do jogador 1");
                jogando(jogador1);

            }
            else{
                JOptionPane.showMessageDialog(null,"É a vez do jogador 2");
                jogando(jogador2);

            }
           
            
            rodada++;
        }
    }

    private static void jogando(Jogador jogador) {
 String[] opcoes = {"Trocar Pokemon", "Atacar"};
        int escolhido = JOptionPane.showOptionDialog(null, "Escolha sua jogada", "Titulo da Janela",
        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
        if(escolhido==0){//o botão clicado a cima foi referente a troca de pokemon o JOPtion pane retorno o.
            //JOPTION PANES PARA TROCA DE POKEMON
            
          Pokemon PokemonEscolhido = (Pokemon) JOptionPane.showInputDialog(null, "Escolha um Pokemon que vai entrar no lugar do atual\nAtual Pokemon:"+jogador.getTime().getPokemon1().getEspecie().getNome(), "",
          JOptionPane.QUESTION_MESSAGE, null,/*vetor de opções*/ new Pokemon[] {
          jogador.getTime().getPokemon2(),
          jogador.getTime().getPokemon3(),
          jogador.getTime().getPokemon4(),
          jogador.getTime().getPokemon5(),
          jogador.getTime().getPokemon6()},
                       /*parametro que começa selecionado*/
          jogador.getTime().getPokemon1().getEspecie().getNome());
          if(PokemonEscolhido.getStatusPrimario()!= Status.FAINTED){
               jogador.trocaPokemon(PokemonEscolhido);
          }            
        }
        if(escolhido==1){//o botão clicado a  foi referente a atacar .
//____________________________________________________________________________________________
          //JOPTIONPANE PARA ATACAR
  Pokemon pokemonQataca = jogador.getTime().getPokemon1();//representa o pokemon q esta escolhido atualmente
// SEGUNDO:JOPTIONPANE COM OS ATAQUES DO PKEMON (PENSANDO EU Q O METODO USAR ATAQUE VAI RECEBER UMA STRING)
         try{
         String ataqueEscolhido = (String) JOptionPane.showInputDialog(null, "Escolha o ataque q "+pokemonQataca.getEspecie().getNome()+" vai usar", "",
          JOptionPane.QUESTION_MESSAGE, null,/*vetor de opções*/ new String[] {
          pokemonQataca.getAtaque1().getNome(),
          pokemonQataca.getAtaque2().getNome(),
          pokemonQataca.getAtaque3().getNome(),
          pokemonQataca.getAtaque4().getNome(),},
          /*parametro que começa selecionado*/
          pokemonQataca.getAtaque1().getNome());
         }catch(Exception e){
         System.out.print(e.getMessage());
         }  
        }    }
    
}
