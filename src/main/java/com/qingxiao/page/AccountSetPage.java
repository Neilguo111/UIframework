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
    public WebElement getReturnBtnElement()  {
        List<WebElement> returnCloseBtn = new ArrayList<WebElement>();
        try {
            logger.info("开始定位元素：" + GetLocator.getLocator("editNickname").toString());
            returnCloseBtn = driver.findElements(GetLocator.getLocator("returnCloseBtn"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnCloseBtn.get(0);
    }

    /**
     * 获取修改昵称按钮webelement
     * @return
     */
    public WebElement getEditNicknameBtnElement() throws Exception {
        logger.info("开始获取定位信息：" + GetLocator.getLocator("editNickname"));
        driver.waitUntilExpect(GetLocator.getLocator("editNickname"));
        List<WebElement> editNickname = driver.findElements(GetLocator.getLocator("editNickname"));
        if (editNickname.size()!= 0) {
            return editNickname.get(0);
        }
        return driver.findElement(GetLocator.getLocator("editNickname"));
    }

    /**
     * 获取nickname输入框WebElement
     * @return
     * @throws Exception
     */
    public WebElement getNicknameInputElement() throws Exception {
        return driver.findElement(GetLocator.getLocator("inputNickname"));
    }

    /**
     * 获取保存昵称按钮WebElement
     *
     */
    public WebElement getCommitNicknameBtnElement() throws Exception {
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

    public static void main(String[] args) {
    }
}
