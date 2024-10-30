/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author admin
 */
public class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro(double valor) {
        super(valor);
    }

    @Override
    public void realizarPagamento() {
        // Lógica para realizar pagamento em dinheiro
        System.out.println("Pagamento de " + valor + " realizado em dinheiro.");
    }
}