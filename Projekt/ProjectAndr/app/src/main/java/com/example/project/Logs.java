package com.example.project;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;


public class Logs implements Runnable{

//    public static TextView logsTextView;
    public static String logs;

    public static  Logger logger = Logger.getLogger(Logs.class.getName());

    public static String tag = "";

    Logs( String className, String log, String Tag){
        logger = Logger.getLogger(className);
        logs = log;
        tag = Tag;
    }

    @Override
    public void run(){
        while(true){
            MainActivity.Delay(1);
            try {
                Process process = Runtime.getRuntime().exec("logcat -d");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                StringBuilder log = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
//                    if (line.contains(tag)){
                        log.append(line).append("\n\n");
//                    }
                }
                logs = log.toString();
//                logsTextView.setText(log.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
