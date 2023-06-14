package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    Button ExitButton,ReloadButton;

//    public static String fix(String head, String link){
//        int maxLength = 60;
//        char[] charHead = head.toCharArray();
//        if ( head.length() >= maxLength ){
//            for(int i=0; i< (int) head.length()/maxLength; i++){
//
//            }
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Exit button action
        this.ExitButton = (Button)this.findViewById(R.id.ExitButton);
        this.ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        // Reload button action
        this.ReloadButton = (Button)this.findViewById(R.id.ReloadButton);
        this.ReloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = WebNews.getTitle();
                Map<String, String> News = WebNews.getSetOfNews();

                TextView NewsTextView = (TextView)findViewById(R.id.WebsiteTextView);
                NewsTextView.setText(title);

//                TextView Logs = (TextView)findViewById(R.id.LogsTextView);
//                Logs.setText(WebNews.numberOfArticles+"");
            }
        });

        // Start Thread for collecting news
        Thread CollectingNewsThread = new Thread(new WebNews());
        CollectingNewsThread.start();

        // Thread main starts 10s after collecting news
        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception e){
            System.out.println(e);
        }

        // Table
        TableLayout stk = (TableLayout) findViewById(R.id.tableLayout);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText("               Article Title ");
        tv0.setTextColor(Color.BLACK);
        tv0.setTextSize(18);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("                   Link ");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(18);
        tbrow0.addView(tv1);
        stk.addView(tbrow0);

        for (int i = 0; i < WebNews.numberOfArticles; i++) {
            String head = Integer.toString(i+1) + " : " + WebNews.News.entrySet().toArray()[i].toString().split("=")[0];
            String link = Integer.toString(i+1) + " : " + WebNews.News.entrySet().toArray()[i].toString().split("=")[1];

            TextView Logs = (TextView)findViewById(R.id.LogsTextView);
            if(i == WebNews.numberOfArticles-1) { Logs.setText(head); }

            TableRow tbrow = new TableRow(this);
            TextView headline1 = new TextView(this);
            headline1.setText(head);
            headline1.setTextColor(Color.BLACK);
            headline1.setTextSize(14);
            tbrow.addView(headline1);

//            TextView link1 = new TextView(this);
//            link1.setText(link);
//            link1.setTextColor(Color.BLACK);
//            link1.setTextSize(14);
//            tbrow.addView(link1);
            stk.addView(tbrow);
        }
    }


//            TableRow tbrow = new TableRow(this);
//            TextView t1v = new TextView(this);
//            t1v.setText("" + i);
//            t1v.setTextColor(Color.BLACK);
//            t1v.setGravity(Gravity.CENTER);
//            tbrow.addView(t1v);
//
//            TextView t2v = new TextView(this);
//            t2v.setText("Product " + i);
//            t2v.setTextColor(Color.BLACK);
//            t2v.setGravity(Gravity.CENTER);
//            tbrow.addView(t2v);
//            TextView t3v = new TextView(this);
//            t3v.setText("Rs." + i);
//            t3v.setTextColor(Color.BLACK);
//            t3v.setGravity(Gravity.CENTER);
//            tbrow.addView(t3v);
//            TextView t4v = new TextView(this);
//            t4v.setText("" + i * 15 / 32 * 10);
//            t4v.setTextColor(Color.BLACK);
//            t4v.setGravity(Gravity.CENTER);
//            tbrow.addView(t4v);
//            stk.addView(tbrow);
//        }


}