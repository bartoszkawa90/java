public class K2_Zad_6 extends Thread {

    public K2_Zad_6(String string){
        super(string);
    }

    public void run(){
        System.out.println("This thread: (" + this.getName() + ")" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("main method - thread:" + Thread.currentThread().getName());
        new K2_Zad_6("Ann").start();
        new K2_Zad_6("Tom").start();
        new K2_Zad_6("Eva").run();
    }
}
