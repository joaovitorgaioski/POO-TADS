package poo.mini_framework.model;

import poo.mini_framework.framework.Campo;
import poo.mini_framework.framework.Entidade;
import poo.mini_framework.framework.Obrigatorio;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Entidade {
    private int id;

    @Campo(descricao = "Nome do Produto")
    @Obrigatorio
    private String nome;

    @Campo(descricao = "Lista de Ingredientes Vinculados")
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public Produto() {
    }

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }
}