package com.example.junhyun.perfectgame;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class touch_main extends AppCompatActivity {
    SoundPool soundpool;
    int sound;

    public List physics(float mass, float theta,
                           float x_vel, float y_vel,
                           float x_ang, float y_ang) {

        float radius = 0.1085F; // [kg]
        float g = 9.8F; // [m/s^2]
        float I = 2 / 5 * mass * radius * radius; // Inertia of sphere
        float u_k = 0.2F; // friction coeff.
        float t = 0.01F; // time slice = 0.01 [sec]
        float x_position = 0;
        float y_position = 0;
        float PI = 3.141592F;
        double angle = theta * PI / 180;
        float crit1 = 0.0F;
        float crit2 = 0.0F;
        int count = 0;
        int count2 = 0;

        mass = 0.453592F * mass; // 파운드 변환


        ArrayList x = new ArrayList<Float>();
        x.add(x_position);

        ArrayList y = new ArrayList<Float>();
        y.add(y_position);


        for(int i=0; i<400; i++){
            count = i;
            crit1 = x_vel - 0.5F*g*t*(i+1);
            crit2 = x_vel - radius*x_ang;

            if (crit1<0) {
                break;
            }

            x_position = x_position + x_vel*t;
            x.add(x_position);

            x_ang = x_ang + (radius*u_k*mass*g*t) / I;

        }
        count2 = count;
        for(int j=0; j<400-count; j++){
            count2 = count2 + 1;
            crit2 = x_vel - radius*x_ang;

            if (crit2>0) {
                break;
            }

            x_position = x_position + x_vel*t + 0.5F*u_k*g*t*t;

            x.add(x_position);

            x_vel = x_vel + u_k*g*t;

        }

        for(int k=0; k<400-count2;k++){
            x_position = x_position + x_vel*t;
            x.add(x_position);
        }

        //System.out.println(x.size());

        // calculate y_position
        for(int i=0; i<400; i++){
            count = i;
            crit1 = y_vel - 0.5F*g*t*(i+1);
            crit2 = y_vel - radius*y_ang;

            if (crit1<0) {
                break;
            }

            y_position = y_position + y_vel*t;
            y.add(y_position);

            y_ang = y_ang + (radius*u_k*mass*g*t) / I;

        }
        count2 = count;
        for(int j=0; j<400-count; j++){
            count2 = count2 + 1;
            crit2 = y_vel - radius*y_ang;

            if (crit2>0) {
                break;
            }

            y_position = y_position + y_vel*t + 0.5F*u_k*g*t*t;

            y.add(y_position);

            y_vel = y_vel + u_k*g*t;

        }

        for(int k=0; k<400-count2;k++){
            y_position = y_position + y_vel*t;
            y.add(y_position);
        }

        ArrayList x_ = new ArrayList<Float>();
        ArrayList y_ = new ArrayList<Float>();

        float x__;
        float y__;
        float cos = (float)Math.cos(angle);
        float sin = (float)Math.sin(angle);

        for(int i=0; i<y.size(); i++){
            x__ = cos * (float) x.get(i) + sin * (float) y.get(i);
            y__ = -1 * sin * (float) x.get(i) + cos * (float) y.get(i);

            x_.add(x__);
            y_.add(y__);
        }
        List tempList = new ArrayList();
        tempList.add(x_);
        tempList.add(y_);

        return tempList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceStace) {
        super.onCreate(savedInstanceStace);
        setContentView(R.layout.activity_touch_main);

        Intent intent = getIntent();
        float mass = intent.getExtras().getFloat("mass");

        ImageView B1 = (ImageView) findViewById(R.id.touchB1);
        ImageView B2 = (ImageView) findViewById(R.id.touchB2);
        final Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        B1.startAnimation(alpha);
        B2.startAnimation(alpha);

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