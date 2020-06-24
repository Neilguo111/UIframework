package com.qingxiao.testcase;

import com.qingxiao.base.DriverBase;
import com.qingxiao.business.IndexPagePro;
import com.qingxiao.business.LogingPro;
import com.qingxiao.business.SchoolListPro;
import com.qingxiao.testCase.CaseBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateCourse extends CaseBase {
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
    public void createCourse(){
        try {
            ipp.newCourse("自动化新建课程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void setup(){
        driver.stop();
    }
}