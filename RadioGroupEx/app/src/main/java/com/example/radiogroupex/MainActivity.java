package com.example.radiogroupex;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    RadioGroup imageGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageGroup = findViewById(R.id.imageGroup);

        imageGroup.check(R.id.radioCat);
        imageView.setImageResource(R.drawable.cat);
        imageGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioCat) {
                    imageView.setImageResource(R.drawable.cat);
                } else if (checkedId == R.id.radioDog) {
                    imageView.setImageResource(R.drawable.dog);
                } else if (checkedId == R.id.radioLion) {
                    imageView.setImageResource(R.drawable.lion);
                } else if (checkedId == R.id.radioRabbit) {
                    imageView.setImageResource(R.drawable.rabbit);
                } else if (checkedId == R.id.radioBear) {
                    imageView.setImageResource(R.drawable.bear);
                }
            }
        });
    }
}
