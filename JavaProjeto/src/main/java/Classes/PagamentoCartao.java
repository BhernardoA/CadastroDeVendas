/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author admin
 */
public class PagamentoCartao extends Pagamento {
    private final int parcelas;

    public PagamentoCartao(double valor, int parcelas) {
        super(valor);
        this.parcelas = parcelas;
    }

    public int getParcelas() {
        return parcelas;
    }

    @Override
    public void realizarPagamento() {
        // Lógica para realizar pagamento com cartão
        System.out.println("Pagamento de " + valor + " realizado em " + parcelas + " parcelas no cartão.");
    }
}