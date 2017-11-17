/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;

import java.io.File;
 
import jxl.Sheet;
 
import jxl.Workbook;
/**
 *
 * @author miche
 */
public class Batalha {
    private Workbook planilha; // objeto que receberá um instancia da planilha estudada
    private Sheet aba; // objeto que será a aba
    private File arquivo; // arquivo .xls que será lido
    
    public void ExemploJXL() {

        try {
            arquivo = new File("arq.xls");
            // instancia a planilha
            planilha = Workbook.getWorkbook(arquivo);
            //Obendo as Abas da planilha
            Sheet[] abas = planilha.getSheets();
            //loop para o vetor de abas
            for (Sheet a : abas) {
            System.out.println(a.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
    
    
    public void carregarTabelas(){
        //vai carregar as informações dos atributos e informações dos anexos
    }

    public void inicializarJogadores(){
        //vai inicializar as informações dos jogadores
    }

    public void executarTurno(){
        //Verificar qual jogador vai jogar primeiro e executar a ação que ele definiu e depois executar a açao do próximo jogador  
    }
}
