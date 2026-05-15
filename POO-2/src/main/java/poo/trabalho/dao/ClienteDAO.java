package poo.trabalho.dao;

import poo.trabalho.model.Cliente;
import poo.trabalho.util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteDAO {

    public void cadastrar(Cliente c) {
        String sql = "INSERT INTO tbcliente (id_cliente, filiacao) VALUES (?, ?)";

        DatabaseHelper.executeCommand(sql, c.getId(), c.getFiliacao());
    }

    public List<Cliente> listar() {
        String sql = """
                SELECT tbpessoa.*, tbcliente.filiacao
                FROM tbpessoa JOIN tbcliente ON tbpessoa.id_pessoa = tbcliente.id_cliente
                """;

        List<Map<String, Object>> result = DatabaseHelper.executeQuery(sql);
        List<Cliente> clientes = new ArrayList<>();

        for (Map<String, Object> linha : result) {
            Cliente c = new Cliente();

            c.setId((int) linha.get("id_pessoa"));
            c.setNome((String) linha.get("nome"));
            c.setCpf((String) linha.get("cpf"));
            c.setTelefone((String) linha.get("telefone"));
            c.setEndereco((String) linha.get("endereco"));
            c.setFiliacao((int) linha.get("filiacao"));

            clientes.add(c);
        }

        return clientes;
    }
}