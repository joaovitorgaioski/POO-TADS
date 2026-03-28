package poo.a2026_03_27_MVC_basico.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// A camada ConnectionFactory possui o metodo getConnection que permite a conexão com o banco
public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/db_poo";
    private static final String USER = "root";
    private static final String PASS = "mysql";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco" + e);
        }
    }

    // Metodos para reduzir a quantidade de try. Ele recebe qualquer quantidade de parâmetros a serem alterados

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

    public static List<Object> executeQuery(String sql, Object... param) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)
        ) {
            int i = 1;

            for (; i < param.length; i++) {
                stm.setObject(i, param[i]);
            }

            List<Object> retorno = new ArrayList<>();

            try (ResultSet rs = stm.executeQuery()) {
                int columnCount = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    for (; i < columnCount; i++) {
                        retorno.add(rs.getObject(i));
                    }
                }

                return retorno;
            }

        } catch (SQLException e) {
            System.out.println("Erro na interação com o banco!" + e);
        }
        return null;
    }
}
