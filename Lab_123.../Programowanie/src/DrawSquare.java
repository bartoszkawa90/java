import java.util.Scanner;


public class DrawSquare {

    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Dla boku o długości : ");
            int size = scan.nextInt();

            if (size <= 0) {
                System.out.println("Podano niewłaściwą długość boku!");
                return;
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == 0 || i == size - 1) {
                        System.out.print("#");
                    } else {
                        if (j == 0 || j == size - 1) {
                            System.out.print("#");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println("");
            }
        }
        catch(java.util.InputMismatchException exc){
            System.err.println("Podana wartość nie jest liczbą!");
        }

    }

}
