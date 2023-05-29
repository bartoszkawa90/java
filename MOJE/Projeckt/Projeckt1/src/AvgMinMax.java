public class AvgMinMax {

    public static void main(String[] args) {

        if (args.length==0){
            System.out.println("Brak argumentów");
        }
        if (args.length==1){
            System.out.println("Podano tylko jeden ardument");
        }

        double tmp = Double.parseDouble(args[0]), min, max, sum;
        min = max = sum = tmp;
        for(int i=1; i< args.length; i++){
            sum+=(tmp=Double.parseDouble(args[i]));
            if (min > tmp ) min = tmp;
            else if (max < tmp) max = tmp;
        }
        System.out.println(sum + " " + min + " " + max);
        System.out.printf("Srednia arytmetyczna wynosi: %.2f, Zakres: [%.2f, %.2f]\n",
                sum/args.length,min,max);

    }

}
