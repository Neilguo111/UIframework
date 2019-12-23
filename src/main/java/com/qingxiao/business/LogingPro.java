package com.qingxiao.business;

import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.LogingPageHandle;
import org.apache.log4j.Logger;

/**
 * 登录业务层
 */
public class LogingPro {
    public LogingPageHandle lph;
    static Logger logger = Logger.getLogger(LogingPro.class);
    //获取driver
    public LogingPro(DriverBase driver){
        lph = new LogingPageHandle(driver);
    }

    public void login(String username,String passwd) throws Exception {
        logger.info("开始执行登录操作！");
        if (lph.assertLoginPage()) {
            lph.inputUserName(username);
            lph.inputPasswd(passwd);
            lph.clickLoginBtn();
            Thread.sleep(2000);
        }else {
            System.out.println("页面不存在，或者状态不正确！");
            logger.error("页面不存在，或者状态不正确！");
        }
    }
}
