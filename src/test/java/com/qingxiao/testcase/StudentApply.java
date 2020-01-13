package com.qingxiao.testcase;

import com.qingxiao.base.DriverBase;
import com.qingxiao.business.IndexPagePro;
import com.qingxiao.business.LogingPro;
import com.qingxiao.business.SchoolListPro;
import com.qingxiao.testCase.CaseBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 新学员报名
 */
public class StudentApply extends CaseBase  {
    private DriverBase driver;
    private LogingPro lp;
    private IndexPagePro ipp;
    private SchoolListPro slp;

    @BeforeTest
    public void beforeTest(){
        driver = initDriver("chrome");
        lp = new LogingPro(driver);
        ipp = new IndexPagePro(driver);
        slp = new SchoolListPro(driver);
        driver.loadUrl("https://biz.qingxiao.online");
    }

    @Test
    public void Login(){
        try {
            lp.login("17602116237","111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"Login"})
    public void getSchool(){
        slp.enterSchool(1);
    }

    @Test(dependsOnMethods = {"getSchool"})
    public void studentApply(){
        try {
            ipp.newStudentApply("测试学员","13100000000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void setUp(){
        driver.stop();
    }
}
