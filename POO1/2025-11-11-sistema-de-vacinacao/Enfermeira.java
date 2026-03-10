public class Enfermeira extends Pessoa {
    public Enfermeira(){

    }

    public Enfermeira(String nome, String cpf){
        super(nome, cpf);
    }

    @Override
    public void cadastrar() {
        System.out.println("Nome da enfermeira: ");
        setNome(scan.nextLine());
        System.out.println("CPF da enfermeira: ");
        setCpf(scan.next());
    }
}
