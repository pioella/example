package com.example.debugingtagex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Pioella";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View v) {
        Log.d(TAG, "버튼이 클릭 되었슴");
    }
    // 화면 밑에 6: Logcat 을 클릭하여 돋보기 그림 뒤에 TAG 인 Pioella를 적으면 보인다.
}
