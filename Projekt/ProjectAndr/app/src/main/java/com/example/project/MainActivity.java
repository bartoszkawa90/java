package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import java.util.Map;

// Do logów
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.Level;


public class MainActivity extends AppCompatActivity {

    public Button ExitButton,ReloadButton,ViewAllArticlesButton;
    public static TextView logsTextView, websiteTitle, articles;
    public static int I;
    public static String Tag = " Mine ";
    public static final Logger Log = Logger.getLogger(MainActivity.class.getName());
    public static void Logging(String tag){
//        try {
//            Process process = Runtime.getRuntime().exec("logcat -d");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            StringBuilder log = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                if (line.contains(tag)){
//                    log.append(line).append("\n\n");
//                }
//            }
//            MainActivity.Log.info("Mine info : Logs collected from logger ");
//            logsTextView.setText(log.toString());
//        } catch (IOException e) {
//            MainActivity.Log.severe("Mine exception : Failed to collect logs ");
//        }
        try {
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            SpannableStringBuilder log = new SpannableStringBuilder();
//            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(tag)){
                    SpannableString text = new SpannableString(line);
                    if(line.contains("info")){
                        text.setSpan(new ForegroundColorSpan(Color.CYAN), 0, text.length(), 0);
                    } else if (line.contains("exception")) {
                        text.setSpan(new ForegroundColorSpan(Color.RED), 0, text.length(), 0);
                    }
                    log.append(text).append("\n\n");
                }
            }
            MainActivity.Log.info("Mine info : Logs collected from logger ");
            logsTextView.setText(log);
        } catch (IOException e) {
            MainActivity.Log.severe("Mine exception : Failed to collect logs ");
        }
    }

    public static void Delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        clearLogs();
        // TextViews
        logsTextView = (TextView) this.findViewById(R.id.LogsTextView);
        websiteTitle = (TextView) findViewById(R.id.WebsiteTextView);
        articles = (TextView) findViewById(R.id.ArticlesTextView);

        // Setup background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);

        // Exit button action
        this.ExitButton = (Button) this.findViewById(R.id.ExitButton);
        this.ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.Log.info("Mine info : Exiting application ");
                finish();
                System.exit(0);
            }
        });
        // View all articles // New window Button
        this.ViewAllArticlesButton = (Button) this.findViewById(R.id.ViewAllArticles);
        this.ViewAllArticlesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.Log.info("Mine info : Entering new window to view all articles ");
                Intent articlesWindow = new Intent(MainActivity.this, ArticlesWindow.class);
                startActivity(articlesWindow);
            }
        });
        // Reload button action
        this.ReloadButton = (Button) this.findViewById(R.id.ReloadButton);
        this.ReloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.Log.info("Mine info : Reloading logs and information ");
                Logging(Tag);
                String title = WebNews.getTitle();
                Map<String, String> News = WebNews.getSetOfNews();

                websiteTitle.setText(title);

                Delay(1);
                articles.setText("");

                try{
                    for ( int i=0; i<WebNews.numberOfArticles; i++){
                        String head = WebNews.News.entrySet().toArray()[i].toString().split("=")[0];
                        String link = WebNews.News.entrySet().toArray()[i].toString().split("=")[1];
                        I = i;

                        SpannableString spannableString = new SpannableString(
                                (i+1) + " : " + head
                        );

                        ClickableSpan span1 = new ClickableSpan() {
                            @Override
                            public void onClick(@NonNull View view) {
                                Intent intent = new Intent(Intent.ACTION_VIEW,
                                        Uri.parse(link));
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }

                            @Override
                            public void updateDrawState(@NonNull TextPaint ds) {
                                ds.setColor(Color.YELLOW);
                                ds.setUnderlineText(false);
                            }
                        };

                        spannableString.setSpan(span1, 1,
                                spannableString.length(),
                                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                        if (articles.getLineCount() * articles.getLineHeight() > articles.getHeight()) {
                            articles.setHeight((articles.getLineCount() + 2) * articles.getLineHeight());
                        }
                        articles.append(spannableString);
                        articles.append("\n\n");
                        articles.setMovementMethod(LinkMovementMethod.getInstance());
                        if (I == WebNews.numberOfArticles) { I = 0; }
                    }
                }
                catch (java.lang.ArrayIndexOutOfBoundsException e){
                    MainActivity.Log.severe("Main exception : Failed to extracted News to " +
                            "TextView");
                }
            }
        });

        // Logs
        Logging(Tag);
//        Thread Logs = new Thread(new Logs(MainActivity.class.getName(), Logi, ""));
//        Logs.start();
//        Delay(1);

        // Zacznij zbierac informacje i zaczekajz głównym wątkiem
        Thread CollectingNewsThread = new Thread(new WebNews());
        CollectingNewsThread.start();
        MainActivity.Log.info("Mine info : Thread for collecting new started ");
        Delay(3);

        websiteTitle.setText(WebNews.getTitle());
        articles.setText("");

        try{
            for ( int i=0; i<WebNews.numberOfArticles; i++){
                String head = WebNews.News.entrySet().toArray()[i].toString().split("=")[0];
                String link = WebNews.News.entrySet().toArray()[i].toString().split("=")[1];
                I = i;

                SpannableString spannableString = new SpannableString(
                        (i+1) + " : " + head
                );

                ClickableSpan span1 = new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(link));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }

                    @Override
                    public void updateDrawState(@NonNull TextPaint ds) {
                        ds.setColor(Color.YELLOW);
                        ds.setUnderlineText(false);
                    }
                };

                spannableString.setSpan(span1, 1,
                        spannableString.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                if (articles.getLineCount() * articles.getLineHeight() > articles.getHeight()) {
                    articles.setHeight((articles.getLineCount() + 2) * articles.getLineHeight());
                }
                articles.append(spannableString);
                articles.append("\n\n");
                articles.setMovementMethod(LinkMovementMethod.getInstance());
                if (I == WebNews.numberOfArticles) { I = 0; }

            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e){
            MainActivity.Log.severe("Main exception : Failed to extracted News to " +
                    "TextView");
        }
    }
}