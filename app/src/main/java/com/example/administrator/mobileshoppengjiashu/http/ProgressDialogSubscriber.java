package com.example.administrator.mobileshoppengjiashu.http;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.mobileshoppengjiashu.R;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.logging.SocketHandler;

import rx.Subscriber;

public abstract class ProgressDialogSubscriber<T> extends Subscriber<T> {
    private Context mContext;
    private ProgressDialog mDialog;
    public ProgressDialogSubscriber(Context context){
        this.mContext = context;
    }
    @Override
    public void onCompleted(){
        dismissProgressDialog();
    }
    @Override
    public void onError(Throwable e){
        if (e instanceof SocketTimeoutException){
            Toast.makeText(mContext,"网络中断，请检查您的网络状态",Toast.LENGTH_SHORT).show();
        }else if (e instanceof ConnectException){
            Toast.makeText(mContext,"网络中断，请检查您的网络状态",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext,"error:"+ e.getMessage(),
                    Toast.LENGTH_SHORT).show();
            System.out.print("error:"+ e.getMessage());
        }
        dismissProgressDialog();
    }
    @Override
    public void onStart(){
        showProgressDialog();
    }
    private void showProgressDialog(){
        if (mDialog == null){
            mDialog = new ProgressDialog(mContext);
            mDialog.setCancelable(true);
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    ProgressDialogSubscriber.this.unsubscribe();
                }
            });
        }
        if (mDialog != null && mDialog.isShowing()){
            mDialog.show();
        }
    }
    private void dismissProgressDialog(){
        if (mDialog != null&& mDialog.isShowing()){
            mDialog.dismiss();
            mDialog = null;
        }
    }
}
