package poo.trabalho.controller;

import poo.trabalho.dao.IngredienteDAO;
import poo.trabalho.dao.ProdutoDAO;
import poo.trabalho.model.Ingrediente;
import poo.trabalho.model.Produto;

import java.util.List;

public class ProdutoController {
    private ProdutoDAO dao;

    public ProdutoController() {
        this.dao = new ProdutoDAO();
    }

    /**
     * Lista todos os Produtos com todos os seus Ingredientes associados
     *
     * @return Lista de Produtos
     */
    public List<Produto> listar() {
        List<Produto> produtos = dao.listar();
        IngredienteController ingController = new IngredienteController();

        produtos.forEach(p -> {
            List<Ingrediente> ingredientes = ingController.listarDeProduto(p);

            ingredientes.forEach(i -> p.getReceita().add(i));
        });

        return produtos;
    }
}
