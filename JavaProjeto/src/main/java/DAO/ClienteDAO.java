package DAO;

import Classes.Cliente;
import SQL.ConexaoSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // Método para cadastrar um cliente
    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    cliente.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // Método para buscar cliente por ID
    public Cliente buscarClientePorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(rs.getInt("id"),
                                   rs.getString("nome"),
                                   rs.getString("cpf"),
                                   rs.getString("telefone"),
                                   rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = ConexaoSQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"),
                                         rs.getString("nome"),
                                         rs.getString("cpf"),
                                         rs.getString("telefone"),
                                         rs.getString("email")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método para editar um cliente
    public void editarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, telefone = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para remover um cliente
    public void removerCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar clientes por nome
    public List<Cliente> buscarClientesPorNome(String nome) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente WHERE nome LIKE ?";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                 
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"),
                                         rs.getString("nome"),
                                         rs.getString("cpf"),
                                         rs.getString("telefone"),
                                         rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
