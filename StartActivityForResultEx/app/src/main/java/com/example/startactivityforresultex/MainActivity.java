package com.example.startactivityforresultex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static final int USER_FORM = 1004;
    TextView textID, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textID = findViewById(R.id.textID);
        textPassword = findViewById(R.id.textPassword);

    }

    public void onClickButton(View view) {
        Intent intent = new Intent(getApplicationContext(), UserForm.class);
        startActivityForResult(intent, USER_FORM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == USER_FORM) {
           if (resultCode == RESULT_OK) {
               Toast.makeText(getApplicationContext(), "입력되었습니다." ,Toast.LENGTH_SHORT).show();
               textID.setText(": " + data.getStringExtra("id"));
               textPassword.setText(": " + data.getStringExtra("password"));
           } else if (resultCode == RESULT_CANCELED) {
               Toast.makeText(getApplicationContext(), "취소되었습니다." ,Toast.LENGTH_SHORT).show();
           }
        }
    }
}
