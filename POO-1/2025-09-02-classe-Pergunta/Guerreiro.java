
public class Guerreiro {

    //Atributos
    private String nome;
    private int pontuacao;
    private int pontosVida;

    //Métodos
    public void exibirStatus() {
        System.out.println("Guerreiro: " + this.nome);
        System.out.println("Vida: " + this.pontosVida);
        System.out.println("Pontuacao: " + this.pontuacao);
        System.out.println("-------------");
    }

    //Método Responder errado
    public void receberDano(int dano) {
        if (dano > 0) {
            this.pontosVida -= dano;
            if (this.pontosVida < 0) {
                this.pontosVida = 0;
            }
        }
    }

    //Método Responder corretamente
    public void adicionarPontos(int pontos) {
        if (pontos > 0) {
            this.pontuacao += pontos;
        }
    }

    //Construtores
    //Sempre criar um construtor padrão!
    public Guerreiro() {
        System.out.println("Um novo guerreiro foi invocado pelo construtor padrão!");
        this.pontosVida = 100;
        this.pontuacao = 0;
    }

    //Construtor atribuindo 1 parâmetro
    public Guerreiro(String nome) {
        System.out.println("'" + nome + "' foi invocado pelo construtor nomeado!");
        this.nome = nome;
        this.pontosVida = 100;
        this.pontuacao = 0;
    }

    //Construtor atribuindo 1 outro parâmetro
    public Guerreiro(int pontuacao) {
        System.out.println("Guerreiro invocado pelo construtor com pontuacao inicial!");
        this.pontuacao = pontuacao;
        this.nome = "Jailton";
        this.pontosVida = 100;
    }

    //Construtor atribuindo 2 parâmetros
    public Guerreiro(String nome, int pontuacao) {
        System.out.println("Guerreiro invocado pelo construtor com nome e pontuacao inicial!");
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.pontosVida = 100;
    }

    //Construtor atribuindo todos os parâmetros
    public Guerreiro(String nome, int pontuacao, int pontosVida) {
        System.out.println("Guerreiro invocado pelo construtor com tudo inicializado!");
        this.nome = nome;
        if (pontuacao <= 100 && pontuacao >= 0) {
            this.pontuacao = pontuacao;
            this.pontosVida = pontosVida;
        }
    }

    //Getters -> Obter informação do atributo (ao invés de usar o atributo diretamente)
    public String getNome() {
        return this.nome;
    }

    public int getPontosVida() {
        return this.pontosVida;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    //Setters -> Inserir / alterar informações dos atributos (sem poder acessar o atributo diretamente)
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Erro: Um guerreiro não pode ter o nome vazio");
        }
    }
}
