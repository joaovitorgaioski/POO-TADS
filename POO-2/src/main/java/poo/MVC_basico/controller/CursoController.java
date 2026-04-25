package poo.MVC_basico.controller;

import poo.MVC_basico.dao.CursoDAO;
import poo.MVC_basico.model.Curso;

import java.util.List;

public class CursoController {
    private CursoDAO dao;

    public CursoController() {
        this.dao = new CursoDAO();
    }

    public void inserirCurso(String nome) {
        Curso curso = new Curso(nome);
        dao.inserir(curso);
        System.out.println("Curso inserido com sucesso!");
    }

    public List<Curso> listarCursos() {
        return dao.listar();
    }

    public boolean atualizarCurso(int id, String nome) {
        Curso curso = dao.buscarPorId(id);

        if (curso != null) {
            curso.setNome(nome);
            dao.atualizar(curso);
            return true;
        }

        return false;
    }

    public boolean excluirCurso(int id) {
        Curso curso = dao.buscarPorId(id);

        if (curso == null) return false;

        dao.excluir(curso);
        return true;
    }

    public Curso buscarCursoPorId(int id) {
        return dao.buscarPorId(id);
    }

    public Curso buscarCursoPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
}
