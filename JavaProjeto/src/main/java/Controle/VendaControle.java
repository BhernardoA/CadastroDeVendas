package Controle;

import Classes.Cliente;
import Classes.Venda;
import DAO.VendaDAO;
import Enums.Parcelas;
import Enums.TipoPagamento;
import Enums.Unidade;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class VendaControle {
    private final VendaDAO vendaDAO; 
    private final ClienteControle clienteControle; 

    public VendaControle(ClienteControle clienteControle, VendaDAO vendaDAO) {
        this.clienteControle = clienteControle;
        this.vendaDAO = vendaDAO;
    }

    public void cadastrarVenda(int idCliente, String material, int quantidade, Unidade unidade, double preco, TipoPagamento pagamento, Integer parcelas, LocalDate dataVenda) {
        try {
            Cliente cliente = clienteControle.buscarClientePorId(idCliente);
            if (cliente == null) {
                throw new IllegalArgumentException("Erro: Nenhum cliente encontrado com o ID fornecido.");
            }

            if (material == null || material.trim().isEmpty()) {
                throw new IllegalArgumentException("Erro: O material é obrigatório.");
            }
            if (quantidade <= 0) {
                throw new IllegalArgumentException("Erro: A quantidade deve ser maior que zero.");
            }
            if (unidade == null) {
                throw new IllegalArgumentException("Erro: A unidade é obrigatória.");
            }
            if (preco < 0) {
                throw new IllegalArgumentException("Erro: O preço não pode ser negativo.");
            }

            Parcelas tipoParcelas = null; 

            if (pagamento == TipoPagamento.CARTAO) {
                if (parcelas == null || parcelas < 1 || parcelas > 12) {
                    throw new IllegalArgumentException("Erro: Para pagamento em cartão, o número de parcelas deve estar entre 1 e 12.");
                }
                tipoParcelas = Parcelas.values()[parcelas - 1]; 
            } else if (pagamento == TipoPagamento.DINHEIRO || pagamento == TipoPagamento.TRANSFERENCIA) {
                if (parcelas != null) {
                    throw new IllegalArgumentException("Erro: Para pagamento em dinheiro ou transferência, não é necessário informar parcelas.");
                }
            }

            Venda novaVenda = new Venda(0, idCliente, dataVenda, material, quantidade, unidade, preco, pagamento, tipoParcelas);
            vendaDAO.cadastrarVenda(novaVenda);
            System.out.println("Venda cadastrada com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean removerVenda(int idVenda) {
        try {
            vendaDAO.removerVenda(idVenda);
            System.out.println("Venda removida com sucesso!");
            return true;  

        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar remover a venda.");
            return false;  
        }
    }

    public List<Venda> listarVendas() {
        return vendaDAO.listarVendas(); 
    }

    public List<Venda> filtrarVendasPorMaterial(String material) {
        List<Venda> vendasFiltradas = vendaDAO.listarVendas(); 
        vendasFiltradas.removeIf(venda -> !venda.getMaterial().toLowerCase().contains(material.toLowerCase()));
        return vendasFiltradas;
    }

    public List<Venda> filtrarVendasPorIdCliente(int idCliente) {
        List<Venda> vendasFiltradas = vendaDAO.listarVendas(); 
        vendasFiltradas.removeIf(venda -> venda.getIdCliente() != idCliente);
        return vendasFiltradas;
    }

    public boolean verificaCliente(int idCliente) {
        return clienteControle.buscarClientePorId(idCliente) != null;
    }

    // Novo método para filtrar vendas por intervalo de datas
    public List<Venda> filtrarVendasPorData(LocalDate dataInicial, LocalDate dataFinal) {
        List<Venda> vendasFiltradas = vendaDAO.listarVendas(); 
        vendasFiltradas.removeIf(venda -> venda.getDataVenda().isBefore(dataInicial) || venda.getDataVenda().isAfter(dataFinal));
        return vendasFiltradas;
    }

    public String formatarParaReais(double valor) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formato.format(valor);
    }
}
