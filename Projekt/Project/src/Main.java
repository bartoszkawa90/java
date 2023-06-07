
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Main {

    static List<String > Naglowki = new ArrayList<>();

    public static String collectNews(){
        //"https://krknews.pl/"
        try
        {
            Document doc = Jsoup.connect("https://krknews.pl/").get();
            Elements divs = doc.getElementsByTag("a");
            Elements href = doc.getElementsByAttribute("title");
            for ( Element ele : href){
//                System.out.println(ele.textNodes());
                if(!Naglowki.contains(ele.text())){
                    Naglowki.add(ele.textNodes().toString());
                }
            }

            return doc.title();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return "None";
        }
    }

    public static void main(String[] args) {

        String title = collectNews();
        for (String s : Naglowki){
            System.out.println(s);
        }
    }
}