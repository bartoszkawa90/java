import java.util.*;
import  java.lang.Integer;


import java.util.*;

public class TestClass {

    private static int count = 0;
    private long CreationTime;
    private int UniqeNum;

    private TestClass(){
        UniqeNum = ++ count;
        CreationTime = System.currentTimeMillis();
    }
    public int GetUniqueNumber(){
        return this.count;
    }
    public long GetCreationTime(){
        return this.CreationTime;
    }
    @Override
    public  String toString(){
        return  this.GetUniqueNumber() + ". [" + this.GetCreationTime() + "]";
    }

    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Brak argumentów");
            return;
        }

        int numOfArgs = Integer.parseInt(args[0]);
        for ( int i=0; i < numOfArgs; i++){
            TestClass Test = new TestClass();
            System.out.println(Test);
        }
        System.out.println("\nLiczba obiektów : " + numOfArgs);

    }

}
