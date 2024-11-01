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
    public void cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO Venda (id_cliente, data_venda, quantidade, valor, unidade, tipo_pagamento, parcelas, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoSQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            stmt.setInt(1, venda.getIdCliente());
            stmt.setDate(2, Date.valueOf(venda.getDataVenda())); 
            stmt.setInt(3, venda.getQuantidade());
            stmt.setDouble(4, venda.getPreco());
            stmt.setString(5, venda.getUnidade().getValor()); 
            stmt.setString(6, venda.getPagamento().name()); 
            
            if (venda.getParcelas() != null) {
                stmt.setInt(7, venda.getParcelas().ordinal() + 1); 
            } else {
                stmt.setNull(7, Types.INTEGER); 
            }
            
            stmt.setString(8, venda.getMaterial());

            int affectedRows = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar venda: " + e.getMessage());
        }
    }

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
                                        Unidade.fromString(rs.getString("unidade")),
                                        rs.getDouble("valor"),
                                        TipoPagamento.fromString(rs.getString("tipo_pagamento")),
                                        rs.getInt("parcelas") > 0 ? Parcelas.values()[rs.getInt("parcelas") - 1] : null);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

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
