package com.example.spinnerex;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;
    Button button1, button2;
    TextView textView1, textView2;
    String str1, str2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        initSpinnerTest1();
        initSpinnerTest2(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(str1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(str2);
            }
        });
    }

    public void initSpinnerTest1(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("서울");
        arrayList.add("대전");
        arrayList.add("대구");
        arrayList.add("부산");
        arrayList.add("광주");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str1 = parent.getSelectedItem() + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void initSpinnerTest2(Context context){
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public int getCount() {
                return super.getCount()-1;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)view.findViewById(android.R.id.text1)).setText("");
                    ((TextView)view.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }
                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("사과");
        adapter.add("딸기");
        adapter.add("바나나");
        adapter.add("키위");
        adapter.add("복숭아");
        adapter.add("과일을 선택하세요.");

        spinner2.setAdapter(adapter);
        spinner2.setSelection(adapter.getCount());
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 5) return;
                str2 = parent.getSelectedItem() + "";
                Toast.makeText(getApplicationContext(), "선택: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
