package poo.trabalho.controller;

import poo.trabalho.dao.FuncionarioDAO;
import poo.trabalho.dao.PessoaDAO;
import poo.trabalho.model.Cliente;
import poo.trabalho.model.Funcionario;

import java.util.List;

public class FuncionarioController {
    private FuncionarioDAO dao;

    public FuncionarioController() {
        this.dao = new FuncionarioDAO();
    }

    public void cadastrar(Funcionario f) {
        // Geramos a chave em Pessoa e obtivemos ela aqui para cadastrar Funcionario
        int chaveGerada = new PessoaDAO().cadastrar(f);
        f.setId(chaveGerada);

        dao.cadastrar(f);
    }

    public List<Funcionario> listar() {
        return dao.listar();
    }

    public void deletar(int id) {
        PessoaDAO pDao = new PessoaDAO();
        pDao.deletar(id);
    }

    public void atualizar(Funcionario f) {
        new PessoaDAO().atualizar(f);

        dao.atualizar(f);
    }
}