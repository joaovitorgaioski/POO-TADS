// Classe Gato é filha herdada de Animal. Usamos o 'extends' para dizer quem é a classe pai.

public class Gato extends Animal {
    // Atributo específico da classe filha
    private String raca;

    public Gato() {
    }

    // Construtor que chama a classe pai (super) e inicializa o atributo específico
    public Gato(String nome, int idade, String especie, String raca) {
        super(nome, idade, especie);
        this.raca = raca;
    }

    // Getter e Setter específicos (Encapsulamento aplicado também aqui)
    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    // Polimorfismo: o gato emite som diferente do cachorro mas usa o mesmo método
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está miando: Miau!");
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está caminhando em quatro patas silenciosamente.");
    }
}