package poo.mini_framework.framework;

import java.lang.reflect.Field;

public class Validador {
    public static boolean validar(Object objeto) {
        try {
            Field[] campos = objeto.getClass().getDeclaredFields();
            for (Field campo : campos) {
                if (campo.isAnnotationPresent(Obrigatorio.class)) {
                    campo.setAccessible(true);
                    Object valor = campo.get(objeto);
                    if (valor == null || valor.toString().isBlank()) {
                        System.out.println("[ERRO] Campo de preenchimento obrigatório ausente: " + campo.getName());
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha na inspeção: " + e.getMessage());
            return false;
        }
    }
}