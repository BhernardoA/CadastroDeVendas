package Controle;

import Classes.Cliente;
import DAO.ClienteDAO;
import java.util.List;

public class ClienteControle {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    // Método para cadastrar um cliente
    public void cadastrarCliente(String nome, String cpf, String telefone, String email) {
        try {
            if (cpf == null || cpf.trim().isEmpty()) {
                throw new IllegalArgumentException("Erro: O CPF é obrigatório.");
            }
            if ((telefone == null || telefone.trim().isEmpty()) && 
                (email == null || email.trim().isEmpty())) {
                throw new IllegalArgumentException("Erro: É necessário preencher pelo menos um dos campos: Telefone ou Email.");
            }

            Cliente novoCliente = new Cliente(0, nome, cpf, telefone, email); 
            clienteDAO.cadastrarCliente(novoCliente);
            System.out.println("Cliente cadastrado com sucesso! ID: " + novoCliente.getId());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar cadastrar o cliente: " + e.getMessage());
        }
    }

    // Método para editar um cliente
    public void editarCliente(int id, String novoNome, String novoTelefone, String novoEmail) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            if (novoNome != null && !novoNome.trim().isEmpty()) {
                cliente.setNome(novoNome);
            }
            if (novoTelefone != null && !novoTelefone.trim().isEmpty()) {
                cliente.setTelefone(novoTelefone);
            }
            if (novoEmail != null && !novoEmail.trim().isEmpty()) {
                cliente.setEmail(novoEmail);
            }
            clienteDAO.editarCliente(cliente);
            System.out.println("Cliente editado com sucesso!");
        } else {
            System.out.println("Erro: Cliente não encontrado para edição.");
        }
    }

    // Método para remover um cliente pelo ID
    public void removerClientePorId(int id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            clienteDAO.removerCliente(id);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Erro: Nenhum cliente encontrado com o ID fornecido.");
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }

    // Método para buscar cliente pelo ID
    public Cliente buscarClientePorId(int idCliente) {
        return clienteDAO.buscarClientePorId(idCliente);
    }

    // Método para pesquisar clientes pelo nome
    public List<Cliente> pesquisarClientesPorNome(String nomePesquisa) {
        if (nomePesquisa != null && !nomePesquisa.trim().isEmpty()) {
            return clienteDAO.buscarClientesPorNome(nomePesquisa);
        }
        return List.of(); // Retorna uma lista vazia se a pesquisa estiver vazia
    }
}
