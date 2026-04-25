package poo.MVC_basico.util;

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

}
