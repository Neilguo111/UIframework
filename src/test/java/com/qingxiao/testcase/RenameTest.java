package com.qingxiao.testcase;

import com.qingxiao.base.DriverBase;
import com.qingxiao.business.AccountSetPro;
import com.qingxiao.business.SchoolListPro;
import com.qingxiao.testCase.CaseBase;
import com.qingxiao.utils.HandleCookie;
import com.qingxiao.utils.ProUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RenameTest extends CaseBase {
    public DriverBase driverBase;
    public SchoolListPro schoolListPro;
    public AccountSetPro accountSetPro;
    public ProUtil proUtil;
    public HandleCookie handleCookie;

    @BeforeClass
    public void beforeTest(){
        driverBase = initDriver("Chrome");
        schoolListPro = new SchoolListPro(driverBase);
        accountSetPro = new AccountSetPro(driverBase);
        proUtil = new ProUtil("cookie.properties");
        handleCookie = new HandleCookie(driverBase);
        driverBase.loadUrl("https://biz.qingxiao.online/#/erp/usersetting");
        handleCookie.setCookie();
        driverBase.loadUrl("https://biz.qingxiao.online/#/erp/usersetting");
    }

    @Test
    public void renameTest(){
        accountSetPro.rename();
    }

    @AfterClass
    public void afterClass(){
        driverBase.stop();
    }
}
