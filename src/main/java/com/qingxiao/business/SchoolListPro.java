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
     *
     */
}
