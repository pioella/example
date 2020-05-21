package com.example.radiogroupex2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    RadioGroup imageGroup;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageGroup = findViewById(R.id.imageGroup);
        btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myDebug", imageGroup.getCheckedRadioButtonId() +"");
                int id = imageGroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radioDog:
                        imageView.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioCat:
                        imageView.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioLion:
                        imageView.setImageResource(R.drawable.lion);
                        break;
                    case R.id.radioRabbit:
                        imageView.setImageResource(R.drawable.rabbit);
                        break;
                    case R.id.radioBear:
                        imageView.setImageResource(R.drawable.bear);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물사진을 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
