
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static Calendar calendar = Calendar.getInstance();

    public static void linhaHorizontal() {
        System.out.println("----------==========----------");
    }

    public static Date formatarData(String data) {
        try {
            Date dataFormatada = sdf.parse(data);
            calendar.setTime(dataFormatada);
        } catch (ParseException e) {
            System.out.println("Erro: não foi possível converter a String em Date.");
        }

        return calendar.getTime();
    }

    public static String obterDataAtual() {
        Calendar dataAtual = Calendar.getInstance();
        Date dataAtualDate = dataAtual.getTime();

        return sdf.format(dataAtualDate);
    }

    public static String formatarDataParaString(Calendar data) {
        return sdf.format(data.getTime());
    }
}
