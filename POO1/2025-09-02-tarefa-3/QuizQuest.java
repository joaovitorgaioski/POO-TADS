//Incrementando a classe Pergunta() usando um ArrayList<Pergunta>. Lembre que em Pergunta(), temos tanto o texto da pergunta como a resposta, e usamos construtores para atribuir a pergunta e a resposta para cada elemento da lista

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class QuizQuest {

    public static void main(String[] args) {

        try {
            // Para a tarefa de 02/09, decidi adicionar níveis de dificuldade e removi o Random() para a pontuação: Fácil: *1, Médio: *2; Difícil: *4
            // A pontuação padrão é 5. A dificuldade é um multiplicador que altera esse valor.

            Scanner scan = new Scanner(System.in);
            Random random = new Random();
            ArrayList<Pergunta> arsenalPerguntas = new ArrayList<>();

            arsenalPerguntas.add( new Pergunta("Qual a palavra-chave que utilizamos para instanciar um objeto?", "new", "facil"));
            arsenalPerguntas.add( new Pergunta("Qual palavra-chave usamos para herdar uma classe?", "extends", "dificil"));
            arsenalPerguntas.add( new Pergunta("Qual 'identificador' protege um atributo de ser visto por outra classe?", "private", "medio"));
            arsenalPerguntas.add( new Pergunta("Como se chama o ritual de invocação que tem o mesmo nome da classe?", "construtor", "medio"));
            arsenalPerguntas.add( new Pergunta("Entre Medico() e Ortopedista(), quem é a generelização?", "Medico", "dificil"));

            Guerreiro guerreiro1 = new Guerreiro("João");
            Guerreiro guerreiro2 = new Guerreiro("Vitor");

            // Colocando um n° aleatório para aleatorizar quem vai iniciar
            int aux = random.nextInt(2);

            Guerreiro jogadorDaVez = (aux % 2 == 0) ? guerreiro1 : guerreiro2;
            Guerreiro oponente = (aux % 2 == 0) ? guerreiro2 : guerreiro1;
            Guerreiro temporario;

            for (int i = 0; i < arsenalPerguntas.size(); i++) {

                // Armazena a pergunta atual na variável perguntaAtual a partir do arsenal na posição i
                Pergunta perguntaAtual = arsenalPerguntas.get(i);
                System.out.println("+--Pergunta: " + perguntaAtual.getTextoPergunta() + "\n+--Dificuldade: " + perguntaAtual.getDificuldade());
                String resposta = scan.nextLine();

                if (perguntaAtual.isRespostaCorreta(resposta)) {
                    jogadorDaVez.adicionarPontos(5 * perguntaAtual.getMultiplicador());
                    oponente.receberDano(5 * perguntaAtual.getMultiplicador());
                } else {
                    // Algoritmo para trocar quem é o oponente e quem é o jogador da vez
                    temporario = jogadorDaVez;
                    jogadorDaVez = oponente;
                    oponente = temporario;
                    i--;
                }

                System.out.println("-- Placar --");
                System.out.println("Jogador da vez: ");
                jogadorDaVez.exibirStatus();
                System.out.println("Oponente: ");
                oponente.exibirStatus();
            }

            scan.close();

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
