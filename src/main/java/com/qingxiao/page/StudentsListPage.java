package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import com.qingxiao.utils.GetLocator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class StudentsListPage extends BasePage{

    static Logger logger = Logger.getLogger(StudentsListPage.class);

    public StudentsListPage(DriverBase driver) {
        super(driver);
    }

    // 获取新增学员按钮WebElement
    public WebElement getAddStudentBtn()  {
        WebElement element = null;
        try {
            logger.info("---开始获取新增学员按钮元素---");
            element =  driver.findElement(GetLocator.getLocator("addStudentBtn"));
            logger.info("---获取成功---");
        } catch (Exception e) {
            logger.error("---获取新增学员按钮失败---");
        }
        return element;
    }

    // 获取更多筛选项元素
    public WebElement getMoreStudentSelection(){
        WebElement element = null;
        try {
            logger.info("---开始获取更多筛选条件按钮---");
            element = driver.findElement(GetLocator.getLocator("moreStudentSelection"));
            logger.info("---获取成功---");
        }catch (Exception e){
            logger.error("---获取更多筛选条件按钮失败---");
        }
        return element;
    }

    // 获取搜索学员姓名手机号元素
    public WebElement getSearchStudentNameMobile(){
        WebElement element = null;
        try{
            logger.info("---开始获取搜索学员姓名手机号输入框---");
            element = driver.findElement(GetLocator.getLocator("searchStudentNameMobile"));
            logger.info("---获取成功---");
        }catch (Exception e){
            logger.error("---获取学员姓名手机号输入框失败---");
        }
        return element;
    }

    // 获取搜索学员课程下拉元素
    public WebElement getSearchStudentCourse(){
        WebElement element = null;
        try {
            logger.info("---开始获取搜素学员课程下拉---");
            element = driver.findElement(GetLocator.getLocator("searchStudentCourse"));
            logger.info("---获取成功---");
        }catch (Exception e){
            logger.error("获取搜素学员课程下拉失败");
        }
        return element;
    }

    // 获取搜素学员班级下拉元素
    public WebElement getSearchStudentClass(){
        WebElement element = null;
        try{
            logger.info("---开始获取搜素学员班级下拉元素---");
            element = driver.findElement(GetLocator.getLocator("searchStudentClass"));
            logger.info("---获取成功---");
        }catch (Exception e){
            logger.error("获取搜素学员班级下拉元素失败");
        }
        return element;
    }

    // 获取搜索学员状态下拉元素
    public WebElement getSearchStudentStaus(){
        WebElement element = null;
        try{
            logger.info("---开始获取搜素学员状态下拉元素---");
            element = driver.findElement(GetLocator.getLocator("searchStudentStaus"));
        }catch (Exception e){
            logger.error("获取搜素学员状态下拉元素失败");
        }
        return element;
    }

    // 获取微信绑定状态下拉元素
    public WebElement getSearchWechatBindStatus(){
        WebElement element = null;
        try{
            logger.info("---开始获取搜索学员微信绑定状态元素---");
            element = driver.findElement(GetLocator.getLocator("searchWechatBindStatus"));
            logger.info("获取微信绑定状态下拉元素成功");
        }catch (Exception e){
            logger.error("获取微信绑定状态下拉元素失败");
        }
        return element;
    }

    // 获取加入班级状态元素
    public WebElement getSearchJoinClassStaus(){
        WebElement element = null;
        try{
            logger.info("---开始获取加入班级状态元素---");
            element = driver.findElement(GetLocator.getLocator("searchJoinClassStaus"));
            logger.info("---获取成功---");
        }catch (Exception e){
            logger.info("获取失败");
        }
        return element;
    }
}
