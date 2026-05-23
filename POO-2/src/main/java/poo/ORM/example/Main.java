package poo.ORM.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    static void main(String[] args) {

        // Conexão com ORM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        // Persistir, buscar, etc
        EntityManager em = emf.createEntityManager();

        /*
         ---------- CREATE - persist ----------

         em.getTransaction().begin();
         em.persist(aluno);
         em.getTransaction().commit();

         ---------- READ - find ----------

         Aluno aluno = em.find(Aluno.class, 2);

         ---------- UPDATE ----------

          em.getTransaction().begin();

          Aluno aluno = em.find(Aluno.class, 2);
          if (aluno != null) {
              aluno.setNome("Robyson");

             em.getTransaction().commit();
          } else
          System.out.println("Aluno não encontrado");

         ---------- DELETE ----------

         em.getTransaction().begin();

         Aluno aluno = em.find(Aluno.class, 2);
         if (aluno != null) {
             em.remove(aluno);

             em.getTransaction().commit();
         } else
             System.out.println("Aluno não encontrado!");

         ---------- DEVEMOS FECHAR A CONEXÃO ----------

         em.close();
         emf.close();
         */

    }
}
