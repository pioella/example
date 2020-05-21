package com.example.minustest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    byte hp;
    TextView textView;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        str = "alive";
        hp = 5;

        textView.setText(str + " : " + hp);

    }

    public void onClickBtnShoot(View view) {
        if (hp > 0) minus();
        if (hp < 0) hp = 0;
        if (hp == 0 ) str = "dead!";
        else str = "alive!";
        textView.setText(str + " : " + hp);
    }

    public void minus() {
        hp -= 1;
    }
}
