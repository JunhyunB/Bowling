package com.example.junhyun.perfectgame;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class lane extends AppCompatActivity {
    ImageView imageView;
    ImageView pin1;
    ImageView pin2;
    ImageView pin3;
    ImageView pin4;
    ImageView pin5;
    ImageView pin6;
    ImageView pin7;
    ImageView pin8;
    ImageView pin9;
    ImageView pin10;
    int count = 0;
    int on1 = 1;
    int on2 = 1;
    int on3 = 1;
    int on4 = 1;
    int on5 = 1;
    int on6 = 1;
    int on7 = 1;
    int on8 = 1;
    int on9 = 1;
    int on10 = 1;

    int [] temp = {0, 0};


    TextView t;


    int q=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lane_main);
        t = findViewById(R.id.textView4);
        pin1 = findViewById(R.id.imageView);
        pin2 = findViewById(R.id.imageView2);
        pin3 = findViewById(R.id.imageView3);
        pin4 = findViewById(R.id.imageView4);
        pin5 = findViewById(R.id.imageView5);
        pin6 = findViewById(R.id.imageView6);
        pin7 = findViewById(R.id.imageView7);
        pin8 = findViewById(R.id.imageView8);
        pin9 = findViewById(R.id.imageView9);
        pin10 = findViewById(R.id.imageView10);
        Intent intent = getIntent();
        Bundle b1 = intent.getBundleExtra("bundle");
        //Bundle b2 = getIntent().getBundleExtra("y_result");
        final boolean bb;

        final ArrayList y_ = b1.getParcelableArrayList("x_result");
        final ArrayList x_ = b1.getParcelableArrayList("y_result");


        imageView = findViewById(R.id.temp);
        ViewTreeObserver viewTreeObserver = this.imageView.getViewTreeObserver();

        this.imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < x_.size()-1; i++) {
                            try {
                                Thread.sleep(10);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageView.setX(imageView.getX() + ((float) x_.get(q)*5)); //좌우로
                                        imageView.setY(imageView.getY() - ((float) y_.get(q)*0.7f)); //위로

                                        temp = collision(imageView, pin1, count, on1);
                                        count = temp[0];
                                        on1 = temp[1];
                                        changeColor(pin1, on1);
                                        temp = collision(imageView, pin2, count, on2);
                                        count = temp[0];
                                        on2 = temp[1];
                                        changeColor(pin2, on2);
                                        temp = collision(imageView, pin3, count, on3);
                                        count = temp[0];
                                        on3 = temp[1];
                                        changeColor(pin3, on3);
                                        temp = collision(imageView, pin4, count, on4);
                                        count = temp[0];
                                        on4 = temp[1];
                                        changeColor(pin4, on4);
                                        temp = collision(imageView, pin5, count, on5);
                                        count = temp[0];
                                        on5 = temp[1];
                                        changeColor(pin5, on5);
                                        temp = collision(imageView, pin6, count, on6);
                                        count = temp[0];
                                        on6 = temp[1];
                                        changeColor(pin6, on6);
                                        temp = collision(imageView, pin7, count, on7);
                                        count = temp[0];
                                        on7 = temp[1];
                                        changeColor(pin7, on7);
                                        temp = collision(imageView, pin8, count, on8);
                                        count = temp[0];
                                        on8 = temp[1];
                                        changeColor(pin8, on8);
                                        temp = collision(imageView, pin9, count, on9);
                                        count = temp[0];
                                        on9 = temp[1];
                                        changeColor(pin9, on9);
                                        temp = collision(imageView, pin10, count, on10);
                                        count = temp[0];
                                        on10 = temp[1];
                                        changeColor(pin10, on10);
                                            //t.setText("성공");


                                        t.setText("Score : " + Integer.toString(count));

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
    public int[] collision(ImageView a, ImageView b, int count, int on){
        float bl = a.getY();
        float bt = a.getX();
        float br = a.getWidth() + bl;
        float bb = a.getHeight() + bt;
        float pl = b.getY();
        float pt = b.getX();
        float pr = b.getWidth() + pl;
        float pb = b.getHeight() + pt;

        if (on == 1) {
            if (bl <= pr && bl >= pl && bt >= pt && bt <= pb) {
                return new int[]{count+1, 0};
            } else if (br >= pl && br <= pr && bb >= pt && bb <= pb) {
                return new int[]{count+1, 0};
            } else if (bt <= pb && bt >= pt && br >= pl && br <= pr) {
                return new int[]{count+1, 0};
            } else if (bb >= pt && bb <= pb && bl >= pl && bl <= pr) {
                return new int[]{count+1, 0};
            }
        }
        return new int[] {count, on};
    }

    public void changeColor(ImageView a, int on) {
        if(on == 0) {
            a.setImageResource(R.drawable.black);
        }
    }
}