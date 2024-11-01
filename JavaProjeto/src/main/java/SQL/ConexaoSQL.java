package SQL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Bhernardo
 */
public class ConexaoSQL{
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/projetopoojavaferrovelho";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar no banco de dados: " + e.getMessage());
        }
        return connection;
    }
}