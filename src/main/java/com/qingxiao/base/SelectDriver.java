package com.qingxiao.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
    /**
     * 兼容多种浏览器
     * @param browser
     * @return
     */
    public WebDriver driverName(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.marionette","E:\\java project\\geckodriver-v0.26.0-win64\\ geckodriver.exe");
            return new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
