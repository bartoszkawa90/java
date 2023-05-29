
//   Implementacja interfejsu Runnable
//     Różnica polega na tym że dziedzicząc po Thread nie możemy już dziedziczyć po innych klasach
//       ale za to mamy więcej troszke roboty w używaniu wątków

public class Watek extends Thread implements Runnable{     //   Runnable to jest właśnie interfejs który dziedziczy jakoś po Thread

    public Watek(String s){
        super(s);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "  " + Thread.currentThread().getName());
    }


}

//  Dziedziczenie po Thread

//public class Watek extends Thread{
//
//    @Override
//    public void run() {
//        for(int i=0; i<100;i++){
//            System.out.println(i + ". ID: " + Thread.currentThread().getId());
//            System.out.println("name : " + Thread.currentThread().getName());
//        }
//    }
//}
