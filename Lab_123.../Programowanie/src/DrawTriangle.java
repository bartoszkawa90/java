import java.util.InputMismatchException;
import java.util.Scanner;


public class DrawTriangle {

    public static void main(String[] args) throws InputMismatchException {

        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Dla wysokości trójkąta wynoszącej : ");
            int hight = scan.nextInt();

            if (hight <= 0) {
                throw new java.util.InputMismatchException();
            }

            for (int j=hight; j>0; j--){
                System.out.print(" ".repeat(j-1));
                System.out.print("#".repeat(2*(hight-j)+1));
                System.out.println("");
            }

        }
        catch(java.util.InputMismatchException exc){
            System.err.println("Podano niewłaściwą wysokość!");
        }

    }

}