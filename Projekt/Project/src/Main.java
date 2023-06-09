
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.*;
import java.io.*;
import java.io.*;
import java.text.Normalizer;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;


public class Main {

    static List<String> Links = new ArrayList<>();

    static List<String > Headlines = new ArrayList<>();
    static int NumberOfNews;

    static Map<String, String > News = new HashMap<String, String >();

    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
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

                if (!Links.contains(link) && !link.equals("")){ Links.add(link); }
                if (!Headlines.contains(headline) && !headline.equals("") && headline.split(" ", 50).length > 1) { Headlines.add(headline); }
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void showArticleText(){
        for (int i=0; i<News.size(); i++){
            String link = News.entrySet().toArray()[i].toString().split("=")[1];
            try{
                Document doc = Jsoup.connect(link).get();
                Elements articles = doc.select("p");
//                System.out.println(link);
                System.out.println(articles.size());
//                for ( Element ele : articles){
//                    System.out.println(ele.text());
//                }
//                System.out.println(" ");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        collectNews();

//        System.out.println(Links.size());
//        System.out.println(Headlines.size() + "\n");

        for(String headline : Headlines){
            String headFrag = unaccent(headline.split(" ", 50)[0] + "-" +
                    headline.split(" ", 50)[1] + "-" +
                    headline.split(" ", 50)[2]).toLowerCase();
            for(String link : Links){
                if(link.contains(headFrag)){
                    News.put(headline,link);
                }
            }
        }
//        News.forEach((k,v) -> {
//            System.out.println("Headline : " + k + "\nLink : " + v);
//        });
//        NumberOfNews = News.size();
//        System.out.println(NumberOfNews);

//        System.out.println(News.entrySet().toArray()[0].toString().split("=")[1]);

        showArticleText();



    }
}