package poo.trabalho.dao;

import poo.trabalho.model.Pessoa;
import poo.trabalho.util.ConnectionFactory;

import java.sql.*;

public class PessoaDAO {
    // Vai retornar o ID cadastrado usando o RETURN_GENERATED_KEYS no prepareStatement
    public int cadastrar(Pessoa p) {
        String sql = "INSERT INTO tbpessoa (nome, cpf, telefone, endereco) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stm.setString(1, p.getNome());
            stm.setString(2, p.getCpf());
            stm.setString(3, p.getTelefone());
            stm.setString(4, p.getEndereco());

            stm.executeUpdate();

            // Obtemos a chave gerada. O rs.next é essencial para obter valor de uma coluna, nesse caso ele obtem apenas a primeira
            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            throw new SQLException("Falha ao obter ID gerado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro no cadastro de Pessoa! ", e);
        }
    }

}