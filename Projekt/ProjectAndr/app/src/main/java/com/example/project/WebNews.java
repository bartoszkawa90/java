package com.example.project;


import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.*;
//import java.net.MalformedURLException;

public class WebNews implements Runnable {

    public static String title;
    WebNews(){
        title = "";
    }


    public static String collectNews(){
    //
        String string;
        try
        {
            Document doc = Jsoup.connect("https://krknews.pl/").get();
//            title = doc.getElementsByTag("parse").attr("title");
            string = doc.title();

            return string;
        }
        catch(IOException e)
        {
            return string="None";
        }

    }

    @Override
    public void run(){
        // Wątek zbierający informacje odświerzany co 10s
        while(true){
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            title = collectNews();
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

}
