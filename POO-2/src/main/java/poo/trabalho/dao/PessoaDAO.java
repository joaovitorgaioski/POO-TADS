package poo.trabalho.dao;

import poo.trabalho.model.Pessoa;
import poo.trabalho.util.DatabaseHelper;

import java.sql.*;

public class PessoaDAO {
    public int cadastrar(Pessoa p) {
        String sql = "INSERT INTO tbpessoa (nome, cpf, telefone, endereco) VALUES (?, ?, ?, ?)";

        // Vai retornar o ID cadastrado usando o RETURN_GENERATED_KEYS no prepareStatement
        return DatabaseHelper.executeCommand(sql, p.getNome(), p.getCpf(), p.getTelefone(), p.getEndereco());
    }

    public void deletar(int id) {
        String sql = "DELETE FROM tbpessoa WHERE id_pessoa = ?";

        DatabaseHelper.executeCommand(sql, id);
    }

    public void atualizar(Pessoa p) {
        String sql = "UPDATE tbpessoa SET nome = ?, cpf = ?, telefone = ?, endereco = ? WHERE id_pessoa = ?";

        DatabaseHelper.executeCommand(sql, p.getNome(), p.getCpf(), p.getTelefone(), p.getEndereco(), p.getId());
    }

}