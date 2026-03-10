public class Caminhao extends Veiculo {
    // Atributos
    private int capacidadeCarga;

    // Construtores
    public Caminhao() {
    }

    public Caminhao(String marca, String modelo, String placa, int quilometragem, int capacidadeCarga) {
        super(marca, modelo, placa, quilometragem);
        this.capacidadeCarga = capacidadeCarga;
    }

    // Getters
    public int getCapacidadeCarga() {
        return this.capacidadeCarga;
    }

    // Setters
    public void setCapacidadeCarga(int capacidadeCarga) {
        if (capacidadeCarga >= 0) {
            this.capacidadeCarga = capacidadeCarga;
        } else {
            System.out.println("Erro: capacidade inválida");
        }
    }

    // Métodos
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Capacidade de carga: " + getCapacidadeCarga() + " kg");
    }

    @Override
    public String exibirStatusConcatenado() {
        return getMarca() + " , " + getModelo() + " , " + getPlaca() + " , " + getQuilometragem() + " km, " + getCapacidadeCarga() + " kg";
    }

    @Override
    public void percorrer(int kmRodados) {
        setLitrosConsumidos(kmRodados / 3.0);
        System.out.println("Quantidade de litros consumidos: " + getLitrosConsumidos() + " L");
    }
}
