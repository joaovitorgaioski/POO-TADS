import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int opcao = -1;
        int indice = -1;

        System.out.println("Seja bem-vindo a Cafeteria Bom Jesus!");
        System.out.println("Cliente não filiados recebem descontos em compras acima de R$20,00. Filiados sempre recebem esse desconto.");

        while (opcao != 0) {
            linhaHorizontal();
            System.out.println(
                    "O que desejas fazer?\n(1) - Cadastrar cliente comum\t\t(2) - Cadastrar cliente filiado\n(3) - Realizar pedido\t\t\t(4) - Listar clientes\n(0) - Sair");
            opcao = scan.nextInt();
            linhaHorizontal();

            switch (opcao) {

                case 1:
                    indice++;
                    clientes.add(new ClienteNaoFiliado("Usuário Comum"));
                    clientes.get(indice).realizarCadastro();
                    break;

                case 2:
                    indice++;
                    clientes.add(new ClienteFiliado("Usuário Filiado"));
                    clientes.get(indice).realizarCadastro();
                    break;

                case 3:
                    if (clientes.isEmpty()) {
                        System.out.println("Erro: não há clientes cadastrados.");
                    } else {
                        System.out.println("Qual cliente gostaria de realizar o pedido?");
                        listarClientes(clientes);
                        opcao = scan.nextInt();
                        clientes.get(opcao).fazerPedido();
                        clientes.get(opcao).exibirComanda();
                    }
                    opcao = -1;
                    break;

                case 4:
                    listarClientes(clientes);
                break;
                    
                case 0:
                    System.out.println("Saindo.");
                    break;

                default:
                    System.out.println("Erro: escolha uma opção válida.");
                    break;
            }
        }
        scan.close();
    }

    // Alguns métodos estáticos que julguei serem úteis

    public static void listarClientes(ArrayList<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNome() + "\t\t" + clientes.get(i).getTelefone() + "\t\t" + clientes.get(i).getTipoCliente());
        }
    }

    public static void linhaHorizontal() {
        System.out.println("\n--" + "=".repeat(40) + "--\n");
    }

}
