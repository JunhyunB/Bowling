package com.example.junhyun.perfectgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class lane extends AppCompatActivity {
    ImageView imageView;
    int q=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lane_main);

        Intent intent = getIntent();
        //final ArrayList y_ = (ArrayList)getIntent().getSerializableExtra("x_result");
        //final ArrayList x_ = (ArrayList)getIntent().getSerializableExtra("y_result");

        final ArrayList x_ = new ArrayList<Float>();
        final ArrayList y_ = new ArrayList<Float>();

        for (int j = 0; j<400; j++) {
            x_.add((float)j / 400);
            y_.add((float)j / 400);
        }

        // 위에 테스트 해본거


        imageView = findViewById(R.id.temp);

        (new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {

                    try {
                        Thread.sleep(20);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setX(imageView.getX() + (float) x_.get(q));
                                imageView.setY(imageView.getY() + (float) y_.get(q));
                            }
                        });
                        q++;
                    } catch (InterruptedException e) {
                    }
                }
            }
        })).start();
    }
}