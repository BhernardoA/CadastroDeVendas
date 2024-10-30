/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

/**
 *
 * @author admin
 */
import Classes.Cliente;
import java.util.ArrayList;
import java.util.List;

import Classes.Cliente;

public class ClienteControle {
    private final List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1; // Contador para o próximo ID de cliente

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

            Cliente novoCliente = new Cliente(proximoId++, nome, cpf, telefone, email);
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso! ID: " + novoCliente.getId());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar cadastrar o cliente.");
        }
    }

    // Método para editar um cliente
    public void editarCliente(Cliente clienteSelecionado, String novoNome, String novoTelefone, String novoEmail) {
        try {
            if (clienteSelecionado == null) {
                throw new IllegalArgumentException("Erro: Nenhum cliente foi selecionado para edição.");
            }

            if (novoNome != null && !novoNome.trim().isEmpty()) {
                clienteSelecionado.setNome(novoNome);
            }
            if (novoTelefone != null && !novoTelefone.trim().isEmpty()) {
                clienteSelecionado.setTelefone(novoTelefone);
            }
            if (novoEmail != null && !novoEmail.trim().isEmpty()) {
                clienteSelecionado.setEmail(novoEmail);
            }

            System.out.println("Cliente editado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar editar o cliente.");
        }
    }

    // Método para remover um cliente pelo ID
    public void removerClientePorId(int id) {
        try {
            Cliente clienteRemover = null;
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    clienteRemover = cliente;
                    break;
                }
            }

            if (clienteRemover == null) {
                throw new IllegalArgumentException("Erro: Nenhum cliente encontrado com o ID fornecido.");
            }

            clientes.remove(clienteRemover);
            System.out.println("Cliente removido com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar remover o cliente.");
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    // Método para pesquisar clientes pelo nome
    public List<Cliente> pesquisarClientesPorNome(String nomePesquisa) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        try {
            if (nomePesquisa == null || nomePesquisa.trim().isEmpty()) {
                return listarClientes();
            }

            for (Cliente cliente : clientes) {
                if (cliente.getNome().toLowerCase().contains(nomePesquisa.toLowerCase())) {
                    clientesEncontrados.add(cliente);
                }
            }

            if (clientesEncontrados.isEmpty()) {
                System.out.println("Nenhum cliente encontrado com o nome fornecido.");
            }

        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar pesquisar clientes pelo nome.");
        }
        return clientesEncontrados;
    }

    // Método para buscar cliente pelo ID
    public Cliente buscarClientePorId(int idCliente) {
        try {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == idCliente) {
                    return cliente;
                }
            }
            throw new IllegalArgumentException("Erro: Cliente não encontrado com o ID fornecido.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar buscar cliente por ID.");
        }
        return null;
    }

    public void removerCliente(int id) {
        removerClientePorId(id); // Chamando o método existente para remover o cliente
    }

    public void editarCliente(int id, String novoNome, String novoTelefone, String novoEmail) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            editarCliente(cliente, novoNome, novoTelefone, novoEmail);
        } else {
            System.out.println("Erro: Cliente não encontrado para edição.");
        }
    }

}

