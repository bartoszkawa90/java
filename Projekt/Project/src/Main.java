
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


public class Main {

    static List<String> Links = new ArrayList<>();

    static List<String > Headlines = new ArrayList<>();


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

//                Links.add(link);
//                Headlines.add(headline);
                if (!Links.contains(link)){ Links.add(link); }
                if (!Headlines.contains(headline) && !headline.equals("")) { Headlines.add(headline); }

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

        System.out.println(Headlines.get(40).split(" ",0)[0] + "\n");

        while (LinkIterator.hasNext() && HeadlineIterator.hasNext() ){
//            System.out.println(LinkIterator.next());
//            System.out.println(HeadlineIterator.next());
            System.out.println(HeadlineIterator.next().split(" ",1)[0]);
        }

    }
}