package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import com.qingxiao.utils.GetLocator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSetPage extends BasePage {

    public AccountSetPage(DriverBase driver) {
        super(driver);
    }

    static Logger logger = Logger.getLogger(AccountSetPage.class);
    /**
     * 获取返回按钮webelement
     * @return
     */
    public WebElement getReturnBtn()  {
        WebElement element = null;
        try {
            logger.info("开始定位元素：" + GetLocator.getLocator("editNickname").toString());
            element = driver.findElement(GetLocator.getLocator("returnBtn"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取修改昵称按钮webelement
     * @return
     */
    public WebElement getEditNicknameBtnElement() throws Exception {
        logger.info("开始获取定位信息：" + GetLocator.getLocator("editNickname"));
        driver.waitUntilExpect(GetLocator.getLocator("editNickname"));
        WebElement editNickname = driver.findElements(GetLocator.getLocator("editNickname")).get(0);
        return editNickname;
    }

    /**
     * 获取nickname输入框WebElement
     * @return
     * @throws Exception
     */
    public WebElement getNicknameInputElement() throws Exception {
        return driver.findElement(GetLocator.getLocator("nicknameInput"));
    }

    /**
     * 获取保存昵称按钮WebElement
     */
    public WebElement getCommitNicknameBtnElement() throws Exception {
        List<WebElement> commitSaveBtn = driver.findElements(GetLocator.getLocator("commitSaveBtn"));
        return commitSaveBtn.get(0);
    }

    /**
     * 获取修改密码保存按钮
     * 第一个元素是提交密码？
     */
    public WebElement getCommitPasswdBtnElement() throws Exception {
        List<WebElement> commitSaveBtn = driver.findElements(GetLocator.getLocator("commitSaveBtn"));
        return commitSaveBtn.get(0);
    }

    /**
     * 获取修改密码按钮WebElement
      * @return
     * @throws Exception
     */
    public WebElement getEditPasswordElement() throws Exception {
        return driver.findElement(GetLocator.getLocator("editPasswd"));
    }

    public WebElement getNicknameElement(){
        /**
         * 昵称元素,,,索引为0
         */
        WebElement element = null;
        try {
            element = driver.findElements(GetLocator.getLocator("assertNickname")).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

}
