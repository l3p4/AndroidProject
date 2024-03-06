package com.ixuea.courses.mymusic.Util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.tencent.mmkv.MMKV;


/**
 * 偏好设置工具类
 * 是否登录,是否显示引导页面,用户Id
 */
public class PreferenceUtil {
    private static final String serviceAgreementKey = "serviceAgreementKey";

    private static PreferenceUtil instance;
    private final Context context;



    private PreferenceUtil(Context context) {
        this.context = context.getApplicationContext();
    }


    public static void setAcceptTermsServiceAgreement(){
        MMKV kv = MMKV.defaultMMKV();
        kv.encode(serviceAgreementKey, true);//赋值
        boolean result =  kv.decodeBool(serviceAgreementKey);//取值
    }
    public static boolean getAcceptTermsServiceAgreement(){
        MMKV kv = MMKV.defaultMMKV();
        boolean result =  kv.decodeBool(serviceAgreementKey);
        return  result;
    }


//    public void putBoolean(String key, boolean value){
//        //commit 是同步 apply是同步
////        preference.edit().putBoolean(key,value).apply();
//        preference.edit().putBoolean(key,value).commit();
//    }

}
