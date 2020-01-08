package com.qingxiao.handle;

import com.qingxiao.base.DriverBase;
import com.qingxiao.page.SchoolListPage;
import com.qingxiao.utils.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SchoolListPageHandle {
    static Logger logger = Logger.getLogger(SchoolListPageHandle.class);
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

    public void clickLogoutBtn(){
        /**
         * 点击登出按钮
         */
        try {
            slp.click(slp.getLogoutBtn());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历所有校区
     */
    public void iterSchool(){
        try {
            List<WebElement> schoolsWebelement = slp.getSchoolsWebelement();
            for (int i = 0; i < schoolsWebelement.size(); i ++){
                slp.click(slp.getSchoolWebelement(i));
                Thread.sleep(1000);
                if (slp.isSchoolExpired()){
                    slp.click(slp.getConfirmBtn());
                    Thread.sleep(1000);
                }else {
                    slp.back();
                }
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean isSchoolExpireWindowPersent(){
        /**
         * 判断到期提示是否展示
         */
        boolean display = slp.isDisplay(slp.getExpireSchool());
        return display;
    }

    public void clickConfirmBtn(){
        /*
        点击到期确认按钮
         */
        slp.click(slp.getConfirmBtn());
    }

}
