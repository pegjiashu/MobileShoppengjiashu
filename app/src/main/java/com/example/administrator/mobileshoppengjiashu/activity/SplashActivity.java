package com.example.administrator.mobileshoppengjiashu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.administrator.mobileshoppengjiashu.R;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";
    private ImageView mSplashItem_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intView();
    }

    private void intView(){
        mSplashItem_iv = (ImageView)findViewById(R.id.splash_loading_item);
        Animation translate = AnimationUtils.loadAnimation(this,R.anim.splash_loading);
        translate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashItem_iv.setAnimation(translate);
    }
}
