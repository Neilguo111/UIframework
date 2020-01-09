package com.qingxiao.testcase;

import com.qingxiao.base.DriverBase;
import com.qingxiao.business.AccountSetPro;
import com.qingxiao.business.LogingPro;
import com.qingxiao.business.SchoolListPro;
import com.qingxiao.testCase.CaseBase;
import com.qingxiao.utils.HandleCookie;
import com.qingxiao.utils.ProUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qingxiao.utils.Utils.getText;

public class RenameTest extends CaseBase {
    private DriverBase driverBase;
    private SchoolListPro schoolListPro;
    private AccountSetPro accountSetPro;
    private ProUtil proUtil;
    private HandleCookie handleCookie;
    private LogingPro logingPro;

    @BeforeClass
    public void beforeTest(){
        driverBase = initDriver("Chrome");
        schoolListPro = new SchoolListPro(driverBase);
        accountSetPro = new AccountSetPro(driverBase);
        proUtil = new ProUtil("cookie.properties");
//        handleCookie = new HandleCookie(driverBase);
        logingPro = new LogingPro(driverBase);
        driverBase.loadUrl("https://biz.qingxiao.online");
//        handleCookie.setCookie();
//        driverBase.loadUrl("https://biz.qingxiao.online/#/erp/usersetting");
    }


    @Test
    public void Login() throws Exception {
        logingPro.login("17602116237","111111");
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"Login"})
    public void switchSetPage() throws Exception {
        schoolListPro.switchAccountSet();
    }

    @Test(dependsOnMethods = {"switchSetPage"})
    public void renameTest() throws Exception {
        accountSetPro.rename();
        Assert.assertEquals(getText(accountSetPro.accountSetPageHandle.getNicknameText()),"rename");
    }

    @Test(dependsOnMethods = {"Login"})
    public void iterSchool(){
        schoolListPro.clickAllSchool();
    }

    @AfterClass
    public void afterClass(){
        driverBase.stop();
    }
}
