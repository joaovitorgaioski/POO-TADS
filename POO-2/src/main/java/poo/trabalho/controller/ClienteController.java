package poo.trabalho.controller;

import poo.trabalho.dao.ClienteDAO;
import poo.trabalho.dao.PessoaDAO;
import poo.trabalho.model.Cliente;

import java.util.List;

public class ClienteController {
    private ClienteDAO dao;

    public ClienteController() {
        this.dao = new ClienteDAO();
    }

    public void cadastrar(Cliente c) {
        // Geramos a chave em Pessoa e obtivemos ela aqui para cadastrar Cliente. Caso de erro, a excessão já é lançada
        int chaveGerada = new PessoaDAO().cadastrar(c);
        c.setId(chaveGerada);

        dao.cadastrar(c);
    }

    public List<Cliente> listar() {
        return dao.listar();
    }
}