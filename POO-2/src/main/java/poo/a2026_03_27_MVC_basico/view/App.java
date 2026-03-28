package poo.a2026_03_27_MVC_basico.view;

import poo.a2026_03_27_MVC_basico.controller.AlunoController;
import poo.a2026_03_27_MVC_basico.model.Aluno;

import java.util.List;
import java.util.Scanner;

/*
---== MVC ==---

Visão    --> Interface gráfica                          (Cliente)
Controle --> Intermediário entre View e Model           (Garçom)
Model    --> Interação com o banco                      (Cozinha)

 */

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();

        int op = -1;

        while (op != 0) {
            try {
                System.out.print("""
                        ------==============================------
                        [1] - Inserir aluno
                        [2] - Listar alunos
                        [3] - Atualizar aluno
                        [4] - Excluir aluno
                        [5] - Buscar aluno por id
                        [6] - Buscar aluno por nome
                        [0] - SAIR
                        Escolha uma opção: """);
                op = Integer.parseInt(scan.nextLine()); // Limpa o buffer na hora, muito bom
                System.out.println("------==============================------");

                switch (op) {
                    case 1:
                        System.out.print("Digite o nome do aluno: ");
                        String nome = scan.nextLine();

                        alunoController.inserirAluno(nome);
                        break;

                    case 2:
                        List<Aluno> alunos = alunoController.listarAlunos();

                        if (alunos.isEmpty())
                            System.out.println("Nenhum aluno encontrado!");
                        else alunos.forEach(a -> {
                            System.out.println(a.getId() + "\t\t" + a.getNome());
                        });
                        break;

                    case 3:
                        System.out.print("Digite o id do aluno que deseja atualizar: ");
                        int idAtualizar = Integer.parseInt(scan.nextLine());

                        System.out.print("Digite um novo nome: ");
                        String novoNome = scan.nextLine();

                        boolean atualizado = alunoController.atualizarAluno(idAtualizar, novoNome);

                        System.out.println(atualizado ? "Aluno atualizado com sucesso!" : "Aluno não foi encontrado!");

                        break;

                    case 4:
                        System.out.print("Digite o id do aluno que deseja excluir: ");
                        int idExcluir = Integer.parseInt(scan.nextLine());

                        boolean excluido = alunoController.excluirAluno(idExcluir);

                        System.out.println(excluido ? "Aluno excluido com sucesso!" : "Aluno não encontrado!");
                        break;

                    case 5:
                        System.out.println("Digite o id do aluno");
                        int idBusca = Integer.parseInt(scan.nextLine());

                        Aluno alunoEncontrado = alunoController.buscarAlunoPorId(idBusca);

                        if (alunoEncontrado == null)
                            System.out.println("Aluno não encontrado!");
                        else
                            System.out.println(alunoEncontrado.getId() + "\t" + alunoEncontrado.getNome());

                        break;

                    case 6:
                        System.out.println("Digite o nome do aluno");
                        String buscaPorNome = scan.nextLine();

                        Aluno alunoEncontradoNome = alunoController.buscarAlunoPorNome(buscaPorNome);

                        if (alunoEncontradoNome == null)
                            System.out.println("Aluno não encontrado!");
                        else
                            System.out.println(alunoEncontradoNome.getId() + "\t" + alunoEncontradoNome.getNome());

                        break;

                    case 0:
                        System.out.println("Deseja realmente sair? (s) ou (n)");
                        String sair = scan.nextLine();

                        if (sair.equals("s")) System.out.println("Bye");
                        else op = -1;

                        break;

                    default:
                        System.out.println("Escolha uma opção válida");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido: [1] a [6] !");
            }
        }
    }
}
