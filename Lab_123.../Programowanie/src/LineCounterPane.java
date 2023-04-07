import javax.swing.*;
import java.io.*;


public class LineCounterPane {

    public static void main(String[] args) throws IOException{

        String file_name = JOptionPane.showInputDialog("Podaj nazwe pliku .txt : ");

        if ( file_name == null || file_name.length() == 0){    // NullPointerException is handled
            System.out.println("Brak argumentu");
            return;
        }
        int lineCount = 0;
        try (BufferedReader file = new BufferedReader(new FileReader(file_name))){
            while (file.readLine() != null) {
                lineCount ++;
            }
            file.close();
            JOptionPane.showMessageDialog(null, "Liczba linii w pliku " + file_name + " wynosi " + lineCount);
            System.out.println("Liczba wierszy w pliku abc.txt wynosi: " + lineCount);
        }
        // Brak uprawnien do pliku to tez zwraca File not found
        catch (FileNotFoundException exc){
            System.err.println("Nie znaleziono pliku " + file_name);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }

    }

}
