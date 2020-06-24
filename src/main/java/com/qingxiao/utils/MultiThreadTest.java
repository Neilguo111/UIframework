package com.qingxiao.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultiThreadTest implements Runnable {



    public static HttpClient getClient(){
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        return closeableHttpClient;
    }

    @Override
    public void run() {
        HttpClient client = getClient();
        String url = "http://192.168.1.190:8053/c/channel/article";
        HttpPost post = new HttpPost(url);
        Map<String ,Object > para = new HashMap<>();
        para.put("source","");
        para.put("keyWord","");
        para.put("infoId","5ee9d405d31e0a14ad37ab8f");
        para.put("articleNo","237");
        para.put("comefromUrl","http://192.168.1.190:8899/article/237?infoId=5ee9d405d31e0a14ad37ab8f&wCh=2C");
        para.put("platform","pc");
        para.put("wCh","2C");
        JSONObject object = new JSONObject(para);
        post.setEntity(new StringEntity(object.toString(), Charset.forName("UTF-8")));
        try {
            HttpResponse execute = client.execute(post);
            System.out.println(execute.getStatusLine().getStatusCode());
            System.out.println(execute);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i=0;i < 100;i++){
            threads.add(new Thread(new MultiThreadTest()));
        }
        for (Thread t:threads){
            t.start();
        }
            Thread t1 = new Thread(new MultiThreadTest());
            t1.start();
    }
}
