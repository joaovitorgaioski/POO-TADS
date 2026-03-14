package poo.a2026_03_13_conexao_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    /*
    Sempre seguimos o mesmo padrão:
        Connection
        Statement -> createStatement (consulta)
        PreparedStatement -> prepareStatement (inserção)
        ResultSet (retorno de dados)
     */

    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO tb_aluno (nome) VALUES (?)";

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, aluno.getNome());

            // Execução do update
            stm.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco" + e);
        }
    }

    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM tb_aluno";

        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                alunos.add(new Aluno(rs.getInt("id"), rs.getString("nome")));
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao obter valores do banco" + e);
        }

        return alunos;
    }
}
