package com.example.toastex;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnToast(View view) {
        Toast myToast = Toast.makeText(this.getApplicationContext(),"", Toast.LENGTH_SHORT);

        myToast.setGravity(Gravity.CENTER, 0,0);
        View toastLayout = getLayoutInflater().inflate(R.layout.toast_layout, null);

        myToast.setView(toastLayout);
        myToast.show();
    }
}
