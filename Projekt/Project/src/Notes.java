import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notes {

    public static List<String> removeDuplicates(List<String> S){
        List<String> New = new ArrayList<>();

        for(String s: S){
            if(!New.contains(s)){
                New.add(s);
            }
        }
        return New;
    }

    public static void main(String[] args) {

        List<String> Links = new ArrayList<>();
        Links.add("dawdwa");
        Links.add("aaaa");
        Links.add("1233");
        Links.add("aaaa");
        for(String s : Links){
            System.out.println(s);
        }

        System.out.println(" ");
        Links = new Notes().removeDuplicates(Links);

        for(String S : Links){
            System.out.println(S);
        }

    }

}
