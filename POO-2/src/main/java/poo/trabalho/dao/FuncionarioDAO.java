package poo.trabalho.dao;

import poo.trabalho.model.Funcionario;
import poo.trabalho.util.ConnectionFactory;
import poo.trabalho.util.DatabaseHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FuncionarioDAO {

    public void cadastrar(Funcionario f) {
        String sql = "INSERT INTO tbfuncionario (id_funcionario, horas_trabalho, salario) VALUES (?, ?, ?)";

        DatabaseHelper.executeCommand(sql, f.getId(), f.getHorasTrabalho(), f.getSalario());
    }

    public List<Funcionario> listar() {
        String sql = """
                SELECT tbpessoa.*, tbfuncionario.salario, tbfuncionario.horas_trabalho
                FROM tbpessoa JOIN tbfuncionario ON tbpessoa.id_pessoa = tbfuncionario.id_funcionario
                """;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)
        ) {
            List<Funcionario> funcionarios = new ArrayList<>();

            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id_pessoa"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setSalario(rs.getBigDecimal("salario"));
                f.setHorasTrabalho(rs.getInt("horas_trabalho"));

                funcionarios.add(f);
            }

            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException("Erro na leitura do banco! ", e);
        }
    }

    public void atualizar(Funcionario f) {
        String sql = "UPDATE tbfuncionario SET horas_trabalho = ?, salario = ? WHERE id_funcionario = ?";

        DatabaseHelper.executeCommand(sql, f.getHorasTrabalho(), f.getSalario(), f.getId());
    }
}
