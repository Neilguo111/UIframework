package com.qingxiao.business;

import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.IndexPageHandle;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 处理首页业务
 */
public class IndexPagePro {
    private DriverBase driver;
    private IndexPageHandle iph;
    public IndexPagePro(DriverBase driverBase){
        this.driver = driverBase;
        iph = new IndexPageHandle(driver);
    }

    /**
     * 新建作业打卡
     */
    public void createHomeworkSubject(String title){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickNewHomeworkSubjectBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.inputHomeworkSubjectTitle(title);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickClassSelectBtn();
        // 选定班级
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickClassConfirmBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickSubmitHomewrkSubjectBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建日历打卡
     * @param title 日历打卡主题标题
     */
    public void createCalenderSubject(String title){
        iph.clickNewCalenderSubjectBtn();
        iph.inputCalenderSubjectTile(title);
        iph.clickClassSelectBtn();
        iph.clickClassConfirmBtn();
        iph.clickSubmitCalenderSubejctBtn();
    }
}
