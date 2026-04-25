package poo.MVC_basico.view;

import poo.MVC_basico.controller.AlunoController;
import poo.MVC_basico.controller.CursoController;
import poo.MVC_basico.model.Aluno;
import poo.MVC_basico.model.Curso;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int op = -1;

        while (op != 0) {
            try {
                System.out.print("""
                        =======================
                        [1] - Gerenciar Alunos
                        [2] - Gerenciar Cursos
                        [0] - Sair
                        Escolha: """);

                op = Integer.parseInt(scan.nextLine());

                switch (op) {
                    case 1:
                        menuAluno(scan);
                        break;

                    case 2:
                        menuCurso(scan);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }

    public static void menuAluno(Scanner scan) {
        AlunoController alunoController = new AlunoController();
        int op = -1;

        while (op != 0) {
            System.out.print("""
                    
                    ---- MENU ALUNO ----
                    [1] Inserir
                    [2] Listar
                    [3] Atualizar
                    [4] Excluir
                    [0] Voltar
                    Escolha: """);

            op = Integer.parseInt(scan.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    alunoController.inserirAluno(scan.nextLine());
                    break;

                case 2:
                    List<Aluno> alunos = alunoController.listarAlunos();
                    alunos.forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scan.nextLine());
                    System.out.print("Novo nome: ");
                    String nome = scan.nextLine();
                    System.out.println(alunoController.atualizarAluno(id, nome) ? "Atualizado!" : "Não encontrado!");
                    break;

                case 4:
                    System.out.print("ID: ");
                    boolean excluido = alunoController.excluirAluno(Integer.parseInt(scan.nextLine()));
                    System.out.println(excluido ? "Excluído!" : "Não encontrado!");
                    break;

                default:
                    System.out.println("Escolha uma opção válida!");
            }
        }
    }

    public static void menuCurso(Scanner scan) {
        CursoController cursoController = new CursoController();
        int op = -1;

        while (op != 0) {
            System.out.print("""
                    
                    ---- MENU CURSO ----
                    [1] Inserir
                    [2] Listar
                    [3] Atualizar
                    [4] Excluir
                    [0] Voltar
                    Escolha: """);

            op = Integer.parseInt(scan.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Nome do curso: ");
                    cursoController.inserirCurso(scan.nextLine());
                    break;

                case 2:
                    List<Curso> cursos = cursoController.listarCursos();
                    cursos.forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scan.nextLine());
                    System.out.print("Novo nome: ");
                    boolean ok = cursoController.atualizarCurso(id, scan.nextLine());
                    System.out.println(ok ? "Atualizado!" : "Não encontrado!");
                    break;

                case 4:
                    System.out.print("ID: ");
                    boolean excluido = cursoController.excluirCurso(Integer.parseInt(scan.nextLine()));
                    System.out.println(excluido ? "Excluído!" : "Não encontrado!");
                    break;

                default:
                    System.out.println("Escolha uma opção válida!");
            }
        }
    }
}