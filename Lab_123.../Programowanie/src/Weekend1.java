// ZAD 2 z L2

import java.time.*;


public class Weekend1 {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        DayOfWeek weekday = date.getDayOfWeek();
        int dayVakue = weekday.getValue();

        if (dayVakue == 1){
            System.out.println("Poniedziałek");
        }
        else if (dayVakue == 2){
            System.out.println("Wtorek");
        }
        else if (dayVakue == 3){
            System.out.println("Sroda");
        }
        else if (dayVakue == 4){
            System.out.println("Czwartek");
        }
        else if (dayVakue == 5){
            System.out.println("Piatek");
        }
        else{
            System.out.println("Jest weekend");
        }
    }
}
