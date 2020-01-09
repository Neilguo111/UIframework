package com.qingxiao.page;

import com.qingxiao.base.DriverBase;
import com.qingxiao.utils.GetLocator;
import org.openqa.selenium.WebElement;

/**
 * 首页元素
 */
public class IndexPage extends BasePage {
    public IndexPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取新建作业打卡按钮元素
     * @return WebElement
     */
    public WebElement getNewHomeworkSubjectBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newHomeworkSubjectBtn"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建作业打卡标题输入框
     * @return WebElement
     */
    public WebElement getHomeworkTitleInputElement(){
        WebElement element = null;
        try {
            element = driver.findElements(GetLocator.getLocator("subjectNamesInput")).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取班级选择下拉按钮
     * @return WebElement
     */
    public WebElement getClassSelectElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("classSelectBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建日历打卡标题输入框
     * @return WebElement
     */
    public WebElement getCalenderTitleInputElement(){
        WebElement element = null;
        try {
            element = driver.findElements(GetLocator.getLocator("subjectNamesInput")).get(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建日历打卡按钮元素
     * @return WebElement
     */
    public WebElement getNewCalenderSubjectBtnElement(){
        WebElement element = null;
        try{
            element = driver.findElement(GetLocator.getLocator("newCalenderSubjectBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * \获取新建闯关打卡按钮元素
     * @return WebElement
     */
    public WebElement getNewStepSubjectBtnElement(){
        WebElement element = null;
        try{
            element = driver.findElement(GetLocator.getLocator("newStepSubjectBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取学员报名按钮元素
     * @return WebElement
     */
    public WebElement getNewStudentApplyElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newStudentApply"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建班级按钮元素
     * @return WebElement
     */
    public WebElement getNewClassBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newClassBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建课程按钮元素
     * @return WebElement
     */
    public WebElement getNewCourseBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newCourseBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取点名提醒按钮元素
     * @return WebElement
     */
    public WebElement getWaitCallRemindBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("waitCallRemindBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取点名提醒数量
     * @return WebElement
     */
    public WebElement getWaitCallNumElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("waitCallNum"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取分配提醒按钮元素
     * @return WebElement
     */
    public WebElement getWaitJoinClassRemindBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("waitJoinClassRemindBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取分配提醒数量
     * @return WebElement
     */
    public WebElement getWaitJoinClassRemindNumElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("waitJoinClassRemindNum"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取生日提醒按钮元素
     * @return WebElement
     */
    public WebElement getBirthdayRemindBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("birthdayRemindBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取身体提醒数量元素
     * @return WebElement
     */
    public WebElement getBirthdayRemindNumElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("birthdayRemindNum"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取请假提醒按钮元素
     * @return WebElement
     */
    public WebElement getLeaveRemindBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("leaveRemindBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取请假提醒数量元素
     * @return WebElement
     */
    public WebElement getLeaveRemindNumElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("leaveRemindNum"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取续费提醒按钮元素
     * @return WebElement
     */
    public WebElement getRenewRemindBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("renewRemindBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取续费提醒数量元素
     * @return WebElement
     */
    public WebElement getRenewRemindNumElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("renewRemindNum"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }
}
