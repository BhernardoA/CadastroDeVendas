/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controls;

/**
 *
 * @author marco
 */
public class PagamentoTransferencia {
    
    public PagamentoTransferencia(double valor) {
        super(valor);
    }

    @Override
    public String tipoPagamento() {
        return "Transferência";
    }

    
}
