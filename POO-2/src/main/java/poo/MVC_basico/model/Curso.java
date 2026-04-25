package poo.MVC_basico.model;

public class Curso {

    private int id;
    private String nome;

    public Curso() {
        this.nome = "Curso Sem Nome";
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "id: " + id + "\tnome: " + nome;
    }
}
