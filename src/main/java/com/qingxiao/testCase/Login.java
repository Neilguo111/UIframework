package com.qingxiao.testCase;

import com.qingxiao.base.DriverBase;
import com.qingxiao.business.LogingPro;

public class Login extends CaseBase {
    public DriverBase driver;
    public LogingPro logingPro;
    public Login(){
        driver = initDriver("chrome");
        logingPro = new LogingPro(driver);
    }

    /**
     * 访问url
     * @throws InterruptedException
     */

    public void getLoginHome() throws InterruptedException {
        driver.loadUrl("https://biz.qingxiao.online");
        Thread.sleep(5000);
    }
    public void testLogin() throws Exception {
        logingPro.login("17602116237","111111");
    }
}

