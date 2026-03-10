
import java.util.Scanner;

abstract class Pessoa {
    Scanner scan = new Scanner(System.in);

    private String nome, cpf;

    public Pessoa() {

    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public abstract void cadastrar();
}
