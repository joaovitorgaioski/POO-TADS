// Abstração: esta classe representa o conceito genérico de um Animal, o essencial
// Abstraímos o que é essencial para qualquer animal: nome, idade, espécie e ações genéricas.

public class Animal {
    // Encapsulamento: atributos privados só podem ser acessados por meio de getters e setters
    private String nome;
    private int idade;
    private String especie;

    // Construtores
    public Animal() {
    }

    public Animal(String nome, int idade, String especie) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
    }

    // Getters e Setters (Encapsulamento)
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    // Métodos genéricos (serão sobrescritos pelas subclasses (ou classes filhas))
    public void emitirSom() {
        System.out.println("O animal emite um som...");
    }

    public void mover() {
        System.out.println("O animal está se movendo...");
    }
}