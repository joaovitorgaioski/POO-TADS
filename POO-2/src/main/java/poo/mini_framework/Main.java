package poo.mini_framework;

import poo.mini_framework.framework.CadastroFramework;
import poo.mini_framework.framework.RepositorioGenerico;
import poo.mini_framework.framework.Validador;
import poo.mini_framework.model.Ingrediente;
import poo.mini_framework.model.Produto;

public class Main {
    public static void main(String[] args) {
        System.out.print("""
                ==================================================
                 SISTEMA DE GERENCIAMENTO DE PRODUTOS E INGREDIENTES
                ==================================================
                """);

        // Inicializacao dos Repositorios
        RepositorioGenerico<Ingrediente> repoIngredientes = new RepositorioGenerico<>();
        RepositorioGenerico<Produto> repoProdutos = new RepositorioGenerico<>();

        // Passo 1
        System.out.println("\n[PASSO 1] Cadastrando Ingredientes no Sistema...");
        Ingrediente i1 = new Ingrediente(1, "Massa de Pizza");
        Ingrediente i2 = new Ingrediente(2, "Molho de Tomate");
        Ingrediente i3 = new Ingrediente(3, "Queijo Mucarela");
        Ingrediente i4 = new Ingrediente(4, "Pepperoni");

        repoIngredientes.salvar(i1);
        repoIngredientes.salvar(i2);
        repoIngredientes.salvar(i3);
        repoIngredientes.salvar(i4);

        // Passo 2
        System.out.println("\n[PASSO 2] Vinculando Ingredientes aos Produtos...");

        Produto p1 = new Produto(101, "Pizza Margherita");
        p1.adicionarIngrediente(i1);
        p1.adicionarIngrediente(i2);
        p1.adicionarIngrediente(i3);

        repoProdutos.salvar(p1);

        Produto p2 = new Produto(102, "Pizza de Pepperoni");
        p2.adicionarIngrediente(i1);
        p2.adicionarIngrediente(i2);
        p2.adicionarIngrediente(i3);
        p2.adicionarIngrediente(i4);

        repoProdutos.salvar(p2);

        // Passo 3
        System.out.println("\n[PASSO 3] Geração Dinâmica de Formulários via Reflection");
        CadastroFramework.mostrarFormulario(Ingrediente.class);
        CadastroFramework.mostrarFormulario(Produto.class);

        // Passo 4
        System.out.println("\n[PASSO 4] Teste de Validação de Restrições");
        Produto produtoInvalido = new Produto(103, "");

        System.out.println("Tentando registrar produto sem nome...");

        if (Validador.validar(produtoInvalido)) {
            repoProdutos.salvar(produtoInvalido);
        } else {
            System.out.println("[ERRO] Operacao cancelada: O objeto nao atende os critérios.");
        }

        // Passo 5 (Relatorio Final)
        System.out.println("""
                \n==================================================
                        RELATORIO DE PRODUTOS CADASTRADOS        
                ==================================================
                """);


        for (Produto produto : repoProdutos.listar()) {
            System.out.println("ID: \t\t" + produto.getId());
            System.out.println("Nome: \t\t" + produto.getNome());
            System.out.print("Ingredientes: ");

            int totalIngredientes = produto.getIngredientes().size();
            for (int i = 0; i < totalIngredientes; i++) {
                System.out.print("\n\t" + produto.getIngredientes().get(i).getNome());
            }
            System.out.println("\n--------------------------------------------------");
        }
    }
}