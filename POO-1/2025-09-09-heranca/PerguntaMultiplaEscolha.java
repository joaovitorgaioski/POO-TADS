
import java.util.ArrayList;

//Pergunta() é a generelização. PerguntaMultiplaEscolha() é a especialização.
//É como se tivéssemos uma classe geral Medico(), mas também especializações como Ortopedista() ou Dentista().
//A classe especializada herda tudo que a classe geral possui, isso inclui atributos, métodos, etc...
public class PerguntaMultiplaEscolha extends Pergunta {

    private ArrayList<String> opcoes;

    public PerguntaMultiplaEscolha() {

    }

    public PerguntaMultiplaEscolha(String textoPergunta, String respostaCorreta, ArrayList<String> opcoes) {
        //'super()' acessa a classe pai, perceba que esses dois atributos são herdados de Pergunta, menos opcoes
        super(textoPergunta, respostaCorreta);
        this.opcoes = opcoes;
    }

    // Realiza esse método quando há opcoes disponíveis
    @Override
    public String getTextoPergunta() {
        // textoBase recebe o valor do getTextoPergunta da classe pai pelo uso do super.
        // Importante: usar o @Overrido para referenciar métodos que vieram da classe pai
        String textoBase = super.getTextoPergunta();

        StringBuilder textoCompleto = new StringBuilder(textoBase);
        textoCompleto.append("\nOpções: ");
        char letraOpcao = 'A';

        // for-each
        for (String opcao : this.opcoes) {
            textoCompleto.append("\n").append(letraOpcao).append(") ").append(opcao);
            letraOpcao++;
        }
        return textoCompleto.toString();
    }
}
