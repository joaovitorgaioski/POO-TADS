package poo.trabalho.dao;

import poo.trabalho.model.Ingrediente;
import poo.trabalho.model.Unidade;
import poo.trabalho.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {

    public List<Ingrediente> listar() {
        String sql = "SELECT * FROM tbingrediente";
        List<Ingrediente> ingredientes = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stm = conn.prepareStatement(sql)) {

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Ingrediente i = new Ingrediente();
                i.setId(rs.getInt("id_ingrediente"));
                i.setNome(rs.getString("nome"));
                i.setQtd(rs.getInt("qtd_estoque"));
                i.setUnidade(Unidade.valueOf(rs.getString("unidade")));

                ingredientes.add(i);
            }
            return ingredientes;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar listar os Ingredientes", e);
        }
    }

    public List<Ingrediente> listarDeProduto(int idP) {
        String sql = """
                SELECT i.id_ingrediente, r.qtd_receita, i.nome, i.unidade 
                FROM tbreceita r
                INNER JOIN tbingrediente i ON i.id_ingrediente = r.id_ingrediente
                WHERE r.id_produto = ?
                """;
        List<Ingrediente> ingredientes = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, idP);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Ingrediente i = new Ingrediente();
                i.setId(rs.getInt("id_ingrediente"));
                i.setNome(rs.getString("nome"));
                i.setQtd(rs.getInt("qtd_receita"));
                i.setUnidade(Unidade.valueOf(rs.getString("unidade")));

                ingredientes.add(i);
            }
            return ingredientes;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar listar os Ingredientes", e);
        }
    }

}
