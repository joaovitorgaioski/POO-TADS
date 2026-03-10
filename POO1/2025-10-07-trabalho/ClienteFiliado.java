
public class ClienteFiliado extends Cliente {

    // Construtores
    public ClienteFiliado() {
    }

    public ClienteFiliado(String nome) {
        super(nome);
    }

    // Métodos especializados
    @Override
    public void calcularDesconto() {
        this.contaDescontada = this.conta * 0.9; // 10% de desconto
    }

    @Override
    public String getTipoCliente() {
        return "Cliente filiado (10% de desconto)";
    }

    @Override
    public void exibirComanda() {
        calcularDesconto();
        super.exibirComanda();
        System.out.printf("Total a pagar: R$%.2f\n", getContaDescontada());
    }
}
