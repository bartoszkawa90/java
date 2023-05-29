public class AritMean {

    public static void main(String[] args) {

        if (args.length==0){
            System.out.println("Brak argumentów");
        }
        if (args.length==1){
            System.out.println("Podano tylko jeden ardument");
        }

        int sum = Integer.parseInt(args[0]);
        String wynik = "Średnia arytmetyczna z liczb : " + sum;
        for (int i=1; i<args.length; i++){
            wynik += "," + args[i];
            sum += Integer.parseInt(args[i]);
        }


        System.out.println(wynik+" wynosi " +sum/args.length +     (sum%args.length==0? "":"  , reszta: " +sum%args.length)     );

    }

}
