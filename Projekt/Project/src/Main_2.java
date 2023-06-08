
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;


public class Main_2 {

    static List<String> Links = new ArrayList<>();

    static List<String > Headlines = new ArrayList<>();

    public static List<String> removeDuplicates(List<String> S){
        List<String> New = new ArrayList<>();

        for(String s: S){
            if(!New.contains(s)){
                New.add(s);
            }
        }
        return New;
    }

    public static void collectNews(){
        //"https://krknews.pl/"
        try
        {
            Document doc = Jsoup.connect("https://krknews.pl/").get();
            Elements articles = doc.select("a");

            for ( Element ele : articles){
                Document art = Jsoup.parse(String.valueOf(ele));
                String headline = art.getAllElements().attr("title");
                String link = art.getAllElements().attr("href");

                if (!Links.contains(link)){ Links.add(link); }
                if (!Headlines.contains(headline)) { Headlines.add(headline); }

            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        collectNews();

        Iterator<String> LinkIterator = Links.iterator();
        Iterator<String> HeadlineIterator = Headlines.iterator();

        while (LinkIterator.hasNext() && HeadlineIterator.hasNext() ){
            System.out.println(LinkIterator.next());
            System.out.println(HeadlineIterator.next());
        }

    }
}