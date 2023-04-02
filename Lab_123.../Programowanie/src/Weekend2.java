import java.time.DayOfWeek;
import java.time.LocalDate;

public class Weekend2 {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        DayOfWeek weekday = date.getDayOfWeek();
        int dayVakue = weekday.getValue();
        int daysToWeekedn = 5 - dayVakue;

        if (dayVakue == 1){
            System.out.println("Dziś Poniedziałek , do weekendu pozostało "+ daysToWeekedn + " dni");
        }
        else if (dayVakue == 2){
            System.out.println("Dziś Wtorek , do weekendu pozostało "+ daysToWeekedn + " dni");
        }
        else if (dayVakue == 3){
            System.out.println("Dziś Sroda , do weekendu pozostało "+ daysToWeekedn + " dni");
        }
        else if (dayVakue == 4){
            System.out.println("Dziś Czwartek , do weekendu pozostało "+ daysToWeekedn + " dni");
        }
        else if (dayVakue == 5){
            System.out.println("Dziś Piatek , do weekendu pozostało "+ daysToWeekedn + " dni");
        }
        else{
            System.out.println("Jest weekend !");
        }

    }

}
