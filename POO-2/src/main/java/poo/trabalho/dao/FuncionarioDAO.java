package poo.trabalho.dao;

import poo.trabalho.model.Funcionario;
import poo.trabalho.util.DatabaseHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FuncionarioDAO {

    public void cadastrar(Funcionario f) {
        String sql = "INSERT INTO tbfuncionario (id_funcionario, horas_trabalho, salario) VALUES (?, ?, ?)";

        DatabaseHelper.executeCommand(sql, f.getId(), f.getHorasTrabalho(), f.getSalario());
    }

    public List<Funcionario> listar() {
        String sql = """
                SELECT tbpessoa.*, tbfuncionario.salario, tbfuncionario.horas_trabalho
                FROM tbpessoa JOIN tbfuncionario ON tbpessoa.id_pessoa = tbfuncionario.id_funcionario
                """;

        List<Map<String, Object>> result = DatabaseHelper.executeQuery(sql);
        List<Funcionario> funcionarios = new ArrayList<>();

        for (Map<String, Object> linha : result) {
            Funcionario f = new Funcionario();

            f.setId((int) linha.get("id_pessoa"));
            f.setNome((String) linha.get("nome"));
            f.setCpf((String) linha.get("cpf"));
            f.setTelefone((String) linha.get("telefone"));
            f.setEndereco((String) linha.get("endereco"));
            f.setSalario(new BigDecimal(linha.get("salario").toString()));
            f.setHorasTrabalho((int) linha.get("horas_trabalho"));

            funcionarios.add(f);
        }

        return funcionarios;
    }

}