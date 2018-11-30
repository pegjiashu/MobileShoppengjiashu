package com.example.administrator.mobileshoppengjiashu.http.service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mobileshoppengjiashu.entity.HttpREsult;
import com.example.administrator.mobileshoppengjiashu.entity.MemberEntitylfn;
import com.example.administrator.mobileshoppengjiashu.http.HttpMethods;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface MemberService {

    @FormUrlEncoded
    @POST("member")
    Observable<HttpREsult<MemberEntitylfn>> register(
            @Field("uname") String uname,
            @Field("passeord") String passeword,
            @Field("email") String email
    );
    @FormUrlEncoded
    @POST("member/login")
    Observable <HttpREsult<MemberEntitylfn>> login(
            @Field("uname") String uname,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("member/{memberId")
    Observable <HttpREsult<MemberEntitylfn>> changePassword(
            @Field("member") String memberId,
            @Field("old_pwd") String old_pwd,
            @Field("new_pwd") String new_pwd
            );
    @FormUrlEncoded
    @POST("member/pwd")
    Observable <HttpREsult<MemberEntitylfn>> findPassword(
            @Field("email") String email
    );
}
