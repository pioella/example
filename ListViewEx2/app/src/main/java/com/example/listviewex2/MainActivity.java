package com.example.listviewex2;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity { // extends AppCompatActivity 에서 ListActivity 로 변경
    String[] fruit = {"사과", "수박", "바나나", "오렌지", "딸기", "천혜향", "레몬", "키위", "복숭아"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);  // 삭제

        String[] city = getResources().getStringArray(R.array.city);  // array.xml 에서 데이터를 불러서 배열을 만듦
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, city);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruit);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
        String item = getListAdapter().getItem(position).toString();
        Toast.makeText(getApplicationContext(), item + " 선택되었음", Toast.LENGTH_SHORT).show();
    }
}

// 나중에 ListActivity 상속 받아서 CustomList를 만들어 보자.
