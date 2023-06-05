package com.example.project;

import static com.example.project.WebNews.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    Button ExitButton,ReloadButton;

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
                TextView NewsTextView = (TextView)findViewById(R.id.NewsTextView);
                NewsTextView.setText(title);
            }
        });

        Thread CollectingNewsThread = new Thread(new WebNews());
        CollectingNewsThread.start();



    }
}