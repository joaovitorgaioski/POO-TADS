package poo.trabalho.model;

public class Ingrediente {
    private int id, qtd;
    private String nome;
    private Unidade unidade;

    public Ingrediente() {
    }

    public Ingrediente(int id, int qtd, String nome, Unidade unidade) {
        this.id = id;
        this.qtd = qtd;
        this.nome = nome;
        this.unidade = unidade;
    }

    public int getId() {
        return id;
    }

    public int getQtd() {
        return qtd;
    }

    public String getNome() {
        return nome;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "\nIngrediente{" +
                "id=" + id +
                ", qtd=" + qtd +
                ", nome='" + nome + '\'' +
                ", unidade=" + unidade +
                '}';
    }
}
