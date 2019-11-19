package com.qingxiao.handle;

import com.qingxiao.base.DriverBase;
import com.qingxiao.page.AccountSetPage;

public class AccountSetPageHandle {
    public DriverBase driverBase;
    public AccountSetPage accountSetPage;
    public AccountSetPageHandle(DriverBase driverBase){
        this.driverBase = driverBase;
        this.accountSetPage = new AccountSetPage(driverBase);
    }

    /**
     * 返回学校列表页面
     */
    public void clickReturnBtn(){
        accountSetPage.click(accountSetPage.getReturnBtnElement());
    }

    /**
     * 点击修改昵称按钮
     */
    public void clickEditNicknameBtn(){
        accountSetPage.click(accountSetPage.getEditNicknameBtnElement());
    }

    /**
     * 获取昵称
     * @return
     * @throws Exception
     */
    public String getNickname() throws Exception {
        return accountSetPage.getText(accountSetPage.getNicknameInputElement());
    }

    /**
     * 输入nickname
     * @param nickname
     * @throws Exception
     */
    public void inputNewNicknam(String nickname) throws Exception {
        accountSetPage.input(accountSetPage.getNicknameInputElement(),nickname);
    }

    /**
     * 点击保存nickname
     * @throws Exception
     */
    public void clickCommitNicknameBtn() throws Exception {
        accountSetPage.click(accountSetPage.getCommitNicknameBtnElement());
    }
}
