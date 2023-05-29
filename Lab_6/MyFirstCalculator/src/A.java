

public class A {

    public void publicMethod(){
        System.out.println("public");
    }
    void defaultMethod(){
        System.out.println("default");
    }
    protected void protectedMethod(){
        System.out.println("protected");
    }
    private void privateMethod(){
        System.out.println("private");
    }
    public void callMethod(){
        System.out.println("From inside:");
        privateMethod();
        protectedMethod();
        defaultMethod();
        publicMethod();
    }
    public A(){
        System.out.println("Object is Created");
    }

}
