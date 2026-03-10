
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Cidadao extends Pessoa {

    private int qntdDoses;
    private ArrayList<Calendar> dataDoses = new ArrayList<>();

    public Cidadao() {

    }

    public Cidadao(String nome, String cpf, int qntdDoses) {
        super(nome, cpf);
        this.qntdDoses = qntdDoses;
    }

    public int getQntdDoses() {
        return this.qntdDoses;
    }

    public String getDataDose(int i) {
        return Util.formatarDataParaString(this.dataDoses.get(i));
    }

    public void setQntdDoses(int qntdDoses) {
        if (qntdDoses > 0 && qntdDoses < 100) {
            this.qntdDoses = qntdDoses;
        } else {
            System.out.println("Erro: a quantidade de doses inserida não é aceita.");
            System.out.print("Quantidade de doses que " + getNome() + " já tomou: ");
            setQntdDoses(scan.nextInt());
        }
    }

    @Override
    public void cadastrar() {
        System.out.print("Nome do cidadão: ");
        setNome(scan.nextLine());
        System.out.print("CPF de " + getNome() + ": ");
        setCpf(scan.next());
        System.out.print("Quantidade de doses que " + getNome() + " já tomou: ");
        setQntdDoses(scan.nextInt());
    }

    public void adicionarDataDose(Date dataDoses, int indiceDose) {
        this.dataDoses.add(Calendar.getInstance());
        this.dataDoses.get(indiceDose).setTime(dataDoses);
    }

    public boolean compararDatasDoses(int indiceDose) {
        if (indiceDose == 0) {
            return true;
        }

        Calendar dataAnterior = dataDoses.get(indiceDose - 1);
        Calendar ultimaData = dataDoses.get(indiceDose);

        ultimaData.add(Calendar.MONTH, -4);

        if (ultimaData.before(dataAnterior)) {
            ultimaData.add(Calendar.MONTH, 4);
            return false;
        } else {
            ultimaData.add(Calendar.MONTH, 4);
            return true;
        }
    }
}