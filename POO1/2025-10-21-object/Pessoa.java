public class Pessoa {
    private String nome, idade, cpf;

    // Construtor
    public Pessoa(String nome, String idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Métodos
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", CPF: " + cpf;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Pessoa outraPessoa = (Pessoa) obj;
        return nome.equals(outraPessoa.nome) && idade.equals(outraPessoa.idade) && cpf.equals(outraPessoa.cpf);
    }
}
