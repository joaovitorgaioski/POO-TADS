import java.util.ArrayList;
import java.util.Scanner;

public class Cafeteria {
    Scanner scan = new Scanner(System.in);

    // Atributos
    String nome;
    int filiacao;
    int pedido = -1;
    double conta;
    double contaFinal;
    ArrayList<String> pedidos = new ArrayList<>();

    // Métodos
    public void realizarCadastro() {
        System.out.println("Olá, qual o seu nome?");
        this.nome = scan.next();

        System.out.println(nome + ", você é cliente filiado?\n1 - Sim\t2 - Não");
        this.filiacao = scan.nextInt();
    }

    public void realizarPedido() {
        System.out.println(
                "1 - Pão (R$0.50)\t2 - Coxinha (R$4.50)\t3 - Bolo de Chocolate (R$5.00)\n4 - Café (R$3.00)\t5 - Rissole (R$5.00)\t6 - Sonho Pequeno (R$1.00)\n0 - SAIR");
        this.pedido = scan.nextInt();

        switch (pedido) {
            case 1:
                this.conta += 0.5;
                this.pedidos.add("Pão R$0.50");
                break;

            case 2:
                this.conta += 4.5;
                this.pedidos.add("Coxinha R$4.50");
                break;

            case 3:
                this.conta += 5;
                this.pedidos.add("Bolo de Chocolate R$5.00");
                break;

            case 4:
                this.conta += 3;
                this.pedidos.add("Café R$3.00");
                break;

            case 5:
                this.conta += 5;
                this.pedidos.add("Rissole R$5.00");
                break;

            case 6:
                this.conta += 1;
                this.pedidos.add("Sonho Pequeno R$1.00");
                break;

            default:
                System.out.println("Pedido finalizado com sucesso!");
                break;
        }
    }

    public void descontarFiliacao() {
        this.contaFinal = this.conta * 0.9;
        System.out.println("Aplicado o desconto de 10% para filiados!");
    }

    public void exibirStatus() {
        System.out.println("-----=====-----");
        System.out.println("Nome: " + nome);

        if (filiacao == 1) {
            System.out.println("Filiado");
        } else {
            System.out.println("Não filiado");
        }

        System.out.println("Total: R$" + conta);
        System.out.printf("Total a pagar: R$%.2f", contaFinal);
        System.out.println("\nPedidos:");

        for (int i = 0; i < this.pedidos.size(); i++) {
            System.out.println("\t" + this.pedidos.get(i));
        }

        System.out.println("-----=====-----");
    }
}
