/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha;

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
        List<Especie> listaEspecies = new ArrayList<Especie>();
        try{
            FileInputStream arquivo = new FileInputStream(new File(Batalha.FILENAME));
             XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
             XSSFSheet sheetAlunos = workbook.getSheetAt(0);
             Iterator<Row> rowIterator = sheetAlunos.iterator();
             
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
        return listaEspecies;
    }

    public void inicializarJogadores(){
        //vai inicializar as informações dos jogadores
    }

    public void executarTurno(){
        //Verificar qual jogador vai jogar primeiro e executar a ação que ele definiu e depois executar a açao do próximo jogador  
    }
}
