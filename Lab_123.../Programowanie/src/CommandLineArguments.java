public class CommandLineArguments {

    public static void main(String[] args) {

        int count = 1;
        if (args.length == 0){
            System.out.println("Brak argumentów");
        }
        else{
            for ( String s : args){
                System.out.println(count + ". " + s);
                count ++;
            }
        }
    }

}
