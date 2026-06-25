package poo.mini_framework.framework;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenerico<T extends Entidade> {
    private List<T> dados = new ArrayList<>();

    public void salvar(T objeto) {
        dados.add(objeto);
        System.out.println("[INFO] Registro armazenado com sucesso.");
    }

    public List<T> listar() {
        return dados;
    }

    public T buscarPorId(int id) {
        for (T objeto : dados) {
            if (objeto.getId() == id) {
                return objeto;
            }
        }
        return null;
    }

    public boolean excluir(int id) {
        T objeto = buscarPorId(id);
        if (objeto != null) {
            dados.remove(objeto);
            return true;
        }
        return false;
    }

    public boolean atualizar(T objeto) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == objeto.getId()) {
                dados.set(i, objeto);
                return true;
            }
        }
        return false;
    }
}