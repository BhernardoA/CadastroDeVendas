/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author marco
 */
public class PagamentoDinheiro extends Pagamento {
    
       public PagamentoDinheiro(double valor) {
        super(valor);
    }

    @Override
    public String tipoPagamento() {
        return "Dinheiro";
    }

    
}
