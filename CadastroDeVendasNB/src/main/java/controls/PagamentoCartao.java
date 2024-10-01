/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controls;

/**
 *
 * @author marco
 */
public class PagamentoCartao {
    
    private int parcelas;

    public PagamentoCartao(double valor, int parcelas) {
        super(valor);
        this.parcelas = parcelas;
    }

    public int getParcelas() {
        return parcelas;
    }

    @Override
    public String tipoPagamento() {
        return "Cartão " + parcelas + "x";
    }

    
}
