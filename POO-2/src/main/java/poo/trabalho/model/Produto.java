package poo.trabalho.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private String nome, sabor;
    private BigDecimal preco;
    private List<Ingrediente> receita = new ArrayList<>();

    public Produto() {
    }

    public Produto(int id, String nome, String sabor, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.sabor = sabor;
        this.preco = preco;
    }

    public Produto(int id, String nome, String sabor, BigDecimal preco, List<Ingrediente> receita) {
        this.id = id;
        this.nome = nome;
        this.sabor = sabor;
        this.preco = preco;
        this.receita = receita;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSabor() {
        return sabor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public List<Ingrediente> getReceita() {
        return receita;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setReceita(List<Ingrediente> receita) {
        this.receita = receita;
    }

    @Override
    public String toString() {
        return id + " | " + "Nome: " + nome + " | Preço: " + sabor + " | Qtd Ingredientes: " + receita.size() + "\n";
    }

}
