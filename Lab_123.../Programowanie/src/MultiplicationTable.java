import java.util.*;
import java.io.*;
import java.lang.*;

public class MultiplicationTable {

    public static void main(String[] args) throws IOException{

        String path = "plik_ustawien_L5_zad3.properties";
        File f1 = new File(path);
        try {
            Properties keys = new Properties();

//       ZAPIS
//        keys.put("wartość_minimum", "1");
//        keys.put("wartość_maximum", "10");
//        keys.put("procent", "70");
//        keys.put("powtórzeń_minimum", "10");
//        keys.put("powtórzeń_maximum", "25");
//
//        FileOutputStream outputStrem = new FileOutputStream(path);
//        keys.store(outputStrem, "This is a sample properties file");

            FileInputStream inputStream = new FileInputStream(path);
            keys.load(inputStream);
            int minVal = Integer.parseInt(keys.getProperty("wartość_minimum"));
            int maxVal = Integer.parseInt(keys.getProperty("wartość_maximum"));
//            int procent = Integer.parseInt(keys.getProperty("procent"));
            float procent = Float.parseFloat(keys.getProperty("procent"));
            int minPow = Integer.parseInt(keys.getProperty("powtórzeń_minimum"));
            int maxPow = Integer.parseInt(keys.getProperty("powtórzeń_maximum"));

            Scanner scan = new Scanner(System.in);
            Random random = new Random();
            int answer = 0, RandNum1 = 0, RandNum2 = 0;
            float score = 0, goodAnswer = 0;

            for(int i=0; i<maxPow; i++){
                System.out.print("\033c");   // kazde wykonanie płetli jedzie od nowa
                RandNum1 = (random.nextInt(maxVal)+minVal);
                RandNum2 = (random.nextInt(maxVal)+minVal);

                System.out.print(RandNum1 + " * " + RandNum2 + " = ");
                answer = scan.nextInt();
                if (answer == (RandNum1 * RandNum2)){
                    goodAnswer ++;
                }
                score = ((goodAnswer*100)/(i+1));
                if(i >= (minPow-1) && ((goodAnswer*100)/(i+1)) >= procent){
                    System.out.println("Liczba prób " + (i+1) + " w tym " + (int)(goodAnswer) +
                            " poprawnych odpowiedzi co daje" +
                            " ostateczny wynik " + score + "% ~ " + Math.round(score) + "%");
                    break;
                }
            }

        }
        catch (FileNotFoundException exc){
            if(!f1.exists()){
                System.err.println("Plik " + path + " nie istnieje");
            }
            else if (f1.isDirectory()) {
                System.err.println("Plik " + path + " jest katalogiem");
            }
            else if (!f1.canRead()) {
                System.err.println("Brak uprawnien do odczytu z pliku " + path);
            }
            else{
                System.err.println("Nie znaleziono pliku " + path);
            }
        }
        catch(java.util.InputMismatchException exc){
            System.err.println("Nie podano liczby!");

        }

    }

}
