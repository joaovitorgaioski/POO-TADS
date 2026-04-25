package poo.MVC_basico.dao;

import poo.MVC_basico.model.Curso;
import poo.MVC_basico.util.ConnectionFactory;
import poo.MVC_basico.util.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void inserir(Curso curso) {
        String sql = "INSERT INTO tb_curso (nome) VALUES (?)";

        DatabaseHelper.executeCommand(sql, curso.getNome());
    }

    public List<Curso> listar() {
        String sql = "SELECT * FROM tb_curso";
        List<Curso> cursos = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                cursos.add(new Curso(rs.getInt("curso_id"), rs.getString("nome")));
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao obter valores do banco!" + e);
        }

        return cursos;
    }

    public void atualizar(Curso curso) {
        String sql = "UPDATE tb_curso SET nome = ? WHERE curso_id = ?";

        DatabaseHelper.executeCommand(sql, curso.getNome(), curso.getId());
    }

    public void excluir(Curso curso) {
        String sql = "DELETE FROM tb_curso WHERE curso_id = ?";

        DatabaseHelper.executeCommand(sql, curso.getId());
    }

    public Curso buscarPorId(int id) {
        String sql = "SELECT * FROM tb_curso WHERE curso_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Curso curso = new Curso();
                    curso.setId(rs.getInt("curso_id"));
                    curso.setNome(rs.getString("nome"));

                    return curso;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar por id no banco!" + e);
        }
        return null;
    }

    public Curso buscarPorNome(String nome) {
        String sql = "SELECT * FROM tb_curso WHERE nome = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, nome);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Curso curso = new Curso();

                    curso.setId(rs.getInt("curso_id"));
                    curso.setNome(rs.getString("nome"));

                    return curso;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar por id no banco!" + e);
        }
        return null;
    }
}
