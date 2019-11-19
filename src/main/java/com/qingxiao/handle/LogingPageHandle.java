package com.qingxiao.handle;

import com.qingxiao.base.DriverBase;
import com.qingxiao.page.LoginPage;
import com.qingxiao.utils.GetLocator;

public class LogingPageHandle {
    public DriverBase driver;
    //设置全局变量
    public LoginPage lp;

    public LogingPageHandle(DriverBase driver){
        this.driver = driver;
        lp = new LoginPage(driver);
    }

    /**
     * 输入用户名
     */
    public void inputUserName(String username) throws Exception {
        lp.input(lp.getUserElement(),username);
    }

    /**
     * 输入密码
     */
    public void inputPasswd(String passwd) throws Exception {
        lp.input(lp.getPasswd(),passwd);
    }

    /**
     * 点击登录
     */
    public void clickLoginBtn() throws Exception {
        lp.click(lp.getLoginBtn());
    }

    /**
     * 判断是否是登录页
     */
    public boolean assertLoginPage() throws Exception {
        return lp.isDisplay(lp.getUserElement());
    }
}
