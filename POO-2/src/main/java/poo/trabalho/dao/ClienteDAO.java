package poo.trabalho.dao;

import poo.trabalho.model.Cliente;
import poo.trabalho.util.ConnectionFactory;
import poo.trabalho.util.DatabaseHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteDAO {

    public void cadastrar(Cliente c) {
        String sql = "INSERT INTO tbcliente (id_cliente, filiacao) VALUES (?, ?)";

        DatabaseHelper.executeCommand(sql, c.getId(), c.getFiliacao());
    }

    public List<Cliente> listar() {
        String sql = """
                SELECT tbpessoa.*, tbcliente.filiacao
                FROM tbpessoa JOIN tbcliente ON tbpessoa.id_pessoa = tbcliente.id_cliente
                """;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)
        ) {

            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id_pessoa"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setFiliacao(rs.getInt("filiacao"));

                clientes.add(c);
            }

            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException("Erro na leitura do banco! ", e);
        }
    }

    public void atualizar(Cliente c) {
        String sql = "UPDATE tbcliente SET filiacao = ? WHERE id_cliente = ?";

        DatabaseHelper.executeCommand(sql, c.getFiliacao(), c.getId());
    }

}
