package com.example.administrator.mobileshoppengjiashu.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.mobileshoppengjiashu.entity.HttpREsult;
import com.example.administrator.mobileshoppengjiashu.http.service.MemberService;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HttpMethods  {
    protected static final String BASE_URL = "http://192.168.8.8:8080/MobileShop";
    private static final int DEFAULT_TIMEOUT = 5;
    protected static final String TAG ="HttpMethods";
    private Retrofit retrofit;
    private static HttpMethods mInstance;
    protected static MemberService memberService;



    public HttpMethods(){
        if (mInstance == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient).build();
            memberService = retrofit.create(MemberService.class);
        }
    }
    public static HttpMethods getmInstance(){
        if (mInstance == null){
            synchronized (HttpMethods.class){
                if (mInstance == null){
                    mInstance = new HttpMethods();
                }
            }
        }
        return mInstance;
    }
    public static class HttpResultFunc<T> implements Func1<HttpREsult<T>,T>{
        @Override
        public T call(HttpREsult<T> httpResult){
            Log.i(TAG,"status:"+ httpResult.getStatus());
            Log.i(TAG,"msg:"+ httpResult.getMsg());
            Log.i(TAG,"data:"+ httpResult.getData());
            return httpResult.getData();
        }
    }
    public static <T> void toSubscribe(Observable<T> o, Subscriber<T>s){
        o.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
