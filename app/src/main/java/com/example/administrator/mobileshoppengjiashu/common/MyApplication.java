package com.example.administrator.mobileshoppengjiashu.common;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mobileshoppengjiashu.db.GreenDaoManager;
import com.example.administrator.mobileshoppengjiashu.http.HttpMethods;

public class MyApplication extends Application {
    public static Context mContext;
    public static Context getContext(){
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        GreenDaoManager.getInstance();
        HttpMethods.getmInstance();
        ImageLoaderManager.getInstance();
    }
}
