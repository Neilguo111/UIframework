package com.qingxiao.testcase;

import com.qingxiao.base.DriverBase;
import com.qingxiao.business.LogingPro;
import com.qingxiao.testCase.CaseBase;
import com.qingxiao.utils.HandleCookie;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends CaseBase {
    public DriverBase driver;
    public LogingPro logingPro;
    public HandleCookie handleCookie;
    static Logger logger = Logger.getLogger(Login.class);
//    public Login(){
//        driver = initDriver("chrome");
//        logingPro = new LogingPro(driver);
//    }

    @BeforeClass
    public void beforeTest(){
        this.driver = initDriver("chrome");
        handleCookie = new HandleCookie(driver);
        logingPro = new LogingPro(driver);
    }


    /**
     * 访问url
     * @throws InterruptedException
     */
    @Test
    public void getLoginHome()  {
        driver.loadUrl("https://biz.qingxiao.online");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test(dependsOnMethods = {"getLoginHome"})
    public void testLogin() throws Exception {
        logger.info("开启执行登录自动化case");
        logingPro.login("17602116237","111111");
        handleCookie.writeCookie();
        Thread.sleep(2000);
     }

     @AfterClass
     public void afterClass(){
        driver.stop();
     }

}
