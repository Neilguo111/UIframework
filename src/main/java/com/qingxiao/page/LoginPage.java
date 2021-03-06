package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import com.qingxiao.utils.GetLocator;
import org.openqa.selenium.WebElement;

/**
 * 封装登录页面元素
 */
public class LoginPage extends BasePage {

    public LoginPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取轻校账号登录元素
     * @return WebElement
     * @throws Exception
     */
    public WebElement getUserElement() throws Exception {
        return findElements(GetLocator.getLocator("username")).get(0);
    }

    /**
     * 获取密码输入框元素
     * @return WebElement
     * @throws Exception
     */
    public WebElement getPasswd() throws Exception {
        return findElements(GetLocator.getLocator("passwd")).get(0);
    }

    /**
     * 获取登录按钮元素
     * @return WebElement
     * @throws Exception
     */
    public WebElement getLoginBtn() throws Exception {
        return findElements(GetLocator.getLocator("loginbtn")).get(0);
    }

    /**
     * 检查username元素是否存在
     */
    public boolean checkIsValid() throws Exception {
        return isDisplay(findElement(GetLocator.getLocator("username")));
    }
}
