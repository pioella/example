package com.example.buttonex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "확인버튼 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClickBtnCancel(View v) {
        Toast.makeText(getApplicationContext(), "취소버튼 클릭", Toast.LENGTH_SHORT).show();
    }
}
