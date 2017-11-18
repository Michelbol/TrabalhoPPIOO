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
                                    ataquestatus = (AtaqueStatus) ataque;
                                    listaAtaques.add(ataquestatus);
                                    break;
                                }else if(cell.getStringCellValue().equals("modifier")){
                                    AtaqueModifier ataquemodifier = new AtaqueModifier();
                                    ataquemodifier = (AtaqueModifier) ataque;
                                    listaAtaques.add(ataquemodifier);
                                    break;
                                }else if(cell.getStringCellValue().equals("multihit")){
                                    AtaqueMultihit ataquemultihit = new AtaqueMultihit();
                                    ataquemultihit = (AtaqueMultihit) ataque;
                                    listaAtaques.add(ataquemultihit);
                                    break;
                                }else if(cell.getStringCellValue().equals("hp")){
                                    AtaqueHP ataquehp = new AtaqueHP();
                                    ataquehp.copiaAtaque(ataque);
                                    Cell parametro = cellIterator.next();
                                    ataquehp.setValor(0);
                                    listaAtaques.add(ataquehp);
                                    break;
                                }else if(cell.getStringCellValue().equals("charge")){
                                    AtaqueCharge ataquecharge = new AtaqueCharge();
                                    ataquecharge = (AtaqueCharge) ataque;
                                    listaAtaques.add(ataquecharge);
                                    break;
                                }else if(cell.getStringCellValue().equals("fixo")){
                                    AtaqueFixo ataquefixo = new AtaqueFixo();
                                    ataquefixo = (AtaqueFixo) ataque;
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
    
    public void inicializarJogadores(){
        //vai inicializar as informações dos jogadores
    }

    public void executarTurno(){
        //Verificar qual jogador vai jogar primeiro e executar a ação que ele definiu e depois executar a açao do próximo jogador  
    }
    
    public String primeiroParametro(String parametro){
        int i = parametro.indexOf(",");
        String string = parametro.substring(0, i);
        return string;
    }
    public String segundoParametro(String parametro){
        pareiaqui
        //implementar
        
        return parametro;
    }
}
