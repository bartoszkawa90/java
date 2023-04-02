import java.io.*;

public class LineCounter {

    public static void main(String[] args) throws  IOException{

        if (args.length == 0){
            System.out.println("Brak argumentów");
            return;
        }
        int lineCount = 0;
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))){
            while (file.readLine() != null) {
                lineCount ++;
            }
            file.close();
            System.out.println("Liczba wierszy w pliku abc.txt wynosi: " + lineCount);
        }
        // Brak uprawnien do pliku to tez zwraca File not found
        catch (FileNotFoundException exc){
            System.err.println("Nie znaleziono pliku " + args[0]);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }

}
