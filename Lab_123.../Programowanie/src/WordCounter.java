import javax.swing.*;
import java.io.*;


public class WordCounter {

    public static void main(String[] args) throws IOException{

//        String file_name = JOptionPane.showInputDialog("Podaj nazwe pliku .txt : ");

        if ( args[0] == null || args[0].length() == 0){    // NullPointerException is handled
            System.out.println("Brak argumentów programu ");
            return;
        }
        File f1 = new File(args[0]);
        int lineCount = 0;
        int charCount = 0;
        int wordCount = 0;
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))){
            while (file.readLine() != null) {
                lineCount ++;
            }
            file.close();

            for (String arg : args){
                if(arg.contains("-") && arg.contains("l")){
                    JOptionPane.showMessageDialog(null, "Liczba linii w pliku " + args[0] + " wynosi " + lineCount);
                    System.out.println("Liczba wierszy w pliku abc.txt wynosi: " + lineCount);
                }
            }

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
