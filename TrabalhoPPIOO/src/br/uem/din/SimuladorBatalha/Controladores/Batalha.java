/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Controladores;

import br.uem.din.SimuladorBatalha.Ataques.Ataque;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueCharge;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueFixo;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueHP;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueModifier;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueMultihit;
import br.uem.din.SimuladorBatalha.Ataques.AtaqueStatus;
import br.uem.din.SimuladorBatalha.Enum.Status;
import br.uem.din.SimuladorBatalha.pokemon.Especie;
import br.uem.din.SimuladorBatalha.Jogador.Jogador;
import br.uem.din.SimuladorBatalha.Jogador.Time;
import br.uem.din.SimuladorBatalha.pokemon.Pokemon;
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
        switch (tabela) {
            case 0/*Caso a tabela selecionada tenha sido especies*/:
                lista.add("Tabela de Especies");
                try {
                    FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
                    XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                    XSSFSheet sheetSpecies = workbook.getSheetAt(tabela);
                    Iterator<Row> rowIterator = sheetSpecies.iterator();
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        if(row.getRowNum() == 0){
                            continue;
                        }
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
                }   break;
            case 1/*Caso a tabela selecionada tenha sido ataques*/:
                lista.add("Tabela de Ataques");
                try {
                    FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
                    XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                    XSSFSheet sheetAtaques = workbook.getSheetAt(tabela);
                    Iterator<Row> rowIterator = sheetAtaques.iterator();
                    
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        if(row.getRowNum() == 0){
                            continue;
                        }
                        Iterator<Cell> cellIterator = row.cellIterator();
                        int id = 0, power = 0, accuracy = 0, parametrosint = 0;
                        String nome = "", tipo = "", classe = "", parametros = "";
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
                                        String primeiroParametro = Parametro(parametros, 0);
                                        String segundoParametro = Parametro(parametros, 1);
                                        double aux = Double.parseDouble(segundoParametro);
                                        aux = aux*100;
                                        int porcentagem = (int) aux;
                                        AtaqueHP ataqueHp = new AtaqueHP(primeiroParametro, porcentagem, id, nome, tipo, ppAtual, ppAtual, power, accuracy);
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
                }   break;
            case 4/*Caso a tabela selecionada tenha sido type Chart*/:
                try {
                    FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
                    XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                    XSSFSheet sheetAtaques = workbook.getSheetAt(tabela);
                    Iterator<Row> rowIterator = sheetAtaques.iterator();
                    
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        if(row.getRowNum() == 0 || row.getRowNum() == 1){
                            continue;
                        }
                        Iterator<Cell> cellIterator = row.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            switch (cell.getColumnIndex()) {
                                case 0:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        
                                    }
                                    break;
                                case 1:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        
                                    }
                                    break;
                                case 2:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("1×")){
                                            lista.add(1.0);
                                        }
                                    }
                                    break;
                                case 3:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 4:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 5:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 6:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 7:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 8:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 9:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 10:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 11:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 12:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 13:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 14:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 15:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                                case 16:
                                    try{
                                        lista.add(cell.getNumericCellValue());
                                    }catch(Exception e){
                                        if(cell.getStringCellValue().equals("0.5")){
                                            lista.add(0.5);
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }   break;
            default:
                break;
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

    public int executarTurno(Jogador jogador1, Jogador jogador2, double matriz[][]) {
        //Verificar qual jogador vai jogar primeiro e executar a ação que ele definiu e depois executar a açao do próximo jogador  
        double dano = 0;
        //==========================inicio jogador1=====================================================================================
        Ataque ataqueEscolhido1 = null;
        View view = new View();
        int escolhaJogador1 = jogador1.escolherComando(1);
        if(escolhaJogador1==0){//o botão clicado a cima foi referente a troca de pokemon o JOPtion pane retorno o.
          jogador1.trocaPokemon();
        }else if(escolhaJogador1==1){//o botão clicado a  foi referente a atacar . 
          int cont = 0;  
            while(ataqueEscolhido1 == null){
                if(cont >0){
                    view.mensagemGenerica("Selecione um ataque válido");
                }
            ataqueEscolhido1 = view.escolheAtaque(jogador1.getTime().getPokemon1(), jogador2.getTime().getPokemon1().getEspecie().getNome());
            cont =1;
          }
        }
        if(escolhaJogador1 == -1){
            return escolhaJogador1;
        }
        //============================inicio jogador 2=====================================================================================
        Ataque ataqueEscolhido2 = null;
        int escolhaJogador2 = jogador2.escolherComando(2);
        if(escolhaJogador2==0){//o botão clicado a cima foi referente a troca de pokemon o JOPtion pane retorno o.
            //JOPTION PANES PARA TROCA DE POKEMON
               jogador2.trocaPokemon();
        }else if(escolhaJogador2==1){//o botão clicado a  foi referente a atacar . 
            int cont = 0;  
            while(ataqueEscolhido2 == null){
                if(cont >0){
                    view.mensagemGenerica("Selecione um ataque válido");
                }
            ataqueEscolhido2 = view.escolheAtaque(jogador2.getTime().getPokemon1(), jogador1.getTime().getPokemon1().getEspecie().getNome());
            cont =1;
          }
        }else if(escolhaJogador2 == -1){
            return escolhaJogador2;
        }
        //===================inicio ataques================================================================================================
             //verificar quem deve atacar primeiro//
        if(escolhaJogador1 == 0 && escolhaJogador2 == 1){
            //jogador1 vai trocar de pokemon --- jogador 2 vai atacar
            dano = ataqueEscolhido2.efeito(jogador2.getTime().getPokemon1(), jogador1.getTime().getPokemon1(), matriz);
            view.mensagemDano(jogador2, jogador1, dano);
        }else if(escolhaJogador2 == 0 && escolhaJogador1 == 1){
            //jogador2 vai trocar de pokemon -- jogador 1 vai atacar
            dano = ataqueEscolhido1.efeito(jogador1.getTime().getPokemon1(), jogador2.getTime().getPokemon1(), matriz);
            view.mensagemDano(jogador1, jogador2, dano);
        }else if(escolhaJogador1 == 1 
                && escolhaJogador2 == 1 
                && jogador1.getTime().getPokemon1().valorAtributoSpd() > jogador2.getTime().getPokemon1().valorAtributoSpd()){
            //os dois vão atacar, mas o pokemon do jogador 1 é mais rápido que o do jogador 2
            dano = ataqueEscolhido1.efeito(jogador1.getTime().getPokemon1(), jogador2.getTime().getPokemon1(), matriz);
            view.mensagemDano(jogador1, jogador2, dano);
            if(jogador2.getTime().getPokemon1().getStatusPrimario().equals(Status.Fainted)) {
                //o pokemon do jogador 2 está fainted
                view.mensagemPokemonStatus(Status.Fainted, 2);
                if(jogador1.getTime().verificaTime() == true && jogador2.getTime().verificaTime() == true){
                    jogador2.trocaFainted();
                }else{
                    return 1;
                }             
            }else{
                //o pokemon 2 está atacando o pokemon do jogador 1
                dano = ataqueEscolhido2.efeito(jogador2.getTime().getPokemon1(), jogador1.getTime().getPokemon1(), matriz);
                view.mensagemDano(jogador2, jogador1, dano);
            }
        }else if(escolhaJogador1 == 1 
                && escolhaJogador2 == 1 
                &&jogador2.getTime().getPokemon1().valorAtributoSpd() > jogador1.getTime().getPokemon1().valorAtributoSpd()){
            //os dois jogadores vão atacar mas o pokemon do jogador 2 é mais rápido que o pokemon do jogador1 
            dano = ataqueEscolhido2.efeito(jogador2.getTime().getPokemon1(), jogador1.getTime().getPokemon1(), matriz);
            view.mensagemDano(jogador2, jogador1, dano);
             //verificar se o pokemon do jogador 1 está morto e não deixar ele atacar.
            if(jogador1.getTime().getPokemon1().getStatusPrimario().equals(Status.Fainted)) {
                 view.mensagemPokemonStatus(Status.Fainted, escolhaJogador1);
                jogador1.trocaFainted();
            }else{
                dano = ataqueEscolhido1.efeito(jogador1.getTime().getPokemon1(), jogador2.getTime().getPokemon1(), matriz);
                view.mensagemDano(jogador1, jogador2, dano);
            }
        }
        if(jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Burn){
            jogador1.getTime().getPokemon1().setHpAtual(jogador1.getTime().getPokemon1().getHpAtual() - (jogador1.getTime().getPokemon1().getHpMax()*0.0625)); 
            view.mensagemGenerica("O pokemon  do jogador 1 receu dano de burn!");
        }
        if(jogador2.getTime().getPokemon1().getStatusPrimario() == Status.Burn){
            jogador2.getTime().getPokemon1().setHpAtual(jogador2.getTime().getPokemon1().getHpAtual() - (jogador2.getTime().getPokemon1().getHpMax()*0.0625)); 
            view.mensagemGenerica("O pokemon do jogador 2 receu dano de burn!");
        }
        if(jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Frozen 
                || jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Paralysis 
                || jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Sleep 
                || jogador1.getTime().getPokemon1().isConfusion() == true){
            double rand = Math.random()*100;
            double curado = (jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Frozen 
                    || jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Paralysis) ? 10 : 20;
            if(curado > rand){
                jogador1.getTime().getPokemon1().setConfusion(false);
               jogador1.getTime().getPokemon1().setStatusPrimario(Status.OK);
               view.mensagemGenerica("O pokemon do jogador 1 está OK!");
            }
        }
        if(jogador2.getTime().getPokemon1().getStatusPrimario() == Status.Frozen 
                || jogador2.getTime().getPokemon1().getStatusPrimario() == Status.Paralysis 
                || jogador2.getTime().getPokemon1().getStatusPrimario() == Status.Sleep 
                || jogador2.getTime().getPokemon1().isConfusion() == true){
            double rand = Math.random()*100, curado = (jogador2.getTime().getPokemon1().getStatusPrimario() == Status.Frozen 
                    || jogador2.getTime().getPokemon1().getStatusPrimario() == Status.Paralysis) ? 10 : 20;
            if(curado > rand){
               jogador2.getTime().getPokemon1().setConfusion(false);
               jogador2.getTime().getPokemon1().setStatusPrimario(Status.OK);
               view.mensagemGenerica("O pokemon do jogador 2 está OK");
            }
        }
        if(jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Poison){
            jogador1.getTime().getPokemon1().setHpAtual(jogador1.getTime().getPokemon1().getHpAtual() - (jogador1.getTime().getPokemon1().getHpMax()*0.0625)); 
            view.mensagemGenerica("O pokemon  do jogador 1 receu dano de Poison!");
        }
        if(jogador2.getTime().getPokemon1().getStatusPrimario() == Status.Poison){
            jogador2.getTime().getPokemon1().setHpAtual(jogador2.getTime().getPokemon1().getHpAtual() - (jogador2.getTime().getPokemon1().getHpMax()*0.0625)); 
            view.mensagemGenerica("O pokemon do jogador 2 receu dano de Poison!");
        }
        if(jogador1.getTime().getPokemon1().getStatusPrimario() == Status.Fainted){
            jogador1.trocaFainted();
        }
        
//            jogador2.usarAtaque(jogador2.getTime().getPokemon1(), pokemonOponente.getTime().getPokemon1(),
//                      matriz,ataqueEscolhido);
        return 1;
    }

    public String Parametro(String parametro, int nroparametro) {
        String[] parametros = parametro.split(",");
        String primeiroParametro = parametros[nroparametro];
        primeiroParametro = primeiroParametro.replace(" ", "");
        return primeiroParametro;
    }
    
    public double[][] formatArray(List listaMultAtk){
        double matriz[][] = new double[15][15];
        int cont = 0;
            for(int linha = 0; linha<15; linha++){
                for(int coluna = 0; coluna<15; coluna++){
                    matriz[linha][coluna] =  (double) listaMultAtk.get((cont));
                    cont++;
                }
            }
//            System.out.println("Matriz:[");
//            for(int linha = 0; linha<15; linha++){
//                for(int coluna = 0; coluna<15; coluna++){
//                    System.out.print(" " + matriz[linha][coluna]);
//                }
//                System.out.println("");
//            }
//            System.out.println("]");
        return matriz;
    }
    
    
}
