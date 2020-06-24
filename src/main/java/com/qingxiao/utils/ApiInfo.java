package com.qingxiao.utils;

import com.qingxiao.ApiBeans;
import com.qingxiao.mapper.ApiBeansMapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import static com.qingxiao.utils.MybatisDemo.getMapper;


public class ApiInfo {
    /**
     * 获取指定size的文件
     * @param size list容量
     */
    public static List<ApiBeans> getApiListLimit(int size){
        List<ApiBeans> beans = null;
        try {
            Class<?> mybatisDemo = Class.forName("com.qingxiao.utils.MybatisDemo");
            try {
                Method getMapper = mybatisDemo.getMethod("getMapper");
                try {
                    ApiBeansMapper invoke = (ApiBeansMapper) getMapper.invoke(mybatisDemo);
                    beans = invoke.getBeans(size);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return beans;
    }

    /**
     * 反射调用方法获取全量接口数据
     * @return 迭代器
     */
    public static Iterator<ApiBeans> getAllApi(){
        List<ApiBeans> allBeans = getMapper().getAllBeans();
        return allBeans.iterator();
    }

    /**
     * 获取ids
     * @return
     */
    public static Iterator<Integer> getIds(){
        List<Integer> ids = getMapper().getIds();
        return ids.iterator();
    }

    public static void main(String[] args) {
        Iterator<ApiBeans> ids = getAllApi();
        while (ids.hasNext()){
            System.out.println(ids.next());
        }
    }
}
