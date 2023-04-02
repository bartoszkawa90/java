// ZAD 1 z L2

// konkretne importy
/*import  java.time.LocalDate;
import java.time.DayOfWeek;*/
import java.time.*;

public class Weekend {
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now();
        DayOfWeek weekday = date.getDayOfWeek();

        if(weekday.getValue() >= 5){
            System.out.println("Mamy Weekend");
        }
        else{
            System.out.println("Liczba dni do weekendu : " + (5 - weekday.getValue()));
        }
    }

}
