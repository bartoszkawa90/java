import  java.lang.Float;
import java.util.Locale;

public class FloatArithmeticMean {

    public static void main(String[] args) {

        float sum = 0;
        float length = args.length;

        if (length == 0){
            System.out.println("Brak argumentów");
        }
        else{
            for (String s : args){
                System.out.printf(Locale.US, "%10.3f%n",Float.parseFloat(s));
                sum += Float.parseFloat(s);
            }
            System.out.println("-------------");
            System.out.printf(Locale.US, "%10.3f%n",sum);

            System.out.println(" Srednia arytmetyczna:  " + sum/length);
        }

    }

}
