package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Daily extends AppCompatActivity {
    int year, month, day;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        year = intent.getIntExtra("year", 0);
        month = intent.getIntExtra("month", 0);
        day = intent.getIntExtra("day", 0);

        String str = String.format("%d년 %d월 %d일", year, month, day);
        textView.setText(str);
    }

    public void onClickBtnReturn(View view) {
        finish();
    }
}
