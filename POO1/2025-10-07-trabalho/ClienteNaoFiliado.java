
public class ClienteNaoFiliado extends Cliente {

    // Construtores
    public ClienteNaoFiliado() {
    }

    public ClienteNaoFiliado(String nome) {
        super(nome);
    }

    // Métodos especializados
    @Override
    public void calcularDesconto() {
        this.contaDescontada = this.conta;
        if (this.conta >= 20) {
            this.contaDescontada = this.conta * 0.9; // 10% de desconto caso gaste mais de 10 reais
        }
    }

    @Override
    public String getTipoCliente() {
        return "Cliente não filiado";
    }

    @Override
    public void exibirComanda() {
        calcularDesconto();
        super.exibirComanda();
        if (this.contaDescontada != this.conta) {
            System.out.printf("Total a pagar: R$%.2f\n", getContaDescontada());
        }
    }
}
