package com.example.administrator.mobileshoppengjiashu.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.administrator.mobileshoppengjiashu.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    private static int cartCount = 0;

    public boolean isLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", 0);
        return !TextUtils.isEmpty(sharedPreferences.getString("username", ""));
    }

    public void showGoods(int goodsid){
        Intent intent = new Intent(this, GoodsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("goods_id", goodsid);
        startActivity(intent);
    }

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }



}
