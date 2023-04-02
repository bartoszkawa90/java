import java.util.*;
import java.text.*;
import  java.time.*;
import java.time.format.DateTimeFormatter;

public class HelloDate2 {
    public static void main(String[] args)
    {
        // wersja 1
        //String CurrentDate = new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date());
        //System.out.println("Witaj! Teraz jest: " + CurrentDate);

        // wersja 2
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        LocalDateTime localDate = LocalDateTime.now();
        System.out.println("Witaj! Teraz jest: " + formatter.format(localDate));
    }
}
