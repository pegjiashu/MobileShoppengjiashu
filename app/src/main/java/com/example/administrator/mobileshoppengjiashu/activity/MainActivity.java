package com.example.administrator.mobileshoppengjiashu.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mobileshoppengjiashu.Fragment.NavigationFragment;
import com.example.administrator.mobileshoppengjiashu.R;

public class MainActivity extends BaseActivity {
    private NavigationFragment navigationFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationFragment = new NavigationFragment();
        FragmentTransaction fragmentionTransaction = getSupportFragmentManager().beginTransaction();
        fragmentionTransaction.add(R.id.main_frame,navigationFragment).commit();
    }
}
