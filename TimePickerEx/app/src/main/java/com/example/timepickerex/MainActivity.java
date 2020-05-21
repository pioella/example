package com.example.timepickerex;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.timePicker);
        textView = findViewById(R.id.textView);
    }

    public void onClickBtn(View view) {
        int hour, min;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
            min = timePicker.getMinute();
        } else {
            hour = timePicker.getCurrentHour();
            min = timePicker.getCurrentMinute();
        }

        String ampm = hour<12 ? "AM" : "PM";
        if (hour > 12) hour = hour - 12;

        String strTime = String.format("%s %d시 %d분", ampm, hour, min);
        textView.setText(strTime);

    }
}
