
public class ClienteNaoFiliado extends Cliente {

    // Construtores
    public ClienteNaoFiliado() {
    }

    public ClienteNaoFiliado(String nome) {
        super(nome);
    }

    public ClienteNaoFiliado(String nome, String telefone) {
        super(nome, telefone);
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
        return "Não filiado";
    }

    @Override
    public StringBuilder obterComanda() {
        calcularDesconto();
        super.obterComanda();
        
        if (this.contaDescontada != this.conta) {
            comanda.append("\nTotal a pagar: R$").append(getContaDescontada());
        }

        return comanda;
    }
}
