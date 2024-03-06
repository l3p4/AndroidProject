package com.ixuea.courses.mymusic.Util;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;



/**
 * 偏好设置工具类
 * 是否登录,是否显示引导页面,用户Id
 */
public class DefaultPreferenceUtil {

    private static final String serviceAgreementKey = "serviceAgreementKey";
    private static DefaultPreferenceUtil instance;
    private final Context context;
    private final SharedPreferences preference;

    private DefaultPreferenceUtil(Context context) {
        this.context = context.getApplicationContext();

        preference = PreferenceManager.getDefaultSharedPreferences(this.context);

//        preference = this.context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public synchronized static DefaultPreferenceUtil getInstance(Context context) {
        if (instance == null) {
            instance = new DefaultPreferenceUtil(context);
        }
        return instance;
    }

    public void setAcceptTermsServiceAgreement(){
        putBoolean(serviceAgreementKey,true);
    }
    public  boolean getAcceptTermsServiceAgreement(){
      boolean result = preference.getBoolean(serviceAgreementKey,false);
      return  result;
    }


    public void putBoolean(String key, boolean value){
        //commit 是同步 apply是同步
//        preference.edit().putBoolean(key,value).apply();
        preference.edit().putBoolean(key,value).commit();
    }

}
