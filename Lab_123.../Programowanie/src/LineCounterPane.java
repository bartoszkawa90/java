import javax.swing.*;
import java.io.*;


public class LineCounterPane {

    public static void main(String[] args) throws IOException{

        String fileName = JOptionPane.showInputDialog("Podaj nazwe pliku .txt : ");

        if ( fileName == null || fileName.length() == 0){    // NullPointerException is handled
            System.out.println("Brak argumentu");
            return;
        }

        File f1 = new File(fileName);
        int lineCount = 0;
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))){
            while (file.readLine() != null) {
                lineCount ++;
            }
            file.close();
            JOptionPane.showMessageDialog(null, "Liczba linii w pliku " + fileName + " wynosi " + lineCount);
            System.out.println("Liczba wierszy w pliku abc.txt wynosi: " + lineCount);
        }
        catch (FileNotFoundException exc){
            if(!f1.exists()){
                System.err.println("Plik  nie istnieje");
                JOptionPane.showMessageDialog(null, "Plik  nie istnieje");
            }
            else if (f1.isDirectory()) {
                System.err.println("Plik  jest katalogiem");
                JOptionPane.showMessageDialog(null, "Plik  jest katalogiem");
            }
            else if (!f1.canRead()) {
                System.err.println("Brak uprawnien do odczytu z pliku ");
                JOptionPane.showMessageDialog(null, "rak uprawnien do odczytu z pliku");
            }
            else{
                System.err.println("Nie znaleziono pliku ");
                JOptionPane.showMessageDialog(null, "Nie znaleziono pliku");
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
