package com.example.listviewex;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
//        array 나 arrayList를 이용해서 listView에 붙이는 방법


//        String[] list = {"김연아", "박지성", "손흥민"}; // 배열로도 붙일 수 있고

        list = new ArrayList<>(); // arrayList로도 붙일 수 있다.
        list.add("김연아");
        list.add("박지성");
        list.add("손흥민");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

}
