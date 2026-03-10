// Herança: Cachorro herda de Animal. Assim, ele já possui os atributos e métodos definidos em Animal.

public class Cachorro extends Animal {
    // Atributo específico da classe filha Cachorro
    private String pelagem;

    public Cachorro() {
    }

    // Construtor que chama a classe pai (super) e inicializa o atributo específico
    public Cachorro(String nome, int idade, String especie, String pelagem) {
        super(nome, idade, especie);
        this.pelagem = pelagem;
    }

    // Getter e Setter (Encapsulamento deve ser aplicado em toda classe)
    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    // Polimorfismo: sobrescrevemos o método emitirSom() e mover() para especializar o comportamento do Cachorro
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está latindo: Au Au!");
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está correndo em quatro patas.");
    }
}