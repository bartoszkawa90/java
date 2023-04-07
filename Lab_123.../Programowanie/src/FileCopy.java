import java.io.*;

public class FileCopy {


    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Brak argumentów programu");
            return;
        }

        String line;
        File f1 = new File(args[0]);
        try (BufferedReader readFile = new BufferedReader(new FileReader(args[0]))){
            File f2 = new File(args[1]);
            try{
                String newFilePath = args[1];
                if (f2.isDirectory()) {
                    System.out.println(args[1] + " jest katalogiem");
                    newFilePath = args[1] + "/" + args[1];
                }

                BufferedWriter writeFile = new BufferedWriter(new FileWriter(newFilePath));
                while (true) {
                    line = readFile.readLine();
                    if (line == null){
                        writeFile.close();
                        return;}
                    writeFile.write(line+"\n");
                }
                //readFile.close();
            }
            catch (FileNotFoundException exc){
                if ( !f2.exists()){
                    System.err.println("Plik do zapisu nie istnieje ");
//                    throw new FileNotFoundException("Plik nie istnieje");
                }
                else if (!f2.canWrite() && f2.isDirectory()) {
                    System.err.println("Brak wymaganych uprawnień do katalogu " + args[1]);
                }
                else if (!f2.canWrite()) {
                    System.err.println("Brak uprawnien do zapisu do pliku " + args[1]);
                }
                 else {
                    System.err.println("Nie znaleziono pliku do zapisu " + args[1]);
                }
            }
            catch (ArrayIndexOutOfBoundsException exc){
                System.err.println("Nie podano pliku do zapisu ");
            }
            catch (IOException exc){
                exc.printStackTrace();
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
            System.err.println("Nie podano pliku do zapisu ");
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
