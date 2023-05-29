public class TestB {

    public static void main(String[] args) {

        B b = new B();
        b.protectedMethod();
        b.defaultMethod();
        b.publicMethod();
//        b.chuj();
        b.callMethod();
        System.out.println("-------------------------------------------------------------------------");

        String s1 = "Witaj";
        String s2 = "Witaj";
        System.out.println(" "+s1.equals(s2));
        System.out.println("#".repeat(1));


    }

}
