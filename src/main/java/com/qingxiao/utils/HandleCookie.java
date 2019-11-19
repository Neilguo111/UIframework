package com.qingxiao.utils;

import com.qingxiao.base.DriverBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class HandleCookie {
    public DriverBase driverBase;
    public ProUtil proUtil;
    static Logger logger = Logger.getLogger(HandleCookie.class);
    public HandleCookie(DriverBase driverBase){
        this.driverBase = driverBase;
        proUtil = new ProUtil("cookie.properties");
    }

    /**
     * 从配置文件读取cookie,写入driver中
     */
    public void setCookie(){
        try {
            String value = proUtil.getPro("acw_tc");
            logger.info("正在从配置文件读取cookie信息。。。");
            Cookie cookie = new Cookie("acw_tc",value,"biz.qingxiao.online","/",null);
            driverBase.setCookie(cookie);
            logger.info("正在对当前driver写入cookie信息");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入cookie配置文件 TODO
     */
    public void writeCookie(){
        Set<Cookie> cookies = driverBase.getCookie();
        logger.info("获取当前driver中的cookies");
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("acw_tc")){
                proUtil.writeProperties(cookie.getName(),cookie.getValue());
                logger.info(cookie.getName() +":" + cookie.getValue() +" 正在写入配置文件");
            }
        }
    }
}
