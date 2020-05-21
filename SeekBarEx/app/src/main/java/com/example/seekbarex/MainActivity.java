package com.example.seekbarex;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    int valueProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueProgress = progress;
                textView.setText("현재 볼륨 : " + valueProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText("현재 볼륨 : " + valueProgress);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "볼륨 설정 완료 : " + valueProgress, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }
}
