package com.example.jose.favoritegame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    MediaPlayer intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        intro = new MediaPlayer();
        intro = MediaPlayer.create(this,R.raw.intro);
        intro.start();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task,4000);
    }
}
