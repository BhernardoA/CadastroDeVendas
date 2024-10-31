package DAO;

import Classes.Venda;
import Enums.Parcelas;
import Enums.TipoPagamento;
import Enums.Unidade;
import SQL.ConexaoSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    // Método para cadastrar uma venda
    public void cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO Venda (id_cliente, data_venda, quantidade, valor, unidade, tipo_pagamento, parcelas, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            stmt.setInt(1, venda.getIdCliente());
            stmt.setDate(2, Date.valueOf(venda.getDataVenda())); // Converte LocalDate para Date
            stmt.setInt(3, venda.getQuantidade());
            stmt.setDouble(4, venda.getPreco());
            stmt.setString(5, venda.getUnidade().getValor()); 
            stmt.setString(6, venda.getPagamento().name()); 
            stmt.setInt(7, venda.getParcelas() != null ? venda.getParcelas().ordinal() + 1 : null); // Converte enum para int
            stmt.setString(8, venda.getMaterial());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                  
                    
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar venda: " + e.getMessage());
        }
    }

    // Método para buscar uma venda pelo ID
    public Venda buscarVendaPorId(int id) {
        String sql = "SELECT * FROM Venda WHERE id = ?";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Venda(rs.getInt("id"),
                                 rs.getInt("id_cliente"),
                                 rs.getDate("data_venda").toLocalDate(), // Converte Date para LocalDate
                                 rs.getString("material"),
                                 rs.getInt("quantidade"),
                                 Unidade.fromString(rs.getString("unidade")), // Usando fromString
                                 rs.getDouble("valor"),
                                 TipoPagamento.fromString(rs.getString("tipo_pagamento")), // Usando fromString
                                 rs.getInt("parcelas") > 0 ? Parcelas.values()[rs.getInt("parcelas") - 1] : null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para listar todas as vendas
    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM Venda";
        try (Connection conn = ConexaoSQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Venda venda = new Venda(rs.getInt("id"),
                                        rs.getInt("id_cliente"),
                                        rs.getDate("data_venda").toLocalDate(),
                                        rs.getString("material"),
                                        rs.getInt("quantidade"),
                                        Unidade.fromString(rs.getString("unidade")), // Usando fromString
                                        rs.getDouble("valor"),
                                        TipoPagamento.fromString(rs.getString("tipo_pagamento")), // Usando fromString
                                        rs.getInt("parcelas") > 0 ? Parcelas.values()[rs.getInt("parcelas") - 1] : null);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    // Método para atualizar uma venda
    public void editarVenda(Venda venda) {
        String sql = "UPDATE Venda SET id_cliente = ?, data_venda = ?, quantidade = ?, valor = ?, unidade = ?, tipo_pagamento = ?, parcelas = ?, material = ? WHERE id = ?";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, venda.getIdCliente());
            stmt.setDate(2, Date.valueOf(venda.getDataVenda()));
            stmt.setInt(3, venda.getQuantidade());
            stmt.setDouble(4, venda.getPreco());
            stmt.setString(5, venda.getUnidade().getValor()); 
            stmt.setString(6, venda.getPagamento().name());
            stmt.setInt(7, venda.getParcelas() != null ? venda.getParcelas().ordinal() + 1 : null);
            stmt.setString(8, venda.getMaterial());
            stmt.setInt(9, venda.getId()); 

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para remover uma venda
    public void removerVenda(int id) {
        String sql = "DELETE FROM Venda WHERE id = ?";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
