package com.simplest.uniapproomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    //public class zoominfragment extends Fragment implements Animation.AnimationListener{ @Nullable
    ImageView view11;
    long time_value = 2000;
    Animation Zoomin;
    Animation Slidedown;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view = inflater.inflate(R.layout.fra)
        view11 = (ImageView) findViewById(R.id.universalplc);

        Zoomin = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
         Zoomin.setAnimationListener(this);

        //Slidedown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);

        //Slidedown.setAnimationListener(this);


        CountDownTimer mytimer = new CountDownTimer(time_value, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                view11.startAnimation(Zoomin);
                //view11.startAnimation(Slidedown);
                long x = millisUntilFinished / 1000;
                Log.d("CurrentValue", String.valueOf(x));
            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        }.start();

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}



