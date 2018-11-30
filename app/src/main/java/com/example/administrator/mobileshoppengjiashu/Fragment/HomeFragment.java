package com.example.administrator.mobileshoppengjiashu.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mobileshoppengjiashu.R;
import com.example.administrator.mobileshoppengjiashu.activity.MainActivity;
import com.example.administrator.mobileshoppengjiashu.common.Urls;
import com.example.administrator.mobileshoppengjiashu.view.MyWebViewlfn;
import com.example.administrator.mobileshoppengjiashu.view.NetworkUtils;

public class HomeFragment extends BaseFragment {
    private static final String TAG = "HomeFragment";
    public HomeFragment(){}
    private MainActivity mainActivity;
    private final  int SEARCH_ACTIVITY = 1;
    private MyWebViewlfn mWebViewlfn;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Button testBtn;
    private TextView searchTV;

    @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        mainActivity = (MainActivity)getActivity();
        searchTV = (TextView)view.findViewById(R.id.home_search);
        searchTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"等待开发...",Toast.LENGTH_SHORT).show();
            }
        });
        mWebViewlfn = (MyWebViewlfn)view.findViewById(R.id.webView);
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_layout);
        initMyWebViewlfn(view);
        initSwipeRefreshLayout();
        return view;
    }
    @SuppressLint("JavascriptInterface")
    private void initMyWebViewlfn(final View view){
        mWebViewlfn.addJavascriptInterface(this,"app");
        mWebViewlfn.setVerticalScrollBarEnabled(false);
        mWebViewlfn.setHorizontalScrollBarEnabled(false);

        WebSettings settings = mWebViewlfn.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);


        mWebViewlfn.setmIWebViewScrollChanged(new MyWebViewlfn.IWebViewScroll(){
            @Override
                    public void onTop(){
                mSwipeRefreshLayout.setEnabled(true);
            }
            @Override
                    public void notOnTop(){
                mSwipeRefreshLayout.setEnabled(false);
            }
        });
        mWebViewlfn.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWebViewlfn.canGoBack()){
                        mWebViewlfn.goBack();
                        return true;
                    }
                }
                return false;
            }
        });

        mWebViewlfn.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error){
                super.onReceivedError(view,request,error);
                Log.e(TAG,"onReceivedError");
                mWebViewlfn.loadUrl("file:///android_asset/error.html");
                mSwipeRefreshLayout.setRefreshing(false);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                mSwipeRefreshLayout.setRefreshing(true);
                Log.e(TAG,"onPageStarted");
            }
            @Override
            public void onPageFinished(WebView view,String url){
                mSwipeRefreshLayout.setRefreshing(false);
                Log.e(TAG,"onPageFinished");
            }
        });
        mWebViewlfn.loadUrl(Urls.INDEX);
    }


    private void initSwipeRefreshLayout(){
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (NetworkUtils.isNetworkAvailable(mainActivity)){
                    mWebViewlfn.reload();
                }else {
                    mSwipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(mainActivity,"网络不可用",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





}
