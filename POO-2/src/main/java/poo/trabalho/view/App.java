package poo.trabalho.view;

import poo.trabalho.controller.ClienteController;
import poo.trabalho.controller.FuncionarioController;
import poo.trabalho.model.Cliente;
import poo.trabalho.model.Funcionario;
import poo.trabalho.model.Pessoa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scan = new Scanner(System.in);
    private static final FuncionarioController funcController = new FuncionarioController();
    private static final ClienteController cliController = new ClienteController();

    public static void main(String[] args) {
        int op = -1;

        while (op != 0) {
            System.out.print("""
                    
                    ===== Gerenciamento de Pessoas =====
                    [1] Gerenciar Funcionários
                    [2] Gerenciar Clientes
                    [0] Sair
                    Escolha uma opção: """);
            op = Integer.parseInt(scan.nextLine());

            switch (op) {
                case 1 -> menuFuncionarios();
                case 2 -> menuClientes();
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Escolha uma opção válida!");
            }
        }
    }

    private static void menuFuncionarios() {
        int op = -1;

        while (op != 0) {
            System.out.print("""
                    
                    --- MENU FUNCIONÁRIOS ---
                    [1] Cadastrar Funcionário
                    [2] Listar Funcionários
                    [3] Atualizar Funcionário
                    [4] Deletar Funcionário
                    [0] Voltar ao Menu Principal
                    Escolha uma opção: """);
            op = Integer.parseInt(scan.nextLine());

            switch (op) {
                case 1 -> cadastrarFuncionario();
                case 2 -> listarFuncionarios();
                case 3 -> atualizarFuncionario();
                case 4 -> deletarFuncionario();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuClientes() {
        int op = -1;
        while (op != 0) {
            System.out.print("""
                    
                    --- MENU CLIENTES ---
                    [1] Cadastrar Cliente
                    [2] Listar Clientes
                    [3] Atualizar Cliente
                    [4] Deletar Cliente
                    [0] Voltar ao Menu Principal
                    Escolha uma opção: """);
            try {
                op = Integer.parseInt(scan.nextLine());

                switch (op) {
                    case 1 -> cadastrarCliente();
                    case 2 -> listarClientes();
                    case 3 -> atualizarCliente();
                    case 4 -> deletarCliente();
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
                op = -1;
            }
        }
    }

    private static void lerDadosPessoa(Pessoa p) {
        System.out.print("Nome: ");
        p.setNome(scan.nextLine());

        System.out.print("CPF (apenas números): ");
        p.setCpf(scan.nextLine());

        System.out.print("Telefone: ");
        p.setTelefone(scan.nextLine());

        System.out.print("Endereço: ");
        p.setEndereco(scan.nextLine());
    }

    // Operações relacionadas a Funcionário

    private static void cadastrarFuncionario() {
        System.out.println("\n-- Cadastrar Funcionário --");
        try {
            Funcionario f = new Funcionario();

            lerDadosPessoa(f);

            System.out.print("Horas de Trabalho diárias: ");
            f.setHorasTrabalho(Integer.parseInt(scan.nextLine()));

            System.out.print("Salário: ");
            f.setSalario(new BigDecimal(scan.nextLine()));

            funcController.cadastrar(f);
            System.out.println("Funcionário cadastrado com sucesso! ID gerado: " + f.getId());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao validar dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao interagir com o banco: " + e.getMessage());
        }
    }

    private static void atualizarFuncionario() {
        System.out.println("\n-- Atualizar Funcionário --");
        try {
            System.out.print("Digite o ID do funcionário que deseja atualizar: ");
            int id = Integer.parseInt(scan.nextLine());

            Funcionario f = new Funcionario();
            f.setId(id);

            lerDadosPessoa(f);

            System.out.print("Novas Horas de Trabalho diárias: ");
            f.setHorasTrabalho(Integer.parseInt(scan.nextLine()));

            System.out.print("Novo Salário: ");
            f.setSalario(new BigDecimal(scan.nextLine()));

            funcController.atualizar(f);
            System.out.println("Funcionário cadastrado/atualizado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao validar dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao atualizar no banco: " + e.getMessage());
        }
    }

    private static void listarFuncionarios() {
        System.out.println("\n-- Lista de Funcionários --");
        List<Funcionario> funcionarios = funcController.listar();

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario f : funcionarios) {
            System.out.printf("ID: %d | Nome: %s | CPF: %s | Tel: %s | Endereço: %s | Horas: %dh | Salário: R$ %.2f%n",
                    f.getId(), f.getNome(), f.getCpf(), f.getTelefone(), f.getEndereco(), f.getHorasTrabalho(), f.getSalario());
        }
    }

    private static void deletarFuncionario() {
        System.out.println("\n-- Excluir Funcionário --");
        System.out.print("Digite o ID do funcionário que deseja remover: ");
        try {
            int id = Integer.parseInt(scan.nextLine());
            funcController.deletar(id);
            System.out.println("Funcionário removido com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido.");
        }
    }

    // Operações relacionadas a Cliente
    private static void cadastrarCliente() {
        System.out.println("\n-- Cadastrar Cliente --");
        try {
            Cliente c = new Cliente();

            lerDadosPessoa(c);

            System.out.print("Filiação [0] ou [1]: ");
            c.setFiliacao(Integer.parseInt(scan.nextLine()));

            cliController.cadastrar(c);
            System.out.println("Cliente cadastrado com sucesso! ID gerado: " + c.getId());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao validar dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao interagir com o banco: " + e.getMessage());
        }
    }

    private static void atualizarCliente() {
        System.out.println("\n-- Atualizar Cliente --");
        try {
            System.out.print("Digite o ID do cliente que deseja atualizar: ");
            int id = Integer.parseInt(scan.nextLine());

            Cliente c = new Cliente();
            c.setId(id);

            lerDadosPessoa(c);

            System.out.print("Nova Filiação [0] ou [1]: ");
            c.setFiliacao(Integer.parseInt(scan.nextLine()));

            cliController.atualizar(c);
            System.out.println("Cliente atualizado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao validar dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao atualizar no banco: " + e.getMessage());
        }
    }

    private static void listarClientes() {
        System.out.println("\n-- Lista de Clientes --");
        List<Cliente> clientes = cliController.listar();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.printf("ID: %d | Nome: %s | CPF: %s | Tel: %s | Endereço: %s | Filiação: %d%n",
                    c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getEndereco(), c.getFiliacao());
        }
    }

    private static void deletarCliente() {
        System.out.println("\n-- Excluir Cliente --");
        System.out.print("Digite o ID do cliente que deseja remover: ");
        try {
            int id = Integer.parseInt(scan.nextLine());
            cliController.deletar(id);
            System.out.println("Cliente removido com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido.");
        }
    }
}