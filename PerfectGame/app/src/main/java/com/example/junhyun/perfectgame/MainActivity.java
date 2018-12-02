package com.example.junhyun.perfectgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int weightcheck = 0; // 0이면 error, 1이면 실행!
    int gamecheck = 0; // 0이면 practice, 1이면 game!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = (ImageView) findViewById(R.id.logo1);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        logo.startAnimation(scale);

        TextView title = (TextView) findViewById(R.id.textView);
        title.startAnimation(scale);

        final EditText weight = (EditText) findViewById(R.id.weightinput);
        Button enter = (Button) findViewById(R.id.enter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
            }
        });

        Button button1 = (Button) findViewById(R.id.swingpractice);
        button1.setOnClickListener(new View.OnClickListener()      {
            @Override
            public void onClick(View v) {
                String strText = weight.getText().toString();

                try {
                    Double.parseDouble(strText);
                }
                catch(NumberFormatException e){
                    weightcheck = 0;
                    Toast.makeText(getApplicationContext(),"공 무게는 실수를 입력해야 합니다.",Toast.LENGTH_LONG).show();
                    return;
                }
                float mass = Float.valueOf(strText).floatValue();
                if(weightcheck == 1) {
                    gamecheck = 0;
                    Intent intent = new Intent(getApplicationContext(), touch_main.class);
                    intent.putExtra("weight", mass);
                    intent.putExtra("gamecheck", gamecheck);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"공 무게를 입력해주세요.",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button game = (Button) findViewById(R.id.minigame);
        game.setOnClickListener(new View.OnClickListener()      {
            @Override
            public void onClick(View v) {
                String strText = weight.getText().toString();

                try {
                    Double.parseDouble(strText);
                }
                catch(NumberFormatException e){
                    weightcheck = 0;
                    Toast.makeText(getApplicationContext(),"공 무게는 실수를 입력해야 합니다.",Toast.LENGTH_LONG).show();
                    return;
                }
                float mass = Float.valueOf(strText).floatValue();
                if(weightcheck == 1) {
                    gamecheck = 1;
                    Intent intent = new Intent(getApplicationContext(), touch_main.class);
                    intent.putExtra("weight", mass);
                    intent.putExtra("gamecheck", gamecheck);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"공 무게를 입력해주세요.",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("볼링공 무게를 설정하시겠습니까?");
        builder.setMessage("파운드 단위 입니다.");

        builder.setPositiveButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"취소됨",Toast.LENGTH_LONG).show();
                        weightcheck = 0;
                    }
                });

        builder.setNegativeButton("설정",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"적용되었습니다.",Toast.LENGTH_LONG).show();
                        weightcheck = 1;
                    }
                });

        builder.show();
    }
}
