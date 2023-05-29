public class B extends A{

    public void publicMethod(){
        System.out.println("new public");
    }
    void defaultMethod(){
        System.out.println("new default");
    }
    protected void protectedMethod(){
        System.out.println("new protected");
    }
    private void privateMethod(){
        System.out.println("new private");
    }

    public void chuj(){
        privateMethod();
    }
    public B(){
        System.out.println("Object B is Created");
    }

}
