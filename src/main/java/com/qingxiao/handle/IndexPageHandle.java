package com.qingxiao.handle;

import com.qingxiao.base.DriverBase;
import com.qingxiao.page.IndexPage;

/**
 * 首页元素处理层
 */
public class IndexPageHandle {
    private IndexPage indexPage;
    private DriverBase driverBase;
    public IndexPageHandle(DriverBase driverBase){
        this.driverBase =driverBase;
        indexPage = new IndexPage(driverBase);
    }

    /**
     * 点击新建作业打卡按钮
     */
    public void clickNewHomeworkSubjectBtn(){
        indexPage.click(indexPage.getNewHomeworkSubjectBtnElement());
    }

    /**
     * 点击新建日历打卡按钮
     */
    public void clickNewCalenderSubjectBtn(){
        indexPage.click(indexPage.getNewCalenderSubjectBtnElement());
    }

    /**
     * 新建作业打卡按钮
     */
    public void clickNewStepSubjectBtn(){
        indexPage.click(indexPage.getNewStepSubjectBtnElement());
    }

    /**
     * 点击新生报名按钮
     */
    public void clickNewStudentApply(){
        indexPage.click(indexPage.getNewStudentApplyElement());
    }

    /**
     * 点击新建班级按钮
     */
    public void clickNewClassBtn(){
        indexPage.click(indexPage.getNewClassBtnElement());
    }

    /**
     * 点击新建课程按钮
     */
    public void clickNewCourseBtn(){
        indexPage.click(indexPage.getNewCourseBtnElement());
    }

    /**
     * 点击点名提醒按钮
     */
    public void clickWaitCallBtn(){
        indexPage.click(indexPage.getWaitCallRemindBtnElement());
    }

    /**
     * 获取待点名数量
     * @return text
     */
    public String getWaitCallNumber(){
        String text = indexPage.getWaitCallNumElement().getText();
        return text;
    }

    /**
     * 点击待分配提醒
     */
    public void clickWaitJoinClassRemindBtn(){
        indexPage.click(indexPage.getWaitJoinClassRemindBtnElement());
    }

    /**
     * 获取待分配提醒数量
     * @return
     */
    public String getWaitJoinClassNumber(){
        return indexPage.getWaitJoinClassRemindNumElement().getText();
    }

    /**
     * 点击生日提醒按钮
     */
    public void clickBirthdayRemindBtn(){
        indexPage.click(indexPage.getBirthdayRemindBtnElement());
    }

    /**
     * 获取生日提醒数量
     * @return
     */
    public String getBirthdayRemindNumber(){
        return indexPage.getBirthdayRemindNumElement().getText();
    }

    /**
     * 点击请假提醒按钮
     */
    public void clickLeaveRemindBtn(){
        indexPage.click(indexPage.getLeaveRemindBtnElement());
    }

    /**
     * 获取请假提醒数量
     * @return text
     */
    public String getLeaveRemindNumber(){
        return indexPage.getLeaveRemindNumElement().getText();
    }

    /**
     * 输入作业打卡标题
     * @param title 标题
     */
    public void inputHomeworkSubjectTitle(String title){
        indexPage.input(indexPage.getHomeworkTitleInputElement(),title);
    }

    /**
     * 输入日历打卡主题标题
     * @param title 标题
     */
    public void inputCalenderSubjectTile(String title) throws Exception {
        indexPage.input(indexPage.getCalenderTitleInputElement(),title);
    }

    /**
     * 获取选择班级按钮
     */
    public void clickClassSelectBtn(){
        indexPage.click(indexPage.getClassSelectElement());
    }

    /**
     * 新建打卡 点击选定班级
     */
    public void clickClassConfirmBtn(){
        indexPage.click(indexPage.getClassElement());
    }

    /**
     * 点击提交主题按钮
     */
    public void clickSubmitHomewrkSubjectBtn(){
        indexPage.click(indexPage.getSubmitHomeworkSubjectBtnElement());
    }

    /**
     * 点击提交日历打卡主题按钮
     */
    public void clickSubmitCalenderSubjectBtn(){
        indexPage.click(indexPage.getSubmitCalenderSubjectBtnElement());
    }

    /**
     * 输入学员报名姓名
     * @param name 学员姓名
     */
    public void typeStudentApplyName(String name){
        indexPage.input(indexPage.getStudentApplyNameInputElement(),name);
    }

    /**
     *  点击选择学员姓名按钮
     */
    public void clickStudentSexBtn(){
        indexPage.click(indexPage.getStudentApplySexSelectBtnElement());
    }

    /**
     * 点击输入学员报名电话
     * @param mobile 学员联系方式
     */
    public void typeStudentMobile(String mobile){
        indexPage.input(indexPage.getStudentApplyMobileInputElement(),mobile);
    }

    /**
     * 点击新增学员确定按钮
     */
    public void clickStudentApplyConfirmBtn(){
        indexPage.click(indexPage.getStudentApplyConfirmBtnElement());
    }

    /**
     * 新建班级点击班级课程下拉框按钮
     */
    public void clickNewClassCourseNameBtn(){
        indexPage.click(indexPage.getNewClassCourseNameBtnElement());
    }

    /**
     * 点击选择新建班级所属课程
     */
    public void clickNewClassCourses(){
        indexPage.click(indexPage.getNewClassCoursesElement());
    }

    /**
     * 新建班级输入班级名称
     * @param className 班级名称
     */
    public void typeNewClassName(String className){
        indexPage.input(indexPage.getNewClassNameInputElement(),className);
    }

    /**
     * 输入班级容量
     * @param classCapacity 班级容量大小
     */
    public void typeClassCapacity(String classCapacity){
        indexPage.input(indexPage.getNewClassSizeInputElement(),classCapacity);
    }

    /**
     * 新建班级输入课时消耗
     * @param expend 课时消耗
     */
    public void typeClassCourseExpend(String expend){
        indexPage.input(indexPage.getNewClassCourseConsumerInputElement(),expend);
    }

    /**
     * 新建班级 点击确认新建班级确认按钮
     */
    public void clickNewClassConfirmBtn(){
        indexPage.click(indexPage.getNewClassConfirmBtnElement());
    }

    /**
     * 输入课程名称
     * @param courseName 课程名称
     */
    public void typeNewCourseName(String courseName){
        indexPage.input(indexPage.getNewCourseNameInputElement(),courseName);
    }

    /**
     * 点击新建课程确认按钮
     */
    public void clickNewCourseConfirmBtn(){
        indexPage.click(indexPage.getNewCourseConfirmBtnElement());
    }
}
