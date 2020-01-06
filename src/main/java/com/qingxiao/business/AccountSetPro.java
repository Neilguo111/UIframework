package com.qingxiao.business;

import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.AccountSetPageHandle;

// 账号设置页面
public class AccountSetPro {
    public DriverBase driverBase;
    public AccountSetPageHandle accountSetPageHandle;
    public AccountSetPro(DriverBase driverBase){
        this.driverBase = driverBase;
        accountSetPageHandle = new AccountSetPageHandle(driverBase);
    }

    /**
     * 修改昵称
     */
    public void rename() throws Exception {
        accountSetPageHandle.clickEditNicknameBtn();
        Thread.sleep(2000);
        try {
            accountSetPageHandle.inputNewNicknam("rename");
            String nickname = accountSetPageHandle.getNickname();
            accountSetPageHandle.clickCommitNicknameBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public boolean assertRenameSuccess(){
//        if ()
//    }
}
