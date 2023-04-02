import  java.lang.Integer;

public class ArithmeticMean {

    public static void main(String[] args) {

        int sum = 0;
        int length = args.length;

        if (length == 0){
            System.out.println("Brak argumentów");
        }
        else{
            System.out.print("Srednia arytmetyczna liczb : ");
            for(String s : args){
                System.out.print(s + ", ");
                sum += Integer.parseInt(s);
            }
            System.out.print("wynosi " + (sum/length));
            if ( sum % length != 0){
                System.out.println(", reszta : " + (sum%length));
            }
        }

    }

}
