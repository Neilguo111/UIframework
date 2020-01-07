package com.qingxiao.base;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * 基类
 */
public class DriverBase {
    public WebDriver driver;

    public DriverBase(String browser) {
        SelectDriver sd = new SelectDriver();
        this.driver = sd.driverName(browser);
    }

    /**
     * 截图
     */
    public void takeScreenShot() {
        long date = System.currentTimeMillis();
        String path = String.valueOf(date);
        //获取当前文件目录
        String curPath = System.getProperty("user.dir");
        path = path + ".png";
        String screenPath = curPath + File.separator + path;
        //截图
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(screenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 关闭浏览器
     */
    public void stop() {
        driver.close();
    }

    /**
     * 封装element方法
     */
    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    /**
     * 封装返回WebElements方法
     * @param by
     * @return
     */
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * 封装返回操作
     */
    public void back(){
        driver.navigate().back();
    }

    /**
     * 跳转url
     */
    public void loadUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    /**
     * 接受提醒alert操作
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * 拒绝提醒
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    /**
     * 模态框切换
     */
    public void switchToMode(){
        driver.switchTo().activeElement();
    }

    /**
     * 获取cookie
     * @return
     */
    public Set<Cookie> getCookie(){
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }

    /**
     * 删除所有cookie
     */
    public void deleteCookie(){
        driver.manage().deleteAllCookies();
    }

    /**
     * 添加cookie
     * @param cookie
     */
    public void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    public void waitUntilExpect(By by){
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public Object executerJs(String js,Object...args){
        JavascriptExecutor driver = (JavascriptExecutor) this.driver;
        Object o = driver.executeScript(js, args);
        return o;
    }
}
