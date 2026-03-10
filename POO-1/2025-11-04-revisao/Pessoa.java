public class Pessoa {
    String nome;
    String cpf;
    String endereco;
    String formacaoEducacional;
    int idade;
    
    public void andar(int metros) {
        System.out.println("A pessoa " + this.nome + " andou " + metros + "m.");
    }

    public void aniversario(){
            this.idade++;
            System.out.println("Parabéns, hoje você faz " + this.idade + " anos!");
    }
}