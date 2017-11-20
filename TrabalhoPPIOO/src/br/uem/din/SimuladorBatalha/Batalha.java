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
    private static final String FILENAME = "C:\\Projetos\\Java\\TrabalhoPPIOO\\Tabelas.xlsx";
    
    public List carregarTabelas(){
        //vai carregar as informações dos atributos e informações dos anexos
        List listaEspecies = new ArrayList<Especie>();
        try{
            FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
             XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
             XSSFSheet sheetSpecies = workbook.getSheetAt(0);
             Iterator<Row> rowIterator = sheetSpecies.iterator();
             
              while (rowIterator.hasNext()) {
                  Row row = rowIterator.next();
                  Iterator<Cell> cellIterator = row.cellIterator();
                  Especie especie = new Especie();
                  listaEspecies.add(especie);
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
                              try{
                                Tipo tipo1 = Tipo.valueOf(stringTipo1);
                                especie.setTipo1(tipo1);
                              }catch(Exception e){
                                  System.out.println("Erro Tipo1");
                                  System.out.println(e.getMessage() + " " + "Valor da Tabela: " + stringTipo1);
                              }
                              break;
                          case 3:
                              String stringTipo2 = cell.getStringCellValue();
                              if(stringTipo2.equals("")){
                                  stringTipo2 = "None";
                              }
                              try{
                                Tipo tipo2 = Tipo.valueOf(stringTipo2);
                                especie.setTipo2(tipo2);
                                }catch(Exception e){
                                    System.out.println("Erro Tipo2");
                                    System.out.println(e.getMessage() + " " + "Valor da Tabela: " + stringTipo2);
                              }
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
              }
              arquivo.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        List listaAtaques = new ArrayList();
        try{
            FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetAtaques = workbook.getSheetAt(1);
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
                                    ataquestatus.setStatus(primeiroParametro(parametro.getStringCellValue()));
                                    ataquestatus.setChance(Integer.parseInt(segundoParametro(parametro.getStringCellValue())));
                                    listaAtaques.add(ataquestatus);
                                    break;
                                }else if(cell.getStringCellValue().equals("modifier")){
                                    AtaqueModifier ataquemodifier = new AtaqueModifier();
                                    ataquemodifier = ataquemodifier.copiaAtaque(ataque);
                                    Cell parametro = cellIterator.next();
                                    ataquemodifier.setMod(primeiroParametro(parametro.getStringCellValue()));
                                    ataquemodifier.setN(Integer.parseInt(segundoParametro(parametro.getStringCellValue())));
                                    ataquemodifier.setChance(Integer.parseInt(terceiroParametro(parametro.getStringCellValue())));
                                    listaAtaques.add(ataquemodifier);
                                    break;
                                }else if(cell.getStringCellValue().equals("multihit")){
                                    AtaqueMultihit ataquemultihit = new AtaqueMultihit();
                                    ataquemultihit = ataquemultihit.copiaAtaque(ataque);
                                    Cell parametro = cellIterator.next();
                                    ataquemultihit.setMin(Integer.parseInt(primeiroParametro(parametro.getStringCellValue())));
                                    ataquemultihit.setMax(Integer.parseInt(segundoParametro(parametro.getStringCellValue())));
                                    listaAtaques.add(ataquemultihit);
                                    break;
                                }else if(cell.getStringCellValue().equals("hp")){
                                    AtaqueHP ataquehp = new AtaqueHP();
                                    ataquehp = ataquehp.copiaAtaque(ataque);
                                    Cell parametro = cellIterator.next();
                                    ataquehp.setPorcentagem((int) (Double.parseDouble(segundoParametro(parametro.getStringCellValue()))*100));
                                    listaAtaques.add(ataquehp);
                                    break;
                                }else if(cell.getStringCellValue().equals("charge")){
                                    AtaqueCharge ataquecharge = new AtaqueCharge();
                                    ataquecharge = ataquecharge.copiaAtaque(ataque);
                                    listaAtaques.add(ataquecharge);
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
                                    listaAtaques.add(ataquefixo);
                                    break;
                                }else{
                                    listaAtaques.add(ataque);
                                    break;
                                } 
                        }
                    }
            }
            arquivo.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        List tabelas = new ArrayList();
        tabelas.add(listaEspecies);
        tabelas.add(listaAtaques);
        return tabelas;
    }
    
    public Jogador inicializarJogadores(String[] args, List tabelas){
        //vai inicializar as informações dos jogadores
        List listaEspecies = new ArrayList();
        List listaAtaques = new ArrayList();
        listaEspecies = (List) tabelas.get(0);
        listaAtaques = (List) tabelas.get(1);
        Time time = new Time();
        Jogador jogador = new Jogador();
        Especie especie = new Especie();
        Pokemon pokemon = new Pokemon();
        time.setNumeroPokemonsTime(Integer.parseInt(args[0].substring(1, 2)));
        especie.setId(Integer.parseInt(args[0].substring(2, 5)));
//        System.out.println("A especie é a: " + especie.getId());
//        System.out.println("O indice da Especie eh: " + tabelas.contains(especie));
        System.out.println(listaEspecies);
        
        jogador.setTime(time);
        return jogador;
    }

    public void executarTurno(){
        //Verificar qual jogador vai jogar primeiro e executar a ação que ele definiu e depois executar a açao do próximo jogador  
    }
    
    public String primeiroParametro(String parametro){
        String[] parametros = parametro.split(",");
        String primeiroParametro = parametros[0];
        return primeiroParametro;
    }
    public String segundoParametro(String parametro){
        String[] parametros = parametro.split(",");
        String segundoParametro = parametros[1];
        segundoParametro = segundoParametro.replace(" ", "");
        return segundoParametro;
    }
    public String terceiroParametro(String parametro){
        String[] parametros = parametro.split(",");
        String terceiroParametro = parametros[2];
        terceiroParametro = terceiroParametro.replace(" ", "");
        return terceiroParametro;
    }
}
