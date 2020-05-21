package com.example.musicex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.piano_man);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void onClickStop(View view) {
        mediaPlayer.stop();
    }
}
