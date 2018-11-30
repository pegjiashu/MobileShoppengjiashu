package com.example.administrator.mobileshoppengjiashu.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.mobileshoppengjiashu.R;
import com.example.administrator.mobileshoppengjiashu.common.Constants;
import com.example.administrator.mobileshoppengjiashu.common.ImageLoaderManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class AdLIUActivity extends AppCompatActivity {
private ImageView adImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        adImage = (ImageView) findViewById(R.id.ad_image);
        loadAd(Constants.AD_URL);


    }
private void loadAd(String url){

        ImageLoader.getInstance().displayImage(url,adImage, ImageLoaderManager.product_options,new ImageLoadingListener(){
            @Override
            public void onLoadingStarted(String imageUri, View view){
            }
            @Override
            public void onLoadingFailed(String imageUri,View view,FailReason failReason){
                skip();
            }
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage){
                timer();
            }
            @Override
            public void onLoadingCancelled(String imageUri,View view){
                skip();
            }
        });
}
private void skip(){
        startActivity(new Intent(AdLIUActivity.this,MainActivity.class));
}
private void timer(){
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                if (msg.what == -1)
                    skip();
            }
        };
        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(Constants.AD_TIME_SECOND);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(-1);
            }
        }.start();
}
}
