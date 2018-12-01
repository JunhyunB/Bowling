package com.example.junhyun.perfectgame;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class touch_main extends AppCompatActivity {
    SoundPool soundpool;
    int sound;
    @Override
    protected void onCreate(Bundle savedInstanceStace) {
        super.onCreate(savedInstanceStace);
        setContentView(R.layout.activity_touch_main);

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundpool.load(this, R.raw.sound1, 1);
        soundpool.play(sound, 1, 1, 0, 1, 1);

        ImageButton button2 = (ImageButton) findViewById(R.id.touchB1);
        button2.setOnClickListener(new View.OnClickListener()      {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lane.class);
                startActivity(intent);
            }
        });
    }
}