// Classe principal
public class Main {
    public static void main(String[] args) {
        // Parte da Abstração: instanciando objetos usando um construtor
        Cachorro cachorro = new Cachorro("Rex", 3, "Canis Lupus Familiaris", "Curta");
        Gato gato = new Gato("Mimi", 2, "Felis Catus", "Persa");

        // Testando Encapsulamento: alterando valores com setter
        cachorro.setIdade(4);
        gato.setNome("Luna");

        // Saída com getters
        System.out.println(cachorro.getNome() + " é da espécie " + cachorro.getEspecie() + ", tem " + cachorro.getIdade() + " anos e possui pelagem " + cachorro.getPelagem() + ".");
        System.out.println(gato.getNome() + " é da espécie " + gato.getEspecie() + ", tem " + gato.getIdade() + " anos e é da raça " + gato.getRaca() + ".");

        // Podemos pegar os atributos próprios de cada classe filha:
        // Perceba que Gato não possui o atributo pelagem, mas possui raça. Já o Cachorro não possui raça mas têm pelagem, isso pode se expandir para muitos cenários
        System.out.println("A pelagem do " + cachorro.getNome() + " é " + cachorro.getPelagem());
        System.out.println("A raça do " + gato.getNome() + " é " + gato.getRaca());

        // Polimorfismo: mesma chamada, resultados diferentes
        cachorro.emitirSom();
        gato.emitirSom();

        cachorro.mover();
        gato.mover();

    }
}