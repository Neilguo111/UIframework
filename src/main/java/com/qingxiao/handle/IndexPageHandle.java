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
    public void inpitHomeworkSubjectTitle(String title){
        indexPage.input(indexPage.getHomeworkTitleInputElement(),title);
    }

    /**
     * 输入日历打卡主题标题
     * @param title 标题
     */
    public void inputCalenderSubjectTile(String title){
        indexPage.input(indexPage.getCalenderTitleInputElement(),title);
    }

    /**
     * 获取选择班级按钮
     */
    public void clickClassSelectBtn(){
        indexPage.click(indexPage.getClassSelectElement());
    }
}
