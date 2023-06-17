package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ArticlesWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_window);

//      plot news
        TextView articlesTextView = (TextView) this.findViewById(R.id.ArticlesTextView);
        articlesTextView.setText("");
        articlesTextView.setText(WebNews.articlesText);

    }
}