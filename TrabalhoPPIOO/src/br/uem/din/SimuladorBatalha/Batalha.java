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
import br.uem.din.SimuladorBatalha.Enum.Tipo;
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
    static int parametroJogador = 0;
    static int parametroNumeroPokemons = 1;
    static int parametroEspeciePokemon = 2;
    static int parametroLevelPokemon = 3;
    static int parametroAtaque1 = 4;
    static int parametroAtaque2 = 5;
    static int parametroAtaque3 = 6;
    static int parametroAtaque4 = 7;
    private static final String FILENAME = "C:\\Projetos\\Java\\TrabalhoPPIOO\\Tabelas.xlsx";
    
    public List carregarTabelas(int tabela){
        //vai carregar as informações dos atributos e informações dos anexos
        List lista = new ArrayList();
        if(tabela == 0){
            lista.add("Tabela de Especies");
            try{
                FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
                 XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                 XSSFSheet sheetSpecies = workbook.getSheetAt(tabela);
                 Iterator<Row> rowIterator = sheetSpecies.iterator();

                  while (rowIterator.hasNext()) {
                      Row row = rowIterator.next();
                      Iterator<Cell> cellIterator = row.cellIterator();
                      Especie especie = new Especie();
                      while(cellIterator.hasNext()){
                          Cell cell = cellIterator.next();
                          switch(cell.getColumnIndex()){
                              case 0:
                                  especie.setId((int) cell.getNumericCellValue());
                                  break;
                              case 1:
                                  especie.setNome(cell.getStringCellValue());
                                  break;
                              case 2:
                                  String stringTipo1 = cell.getStringCellValue();
                                    Tipo tipo1 = Tipo.valueOf(stringTipo1);
                                    especie.setTipo1(tipo1);
                                  break;
                              case 3:
                                  String stringTipo2 = cell.getStringCellValue();
                                  if(stringTipo2.equals("")){
                                      stringTipo2 = "None";
                                  }
                                    Tipo tipo2 = Tipo.valueOf(stringTipo2);
                                    especie.setTipo2(tipo2);
                                  break;
                              case 4:
                                  especie.setBaseHp(cell.getNumericCellValue());
                                  break;
                              case 5:
                                  especie.setBaseAtk(cell.getNumericCellValue());
                                  break;
                              case 6:
                                  especie.setBaseDef(cell.getNumericCellValue());
                                  break;
                              case 7:
                                  especie.setBaseSpe(cell.getNumericCellValue());
                                  break;
                              case 8:
                                  especie.setBaseSpd(cell.getNumericCellValue());
                                  break;
                          }
                      }
                      lista.add(especie);
                  }
                  arquivo.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else if(tabela == 1){
            lista.add("Tabela de Ataques");
            try{
                FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
                XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
                XSSFSheet sheetAtaques = workbook.getSheetAt(tabela);
                Iterator<Row> rowIterator = sheetAtaques.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Ataque ataque = new Ataque();
                        while(cellIterator.hasNext()){
                            Cell cell = cellIterator.next();
                            switch(cell.getColumnIndex()){
                                case 0:
                                    ataque.setId((int) cell.getNumericCellValue());
                                    break;
                                case 1:
                                    ataque.setNome(cell.getStringCellValue());
                                    break;
                                case 2:
                                    String stringTipo = cell.getStringCellValue();
                                    try{
                                      Tipo tipo = Tipo.valueOf(stringTipo);
                                      ataque.setTipo(tipo);
                                    }catch(Exception e){
                                        System.out.println(e.getMessage() + " " + "Valor da Tabela: " + stringTipo);
                                    }
                                    break;
                                case 3:
                                    ataque.setPpAtual(cell.getNumericCellValue());
                                    break;
                                case 4:
                                    ataque.setPower((int) cell.getNumericCellValue());
                                    break;
                                case 5:
                                    ataque.setAccuracy((int) cell.getNumericCellValue());
                                    break;
                                case 6:
                                    if(cell.getStringCellValue().equals("status")){
                                        AtaqueStatus ataquestatus = new AtaqueStatus();
                                        ataquestatus = ataquestatus.copiaAtaque(ataque);
                                        Cell parametro = cellIterator.next();
                                        ataquestatus.setStatus(Parametro(parametro.getStringCellValue(),0));
                                        ataquestatus.setChance(Integer.parseInt(Parametro(parametro.getStringCellValue(),1)));
                                        lista.add(ataquestatus);
                                        break;
                                    }else if(cell.getStringCellValue().equals("modifier")){
                                        AtaqueModifier ataquemodifier = new AtaqueModifier();
                                        ataquemodifier = ataquemodifier.copiaAtaque(ataque);
                                        Cell parametro = cellIterator.next();
                                        ataquemodifier.setMod(Parametro(parametro.getStringCellValue(),0));
                                        ataquemodifier.setN(Integer.parseInt(Parametro(parametro.getStringCellValue(),1)));
                                        ataquemodifier.setChance(Integer.parseInt(Parametro(parametro.getStringCellValue(),2)));
                                        lista.add(ataquemodifier);
                                        break;
                                    }else if(cell.getStringCellValue().equals("multihit")){
                                        AtaqueMultihit ataquemultihit = new AtaqueMultihit();
                                        ataquemultihit = ataquemultihit.copiaAtaque(ataque);
                                        Cell parametro = cellIterator.next();
                                        ataquemultihit.setMin(Integer.parseInt(Parametro(parametro.getStringCellValue(),0)));
                                        ataquemultihit.setMax(Integer.parseInt(Parametro(parametro.getStringCellValue(),1)));
                                        lista.add(ataquemultihit);
                                        break;
                                    }else if(cell.getStringCellValue().equals("hp")){
                                        AtaqueHP ataquehp = new AtaqueHP();
                                        ataquehp = ataquehp.copiaAtaque(ataque);
                                        Cell parametro = cellIterator.next();
                                        ataquehp.setPorcentagem((int) (Double.parseDouble(Parametro(parametro.getStringCellValue(),1))*100));
                                        lista.add(ataquehp);
                                        break;
                                    }else if(cell.getStringCellValue().equals("charge")){
                                        AtaqueCharge ataquecharge = new AtaqueCharge();
                                        ataquecharge = ataquecharge.copiaAtaque(ataque);
                                        lista.add(ataquecharge);
                                        break;
                                    }else if(cell.getStringCellValue().equals("fixo")){
                                        AtaqueFixo ataquefixo = new AtaqueFixo();
                                        ataquefixo = ataquefixo.copiaAtaque(ataque);
                                        Cell parametro = cellIterator.next();
                                        try{
                                            ataquefixo.setVal((int) parametro.getNumericCellValue());
                                        }catch(Exception e){
    //                                        System.out.println("Parametro é uma string id:" + ataquefixo.getId());
                                        }
                                        lista.add(ataquefixo);
                                        break;
                                    }else{
                                        lista.add(ataque);
                                        break;
                                    } 
                            }
                        }
                }
                arquivo.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return lista;
    }
    
    public Jogador inicializarJogadores(String[] args, List listaAtaques, List listaEspecies){
        //vai inicializar as informações dos jogadores
        Time time = new Time();
        Jogador jogador = new Jogador();
        Especie especie = new Especie();
        Pokemon pokemon = new Pokemon();
        time.setNumeroPokemonsTime(Integer.parseInt(args[1]));
        Ataque ataque = new Ataque();
        AtaqueCharge ataquecharge = new AtaqueCharge();
        AtaqueFixo ataquefixo = new AtaqueFixo();
        AtaqueHP ataquehp = new AtaqueHP();
        
        for(int i=0; i<time.getNumeroPokemonsTime(); i++){
            int multiplicador = (i*6);
            especie = (Especie) listaEspecies.get(Integer.parseInt(args[parametroEspeciePokemon+multiplicador]));
            pokemon.setLevel(Integer.parseInt(args[parametroLevelPokemon+multiplicador]));
            Object o = listaAtaques.get(Integer.parseInt(args[parametroAtaque1+multiplicador]));
            pokemon.setAtaque1(o);
            
            time.setPokemon(pokemon, time);
        }
//        System.out.println(listaEspecies);
        
        jogador.setTime(time);
        return jogador;
    }

    public void executarTurno(){
        //Verificar qual jogador vai jogar primeiro e executar a ação que ele definiu e depois executar a açao do próximo jogador  
    }
    
    public String Parametro(String parametro, int nroparametro){
        String[] parametros = parametro.split(",");
        String primeiroParametro = parametros[nroparametro];
        primeiroParametro = primeiroParametro.replace(" ", "");
        return primeiroParametro;
    }
}
