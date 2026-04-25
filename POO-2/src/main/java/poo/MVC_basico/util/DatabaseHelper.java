package poo.MVC_basico.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {

    /**
     * Metodos para reduzir a quantidade de try. Ele recebe qualquer quantidade de parâmetros a serem alterados.
     * @param sql SQL
     * @param param Parâmetros do comando SQL
     */
    public static void executeCommand(String sql, Object... param) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)
        ) {

            // Vamos percorrer os índices de cada parâmetro e executar o set adequado
            for (int i = 0; i < param.length; i++) {
                stm.setObject(i + 1, param[i]);
            }

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro na interação com o banco!" + e);
        }
    }
}
