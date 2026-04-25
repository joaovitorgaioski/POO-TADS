package poo.MVC_basico.controller;

import poo.MVC_basico.dao.AlunoDAO;
import poo.MVC_basico.model.Aluno;

import java.util.List;

public class AlunoController {

    private AlunoDAO dao;

    public AlunoController() {
        this.dao = new AlunoDAO();
    }

    // Métodos que a view vai usar para interagir com o banco, intermediados pelo controller

    public void inserirAluno(String nome) {
        Aluno aluno = new Aluno(nome);
        dao.inserir(aluno);
        System.out.println("Aluno inserido com sucesso!");
    }

    public List<Aluno> listarAlunos() {
        return dao.listar();
    }

    public boolean atualizarAluno(int id, String nome) {
        Aluno aluno = dao.buscarPorId(id);

        if (aluno != null) {
            aluno.setNome(nome);
            dao.atualizar(aluno);
            return true;
        }

        return false;
    }

    public boolean excluirAluno(int id) {
        Aluno aluno = dao.buscarPorId(id);

        if (aluno == null) return false;

        dao.excluir(aluno);
        return true;
    }

    public Aluno buscarAlunoPorId(int id) {
        return dao.buscarPorId(id);
    }

    public Aluno buscarAlunoPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
}
