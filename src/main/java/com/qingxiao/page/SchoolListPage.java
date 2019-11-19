package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import com.qingxiao.utils.GetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SchoolListPage extends BasePage {
    public SchoolListPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取设置按钮
     */
    public WebElement getSetImformationBtn() throws Exception {
        return driver.findElement(GetLocator.getLocator("setImformation"));
    }

    /**
     * 获取退出按钮
     */
    public WebElement getLogoutBtn() throws Exception {
        return driver.findElement(GetLocator.getLocator("logout"));
    }

    /**
     * 获取校区名字
     */
    public List<String> getSchoolsName() throws Exception {
        List<String> listName = new ArrayList<String>();
        List<WebElement> schoolsName = driver.findElements(GetLocator.getLocator("schoolsName"));
        for (WebElement we:schoolsName){
            listName.add(we.getText());
        }
        return listName;
    }

    /**
     * 获取全部校区webelement
      * @return
     * @throws Exception
     */
    public List<WebElement> getSchoolsWebelement() throws Exception {
        return driver.findElements(GetLocator.getLocator("schoolsName"));
    }

    /**
     * 获取校区身份列表
     */
    public List<WebElement> getIdentityList() throws Exception {
        return driver.findElements(GetLocator.getLocator("identityCards"));
    }

    /**
     * 获取创建校区按钮
     */
    public WebElement getCreateSchoolBtn() throws Exception {
        return driver.findElement(GetLocator.getLocator("createSchool"));
    }

    /**
     * 获取校区数量Element
     */
    public WebElement getSchoolNumElment() throws Exception {
        return driver.findElement(GetLocator.getLocator("schoolNum"));
    }

//    @FindBy(how = How.ID,id = "asdas")
//    WebElement message;
}
