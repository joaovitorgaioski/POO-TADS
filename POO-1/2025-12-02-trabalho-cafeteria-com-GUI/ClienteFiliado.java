
public class ClienteFiliado extends Cliente {

    // Construtores
    public ClienteFiliado() {
    }

    public ClienteFiliado(String nome) {
        super(nome);
    }

    public ClienteFiliado(String nome, String telefone) {
        super(nome, telefone);
    }

    // Métodos especializados
    @Override
    public void calcularDesconto() {
        this.contaDescontada = this.conta * 0.9; // 10% de desconto
    }

    @Override
    public String getTipoCliente() {
        return "Filiado (10% de desconto)";
    }

    @Override
    public StringBuilder obterComanda() {
        calcularDesconto();
        super.obterComanda();
        
        comanda.append("\nTotal a pagar: R$").append(getContaDescontada());

        return comanda;
    }
}
