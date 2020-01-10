package com.qingxiao.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 操作配置文件类
 */
public class ProUtil {
    private Properties pro;
    private String fileName;
    private String filePath;

    public ProUtil(String fileName){
        this.fileName = fileName;
        this.filePath = "E:\\code project\\java\\UIframework\\src\\main\\resources\\element.properties";
        this.pro = readProperties();
    }

    /**
     *
     * @param key
     * @return
     * @throws Exception
     */
    public String getPro(String key) throws Exception {
        if (pro.containsKey(key)){
            String result = pro.getProperty(key);
            return result;
        }else {
            return "";
        }
    }

    /**
     *
     * @return
     */
    private Properties readProperties(){
        Properties properties = new Properties();
        InputStream in = ProUtil.class.getClassLoader().getResourceAsStream(this.fileName);
//        InputStreamReader in1 = null;
//        try {
//            in1 = new InputStreamReader(ProUtil.class.getClassLoader().getResourceAsStream(this.fileName), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 写入cookie配置文件
     * @param key
     * @param value
     */
    public void writeProperties(String key,String value){
        Properties properties = new Properties();
        properties.setProperty(key, value);
        try {
            pro.store(new FileOutputStream(this.fileName),"cookie配置");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        ProUtil util = new ProUtil("element.properties");
        System.out.println(util.getPro("newHomeworkSubjectBtn"));
    }

}
