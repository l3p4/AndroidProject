package com.ixuea.courses.mymusic.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.ixuea.courses.mymusic.Util.SuperDarkUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

/**
 * 通用界面逻辑
 */
public class BaseCommonActivity extends BaseActivity{
    public BaseCommonActivity getHostActivity(){
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        if(SuperDarkUtil.isDark(this)){
            QMUIStatusBarHelper.setStatusBarDarkMode(this);
        }else {
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }
    }

    public void startActivityThenFinshed(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }
}
