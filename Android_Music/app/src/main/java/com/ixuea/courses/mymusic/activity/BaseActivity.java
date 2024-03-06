package com.ixuea.courses.mymusic.activity;

import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ixuea.courses.mymusic.R;

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("TAG", "onPostCreate: onPostCreate");
        initViews();
        initDatum();
        initListeners();



    }





    protected void initViews(){}

    protected void initDatum(){}

    protected void initListeners(){}

}
