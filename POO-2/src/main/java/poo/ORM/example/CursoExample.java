package poo.ORM.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import poo.ORM.model.Curso;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CursoExample {
    static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        Scanner scan = new Scanner(System.in);

        int op = -1;

        while (op != 0) {
            System.out.println("""
                    ---=== Manipulação simples de curso ===---
                    Escolha uma opção:
                    [1] - Adicionar curso
                    [2] - Ver todos os cursos
                    [3] - Ver curso específico
                    [4] - Remover um curso
                    [5] - Atualizar curso
                    Opção:""");
            op = Integer.parseInt(scan.nextLine());

            switch (op) {

                case 1:
                    em.getTransaction().begin();
                    Curso curso = new Curso();

                    System.out.print("Nome do curso: ");
                    curso.setNome(scan.nextLine());

                    em.persist(curso);
                    em.getTransaction().commit();
                    break;

                case 2:
                    List<Curso> cursos = em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();

                    System.out.println(Arrays.asList(cursos));
                    break;

                case 3:
                    System.out.print("Insira um id: ");
                    int id = Integer.parseInt(scan.nextLine());

                    Curso cursoEspecifico = em.find(Curso.class, id);

                    System.out.println(cursoEspecifico);
                    break;

                case 4:
                    em.getTransaction().begin();
                    System.out.print("Insira o id do curso a remover: ");
                    int idRemover = Integer.parseInt(scan.nextLine());

                    Curso cursoRemover = em.find(Curso.class, idRemover);

                    em.remove(cursoRemover);
                    em.getTransaction().commit();
                    break;

                case 5:
                    em.getTransaction().begin();
                    System.out.print("Insira o id do curso a atualizar: ");
                    int idUpdate = Integer.parseInt(scan.nextLine());

                    Curso cursoUpdate = em.find(Curso.class, idUpdate);

                    System.out.print("Novo nome para o curso: ");
                    cursoUpdate.setNome(scan.nextLine());

                    em.getTransaction().commit();
                    break;

                default:
                    System.out.println("Selecione uma opção válida!");
                    break;
            }

        }

        em.close();
        emf.close();
    }
}
