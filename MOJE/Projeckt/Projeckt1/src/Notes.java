public class Notes {

    public static void main(String[] args) {

        System.out.println(new java.util.Date() );
        System.out.println(12+3+"  Witaj  "+10+1);

        int[] arr = {1,2,3,4,5};
        System.out.println(arr.length);
        String s = "ble ble";
        System.out.println(s.length());

        // EGZ zad 1
        int x = 1;
        System.out.print(x++ + ++x + x<3 && ++x>3);
        System.out.println(x);
        System.out.print(x++ + ++x + x>3 && ++x>3 );
        System.out.println(x);
        System.out.println(" ");
        x = 1;

        // K2 zad 4
        System.out.println(x++ + ++x +" x " + x++ + x);

        System.out.println(Thread.currentThread().getName());

        // K2 zad 8
//        int iter = 0;
//        for(int a=1; a<20; a+=2){    // b
//            if (a++<5) continue;     // b
//            if(a%2==0) continue;     // b
//            iter ++;
//            System.out.println(++a);
//        }

        // K2 Zad 9
        // ten dziwny printf to chodzi o to że
        int value = 4;
        for(int i=0; i<value; i++){
            System.out.print("#");
        }
        System.out.println();

        for(int i=value-2;i>0;i--){
            System.out.printf("#%" + (value-1) + "s\n", "#");
//            System.out.printf("#%3s\n", "#");
        }

        for(int i=0; i<value; i++){
            System.out.print("#");
        }

        System.out.println("\n-------------------------------------------------------------------");

    }

}
