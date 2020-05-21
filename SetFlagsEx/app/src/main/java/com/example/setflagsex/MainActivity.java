package com.example.setflagsex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //        Intent.FLAG_ACTIVITY_SINGLE_TOP : 실행된 activity가 현재의 activity이면 재사용
    //        Intent.FLAG_ACTIVITY_CLEAR_TOP : activity의 하위 activity를 모두 제거
    //        Intent.FLAG_ACTIVITY_NEW_TASK : activity를 새롭게 생성
    //        아직 정확하게 무슨 모르겠다.

    public void mainDefault(View v) {
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(in);
    }

    public void mainSingleTop(View v) {
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(in);
    }

    public void mainClearTop(View v) {
        Intent in = new Intent(getApplicationContext(), SubActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
    }

    public void mainNewTask(View v) {
        Intent in = new Intent(getApplicationContext(), SubActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(in);
    }
}
