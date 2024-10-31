package Controle;

import Classes.Cliente;
import Classes.Venda;
import DAO.VendaDAO; // Importa a classe VendaDAO
import Enums.Parcelas;
import Enums.TipoPagamento;
import Enums.Unidade;
import java.time.LocalDate;
import java.util.List;

public class VendaControle {
    private final VendaDAO vendaDAO; 
    private final ClienteControle clienteControle; 

    // Construtor que recebe o controle de clientes e o DAO de vendas
    public VendaControle(ClienteControle clienteControle, VendaDAO vendaDAO) {
        this.clienteControle = clienteControle;
        this.vendaDAO = vendaDAO;
    }

    // Método para cadastrar uma venda usando o ID do cliente para preencher as informações do mesmo automaticamente
    public void cadastrarVenda(int idCliente, String material, int quantidade, Unidade unidade, double preco, TipoPagamento pagamento, Integer parcelas, LocalDate dataVenda) {
        try {
            // Buscar cliente pelo ID
            Cliente cliente = clienteControle.buscarClientePorId(idCliente);
            if (cliente == null) {
                throw new IllegalArgumentException("Erro: Nenhum cliente encontrado com o ID fornecido.");
            }

            // Validar os outros dados da venda
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
                tipoParcelas = Parcelas.values()[parcelas - 1]; // Ajusta o índice conforme necessário
            } else if (pagamento == TipoPagamento.DINHEIRO || pagamento == TipoPagamento.TRANSFERENCIA) {
                if (parcelas != null) {
                    throw new IllegalArgumentException("Erro: Para pagamento em dinheiro ou transferência, não é necessário informar parcelas.");
                }
            }

            // Cadastrar a nova venda usando o DAO
            Venda novaVenda = new Venda(0, idCliente, dataVenda, material, quantidade, unidade, preco, pagamento, tipoParcelas);
            vendaDAO.cadastrarVenda(novaVenda); // Chama o método do DAO
            System.out.println("Venda cadastrada com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar cadastrar a venda.");
        }
    }

    // Método para remover uma venda
    public boolean removerVenda(int idVenda) {
        try {
            // Remove a venda usando o DAO
            vendaDAO.removerVenda(idVenda);
            System.out.println("Venda removida com sucesso!");
            return true;  // Retorna true se a venda foi removida

        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar remover a venda.");
            return false;  // Retorna false se ocorreu um erro
        }
    }

    // Método para listar todas as vendas
    public List<Venda> listarVendas() {
        return vendaDAO.listarVendas(); // Chama o método do DAO
    }

    // Método para filtrar vendas por nome do material
    public List<Venda> filtrarVendasPorMaterial(String material) {
        List<Venda> vendasFiltradas = vendaDAO.listarVendas(); // Pega todas as vendas do banco
        vendasFiltradas.removeIf(venda -> !venda.getMaterial().toLowerCase().contains(material.toLowerCase()));
        return vendasFiltradas;
    }

    // Método para filtrar vendas por ID do cliente
    public List<Venda> filtrarVendasPorIdCliente(int idCliente) {
        List<Venda> vendasFiltradas = vendaDAO.listarVendas(); // Pega todas as vendas do banco
        vendasFiltradas.removeIf(venda -> venda.getIdCliente() != idCliente);
        return vendasFiltradas;
    }

    // Método para verificar se um cliente existe pelo ID
    public boolean verificaCliente(int idCliente) {
        return clienteControle.buscarClientePorId(idCliente) != null;
    }

    // Método para filtrar vendas por data
    public List<Venda> filtrarVendasPorData(LocalDate dataFiltro) {
        List<Venda> vendasFiltradas = vendaDAO.listarVendas(); // Pega todas as vendas do banco
        vendasFiltradas.removeIf(venda -> !venda.getDataVenda().isEqual(dataFiltro));
        return vendasFiltradas;
    }
}
