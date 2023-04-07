//import javax.swing.*;
import java.io.*;
import java.util.regex.Pattern;

public class WordCounter {

    private static Pattern pattern = Pattern.compile("\\s{2,}");

    public static void main(String[] args) throws IOException{

        // potrzebne zeby dawac opcje przed nazwa pliku
        String fileName = "";
        int lineFlag = 0;
        int wordFlag = 0;
        int charFlag = 0;

        for (String arg : args){
            if(arg.contains("-") && arg.contains("l")){
                lineFlag ++;
            }
            if(arg.contains("-") && arg.contains("w")){
                wordFlag ++;
            }
            if(arg.contains("-") && arg.contains("c")){
                charFlag ++;
            }
            if(!arg.contains("-")){
                fileName = arg;
            }
        }
        if (args.length == 0 || fileName.equals("") || (lineFlag == 0 && wordFlag == 0 && charFlag == 0 )){    // NullPointerException is handled
            System.out.println("Brak argumentów programu ");
            return;
        }

        File f1 = new File(fileName);
        String line = "";
        int lineCount = 0;
        int charCount = 0;
        int wordCount = 0;

        try (BufferedReader file = new BufferedReader(new FileReader(fileName))){
            while (true) {
                line = file.readLine();
                if (line == null) {
                    file.close();
                    break;
                }
                charCount += line.replaceAll("\\s", "").length();
                wordCount += pattern.matcher(line).replaceAll(" ").split(" ").length;
                lineCount ++;
            }

            if(lineFlag > 0){
                System.out.println("wierszy : " + lineCount);
            }
            if(wordFlag > 0){
                System.out.println("znaków : " + wordCount);
            }
            if(charFlag > 0){
                System.out.println("słów : " + charCount);
            }
        }
        catch (FileNotFoundException exc){
            if(!f1.exists()){
                System.err.println("Plik " + fileName + " nie istnieje");
//                JOptionPane.showMessageDialog(null, "Plik  "+ fileName + " nie istnieje");
            }
            else if (f1.isDirectory()) {
                System.err.println("Plik " + fileName + " jest katalogiem");
//                JOptionPane.showMessageDialog(null, "Plik " + fileName + " jest katalogiem");
            }
            else if (!f1.canRead()) {
                System.err.println("Brak uprawnien do odczytu z pliku " + fileName);
//                JOptionPane.showMessageDialog(null, "rak uprawnien do odczytu z pliku " + fileName);
            }
            else{
                System.err.println("Nie znaleziono pliku " + fileName);
//                JOptionPane.showMessageDialog(null, "Nie znaleziono pliku " + fileName);
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
