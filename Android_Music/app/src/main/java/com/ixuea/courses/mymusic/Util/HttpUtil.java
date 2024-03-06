package com.ixuea.courses.mymusic.Util;

import java.io.IOException;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    private  static final OkHttpClient CLIENT = new OkHttpClient();
    
    static public String get(String url, Map<String,String> headerMap) throws Exception{
        Request.Builder requestBuilder = new Request.Builder().url(url);
        handleRequestHeader(requestBuilder,headerMap);
        return  executeRequest(requestBuilder);
    }


    static public String postJson(String url,String josnStr ,Map<String,String> headerMap) throws Exception{
        Request.Builder requestBuilder = new Request.Builder().url(url);
        handleRequestHeader(requestBuilder,headerMap);
        return  executeRequest(requestBuilder);
    }


    private static void handleRequestHeader(Request.Builder requestBulider, Map<String, String> headerMap) {
        if(headerMap != null && headerMap.size() > 0){
            /*
            headerMap.forEach(requestBuilder::header);: 这行代码使用了 Java 8 引入的函数式编程特性，
            使用 forEach 方法遍历 headerMap 中的每个键值对，并对每个键值对调用 requestBuilder::header。
            这里 requestBuilder::header 表示对 Request.Builder
            对象调用 header 方法，相当于 requestBuilder.header(key, value)，
             */
            headerMap.forEach((key,value) -> requestBulider.header(key,value));
            //headerMap.forEach(requestBuilder::header);
        }
    }

    public static String executeRequest(Request.Builder requestBuilder) throws  Exception{
        try (Response response = CLIENT.newCall(requestBuilder.build()).execute()){
                if(response != null){
                    return response.toString();
                }
                return null;
            }
    }

}
