package com.example.administrator.mobileshoppengjiashu.http.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mobileshoppengjiashu.entity.MemberEntitylfn;
import com.example.administrator.mobileshoppengjiashu.http.HttpMethods;

import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods {

    public static void register(Subscriber<MemberEntitylfn> subscriber,String username,String email,String password){
        Observable observable = memberService.register(username,password,email)
                .map(new HttpResultFunc<MemberEntitylfn>());
        toSubscribe(observable,subscriber);
    }
    public static void login(Subscriber<MemberEntitylfn>subscriber,String username,String password){
        Observable observable = memberService.login(username,password)
                .map(new HttpResultFunc<MemberEntitylfn>());
        toSubscribe(observable,subscriber);
    }

    public static void changePassword(Subscriber subscriber, String memberId, String old_pwd, String new_pwd){
        Observable observable = memberService.changePassword(memberId, old_pwd, new_pwd);
        toSubscribe(observable, subscriber);
        }
    public static void findPassword(Subscriber subscriber, String email){
        Observable observable = memberService.findPassword(email);
        toSubscribe(observable, subscriber);
        }
}
