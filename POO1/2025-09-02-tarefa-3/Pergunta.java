
public class Pergunta {

    private String textoPergunta;
    private String respostaCorreta;
    private String dificuldade;

    public Pergunta() {

    }

    public Pergunta(String textoPergunta, String respostaCorreta) {
        this.textoPergunta = textoPergunta;
        this.respostaCorreta = respostaCorreta;
    }

    public Pergunta(String textoPergunta, String respostaCorreta, String dificuldade) {
        this.textoPergunta = textoPergunta;
        this.respostaCorreta = respostaCorreta;
        this.dificuldade = dificuldade.toLowerCase();
    }

    public String getTextoPergunta() {
        return this.textoPergunta;
    }

    public String getDificuldade() {
        return this.dificuldade;
    }

    public int getMultiplicador() {
        switch (this.dificuldade) {
            case "facil":
                return 1;

            case "medio":
                return 2;

            case "dificil":
                return 4;

            default:
                return 1;
        }
    }

    // Método para verificar se a resposta está correta
    public boolean isRespostaCorreta(String resposta) {
        return resposta.equalsIgnoreCase(this.respostaCorreta);
    }
}
