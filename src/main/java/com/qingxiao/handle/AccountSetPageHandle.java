package com.qingxiao.handle;

import com.qingxiao.base.DriverBase;
import com.qingxiao.page.AccountSetPage;

public class AccountSetPageHandle {
    private DriverBase driverBase;
    private AccountSetPage accountSetPage;
    public AccountSetPageHandle(DriverBase driverBase){
        this.driverBase = driverBase;
        this.accountSetPage = new AccountSetPage(driverBase);
    }

    /**
     * 返回学校列表页面
     */
    public void clickReturnBtn(){
        accountSetPage.click(accountSetPage.getReturnBtn());
    }

    /**
     * 点击修改昵称按钮
     */
    public void clickEditNicknameBtn() throws Exception {
        accountSetPage.click(accountSetPage.getEditNicknameBtnElement());
    }

    /**
     * 获取昵称
     * @return
     * @throws Exception
     */
    public String getNicknameText() throws Exception {
        return accountSetPage.getText(accountSetPage.getNicknameElement());
    }

    /**
     * 输入nickname
     * @param nickname
     * @throws Exception
     */
    public void inputNewNicknam(String nickname) throws Exception {
        accountSetPage.clearInput(accountSetPage.getNicknameInputElement(),nickname);
    }

    /**
     * 点击保存nickname
     * @throws Exception
     */
    public void clickCommitNicknameBtn() throws Exception {
        accountSetPage.click(accountSetPage.getCommitNicknameBtnElement());
    }
}
