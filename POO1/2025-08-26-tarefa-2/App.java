public class App {
    public static void main(String[] args) {

        System.out.println("Seja bem-vindo a Cafeteria Bom Jesus!");

        Cafeteria cliente1 = new Cafeteria("Usuário", 2);

        cliente1.realizarCadastro();

        while (cliente1.getPedido() != 0) {
            cliente1.realizarPedido();
        }

        cliente1.descontarFiliacao();
        cliente1.exibirStatus();

        Cafeteria cliente2 = new Cafeteria("Usuário 2", 2);

        cliente2.realizarCadastro();

        while (cliente2.getPedido() != 0) {
            cliente2.realizarPedido();
        }

        cliente2.descontarFiliacao();
        cliente2.exibirStatus();
    }
}
