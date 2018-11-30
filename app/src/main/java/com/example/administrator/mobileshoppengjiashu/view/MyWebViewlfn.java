package com.example.administrator.mobileshoppengjiashu.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebView;


import java.util.jar.Attributes;

public class MyWebViewlfn extends WebView {

    private IWebViewScroll mIWebViewScroll;
    public MyWebViewlfn(Context context){
        super(context,null);
    }
    public MyWebViewlfn(Context context, AttributeSet attrs){
        super(context, (AttributeSet) attrs,0);
    }
    public MyWebViewlfn(Context context,AttributeSet attrs,int defStyleAttr){
        super(context, (AttributeSet) attrs,defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l,int t ,int oldl,int oldt){
        super.onScrollChanged(l,t,oldl,oldt);
        if (mIWebViewScroll != null &&t==0){
            mIWebViewScroll.onTop();
        }else if (mIWebViewScroll != null&& t!=0){
            mIWebViewScroll.notOnTop();
        }
    }
    public void setmIWebViewScrollChanged(IWebViewScroll listener){
        this.mIWebViewScroll = listener;
    }

    public interface IWebViewScroll{
        void  onTop();
        void notOnTop();
    }
}
