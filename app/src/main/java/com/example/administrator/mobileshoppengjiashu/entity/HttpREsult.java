package com.example.administrator.mobileshoppengjiashu.entity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class HttpREsult<T> {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("status="+status+",msg="+msg);
        if (null!=data){
            sb.append(",data="+data.toString());
        }
        return sb.toString();
    }
}
