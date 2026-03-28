package poo.a2026_03_27_MVC_basico.dao;

import poo.a2026_03_27_MVC_basico.model.Curso;
import poo.a2026_03_27_MVC_basico.util.ConnectionFactory;

import java.util.List;

public class CursoDAO {

    public void inserir(Curso curso) {
        String sql = "INSERT INTO tb_curso (nome) VALUES (?)";

        ConnectionFactory.executeCommand(sql, curso.getNome());
    }
    
}
