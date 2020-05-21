package com.example.chronometerex;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }

    public void onClickBtnStart(View view) {
        chronometer.start();
    }

    public void onClickBtnStop(View view) {
        chronometer.stop();
    }

    public void onClickBtnReset(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
    }
}
