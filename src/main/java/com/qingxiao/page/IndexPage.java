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
     * 获取选定班级元素
     * @return WebElement
     */
    public WebElement getClassElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("classConfirmBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取发布作业打卡主题按钮
     * @return WebElement
     */
    public WebElement getSubmitHomeworkSubjectBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElements(GetLocator.getLocator("submitSubjectBtn")).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取发布日历打卡主题按钮
     * @return WebElement
     */
    public WebElement getSubmitCalenderSubjectBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElements(GetLocator.getLocator("submitSubjectBtn")).get(1);
        }catch (Exception e){
            try {
                // 找到的元素非列表就直接定位
                element = driver.findElement(GetLocator.getLocator("submitSubjectBtn"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return element;
    }

    /**
     * 获取新建日历打卡标题输入框
     * @return WebElement
     */
    public WebElement getCalenderTitleInputElement() throws Exception {
        WebElement element = null;
        try {
            element = driver.findElements(GetLocator.getLocator("subjectNamesInput")).get(1);
        }catch (Exception e){
            element = driver.findElement(GetLocator.getLocator("subjectNamesInput"));
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
     * 获取报名学员姓名输入框元素
     * @return WebElement
     */
    public WebElement getStudentApplyNameInputElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("studentApplyNameInput"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取学员报名性别选择按钮元素
     * @return WebElement
     */
    public WebElement getStudentApplySexSelectBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("studentApplySexSelectBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }


    /**
     * 获取学员报名输入框元素
     * @return WebElement
     */
    public WebElement getStudentApplyMobileInputElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("studentApplyMobileInput"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取学员报名确定按钮
     * @return WebElement
     */
    public WebElement getStudentApplyConfirmBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("studentApplyConfirmBtn"));
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
     * 获取课程选择按钮元素
     * @return WebElement
     */
    public WebElement getNewClassCourseNameBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newClassCourseNameBtn"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建班级课程选择元素
     * 默认选择第一个
     * @return WebElement
     */
    public WebElement getNewClassCoursesElement(){
        WebElement element = null;
        try {
            element = driver.findElements(GetLocator.getLocator("newClassCourses")).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建班级班级名称输入框元素
     * @return WebElement
     */
    public WebElement getNewClassNameInputElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newClassNameInput"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建班级 班级容量输入框元素
     * @return WebElement
     */
    public WebElement getNewClassSizeInputElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newClassSizeInput"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建班级 消耗课时数输入框元素
     * @return WebElement
     */
    public WebElement getNewClassCourseConsumerInputElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newClassCourseConsumerInput"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建班级确认按钮元素
     * @return WebElement
     */
    public WebElement getNewClassConfirmBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newClassConfirmBtn"));
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
     * 获取新建课程输入框元素
     * @return WebElement
     */
    public WebElement getNewCourseNameInputElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newCourseNameInput"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    /**
     * 获取新建课程确定按钮元素
     * @return WebElement
     */
    public WebElement getNewCourseConfirmBtnElement(){
        WebElement element = null;
        try {
            element = driver.findElement(GetLocator.getLocator("newCourseConfirmBtn"));
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
