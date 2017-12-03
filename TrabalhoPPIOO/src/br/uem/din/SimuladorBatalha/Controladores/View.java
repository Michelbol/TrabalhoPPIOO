/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Controladores;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.Jogador.Jogador;
import br.uem.din.SimuladorBatalha.pokemon.Pokemon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author miche
 */
public class View {
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
            if(jogador1.getTime().getPokemon1().getStatusPrimario().equals(Status.Fainted)){
                JOptionPane.showMessageDialog(null, "Atenção Jogador1 !!!\nSeu pokemon precisa de cuidados escolha outro para subistitui-lo");
                jogador1.trocaPokemon();
            }
            if(jogador2.getTime().getPokemon1().getStatusPrimario().equals(Status.Fainted)){
               JOptionPane.showMessageDialog(null, "Atenção Jogador2!!!\nSeu pokemon precisa de cuidados escolha outro para subistitui-lo");
               jogador2.trocaPokemon(); 
            }
            View view = new View();
            view.mensagemInicioBatalha(rodada, jogador1, jogador2);
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
    
    public void mensagemInicioBatalha(int rodada, Jogador jogador1, Jogador jogador2){
        JOptionPane.showMessageDialog(null, "Rodada " + rodada 
            + "\nPokemons da Batalha: "
            + "\nStatus do pokemon do jogador1 antes da batalha:\n"
            +"========================================================\n"
            + "Nome:"+ jogador1.getTime().getPokemon1().getEspecie().getNome()
            + " | Level: " + jogador1.getTime().getPokemon1().getLevel() + "\n"
            + "HP Maximo: " + jogador1.getTime().getPokemon1().getHpMax()+"\n"
            + "HP Atual: " + jogador1.getTime().getPokemon1().getHpAtual()+"\n"
            + "Status Primario: '" + jogador1.getTime().getPokemon1().getStatusPrimario() 
            + "' Está Confuso: " + jogador1.getTime().getPokemon1().isConfusion()
            + " Está Flich: " + jogador1.getTime().getPokemon1().isFlinch()
            +"\n========================================================"
            + "\nStatus do pokemon do jogador2 antes da batalha:\n"
            + "Nome:"+ jogador2.getTime().getPokemon1().getEspecie().getNome()
            + " | Level: " + jogador2.getTime().getPokemon1().getLevel() + "\n"
            + "HP Maximo:"+jogador2.getTime().getPokemon1().getHpMax()+"\n"
            + "HP Atual:"+jogador2.getTime().getPokemon1().getHpAtual()+"\n"
            + "Status Primario: '" + jogador2.getTime().getPokemon1().getStatusPrimario() 
            + "' Está Confuso: " + jogador2.getTime().getPokemon1().isConfusion()
            + " Está Flich: " + jogador2.getTime().getPokemon1().isFlinch());
    }
    
    public Pokemon trocaPokemon(Jogador jogador){
        Pokemon pokemon = (Pokemon) JOptionPane.showInputDialog(null, "Escolha um Pokemon que vai entrar no lugar do"
                  + " atual\nAtual Pokemon:"+jogador.getTime().getPokemon1().getEspecie().getNome(), ""
                  ,JOptionPane.QUESTION_MESSAGE, null,/*vetor de opções*/ new Pokemon[] {
                        jogador.getTime().getPokemon2(),
                        jogador.getTime().getPokemon3(),
                        jogador.getTime().getPokemon4(),
                        jogador.getTime().getPokemon5(),
                        jogador.getTime().getPokemon6(),
                  },jogador.getTime().getPokemon1().getEspecie().getNome());
        return pokemon;
    }
    public int viewEscolherComandos(int nroJogador){
        String[] opcoes = {"Trocar Pokemon", "Atacar"};
        int escolhaJogador = JOptionPane.showOptionDialog(null, "É a vez do jogador " + nroJogador 
                +" escolhar sua jogada", "Opções de Batalha",JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
        return escolhaJogador;
    }
    
        public Ataque escolheAtaque(Pokemon pokemonAtacante, String nomePokemonDefensor){
        return (Ataque) JOptionPane.showInputDialog(null, "Escolha o ataque que "
                  + pokemonAtacante.getEspecie().getNome()+" vai usar para atacar o "
                  + nomePokemonDefensor, "",
                    JOptionPane.QUESTION_MESSAGE, null,/*vetor de opções*/ new Ataque[] {
                    pokemonAtacante.getAtaque1(),
                    pokemonAtacante.getAtaque2(),
                    pokemonAtacante.getAtaque3(),
                    pokemonAtacante.getAtaque4()},
                    pokemonAtacante.getAtaque1().getNome()
                );
    }
}
