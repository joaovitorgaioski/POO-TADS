
public class QuizQuest {

    //main é a classe principal, o primeiro arquivo
    public static void main(String[] args) {
        System.out.println("Bem vindo ao QuizQuest: A Batalha de Conhecimento");

        //Instanciando objetos --> new
        //Classe objeto = new Classe();
        Guerreiro guerreiro3 = new Guerreiro("Joao");
        guerreiro3.exibirStatus();

        Guerreiro guerreiro4 = new Guerreiro(5);
        guerreiro4.exibirStatus();

        Guerreiro guerreiro5 = new Guerreiro("Jonas", 10);
        guerreiro5.exibirStatus();

        //O guerreiro6 é inicializado como "Marquinhos" e logo em seguida é usado um 'set' para alterá-lo e depois é exibido
        Guerreiro guerreiro6 = new Guerreiro("Marquinhos");
        guerreiro6.setNome("Salamaleico");
        guerreiro6.exibirStatus();

    }
    /*
    public static void testarArmadura(){
        Guerreiro guerreiro = new Guerreiro("Valdecir");
        System.out.println("--- TESTANDO A ARMADURA DE " + guerreiro.getNome());
        int vidaAntes = guerreiro.getPontosVida();
        System.out.println("Vida atual: " + vidaAntes);

        System.out.println("Ataque: (-50)");
        guerreiro.receberDano(50);
        System.out.println("Vida após receber dano (-50): " + guerreiro.getPontosVida());

        System.out.println("Ataque fulminante: (-200)");
        guerreiro.receberDano(200);
        System.out.println("Vida após receber dano (-200): " + guerreiro.getPontosVida());
        }
     */
}
