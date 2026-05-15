package poo.trabalho.dao;

import poo.trabalho.util.ConnectionFactory;
import poo.trabalho.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public List<Produto> listar() {
        String sql = "SELECT * FROM tbproduto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stm = conn.prepareStatement(sql)) {

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setSabor(rs.getString("sabor"));
                p.setPreco(rs.getBigDecimal("preco"));

                produtos.add(p);
            }
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar listar os Produtos", e);
        }
    }

}
