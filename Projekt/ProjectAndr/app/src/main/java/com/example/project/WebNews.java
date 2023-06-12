package com.example.project;


import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.net.MalformedURLException;

public class WebNews implements Runnable {

    public static String title;
    static List<String> Links = new ArrayList<>();
    static List<String > Headlines = new ArrayList<>();
    static Map<String, String > News = new HashMap();

    static int numberOfArticles;
    static boolean informationCollected;

    WebNews(){
        title = "";
    }

    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static void collectNews(){
        try
        {
            //Clear
            Headlines.clear();
            Links.clear();
            News.clear();

            Document doc = Jsoup.connect("https://krknews.pl/").get();
            title = doc.title();
            Elements articles = doc.select("a");

            for ( Element ele : articles){
                Document art = Jsoup.parse(String.valueOf(ele));
                String headline = art.getAllElements().attr("title");
                String link = art.getAllElements().attr("href");

                if (!Links.contains(link) && !link.equals("")){ Links.add(link); }
                if (!Headlines.contains(headline) && !headline.equals("") && headline.split(" ", 50).length > 1) { Headlines.add(headline); }
            }

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
            numberOfArticles = News.size();
            informationCollected = true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void run(){
        // Wątek zbierający informacje odświerzany co 10s
        while(true){
            if(informationCollected) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            collectNews();
        }
    }

    public static String getTitle(){
        if(title.isEmpty()){
            return "¯\\_(ツ)_/¯";
        }
        else{
            return title;
        }
    }

    public static Map getSetOfNews(){
        try{
            return News;
        }
        catch (Exception e){
            e.printStackTrace();
            News.put("Brak Newsów", "Brak Newsów");
            return News;
        }
    }

}
