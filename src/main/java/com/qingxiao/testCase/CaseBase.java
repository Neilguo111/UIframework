package com.qingxiao.testCase;

import com.qingxiao.base.DriverBase;

/**
 * init driver
 */
public class CaseBase {
    public DriverBase initDriver(String broswer){
        return new DriverBase(broswer);
    }
}
