package com.example.junhyun.perfectgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = (ImageView) findViewById(R.id.logo1);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        logo.startAnimation(scale);

        TextView title = (TextView) findViewById(R.id.textView);
        title.startAnimation(scale);

        Button button1 = (Button) findViewById(R.id.swingpractice);
        button1.setOnClickListener(new View.OnClickListener()      {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), touch_main.class);
                startActivity(intent);
            }
        });

        Button game = (Button) findViewById(R.id.minigame);
        game.setOnClickListener(new View.OnClickListener()      {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), touch_main.class);
                startActivity(intent);
            }
        });
    }
}
