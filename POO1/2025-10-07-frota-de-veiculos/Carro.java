public class Carro extends Veiculo {
    // Atributos
    private int capacidadePassageiros;

    // Construtores
    public Carro() {
    }

    public Carro(String marca, String modelo, String placa, int quilometragem, int capacidadePassageiros) {
        super(marca, modelo, placa, quilometragem);
        this.capacidadePassageiros = capacidadePassageiros;
    }

    // Getters
    public int getCapacidadePassageiros() {
        return this.capacidadePassageiros;
    }

    // Setters
    public void setCapacidadePassageiros(int capacidadePassageiros) {
        if (capacidadePassageiros >= 0) {
            this.capacidadePassageiros = capacidadePassageiros;
        } else {
            System.out.println("Erro: capacidade inválida");
        }
    }

    // Métodos
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Capacidade de passageiros: " + getCapacidadePassageiros());
    }

    @Override
    public String exibirStatusConcatenado() {
        return getMarca() + " , " + getModelo() + " , " + getPlaca() + " , " + getQuilometragem() + " km, " + getCapacidadePassageiros() + " passageiros";
    }

    @Override
    public void percorrer(int kmRodados) {
        setLitrosConsumidos(kmRodados / 10.0);
        System.out.println("Quantidade de litros consumidos: " + getLitrosConsumidos() + " L");
    }
}
