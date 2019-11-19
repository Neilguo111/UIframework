package com.qingxiao.testcase;

import com.qingxiao.TestngListenerScreenShot;
import com.qingxiao.base.DriverBase;
import com.qingxiao.utils.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestngListenerScreenShot.class})
public class LoginTest extends DriverBase {

    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void loginScript() throws Exception {
        driver.get("https://biz.qingxiao.online");
        WebElement user = driver.findElement(this.byString("username"));
        user.isDisplayed();
        WebElement password = driver.findElement(this.byString("passwd"));
        password.isDisplayed();
        WebElement loginButton = driver.findElement(this.byString("loginbtn"));
        loginButton.isDisplayed();
        user.sendKeys("17602116237");
        password.sendKeys("111111");
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

}
