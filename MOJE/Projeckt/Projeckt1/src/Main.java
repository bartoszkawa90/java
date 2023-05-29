//public class Main {
//
//    public static void main(String[] args) {
//
//        Watek thread1 = new Watek("Watek 1");
//        Thread thread2 = new Watek("Watek 2");
//        new Watek("Watek 3").start();
//
//        thread1.start();
//        thread2.start();
//
//    }
//
//}
//
//import java.util.Scanner;
//
//class Main {
//    public static void main(String[] args) {
//        Scanner myObj = new Scanner(System.in);
//
//        System.out.println("Enter name, age and salary:");
//
//        // String input
//        String name = myObj.nextLine();
//
//        // Numerical input
//        int age = Integer.parseInt(myObj.nextLine());
//        double salary = myObj.nextDouble();
//
//        // Output input by user
//        System.out.println("Name: " + name);
//        System.out.println("Age: " + age);
//        System.out.println("Salary: " + salary);
//    }
//}


 //ExecutorService

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Watek("Watek 1"));
        pool.submit(new Watek("Watek 2"));
        pool.submit(new Watek("Watek 3"));
//        pool.submit(new Watek());
//        pool.submit(new Watek());
//        pool.submit(new Watek());
//        pool.submit(new Watek());
        pool.shutdown();   // wyłącza po zakończeniu aktualnie jeszcze działających wątków
//        pool.submit(new Watek("Watek 4"));
    }

}
