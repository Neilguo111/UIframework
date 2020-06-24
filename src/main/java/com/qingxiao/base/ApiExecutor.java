package com.qingxiao.base;

import com.qingxiao.ApiBeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.qingxiao.utils.ApiInfo.getAllApi;

public class ApiExecutor {

    public void handleApi(){
        Iterator<ApiBeans> allApi = getAllApi();
        while (allApi.hasNext()){
            ApiBeans api = allApi.next();
            String method = api.getMethod();
            String name = api.getName();
            int needToken = api.getNeedToken();
            String params = api.getParams();
            String path = api.getPath();

        }
    }

    public static void main(String[] args) {
        
    }
}
