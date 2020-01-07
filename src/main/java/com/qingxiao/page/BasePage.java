package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        WebElement element = driver.findElement(by);
        return element;
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    /**
     * 等待
     * @param by
     */
    public void wait(By by){
        driver.waitUntilExpect(by);
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

    public void clearInput(WebElement element,String value){
        if (element != null){
            element.clear();
            element.sendKeys(value);
        }else {
            logger.error("元素没有定位到，输入失败！");
        }
    }

    /**
     * 返回页面
     */
    public void back(){
        driver.back();
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
