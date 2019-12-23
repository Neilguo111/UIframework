package com.qingxiao.handle;

import com.qingxiao.base.DriverBase;
import com.qingxiao.page.SchoolListPage;
import com.qingxiao.utils.Utils;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SchoolListPageHandle {
    public DriverBase driver;
    public SchoolListPage slp;
    public SchoolListPageHandle(DriverBase driver){
        this.driver = driver;
        slp = new SchoolListPage(driver);
    }

    /**
     * 查看指定校区
     * @param index
     * @throws Exception
     */
    public void clickScool(int index) throws Exception {
        List<WebElement> schoolsWebelement = slp.getSchoolsWebelement();
        schoolsWebelement.get(index).click();
    }

    /**
     * 点击创建校区
     * @throws Exception
     */
    public void clickCreateBtn() throws Exception {
        slp.click(slp.getCreateSchoolBtn());
    }

    /**
     * 获取校区数量
     */
    public int getSchoolNum() throws Exception {
        String text = slp.getText(slp.getSchoolNumElment());
        int anInt = Utils.getInt(text);
        return anInt;
    }

    /**
     * 点击账号设置按钮
     * @throws Exception
     */
    public void clickAccountSetBtn() throws Exception {

        slp.click(slp.getSetImformationBtn());
    }

}
