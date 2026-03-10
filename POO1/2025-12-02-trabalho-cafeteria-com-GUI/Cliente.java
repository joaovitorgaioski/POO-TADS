import java.util.Scanner;

public abstract class Cliente {
    protected Scanner scan = new Scanner(System.in);
    protected StringBuilder pedidos = new StringBuilder();
    protected StringBuilder comanda = new StringBuilder();
    protected double conta;
    protected double contaDescontada;
    protected String nome;
    protected String telefone;

    // Construtores
    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters
    public String getNome() {
        return this.nome;
    }

    public double getConta() {
        return this.conta;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public double getContaDescontada() {
        return this.contaDescontada;
    }

    // Setters
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Erro: esse nome não é válido.");
        }
    }

    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.isEmpty()) {
            this.telefone = telefone;
        } else {
            System.out.println("Erro: esse telefone não é válido.");
        }
    }

    // Métodos
    public void realizarCadastro(String nome, String telefone) {
        setNome(nome);
        setTelefone(telefone);
    }

    public void processarPedido(int pedido) {
        switch (pedido) {
            case 1 -> {
                pedidos.append("Pão R$0.50\n");
                conta += 0.5;
            }
            case 2 -> {
                pedidos.append("Coxinha R$4.50\n");
                conta += 4.5;
            }
            case 3 -> {
                pedidos.append("Bolo de Chocolate R$5.00\n");
                conta += 5;
            }
            case 4 -> {
                pedidos.append("Café R$3.00\n");
                conta += 3;
            }
            case 5 -> {
                pedidos.append("Rissole R$5.00\n");
                conta += 5;
            }
            case 6 -> {
                pedidos.append("Sonho Pequeno R$1.00\n");
                conta += 1;
            }
            case 0 -> {
            }
            default -> System.out.println("Erro: opção inválida.");
        }
    }

    public abstract String getTipoCliente();

    public abstract void calcularDesconto();

    public StringBuilder obterComanda() {
        comanda.append("Nome: ").append(getNome()).append("\nTipo: ").append(getTipoCliente()).append("\n\nPedidos:\n");

        comanda.append(pedidos);
        comanda.append("\nTotal: R$").append(getConta());

        return comanda;
    }

    public void limparCliente() {
        pedidos.setLength(0);
        comanda.setLength(0);
        this.conta = 0;
        this.contaDescontada = 0;
    }
}