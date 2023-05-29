public class Person {
    public int age;
    public String name;
    public String surname;
    public static  String rasa;   // zmienna static dostępna cały czas tak po prostu albo jako atrybut : rasa albo Tom.rasa
    static{                       // inicjalizacja zmiennych static , mozna w tym bloku różne rzeczy porobić ze zmiennymi static
        System.out.println("Inicjalizacja zmiennych static");
        rasa = "czlowiek";
    }



    public Person(){
        age = 0;
        name = "";
        surname = "";
    }
    public Person(int age, String name, String surname){
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

//    public String vl(int a){
//        return "daw";
//    }
//    public int vl(int a){
//        return 2;
//    }



    public String GetName(){
        return name;
    }
    public void SetName(String newName){
        name = newName;
    }
    public static int Add(int a, int b){    // statyczna metoda może byc używana tak po prostu albo jako metoda obiektu
        return a+b;                         //   np. Add(2,2)  albo Tom.Add(2,2)
    }
    static int n(){
        System.out.println("dadwadw");
        return 20;
    }




    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        System.out.println(rasa);
        System.out.println(Add(2,2));

        Person Tom  = new Person();
        System.out.println(Tom.GetName());
        Tom.SetName("Tom");
        System.out.println(Tom.GetName());

        Person Adam = new Person(15,"Adam","Kowalski");
        System.out.println(Adam.GetName());

        System.out.println("-------------------------------------------------------------------------");

        System.out.println(new java.sql.Date(0));

        int val = 10;
        System.out.println(val++ + val);
        System.out.println(val);

        //EGZ zad 11
        System.out.println("\n EGZ zad 11");
        CDE: for(int z=0; z<6; z += 5){

            ABC: for(int y=z; y<20; y+=2){

                for(int x = 1; x<y; x++){
                    if(x++ < 5) continue ;
                    if(x%5 == 0 || y>7) continue ABC;
                    System.out.println(++x);
                }
                System.out.println(z+y);
                if (y+z > 16) break CDE;
            }

        }

        String[] a = {"dawd", "daadd", "aaaaa"};
        for(String s: a){
            System.out.println(s);}




    }
}