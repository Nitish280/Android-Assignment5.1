package com.example.nitishsingh.android51;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    //Declaration
    TextView txtView;
    Button btn;
    Animation animFadein, animFadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting up UI Componenet
        txtView=(TextView)findViewById(R.id.textView);
        btn=(Button)findViewById(R.id.button);
        //load the animation
        animFadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        animFadeout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        //set animation listener
        animFadein.setAnimationListener(this);
        //button click event
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtView.setVisibility(View.VISIBLE);
                //start the animation
                txtView.startAnimation(animFadein);
            }
        });


    }

    @Override
    public void onAnimationStart(Animation animation) {

        //Toast.makeText(MainActivity.this, "Animation Started", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animFadein==animFadein){
//            Toast.makeText(getApplicationContext(),"Animation End",
//                    Toast.LENGTH_SHORT).show();
            txtView.startAnimation(animFadeout);
            animFadeout.start();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
