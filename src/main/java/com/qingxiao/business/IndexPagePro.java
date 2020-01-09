package com.qingxiao.business;

import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.IndexPageHandle;

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
        iph.inpitHomeworkSubjectTitle(title);
        iph.clickClassSelectBtn();
    }
}
