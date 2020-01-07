package com.qingxiao.business;


import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.SchoolListPageHandle;

/**
 * 校区列表业务层
 */
public class SchoolListPro {
    public DriverBase driverBase;
    public SchoolListPageHandle schoolListPageHandle;
    public SchoolListPro(DriverBase driverBase){
        this.driverBase = driverBase;
        schoolListPageHandle = new SchoolListPageHandle(driverBase);
    }

    /**
     * 点击跳转账号设置
     */
    public void switchAccountSet() throws Exception {
        schoolListPageHandle.clickAccountSetBtn();
        Thread.sleep(2000);
    }

    /**
     *点击创建机构
     */
    public void schoolListLoginOut(){
        schoolListPageHandle.clickLogoutBtn();
    }
}
