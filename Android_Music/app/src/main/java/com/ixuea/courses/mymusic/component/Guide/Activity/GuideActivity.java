package com.ixuea.courses.mymusic.component.Guide.Activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity;
import com.ixuea.courses.mymusic.component.Guide.Adapter.GuideAdapter;
import com.ixuea.courses.mymusic.databinding.ActivityGuideBinding;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GuideActivity extends BaseViewModelActivity<ActivityGuideBinding> implements View.OnClickListener {
    String TAG = "TAG";
    @Override
    protected void initViews() {
        super.initViews();

        ArrayList<Integer> datas = new ArrayList<>();

        datas.add(R.drawable.guide1);
        datas.add(R.drawable.guide2);
        datas.add(R.drawable.guide3);
        datas.add(R.drawable.guide4);
        datas.add(R.drawable.guide5);

        GuideAdapter adapter = new GuideAdapter(datas);
        binding.pagerView.setAdapter(adapter);

    }

    @Override
    protected void initListeners() {
        super.initListeners();
        binding.loginOrRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        OkHttpClient client = new OkHttpClient();
        String urlStr = "http://my-cloud-music-api-sp3-dev.ixuea.com/v1/sheets";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            doGet(urlStr);
            }
        });
        thread.start();


//        try {
//            URL url =  new URL(urlStr);
//        Request request = new Request.Builder().url(url).build();
//
//        Response response = client.newCall(request).execute();
//
//            Log.d(TAG, "onClick: " + response);
//
//        } catch (MalformedURLException e) {
//            Log.d(TAG, "onClick: " + e);
////            throw new RuntimeException(e);
//        } catch (IOException e) {
////            throw new RuntimeException(e);
//            Log.d(TAG, "onClick: " + e);
//        }

    }


//    String get(String url) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        }
//    }

    public void doGet(String urlStr){


        OkHttpClient client = new OkHttpClient(); // 创建 OkHttpClient 实例
        Request request = new Request.Builder()
                .url(urlStr) // 设置请求地址
                .build(); // 构建 Request 对象

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

            }
        });

//        try {
//            Response response = client.newCall(request).execute(); // 发送同步请求
//            String responseData = response.body().string(); // 获取响应数据
//            System.out.println(responseData); // 输出响应数据
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void post(){
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBody = new FormBody.Builder();//表当请求体
        formBody.add("","");


    }

}
