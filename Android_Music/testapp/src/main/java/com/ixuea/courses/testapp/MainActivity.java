package com.ixuea.courses.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        String urlStr = "http://my-cloud-music-api-sp3-dev.ixuea.com/v1/sheets";
//        request();
        Map<String, String> map= new HashMap<>();
        map.put("key1","2");
        map.put("key2","4");
        map.put("key3","5");
        map.put("key4","6");
        String requestStr = getRquestString(map);
        Log.d("Tag", "requestStr: " + requestStr);



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                doGet(urlStr);
                get(urlStr);
            }

        });
        thread.start();
    }

        /**
         * 测试get请求方式
         *
         * @param apiUrl 链接
         * @return 请求返回值
         * @author 明快de玄米61
         * @date 2021/09/05
         */

        public void get(String apiUrl){
            HttpURLConnection connection = null;
            InputStream in = null;
            BufferedReader reader = null;
            try {
                //一.设置参数
                //1.获取链接
                // 构造一个URL对象
                final URL url = new URL(apiUrl);
                /*因为 URL 是根据 url 中的协议(此处http)生成的 URLConnection 类的子类
                HttpURLConnection, 故此处转换为 HttpURLConnection子类，方便使用子类
                中的更多的API*/
                URLConnection urlConnection = url.openConnection();
                connection =  (HttpURLConnection) urlConnection;
                //2.设置参数
                //2.1 连接超时时间 读超时时间 毫秒 0表示不超时
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(6000);
                //2.2设置请求方法 "GET" "POST"
                /*
                 public enum HttpMethod {
                    GET, HEAD, POST, PUT, DELETE, CONNECT, OPTIONS, TRACE, PATCH
                  }
                // 在使用枚举设置请求方法
                connection.setRequestMethod(HttpMethod.POST.name());
                 */
                connection.setRequestMethod("GET");

                //2.3其他参数
                connection.setUseCaches(false);

                //3.设置请求头信息
                connection.setRequestProperty("Content-Type","iOSPlatform");
                connection.setRequestProperty("Token", "123456");

                //二.建立连接
                /*1.显式连接,由于一般会调用2.1中的获取数据,所以可以不用调用显式连接
                connection.connect();
                //2.调用下面的方法,会隐式的调用显式连接
                //2.1 获取输出输入流
                connection.getOutputStream();//获取输出流
                connection.getInputStream();//获取输入流 */

                //三.发送数据
                //GET请求,参数直接拼接在URL上,没有发送数据步骤

                //四.读取数据
                InputStream inputStream = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
                BufferedReader bReader = new BufferedReader(isr);
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = bReader.readLine()) != null) {
                    sb.append(line);
                }

                String result  = sb.toString();
                Log.d("1", "doGet: " + result);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    public void post(String apiUrl, Map<String,String>paramas){
        HttpURLConnection connection = null;
        InputStream in = null;
        BufferedReader reader = null;
        try {
            //一.设置参数
            //1.获取链接
            // 构造一个URL对象
            final URL url = new URL(apiUrl);
                /*因为 URL 是根据 url 中的协议(此处http)生成的 URLConnection 类的子类
                HttpURLConnection, 故此处转换为 HttpURLConnection子类，方便使用子类
                中的更多的API*/
            URLConnection urlConnection = url.openConnection();
            connection =  (HttpURLConnection) urlConnection;
            //2.设置参数
            //2.1 连接超时时间 读超时时间 毫秒 0表示不超时
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(6000);
            //2.2设置请求方法 "GET" "POST"
                /*
                 public enum HttpMethod {
                    GET, HEAD, POST, PUT, DELETE, CONNECT, OPTIONS, TRACE, PATCH
                  }
                // 在使用枚举设置请求方法
                connection.setRequestMethod(HttpMethod.POST.name());
                 */
            connection.setRequestMethod("POST");

            //2.3其他参数
            connection.setUseCaches(false);

            //3.设置请求头信息
            connection.setRequestProperty("Content-Type","iOSPlatform");
            connection.setRequestProperty("Token", "123456");

            //二.建立连接
                /*1.显式连接,由于一般会调用2.1中的获取数据,所以可以不用调用显式连接
                connection.connect();
                //2.调用下面的方法,会隐式的调用显式连接
                //2.1 获取输出输入流
                connection.getOutputStream();//获取输出流
                connection.getInputStream();//获取输入流 */

            //三.发送数据
            //GET请求,参数直接拼接在URL上,没有发送数据步骤
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            DataOutputStream dos = new DataOutputStream(outputStream);

            Map<String, String> map= new HashMap<>();
            map.put("key1","2");
            map.put("key2","4");
            map.put("key3","5");
            map.put("key4","6");
            String requestStr = getRquestString(map);
            dos.writeBytes("key1=2&key2=4&key3=5&key4=6");
            dos.writeBytes(requestStr);
            dos.flush();
            dos.close();

            //四.读取数据
            InputStream inputStream = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
            BufferedReader bReader = new BufferedReader(isr);
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                sb.append(line);
            }

            String result  = sb.toString();
            Log.d("1", "doGet: " + result);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getRquestString(Map<String, String> parameters){
        StringBuilder sb = new StringBuilder();
//        for(NameValuePair pair: parameters ){)
//        parameters.forEach();

        parameters.forEach((key,value)->{
            if(sb.length() <= 0){
                sb.append( key + "=" + value);
            }else {
                sb.append("&" + key + "=" + value);
            }
        });
        return sb.toString();
    }
}