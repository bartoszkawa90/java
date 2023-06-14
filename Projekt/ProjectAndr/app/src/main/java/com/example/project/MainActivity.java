package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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
    public static int I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Exit button action
        this.ExitButton = (Button) this.findViewById(R.id.ExitButton);
        this.ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        // Reload button action
        this.ReloadButton = (Button) this.findViewById(R.id.ReloadButton);
        this.ReloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = WebNews.getTitle();
                Map<String, String> News = WebNews.getSetOfNews();

                TextView NewsTextView = (TextView) findViewById(R.id.WebsiteTextView);
                NewsTextView.setText(title);


                TextView articles = (TextView) findViewById(R.id.ArticlesTextView);
                articles.setText("");

                for ( int i=0; i<WebNews.numberOfArticles; i++){
                    String head = WebNews.News.entrySet().toArray()[I].toString().split("=")[0];
                    String link = WebNews.News.entrySet().toArray()[I].toString().split("=")[1];
                    I = i;

                    SpannableString spannableString = new SpannableString(
                            (I+1) + " : " + head
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
                            ds.setColor(Color.BLUE);
                            ds.setUnderlineText(false);
                        }
                    };

                    spannableString.setSpan(span1, 1, head.length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    articles.append(spannableString);
                    articles.append("\n\n");
                    articles.setMovementMethod(LinkMovementMethod.getInstance());


                }
            }
        });

        // Zacznij zbierac informacje i zaczekajz głównym wątkiem
        Thread CollectingNewsThread = new Thread(new WebNews());
        CollectingNewsThread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            System.out.println(e);
        }


        TextView articles = (TextView) findViewById(R.id.ArticlesTextView);

        for ( int i=0; i<WebNews.numberOfArticles; i++){
            String head = WebNews.News.entrySet().toArray()[I].toString().split("=")[0];
            String link = WebNews.News.entrySet().toArray()[I].toString().split("=")[1];
            I = i;

            SpannableString spannableString = new SpannableString(
                    (I+1) + " : " + head
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
                    ds.setColor(Color.BLUE);
                    ds.setUnderlineText(false);
                }
            };

            spannableString.setSpan(span1, 1, head.length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            articles.append(spannableString);
            articles.append("\n\n");
            articles.setMovementMethod(LinkMovementMethod.getInstance());
            if (I == WebNews.numberOfArticles-1) { I = 0; }

        }



//        TextView articles = (TextView) findViewById(R.id.ArticlesTextView);
//
//        SpannableString spannableString = new SpannableString(
//                WebNews.News.entrySet().toArray()[0].toString().split("=")[0]
//        );
//
//        ClickableSpan span1 = new ClickableSpan() {
//            @Override
//            public void onClick(@NonNull View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse(WebNews.News.entrySet().toArray()[0].toString().split("=")[1]));
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//
//            @Override
//            public void updateDrawState(@NonNull TextPaint ds) {
//                ds.setColor(Color.BLUE);
//                ds.setUnderlineText(false);
//            }
//        };
//
//        spannableString.setSpan(span1, 9, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        articles.setText(spannableString);
//        articles.setMovementMethod(LinkMovementMethod.getInstance());

    }
}