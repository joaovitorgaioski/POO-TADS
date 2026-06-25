package poo.mini_framework.framework;

import java.lang.reflect.Field;

public class CadastroFramework {
    public static <T> void mostrarFormulario(Class<T> classe) {
        System.out.println("-----==========-----");
        System.out.println("Formulário de Cadastro: " + classe.getSimpleName());
        System.out.println("-----==========-----");

        Field[] campos = classe.getDeclaredFields();

        for (Field campo : campos) {
            if (campo.isAnnotationPresent(Campo.class)) {
                Campo anotacao = campo.getAnnotation(Campo.class);
                System.out.println(anotacao.descricao() + ": ");
            }
        }
        System.out.println();
    }
}