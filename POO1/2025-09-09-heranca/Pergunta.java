
public class Pergunta {

    private String textoPergunta;
    private String respostaCorreta;

    public Pergunta() {

    }

    public Pergunta(String textoPergunta, String respostaCorreta) {
        this.textoPergunta = textoPergunta;
        this.respostaCorreta = respostaCorreta;
    }

    public String getTextoPergunta() {
        return this.textoPergunta;
    }

    //Método para verificar se a resposta está correta
    public boolean isRespostaCorreta(String resposta) {
        return resposta.equalsIgnoreCase(this.respostaCorreta);
    }
}
