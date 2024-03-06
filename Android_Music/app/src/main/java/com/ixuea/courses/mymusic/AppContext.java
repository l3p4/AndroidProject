package com.ixuea.courses.mymusic;

import android.app.Application;
import android.util.Log;

import com.tencent.mmkv.MMKV;

public class AppContext extends Application {
    private static final String TAG = "AppContext";
    private static AppContext instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initMMKV();
        Thread.currentThread();

    }




    public AppContext getInstance(){
        return instance;
    }
    private void initMMKV(){
        String dirPath = MMKV.initialize(this);
        Log.d(TAG, "initMMKV: " + dirPath);
    }
}
