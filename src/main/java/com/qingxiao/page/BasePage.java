package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    public DriverBase driver;
    static Logger logger = Logger.getLogger(BasePage.class);
    public BasePage(DriverBase driver) {
        this.driver = driver;
    }

    /**
     * 定位element方法
     * @param by
     * @return
     */
    public WebElement findElement(By by){
        WebElement element = null;
        try {
            element = driver.findElement(by);
            logger.info("开始获取元素" + by.toString());
        }catch (NoSuchElementException e){
            logger.error("找不到元素" + e.getMessage());
        }
        return element;
    }

    /**
     * 查找元素列表
     * @param by
     * @return
     */
    public List<WebElement> findElements(By by){
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }

    /**
     * 等待
     * @param by
     */
    public void wait(By by){
        driver.waitUntilExpect(by);
    }

    /**
     * 刷新页面
     */
    public void refresh(){
        driver.refresh();
    }

    /**
     * 封装点击事件
     * @param element
     */
    public void click(WebElement element){
        if (element != null){
            element.click();
        }else {
            logger.error("元素没有定位到，点击失败！");
        }
    }

    /**
     * 封装输入事件
     * @param element WebElement对象，通过findElement方法取得
     * @param value 输入内容
     */
    public void input(WebElement element,String value){
        if (element != null){
            element.sendKeys(value);
        }else {
            logger.error("元素没有定位到，输入失败！");
        }
    }

    /**
     * 删除现有内容后输入
     * @param element
     * @param value
     */
    public void clearInput(WebElement element,String value){
        if (element != null){
            element.clear();
            element.sendKeys(value);
        }else {
            logger.error("元素没有定位到，输入失败！");
        }
    }

    public String getElementText(WebElement element){
        return element.getText();
    }

    /**
     * 返回页面
     */
    public void back(){
        driver.back();
    }

    /**
     * 获取当前页面title
     * @return String
     */
    public String windowTitle(){
        return driver.currentWindowTitle();
    }

    /**
     * 封装元素是否显示的判断
     * @param element
     * @return Boolean
     */
    public boolean isDisplay(WebElement element){
        return element.isDisplayed();
    }

    /**
     * 获取文本信息
     */
    public String getText(WebElement element){
        return element.getText();
    }

    public void executeJs(String jsCode){
    }

}
