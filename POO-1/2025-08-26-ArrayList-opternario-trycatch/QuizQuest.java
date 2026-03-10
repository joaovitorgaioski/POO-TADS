
import java.util.ArrayList;
import java.util.Scanner;

public class QuizQuest {

    //main é a classe principal, o primeiro arquivo
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) { //Caso não faça um try colocando o Scanner, colocar scanner.close(); no final

            //O ArrayList é uma lista (vetor) flexível
            ArrayList<String> perguntas = new ArrayList<>();

            System.out.println("-- Lista de Perguntas --");

            perguntas.add("Qual palavra-chave usamos para invocar (criar) um objeto?");
            perguntas.add("Qual 'identificador' protege um atributo de ser visto por outra classe?");
            perguntas.add("Como se chama o ritual de invocação que tem o mesmo nome da classe?");
            perguntas.add("Qual a diferença entre o get e o set?");
            perguntas.add("O que faz um método construtor?");
            perguntas.add("Para que serve o 'this'?");

            ArrayList<String> respostas = new ArrayList<>();

            respostas.add("new");
            respostas.add("private");
            respostas.add("Construtor");
            respostas.add("get = obter e set = inserir");
            respostas.add("Define valores iniciais para um objeto.");
            respostas.add("this é usado para diferenciar um atributo da classe de um parâmetro de um método, para evitar confusão.");

            Guerreiro guerreiro1 = new Guerreiro("João");
            Guerreiro guerreiro2 = new Guerreiro("Vitor");

            //Simulando perguntas onde guerreiro2 é par e guerreiro1 é impar, sem o uso de Scanner
            for (int i = 0; i < perguntas.size(); i++) {
                //Operador ternário faz um if e else em 1 linha, e também coloca qualquer objeto dentro de outro objeto
                //Em jogadorDaVez. Se a condição for V, faz guerreiro1. Se for F, faz guerreiro2. Assim dá pra alternar por conta da instrução
                Guerreiro jogadorDaVez = (i % 2 == 0) ? guerreiro1 : guerreiro2;
                Guerreiro oponente = (i % 2 == 0) ? guerreiro2 : guerreiro1;
                System.out.println("Jogador da vez: " + jogadorDaVez.getNome());
                System.out.println("Pergunta " + (i + 1) + ": " + perguntas.get(i));
                System.out.println("Resposta: ");
                String respostaJogador = scanner.nextLine();
                String respostaCorreta = respostas.get(i);

                if (respostaJogador.equalsIgnoreCase(respostaCorreta)) {
                    System.out.println(jogadorDaVez.getNome() + " acertou!");
                    jogadorDaVez.adicionarPontos(10);
                    oponente.receberDano(10);
                } else {
                    System.out.println(jogadorDaVez.getNome() + " errou!");
                    jogadorDaVez.receberDano(5);
                }

                System.out.println("-- Placar --");
                System.out.println("Jogador da vez: ");
                jogadorDaVez.exibirStatus();
                System.out.println("Oponente: ");
                oponente.exibirStatus();

            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
