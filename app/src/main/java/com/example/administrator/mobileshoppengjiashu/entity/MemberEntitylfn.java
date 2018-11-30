package com.example.administrator.mobileshoppengjiashu.entity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemberEntitylfn  {
    private int member_id;
    private String uname;
    private String password;
    private String email;
    private int sex;
    private String mobile;
    private Object regtime;
    private Object lastlogin;
    private String image;
    private Object menberAddresses;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getRegtime() {
        return regtime;
    }

    public void setRegtime(Object regtime) {
        this.regtime = regtime;
    }

    public Object getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Object lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getMenberAddresses() {
        return menberAddresses;
    }

    public void setMenberAddresses(Object menberAddresses) {
        this.menberAddresses = menberAddresses;
    }

    @Override
    public String toString() {
        return "MemberEntitylfn{" +
                "member_id=" + member_id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastlogin=" + lastlogin +
                ", image='" + image + '\'' +
                ", menberAddresses=" + menberAddresses +
                '}';
    }
}
