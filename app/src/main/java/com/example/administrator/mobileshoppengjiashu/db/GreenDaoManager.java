package com.example.administrator.mobileshoppengjiashu.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.mobileshoppengjiashu.common.MyApplication;
import com.example.administrator.mobileshoppengjiashu.gen.DaoMaster;
import com.example.administrator.mobileshoppengjiashu.gen.DaoSession;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class GreenDaoManager  {

private static GreenDaoManager mInstance;
private static DaoMaster mDaoMaster;
private static DaoSession mDaoSession;
public GreenDaoManager (){
    if (mInstance == null) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), "mydb", null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

}
public static GreenDaoManager getInstance(){
    if (mInstance == null){
        synchronized (GreenDaoManager.class){
            if (mInstance == null){
                mInstance = new GreenDaoManager();
            }
        }
    }
    return mInstance;
}
public static AbstractDaoMaster getMaster(){
    return  mDaoMaster;
}
public static AbstractDaoSession getSession(){
    return  mDaoSession;
}
public static AbstractDaoSession getNewSession(){
    mDaoSession = mDaoMaster.newSession();
    return mDaoSession;
}
}
