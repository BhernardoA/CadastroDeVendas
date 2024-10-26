/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrodevendasnb;

/**
 *
 * @author marco
 */

import SQL.ConexaoSQL;
import entities.Cliente;
import javax.swing.SwingUtilities;
import screens.Home;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 

public class CadastroDeVendasNB {
    public static void main(String[] args) {
        
        Connection connection = ConexaoSQL.getConnection();
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Home telaPrincipal = new Home();
                telaPrincipal.setVisible(true);
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (connection !=null) {
                try {
                    connection.close();
                    System.out.println("Conexão encerrada.");
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }));
    }
}