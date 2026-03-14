package poo.a2026_03_13_conexao_JDBC;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("James");
        AlunoDAO alunoDAO = new AlunoDAO();

        alunoDAO.inserir(aluno);

        List<Aluno> lista = alunoDAO.listar();

        lista.forEach(System.out::println);
    }
}
