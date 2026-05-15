package poo.trabalho.view;

import poo.trabalho.controller.ProdutoController;
import poo.trabalho.model.Produto;

import java.util.List;
import java.util.Scanner;

public class App {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProdutoController pc = new ProdutoController();
        int op = -1;

        System.out.println("---==== Sistema Gestor de Produtos ====---");

        while (op != 0) {
            System.out.print("""
                    [1] - Listar Produtos
                    [2] - Listar Ingredientes
                    [3] - Inserir Produto
                    [4] - Inserir Ingrediente
                    [0] - SAIR
                    Opção: """);
            op = Integer.parseInt(scan.nextLine());

            switch (op) {
                case 1:
                    List<Produto> produtos = pc.listar();

                    System.out.println(produtos);
                    break;

                case 0:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Selecione uma das opções válidas!");
                    break;
            }

            if (op != 0) op = -1;
        }
    }
}
