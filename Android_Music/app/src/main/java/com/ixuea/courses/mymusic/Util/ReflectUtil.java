package com.ixuea.courses.mymusic.Util;

import android.util.Log;
import android.view.LayoutInflater;

import androidx.viewbinding.ViewBinding;

import com.ixuea.courses.mymusic.activity.BaseViewModelActivity;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtil {
    public static <VB extends ViewBinding> VB newViewBinding(LayoutInflater layoutInflater, Class<?> clazz) {
        try {
            //获取泛型参数对象
            ParameterizedType type;
            try {
                type = (ParameterizedType) clazz.getGenericSuperclass();
            } catch (ClassCastException e) {
                type = (ParameterizedType) clazz.getSuperclass().getGenericSuperclass();
            }

            //type.actualTypeArguments[0]：ViewBinding
            Type[] classList =  type.getActualTypeArguments();
            Class<VB> clazzVB = (Class<VB>) type.getActualTypeArguments()[0];


            //获取inflate方法
            Method inflateMethod = clazzVB.getMethod("inflate", LayoutInflater.class);
            return (VB) inflateMethod.invoke(null, layoutInflater);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//    public static <VB extends ViewBinding> VB newViewBinding(LayoutInflater layoutInflater, Class<?> aClass) {
//
//        try {
//            //获取泛型参数对象
//            ParameterizedType type;
//            try {
//                type = (ParameterizedType) aClass.getGenericSuperclass();
//            } catch (ClassCastException e) {
//
//                type = (ParameterizedType) aClass.getSuperclass().getGenericSuperclass();
//            }
//
//            //type.actualTypeArguments[0]：ViewBinding
//            String msg = String.format("%@",type.getActualTypeArguments());
//            Log.d("1", msg);
//            Type[] classList =  type.getActualTypeArguments();
//            Class<VB> clazzVB = (Class<VB>) type.getActualTypeArguments()[0];
//
//
//            //获取inflate方法
//            Method inflateMethod = clazzVB.getMethod("inflate", LayoutInflater.class);
//
//            return (VB) inflateMethod.invoke(null, layoutInflater);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
}
