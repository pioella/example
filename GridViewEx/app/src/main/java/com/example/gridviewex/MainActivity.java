package com.example.gridviewex;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        MyGridAdapter myGridAdapter = new MyGridAdapter(this);
        gridView.setAdapter(myGridAdapter);
    }
}
