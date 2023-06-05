
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Main {

    public static String collectNews(String url){
        //"https://krknews.pl/"
        try
        {
            Document doc = Jsoup.connect(url).get();
//            System.out.println(doc.text());

            return doc.title();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return "None";
        }
    }

    public static void main(String[] args) {

        String title = collectNews("https://krknews.pl/");
        System.out.println(title);

    }
}