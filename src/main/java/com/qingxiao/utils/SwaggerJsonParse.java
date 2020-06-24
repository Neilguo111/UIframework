package com.qingxiao.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.qingxiao.ApiBeans;
import com.qingxiao.mapper.ApiBeansMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static com.qingxiao.utils.MybatisDemo.getMapper;

public class SwaggerJsonParse implements Serializable {
    //
    private static ApiBeansMapper mapper;

    private static String FILEPATH = "C:\\Users\\Administrator\\Downloads\\api (1).json";

    public static void save(){
        try {
            JSONReader reader = new JSONReader(new FileReader(FILEPATH));
            List<ApiBeans> beans = new ArrayList<>();
            reader.startArray();
            while (reader.hasNext()){
                HashMap<String ,String > params = new HashMap<>();
                JSONObject object = (JSONObject) reader.readObject();
                // 获取接口组的别名
                String name = (String) object.get("name");
                String apiName = null;
                String apiPath = null;
                String apiMehtod = null;
                // 1:需要 2:不需要
                int apiNeedAuthor = 2;
                // 接口组对象
                JSONArray list = object.getJSONArray("list");
                Iterator<Object> iterator = list.iterator();
                while (iterator.hasNext()){
                    JSONObject next = (JSONObject) iterator.next();
                    apiName = (String) next.get("title");
                    apiPath = (String) next.get("path");
                    apiMehtod = (String) next.get("method");
                    JSONArray req_headers = (JSONArray) next.get("req_headers");
                    // 判断是否需要token
                    if (req_headers.toString().contains("Authorization")){
                        apiNeedAuthor = 1;
                    }
                    switch (apiMehtod){
                        case "GET":
                            try{
                                JSONArray req_query = next.getJSONArray("req_query");
                                extractParams(params, req_query);
                                break;
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        case "POST":
                            try{
                                JSONArray req_body_form = next.getJSONArray("req_body_form");
                                extractParams(params, req_body_form);
                                break;
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            // todo
                        case "PUT":
                            try{

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                    }
                    // 实例化对象
                    ApiBeans bean = new ApiBeans();
                    bean.setName(apiName);
                    bean.setPath(apiPath);
                    bean.setMethod(apiMehtod);
                    bean.setParams(params.toString());
                    bean.setNeedToken(apiNeedAuthor);
                    System.out.println(bean);
                    System.out.println("准备实例化mapper对象");
                    ApiBeansMapper mapper = getMapper();
                    System.out.println("操作insert");
                    mapper.insertApi(bean);
                    System.out.println(bean);
                }
            }
            reader.endArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    private static void extractParams(HashMap<String, String> params, JSONArray req_query) {
        Iterator<Object> iterator = req_query.iterator();
        while (iterator.hasNext()){
            JSONObject next = (JSONObject) iterator.next();
            String param = null;
            String require = null;
            try{
                // 获取请求参数名称
                param = (String) next.get("name");
                // 获取接口的请求条件
                require = (String) next.get("required");

            }catch (JSONException e){
                e.printStackTrace();
            }
            params.put(param,require);
        }
        return;
    }


    public static void main(String[] args) {
        save();
    }
}
