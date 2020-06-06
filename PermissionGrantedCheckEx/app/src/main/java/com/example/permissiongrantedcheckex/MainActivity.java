package com.example.permissiongrantedcheckex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int permissionCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public void onBtnCheck(View view) {
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "쓰기 권한이 허용됨!(1번 방법)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "쓰기 권한이 거절됨!(1번 방법)", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBtnCheck2(View view) {
        if (checkPermission()) {
            Toast.makeText(getApplicationContext(), "쓰기 권한이 허용됨!(2번 방법)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "쓰기 권한이 거절됨!(2번 방법)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkPermission() {
        int permissionState = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }
}
