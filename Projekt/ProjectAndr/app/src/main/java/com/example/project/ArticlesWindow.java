package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
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

        MainActivity.Log.info("Mine info : Articles window opened ");
        // Setup background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);

        // setup articles in textview
        TextView articlesTextView = (TextView) this.findViewById(R.id.ArticlesTextView);
        articlesTextView.setText(WebNews.articlesText);

    }
}