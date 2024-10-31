/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package JavaProjeto;

import GUI.Home;
import javax.swing.SwingUtilities;
import SQL.ConexaoSQL;  // Importa a classe de conexão
import java.sql.Connection;


public class JavaProjeto {

    public static void main(String[] args) {
        // Tenta estabelecer a conexão com o banco de dados
        Connection conn = ConexaoSQL.getConnection(); // Chama o método que retorna a conexão

        // Verifica se a conexão foi bem-sucedida
        if (conn != null) {
            System.out.println("Conexão com o banco de dados foi estabelecida com sucesso.");
        } else {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
        }

        // Inicializa a interface gráfica
        SwingUtilities.invokeLater(() -> new Home());
    }
    
}
