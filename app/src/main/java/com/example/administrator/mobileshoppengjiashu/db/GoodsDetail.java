package com.example.administrator.mobileshoppengjiashu.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.mobileshoppengjiashu.R;
import com.example.administrator.mobileshoppengjiashu.activity.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class GoodsDetail  {
 /*   @GET("goods")
    Call<List<GoodsEntity>>getGoodsList(
            @Query("page")int page,
            @Query("count")int count
    );

    private void getGoodsDetail(){
        Retrofit retrofit = new Retrofit().Builder()
                .baseUrl("http://192.168.2.2:8080/MobileShop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GoodsService service= retrofit.create(GoodsService.class);
        Call<List<GoodsEntity>> call = service.getGoodsList(3,10);
        call.enqueue(new Callback<List<GoodsEntity>>() {
            @Override
            public void onResponse(Call<List<GoodsEntity>> call, Response<List<GoodsEntity>> response) {
                String title = response.body().get(0).toString();
                Toast.makeText(MainActivity.this,title,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<GoodsEntity>> call, Throwable t) {

            }
        });
    }*/
}
