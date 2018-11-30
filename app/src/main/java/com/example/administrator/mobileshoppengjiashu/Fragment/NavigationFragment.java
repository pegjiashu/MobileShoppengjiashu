package com.example.administrator.mobileshoppengjiashu.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.administrator.mobileshoppengjiashu.R;

public class NavigationFragment extends BaseFragment implements View.OnClickListener{
    private LinearLayout home;
    private LinearLayout fenlei;
    private LinearLayout gouwuche;
    private LinearLayout wode;

    private ImageButton homebtn;
    private ImageButton fenleibtn;
    private ImageButton gouwuchebtn;
    private ImageButton wodebtn;

    private Fragment homeFragment;
    private Fragment fenleiFragment;
    private Fragment gouwucheFragment;
    private Fragment wodeFragment;

    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup conatainer,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.activity_navigation_fragment,conatainer,false);
        initViews(view);
        setTabSelection(R.id.tab_item_home);
        return view;}
        private void initViews(View view){
        home =(LinearLayout)view.findViewById(R.id.tab_item_home);
        home.setOnClickListener(this);
        fenlei=(LinearLayout)view.findViewById(R.id.tab_item_fenlei);
        fenlei.setOnClickListener(this);
        gouwuche =(LinearLayout)view.findViewById(R.id.tab_item_gouwuche);
        gouwuche.setOnClickListener(this);
        wode =(LinearLayout)view.findViewById(R.id.tab_item_wode);
        wode.setOnClickListener(this);
        homebtn=(ImageButton)view.findViewById(R.id.tab_item_home_btn);
        fenleibtn=(ImageButton)view.findViewById(R.id.tab_item_fenlei_btn);
        gouwuchebtn=(ImageButton)view.findViewById(R.id.tab_item_gouwuche_btn);
        wodebtn=(ImageButton)view.findViewById(R.id.tab_item_wode_btn);
        fragmentManager =getFragmentManager();

    }
    @Override
    public void onClick(View v){
        setTabSelection(v.getId());
    }
    public void setTabSelection(int id){
          homebtn.setImageResource(R.drawable.tab_item_home_focus);
          fenleibtn.setImageResource(R.drawable.tab_item_fenlei_focus);
          gouwuchebtn.setImageResource(R.drawable.tab_item_gouwuche_focus);
          wodebtn.setImageResource(R.drawable.tab_item_wode_focus);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (homeFragment !=null)
            fragmentTransaction.hide(homeFragment);
        if (fenleiFragment!=null)
            fragmentTransaction.hide(fenleiFragment);
        if (gouwucheFragment !=null)
            fragmentTransaction.hide(gouwucheFragment);
        if (wodeFragment!=null)
            fragmentTransaction.hide(wodeFragment);
        switch (id){
            case R.id.tab_item_home:
                homebtn.setImageResource(R.drawable.tab_item_home_normal);
                if (homeFragment==null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.content,homeFragment);
                }else{
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.tab_item_fenlei:
                fenleibtn.setImageResource(R.drawable.tab_item_fenlei_normal);
                if (fenleiFragment==null){
                    fenleiFragment=new FenleiFragment();
                    fragmentTransaction.add(R.id.content,fenleiFragment);
                }else {
                    fragmentTransaction.show(fenleiFragment);
                }
                break;
            case R.id.tab_item_gouwuche:
                gouwuchebtn.setImageResource(R.drawable.tab_item_gouwuche_normal);
                if (gouwucheFragment==null){
                    gouwucheFragment=new GouwucheFragment();
                    fragmentTransaction.add(R.id.content,gouwucheFragment);
                }else {
                    fragmentTransaction.show(gouwucheFragment);
        }
        break;
            case R.id.tab_item_wode:
                wodebtn.setImageResource(R.drawable.tab_item_wode_normal);
                if (wodeFragment==null){
                    wodeFragment=new PersonFragment();
                    fragmentTransaction.add(R.id.content,wodeFragment);
                }else {
                    fragmentTransaction.show(wodeFragment);
                }
                break;
        }
        fragmentTransaction.commit();
        //currentId()=id;
    }
}
