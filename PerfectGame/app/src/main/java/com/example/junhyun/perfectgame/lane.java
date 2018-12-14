package com.example.junhyun.perfectgame;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
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
        Bundle b1 = intent.getBundleExtra("bundle");
        //Bundle b2 = getIntent().getBundleExtra("y_result");

        final ArrayList y_ = b1.getParcelableArrayList("x_result");
        final ArrayList x_ = b1.getParcelableArrayList("y_result");
/*
        for(int i=0;i<x_.size();i++){
            Log.d("x값:",String.valueOf(x_.get(i)));
            Log.d("y값:",String.valueOf(y_.get(i)));
        }
*/

        imageView = findViewById(R.id.temp);
        ViewTreeObserver viewTreeObserver = this.imageView.getViewTreeObserver();
        this.imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < x_.size(); i++) {
                            try {
                                Thread.sleep(20);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageView.setX(imageView.getX() + (float) x_.get(q)); //좌우로
                                        imageView.setY(imageView.getY() - (float) y_.get(q)); //위로
                                    }
                                });
                                q++;
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }).start();
                ViewTreeObserver obs = lane.this.imageView.getViewTreeObserver();
                if (Build.VERSION.SDK_INT >= 16) {
                    obs.removeOnGlobalLayoutListener(this);
                } else {
                    obs.removeGlobalOnLayoutListener(this);
                }

            }
        });
    }
}