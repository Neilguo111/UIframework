package com.qingxiao.business;


import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.SchoolListPageHandle;

/**
 * 校区列表业务层
 */
public class SchoolListPro {
    private DriverBase driverBase;
    private SchoolListPageHandle schoolListPageHandle;
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
     *点击登出
     */
    public void schoolListLoginOut(){
        schoolListPageHandle.clickLogoutBtn();
    }

    /**
     * 遍历校区
     */
    public void clickAllSchool(){
        schoolListPageHandle.iterSchool();
    }

    /**
     * 点击指定校区
     */
    public void enterSchool(int index){
        try {
            schoolListPageHandle.clickScool(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
