/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.SimuladorBatalha.Enum;

/**
 *
 * @author miche
 */
public enum Tipo {
    None(0),Normal(1), Fighting(2), Flying(3), Poison(4), Ground(5), Rock(6), Bug(7), Ghost(8),  Fire(9), Water(10),
     Grass(11), Electric(12), Psychic(13), Ice(14), Dragon(15);
    public int nroEnum;
    Tipo(int nro){
        nroEnum = nro;
    }
}
