package poo.trabalho.controller;

import poo.trabalho.dao.IngredienteDAO;
import poo.trabalho.model.Ingrediente;
import poo.trabalho.model.Produto;

import java.util.List;

public class IngredienteController {
    private IngredienteDAO dao;

    public IngredienteController() {
        this.dao = new IngredienteDAO();
    }

    /**
     * Lista os Ingredientes cadastrados e no estoque, desconsiderando Produtos
     *
     * @return Lista de Ingredientes
     */
    public List<Ingrediente> listar() {
        return dao.listar();
    }

    /**
     * Lista todos os Ingredientes de um determinado Produto
     *
     * @param p Produto
     * @return Lista de Ingredientes de um produto específico
     */
    public List<Ingrediente> listarDeProduto(Produto p) {
        return dao.listarDeProduto(p.getId());
    }
}
