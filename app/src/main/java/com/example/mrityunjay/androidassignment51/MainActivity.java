package com.example.mrityunjay.androidassignment51;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    TextView txtMessage;
    Button btnStart;
    Animation animFadein,animFadeout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage =(TextView)findViewById(R.id.mj);
        btnStart= (Button)findViewById(R.id.startButton);
        animFadeout =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animFadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadein.setAnimationListener(this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.startAnimation(animFadein);
            }
        });



    }


    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_LONG).show();


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animation==animFadein){
            Toast.makeText(getApplicationContext(),"animatin stopped",Toast.LENGTH_SHORT).show();
            txtMessage.startAnimation(animFadeout);
            txtMessage.setVisibility(View.INVISIBLE);
            animFadeout.start();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

