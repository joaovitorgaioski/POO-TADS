package poo.mini_framework.model;

import poo.mini_framework.framework.Campo;
import poo.mini_framework.framework.Entidade;
import poo.mini_framework.framework.Obrigatorio;

public class Ingrediente implements Entidade {
    private int id;

    @Campo(descricao = "Nome do Ingrediente")
    @Obrigatorio
    private String nome;

    public Ingrediente() {
    }

    public Ingrediente(int id, String nome) {
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

    @Override
    public String toString() {
        return nome;
    }
}