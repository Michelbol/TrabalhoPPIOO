/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueCharge;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueFixo;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueHP;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueModifier;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueMultihit;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueStatus;
import br.uem.din.SimuladorBatalha.Jogador.Jogador;
import br.uem.din.SimuladorBatalha.Jogador.Time;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author miche
 */
public class Batalha {

    static final int PARAMETRO_JOGADOR = 0;
    static final int PARAMETRO_NUMERO_POKEMONS = 1;
    static final int PARAMETRO_ESPECIE_POKEMON = 2;
    static final int PARAMETRO_LEVEL_POKEMON = 3;
    static final int PARAMETRO_ATAQUE_1 = 4;
    static final int PARAMETRO_ATAQUE_2 = 5;
    static final int PARAMETRO_ATAQUE_3 = 6;
    static final int PARAMETRO_ATAQUE_4 = 7;
    private static final String FILENAME = "C:\\Tabelas.xlsx";
   
    public List carregarTabelas(int tabela) {
        //vai carregar as informações dos atributos e informações dos anexos
        List lista = new ArrayList();
        if (tabela == 0) {
            lista.add("Tabela de Especies");
            try {
                FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
                XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                XSSFSheet sheetSpecies = workbook.getSheetAt(tabela);
                Iterator<Row> rowIterator = sheetSpecies.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int id = 0;
                    String nome = "", tipo1 = "", tipo2 = "";
                    double baseHp = 0, baseAtk = 0, baseDef = 0, baseSpe = 0, baseSpd = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getColumnIndex()) {
                            case 0:
                                id = (int) cell.getNumericCellValue();
                                break;
                            case 1:
                                nome = cell.getStringCellValue();
                                break;
                            case 2:
                                tipo1 = cell.getStringCellValue();
                                break;
                            case 3:
                                tipo2 = cell.getStringCellValue();
                                break;
                            case 4:
                                baseHp = cell.getNumericCellValue();
                                break;
                            case 5:
                                baseAtk = cell.getNumericCellValue();
                                break;
                            case 6:
                                baseDef = cell.getNumericCellValue();
                                break;
                            case 7:
                                baseSpe = cell.getNumericCellValue();
                                break;
                            case 8:
                                baseSpd = cell.getNumericCellValue();
                                break;
                        }
                    }
                    Especie especie = new Especie(id, nome, tipo1, tipo2, baseHp, baseAtk, baseDef, baseSpe, baseSpd);
                    lista.add(especie);
                }
                arquivo.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (tabela == 1) {
            lista.add("Tabela de Ataques");
            try {
                FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
                XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                XSSFSheet sheetAtaques = workbook.getSheetAt(tabela);
                Iterator<Row> rowIterator = sheetAtaques.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int id = 0, power = 0, accuracy = 0, parametrosint = 0;
                    String nome = "", tipo = "", parametro = "", classe = "", parametros = "";
                    double ppAtual = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getColumnIndex()) {
                            case 0:
                                id = (int) cell.getNumericCellValue();
                                break;
                            case 1:
                                nome = cell.getStringCellValue();
                                break;
                            case 2:
                                tipo = cell.getStringCellValue();
                                break;
                            case 3:
                                ppAtual = cell.getNumericCellValue();
                                break;
                            case 4:
                                power = (int) cell.getNumericCellValue();
                                break;
                            case 5:
                                accuracy = (int) cell.getNumericCellValue();
                                break;
                            case 6:
                                classe = cell.getStringCellValue();
                                break;
                            case 7:
                                try{
                                   parametros = cell.getStringCellValue();
                                }catch(Exception e){
                                   parametrosint = (int) cell.getNumericCellValue();
                                }
                                if (classe.equals("comum")) {
                                    Ataque ataque = new Ataque(id, nome, tipo, ppAtual, ppAtual, power, accuracy);
                                    lista.add(ataque);
                                } else if (classe.equals("charge")) {
                                    AtaqueCharge ataqueCharge = new AtaqueCharge(id, nome, tipo, ppAtual, ppAtual, power, accuracy);
                                    lista.add(ataqueCharge);
                                } else if (classe.equals("fixo")) {
                                    int val;
                                    if((parametrosint > 0) || (parametros.equals("lvl"))){
                                        val = parametrosint;
                                    }else{
                                         parametros = Parametro(parametros, 0);
                                        val = Integer.parseInt(parametros);
                                    }
                                    AtaqueFixo ataqueFixo = new AtaqueFixo(val, id, nome, tipo, ppAtual, ppAtual, power, accuracy);
                                    lista.add(ataqueFixo);
                                } else if (classe.equals("hp")) {
                                    String segundoParametro = Parametro(parametros, 1);
                                    double aux = Double.parseDouble(segundoParametro);
                                    aux = aux*100;
                                    int porcentagem = (int) aux;
                                    AtaqueHP ataqueHp = new AtaqueHP(0, porcentagem, id, nome, tipo, ppAtual, ppAtual, power, accuracy);
                                    lista.add(ataqueHp);
                                } else if (classe.equals("modifier")) {
                                    String mod = Parametro(parametros, 0), segundoParametro = Parametro(parametros, 1), terceiroParametro = Parametro(parametros, 2);
                                    int n = Integer.parseInt(segundoParametro), chance = Integer.parseInt(terceiroParametro);
                                    AtaqueModifier ataquemodifier = new AtaqueModifier(mod, n, chance, id, nome, tipo, ppAtual, ppAtual, power, accuracy);
                                    lista.add(ataquemodifier);
                                } else if (classe.equals("multihit")) {
                                    String primeiroParametro = Parametro(parametros, 0), segundoParametro = Parametro(parametros, 1);
                                    int min = Integer.parseInt(primeiroParametro), max = Integer.parseInt(segundoParametro);
                                    AtaqueMultihit ataqueMultihit = new AtaqueMultihit(min, max, id, nome, tipo, ppAtual, ppAtual, power, accuracy);
                                    lista.add(ataqueMultihit);
                                } else if (classe.equals("status")) {
                                    String status = Parametro(parametros, 0), segundoParametro = Parametro(parametros, 1);
                                    int chance = Integer.parseInt(segundoParametro);
                                    AtaqueStatus ataquestatus = new AtaqueStatus(status, chance, id, nome, tipo, ppAtual, ppAtual, power, accuracy);
                                    lista.add(ataquestatus);
                                }
                                break;
                        }
                    }
                }
                arquivo.close();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return lista;
    }

    public Jogador inicializarJogadores(String[] args, int decideJogador, List<Ataque> listaAtaques, List<Especie> listaEspecies) {
        //vai inicializar as informações dos jogadores
        Time time = null;
        Jogador jogador = new Jogador();
        Especie especie;
        Pokemon pokemon;
        Ataque ataque1 = null;
        Ataque ataque2 = null;
        Ataque ataque3 = null;
        Ataque ataque4 = null;
        if(decideJogador == 1){
            time = new Time();
            time.setNumeroPokemonsTime(Integer.parseInt(args[PARAMETRO_NUMERO_POKEMONS]));
            for (int i = 0; i < time.getNumeroPokemonsTime(); i++) {
                int level;
                int multiplicador = (i * 6);
                especie = listaEspecies.get(Integer.parseInt(args[PARAMETRO_ESPECIE_POKEMON+multiplicador]));
                level = Integer.parseInt(args[PARAMETRO_LEVEL_POKEMON + multiplicador]);
                if(Integer.parseInt(args[PARAMETRO_ATAQUE_1 + multiplicador]) == 0){
    //                System.out.println("Ataque1 não informado");
                }else{
                    ataque1 = listaAtaques.get(Integer.parseInt(args[PARAMETRO_ATAQUE_1 + multiplicador]));
                }
                if(Integer.parseInt(args[PARAMETRO_ATAQUE_2 + multiplicador]) == 0){
    //                System.out.println("Ataque2 não informado");
                }else{
                    ataque2 = listaAtaques.get(Integer.parseInt(args[PARAMETRO_ATAQUE_2 + multiplicador]));
                }   
                if(Integer.parseInt(args[PARAMETRO_ATAQUE_3 + multiplicador]) == 0){
    //                System.out.println("Ataque3 não informado");
                }else{
                    ataque3 = listaAtaques.get(Integer.parseInt(args[PARAMETRO_ATAQUE_3 + multiplicador]));
                }
                if(Integer.parseInt(args[PARAMETRO_ATAQUE_4 + multiplicador]) == 0){
    //                System.out.println("Ataque4 não informado");
                }else{
                   ataque4 = listaAtaques.get(Integer.parseInt(args[PARAMETRO_ATAQUE_4 + multiplicador])); 
                }
                pokemon = new Pokemon(level, especie, ataque1, ataque2, ataque3, ataque4);
                time.setPokemon(pokemon);
            }
        }else if(decideJogador == 2){
            time = new Time();
            int ultimaPosicaoPrimeiroJogador = 38;
           time.setNumeroPokemonsTime(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_NUMERO_POKEMONS]));
            for (int i = 0; i < time.getNumeroPokemonsTime(); i++) {
                int level;
                int multiplicador = (i * 6);
                especie = listaEspecies.get(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ESPECIE_POKEMON+multiplicador]));
                level = Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_LEVEL_POKEMON + multiplicador]);
                if(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_1 + multiplicador]) == 0){
    //                System.out.println("Ataque1 não informado");
                }else{
                    ataque1 = listaAtaques.get(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_1 + multiplicador]));
                }
                if(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_2 + multiplicador]) == 0){
    //                System.out.println("Ataque2 não informado");
                }else{
                    ataque2 = listaAtaques.get(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_2 + multiplicador]));
                }   
                if(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_3 + multiplicador]) == 0){
    //                System.out.println("Ataque3 não informado");
                }else{
                    ataque3 = listaAtaques.get(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_3 + multiplicador]));
                }
                if(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_4 + multiplicador]) == 0){
    //                System.out.println("Ataque4 não informado");
                }else{
                   ataque4 = listaAtaques.get(Integer.parseInt(args[ultimaPosicaoPrimeiroJogador+PARAMETRO_ATAQUE_4 + multiplicador])); 
                }
                pokemon = new Pokemon(level, especie, ataque1, ataque2, ataque3, ataque4);
                time.setPokemon(pokemon);
            } 
        }
        jogador.setTime(time);
//        System.out.println("Jogador: " + jogador);
        return jogador;
    }

    public void executarTurno() {
        //Verificar qual jogador vai jogar primeiro e executar a ação que ele definiu e depois executar a açao do próximo jogador  
    }

    public String Parametro(String parametro, int nroparametro) {
        String[] parametros = parametro.split(",");
        String primeiroParametro = parametros[nroparametro];
        primeiroParametro = primeiroParametro.replace(" ", "");
        return primeiroParametro;
    }
}
