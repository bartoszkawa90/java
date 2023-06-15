package com.example.project;

import android.widget.TextView;

public class Logs implements Runnable{

    public static TextView logsTextView;
    public static boolean newLog;
    public String nextLog;

    Logs(TextView t){
        logsTextView = t;
    }

    @Override
    public void run(){
        while(true){
//            try{
//                Thread.sleep(2000);
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
            if(newLog) {
                if (logsTextView.getLineCount() * logsTextView.getLineHeight() > logsTextView.getHeight()) {
                    logsTextView.setHeight((logsTextView.getLineCount() + 1) * logsTextView.getLineHeight());
                }
                logsTextView.append(nextLog);
                newLog = false;
            }
        }

    }

    public void SetNextLog(String nlog){
        nextLog = nlog;
        newLog = true;
    }

}
