import java.util.Calendar;

public class ClasseObject {
    public static void main(String[] args) {
        // Instanciando
        Calendar dia1 = Calendar.getInstance();
        Calendar dia2 = Calendar.getInstance();
        Calendar diferenca = Calendar.getInstance();

        // Definindo datas
        dia1.set(2025, 11, 10, 13, 30);
        dia2.set(2025, 6, 3, 7, 30);

        // Calculando a diferença
        diferenca.set(Calendar.MONTH, dia1.get(Calendar.MONTH) - dia2.get(Calendar.MONTH));
        diferenca.set(Calendar.DAY_OF_MONTH, dia1.get(Calendar.DATE) - dia2.get(Calendar.DATE));
        diferenca.set(Calendar.HOUR_OF_DAY, dia1.get(Calendar.HOUR_OF_DAY) - dia2.get(Calendar.HOUR_OF_DAY));
        diferenca.set(Calendar.MINUTE, dia1.get(Calendar.MINUTE) - dia2.get(Calendar.MINUTE));

        // Exibindo a diferença
        System.out.println("Diferença entre as datas: ");
        System.out.println("Meses: " + diferenca.get(Calendar.MONTH));
        System.out.println("Dias: " + diferenca.get(Calendar.DAY_OF_MONTH));
        System.out.println("Horas: " + diferenca.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minutos: " + diferenca.get(Calendar.MINUTE));
    }
}
