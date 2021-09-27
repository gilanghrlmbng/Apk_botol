package com.depot_air;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
    TextView appname;
    LottieAnimationView lottieAnimationView;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appname=findViewById(R.id.tv);
        animation= AnimationUtils.loadAnimation(this,R.anim.splashanim);
        lottieAnimationView=findViewById(R.id.splash);
        appname.setAnimation(animation);
        appname.animate().translationY(2350).setDuration(2500).setStartDelay(1100);
        lottieAnimationView.animate().translationY(2100).setDuration(1000).setStartDelay(3000);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        },4500L);
    }
}