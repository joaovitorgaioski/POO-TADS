/*public class App {
    public static void main(String[] args) {
        System.out.println("Seja bem-vindo a Cafeteria Bom Jesus!");

        Cafeteria cliente1 = new Cafeteria();
        // Cadastro do cliente
        cliente1.realizarCadastro();

        // Pedido do cliente
        System.out.println(cliente1.nome + " o que desejas?");
        while (cliente1.pedido != 0) {
            cliente1.realizarPedido();
        }

        // Descontando filiação caso seja filiado
        if (cliente1.filiacao == 1) {
            cliente1.descontarFiliacao();
        } else {
            System.out.println(cliente1.nome + ", você não é filiado e não obterá desconto!");
            cliente1.contaFinal = cliente1.conta;
        }

        // Exibindo status do pedido
        cliente1.exibirStatus();

        //Instanciando o segundo objeto (próximo cliente)
        Cafeteria cliente2 = new Cafeteria();
        cliente2.realizarCadastro();
        
        System.out.println(cliente2.nome + " o que desejas?");
        while (cliente2.pedido != 0) {
            cliente2.realizarPedido();
        }

        if (cliente2.filiacao == 1) {
            cliente2.descontarFiliacao();
        } else {
            System.out.println(cliente2.nome + ", você não é filiado e não obterá desconto!");
            cliente2.contaFinal = cliente2.conta;
        }
    }
}
*/