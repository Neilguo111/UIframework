package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import com.qingxiao.utils.ProUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;


public class Login extends DriverBase {


    public Login(String browser) {
        super(browser);
    }

    public void loginScript(String username, String passwd) throws Exception {
        WebElement user = driver.findElement(this.byString("username"));
        user.isDisplayed();
        WebElement password = driver.findElement(this.byString("passwd"));
        password.isDisplayed();
        WebElement loginButton = driver.findElement(this.byString("loginbtn"));
        loginButton.isDisplayed();
        user.sendKeys(username);
        password.sendKeys(passwd);
        loginButton.click();
        Thread.sleep(1000);
        driver.findElement(this.byString("assertEle")).isDisplayed();
        String name = driver.findElement(this.byString("avatorEle")).getText();
        if ("Potential".equals(name)){
            this.takeScreenShot();
            System.out.println("请求成功");
        }else {
            System.out.println("请求失败");
        }
        driver.close();
    }

    /**
     *
     * @param key
     * @return 根绝key拿到配置文件中的locator和定位元素
     * @throws Exception
     */
    public By byString(String key) throws Exception {
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

    /**
     * 封装WebElement
     * @param by
     */
    public WebElement element(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    /**
     * 截图
     */
    public void takeScreenShot(){
        long date = System.currentTimeMillis();
        String path = String.valueOf(date);
        //获取当前文件目录
        String curPath = System.getProperty("user.dir");
        path = path + ".png";
        String screenPath = curPath + File.separator + path;
        //截图
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File(screenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
