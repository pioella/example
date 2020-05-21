package com.example.onbackpressedex;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final long DURATION_TIME = 2000L;
    private long previousPressTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    // 1. dialog로 물어본 뒤 앱 종료.
//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("알림");
//        builder.setMessage("앱을 종료하시겠습니까?");
//        builder.setNegativeButton("취소", null);
//        builder.setPositiveButton("종료", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                android.os.Process.killProcess(android.os.Process.myPid());
//            }
//        });
//        builder.show();
//    }

    // 2. 뒤로 가기 2번 누르면 앱 종료.
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - previousPressTime <= DURATION_TIME) {
            android.os.Process.killProcess((android.os.Process.myPid()));
        } else {
            previousPressTime = System.currentTimeMillis();
            Toast.makeText(this, "뒤로가기 버튼을 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
