
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Incrementando a classe Pergunta() usando um ArrayList<Pergunta>. Lembre que em Pergunta(), temos tanto o texto da pergunta como a resposta, e usamos construtores para atribuir a pergunta e a resposta para cada elemento da lista
public class QuizQuest {

    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);
            Random random = new Random();
            ArrayList<Pergunta> arsenalPerguntas = new ArrayList<>();

            arsenalPerguntas.add(new Pergunta("Qual a palavra-chave que utilizamos para instanciar um objeto?", "new"));
            arsenalPerguntas.add(new Pergunta("Qual 'identificador' protege um atributo de ser visto por outra classe?", "private"));
            arsenalPerguntas.add(new Pergunta("Como se chama o ritual de invocação que tem o mesmo nome da classe?", "construtor"));

            Guerreiro guerreiro1 = new Guerreiro("João");
            Guerreiro guerreiro2 = new Guerreiro("Vitor");

            //Colocando um n° aleatório para aleatorizar quem vai iniciar
            int aux = random.nextInt(2);

            Guerreiro jogadorDaVez = (aux % 2 == 0) ? guerreiro1 : guerreiro2;
            Guerreiro oponente = (aux % 2 == 0) ? guerreiro2 : guerreiro1;
            Guerreiro temporario;

            for (int i = 0; i < arsenalPerguntas.size(); i++) {

                //Armazena a pergunta atual na variável perguntaAtual a partir do arsenal na posição i
                Pergunta perguntaAtual = arsenalPerguntas.get(i);
                System.out.println("Pergunta: " + perguntaAtual.getTextoPergunta());
                String resposta = scan.nextLine();

                if (perguntaAtual.isRespostaCorreta(resposta)) {
                    jogadorDaVez.adicionarPontos(random.nextInt(20) + 1);
                    oponente.receberDano(random.nextInt(10) + 1);
                } else {
                    //Algoritmo para trocar quem é o oponente e quem é o jogador da vez
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
