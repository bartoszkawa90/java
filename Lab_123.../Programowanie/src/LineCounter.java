import java.io.*;

public class LineCounter {

    public static void main(String[] args) throws  IOException{

        if (args.length == 0){
            System.out.println("Brak argumentów");
            return;
        }

        File f1 = new File(args[0]);
        int lineCount = 0;
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))){
            while (file.readLine() != null) {
                lineCount ++;
            }
            file.close();
            System.out.println("Liczba wierszy w pliku abc.txt wynosi: " + lineCount);
        }
        catch (FileNotFoundException exc){
            if(!f1.exists()){
                System.err.println("Plik " + args[0] + " nie istnieje");
            }
            else if (f1.isDirectory()) {
                System.err.println("Plik " + args[0] + " jest katalogiem");
            }
            else if (!f1.canRead()) {
                System.err.println("Brak uprawnien do odczytu z pliku " + args[0]);
            }
            else{
                System.err.println("Nie znaleziono pliku " + args[0]);
            }
        }
        catch (ArrayIndexOutOfBoundsException exc){
            System.err.println("Nie podano pliku do odczytania ");
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }

}
