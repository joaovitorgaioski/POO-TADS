package poo.trabalho.util;

import java.sql.*;

// Classe usada para gerenciar comandos de inserção. Evitar repetição de "try-catch"
public class DatabaseHelper {

    public static int executeCommand(String sql, Object... param) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {

            // Vamos percorrer os índices de cada parâmetro e executar o set adequado
            for (int i = 0; i < param.length; i++) {
                stm.setObject(i + 1, param[i]);
            }

            stm.executeUpdate();

            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next())
                    return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro na interação com o banco! ", e);
        }
        return 0;
    }
}
