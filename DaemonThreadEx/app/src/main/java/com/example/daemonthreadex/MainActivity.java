package com.example.daemonthreadex;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WorkThread workThread = new WorkThread();
    static public boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        workThread = new WorkThread();
        running = true;
        workThread.setDaemon(true);
        workThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
    }
}

class WorkThread extends Thread {
    @Override
    public void run() {
        for (int i=1 ; i<=20 && MainActivity.running ; i++) {
            try {
                Thread.sleep(1000);
                Log.d("Pioella", "time : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


