package com.example.setflagsex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void subDefault(View v) {
        Intent in = new Intent(getApplicationContext(), SubActivity.class);
        startActivity(in);
    }

    public void subSingleTop(View v) {
        Intent in = new Intent(getApplicationContext(), SubActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(in);
    }

    public void subClearTop(View v) {
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
    }

    public void subNewTask(View v) {
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(in);
    }
}
