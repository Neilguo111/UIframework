package com.qingxiao.business;

import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.StudentsListPageHandle;

public class StudentsListPro {

    public DriverBase driver;
    public StudentsListPageHandle slp;
    public StudentsListPro(DriverBase driver){
        this.driver = driver;
        slp = new StudentsListPageHandle(driver);
    }

    public void SearchByStudentNameMobile(String str){
        /**
         * 搜索学员姓名电话
         */
        slp.clickMoreSelection();
        slp.inputStudentNameMobile(str);
        slp.clickSearchBtn();
    }

    public void SearchByStudentNameMobileReset(String str){
        /**
         * 搜索完成之后重置搜索条件
         */
        slp.clickMoreSelection();
        slp.inputStudentNameMobile(str);
        slp.clickSearchBtn();
        slp.clickResetBtn();
    }
}
