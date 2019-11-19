package com.qingxiao.utils;

import org.openqa.selenium.By;

public class GetLocator {

    public static By getLocator(String key) throws Exception {
        //读取配置文件
        ProUtil util = new ProUtil("element.properties");
        //根据key拿到配置的值
        String username = util.getPro(key);
        String locatorType = username.split(">")[0];
        String locatorElement = username.split(">")[1];

        if (locatorType.toLowerCase().equals("id")){
            return By.id(locatorElement);
        }else if (locatorType.toLowerCase().equals("name")){
            return By.name(locatorElement);
        }else if (locatorType.toLowerCase().equals("classname")){
            return By.className(locatorElement);
        }else if (locatorType.toLowerCase().equals("xpath")){
            return By.xpath(locatorElement);
        }else if (locatorType.toLowerCase().equals("css")){
            return By.cssSelector(locatorElement);
        }else if (locatorType.toLowerCase().equals("text")){
            return By.linkText(locatorElement);
        }
        return By.partialLinkText(locatorElement);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(GetLocator.getLocator("username"));
    }
}
