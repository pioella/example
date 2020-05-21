package com.example.handlerpostdelayedex;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Toast toast = Toast.makeText(getApplicationContext(), "취소버튼 클릭", Toast.LENGTH_LONG);  // run 안에 불르기 위해서는 final 로 선언해야함
                toast.show();
                textView.setText("");

                Handler handler = new Handler();

                // 특정 시간 딜레이 후에 오버라이드된 내용 실행
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                        textView.setText("토스트 끝");
                    }
                }, 1000); // 1000 은 1초
            }
        });

    }
}
