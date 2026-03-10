import java.util.ArrayList;
import java.util.Scanner;

public class Cafeteria {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> pedidos = new ArrayList<>();

    // Atributos
    private String nome;
    private int filiacao;
    private int pedido = -1;
    private double conta;
    private double contaFinal;

    // Construtores
    public Cafeteria() {
        //Esse é um Construtor Padrão, ele precisa sempre ser feito, é usado caso não seja atribuido nenhum argumento ao instanciar um objeto (mesmo que este construtor esteja vazio).
    }

    public Cafeteria(String nome) {
        this.nome = nome;
        //A palavra 'this' vai ser usada para referenciar atributos da classe. Diferenciando atributos da classe de parâmetros. Esse atributo com this recebe o valor do parâmetro.
    }

    public Cafeteria(String nome, int filiacao) {
        this.nome = nome;
        this.filiacao = filiacao;
    }

    // Getters
    public String getNome() {
        return this.nome;
    }

    public int getFiliacao() {
        return this.filiacao;
    }

    public int getPedido() {
        return this.pedido;
    }

    public double getConta() {
        return this.conta;
    }

    public double getContaFinal() {
        return this.contaFinal;
    }

    // Setters
    public void setNome(String nome) {
        if (nome != null && nome != "" && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Esse nome não é válido.");
        }
    }

    public void setFiliacao(int filiacao) {
        if (filiacao == 1 || filiacao == 2) {
            this.filiacao = filiacao;
        } else {
            System.out.println("Escolha uma opção válida!");
        }
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public void setConta(double conta) {
        this.conta = this.conta + conta;
    }

    public void setContaFinal(double contaFinal) {
        this.contaFinal = contaFinal;
    }

    // Métodos
    public void realizarCadastro() {
        System.out.println("Olá, qual o seu nome?");
        setNome(scan.nextLine());

        System.out.println(nome + ", você é cliente filiado?\n1 - Sim\t2 - Não");
        setFiliacao(scan.nextInt());
    }

    public void realizarPedido() {
        System.out.println(
                "1 - Pão (R$0.50)\t2 - Coxinha (R$4.50)\t3 - Bolo de Chocolate (R$5.00)\n4 - Café (R$3.00)\t5 - Rissole (R$5.00)\t6 - Sonho Pequeno (R$1.00)\n0 - SAIR");
        setPedido(scan.nextInt());

        switch (getPedido()) {
            case 1:
                this.pedidos.add("Pão R$0.50");
                setConta(0.5);
                break;

            case 2:
                this.pedidos.add("Coxinha R$4.50");
                setConta(4.5);
                break;

            case 3:
                this.pedidos.add("Bolo de Chocolate R$5.00");
                setConta(5);
                break;

            case 4:
                this.pedidos.add("Café R$3.00");
                setConta(3);
                break;

            case 5:
                this.pedidos.add("Rissole R$5.00");
                setConta(5);
                break;

            case 6:
                this.pedidos.add("Sonho Pequeno R$1.00");
                setConta(1);
                break;

            default:
                System.out.println("Pedido finalizado com sucesso!");
                break;
        }
    }

    public void descontarFiliacao() {
        if (getFiliacao() == 1) {
            setContaFinal(getConta() * 0.9);
        } else {
            setContaFinal(getConta());
        }
    }

    public void exibirStatus() {
        System.out.println("-----=====-----");
        System.out.println("Nome: " + getNome());

        if (getFiliacao() == 1) {
            System.out.println("Filiado");
        } else {
            System.out.println("Não filiado");
        }

        System.out.println("Total: R$" + getConta());
        System.out.printf("Total a pagar: R$%.2f", getContaFinal());
        System.out.println("\nPedidos:");

        for (int i = 0; i < this.pedidos.size(); i++) {
            System.out.println("\t" + this.pedidos.get(i));
        }

        System.out.println("-----=====-----");
    }
}
