package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickButton1(View view) {
        Intent intentTel = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-2803-5311"));
        startActivity(intentTel);
    }

    public void onClickButton2(View view) {
        Intent intentTel = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-9357-5262"));
        startActivity(intentTel);
    }

    public void onClickButton3(View view) {
        Intent intentTel = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
        startActivity(intentTel);
    }
}
