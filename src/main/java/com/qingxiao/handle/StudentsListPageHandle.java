package com.qingxiao.handle;


import com.qingxiao.base.DriverBase;
import com.qingxiao.page.StudentsListPage;

public class StudentsListPageHandle {
    /**
     * 处理学员列表元素
     */

    public DriverBase driver;
    private StudentsListPage studentsListPage;
    public StudentsListPageHandle(DriverBase driverBase){
        this.driver = driverBase;
        studentsListPage = new StudentsListPage(driver);
    }

    public void clickAddStudentBtn(){
        /**
         * 点击新增学员按钮元素
         */
        studentsListPage.click(studentsListPage.getAddStudentBtn());
    }

    public void clickMoreSelection(){
        /**
         * 点击更多筛选项按钮
         */
        studentsListPage.click(studentsListPage.getMoreStudentSelection());
    }

    public void inputStudentNameMobile(String str){
        /**
         * 输入搜索内容
         */
           studentsListPage.input(studentsListPage.getSearchJoinClassStaus(),str);
    }

    public void clickSearchStudentCourseBtn(){
        /**
         * 点击搜索学员课程下拉元素
         */
        studentsListPage.click(studentsListPage.getSearchStudentCourse());
    }

    public void clickSearchStudentClassBtn(){
        /**
         * 点击搜索学员班级下拉元素
         */
        studentsListPage.click(studentsListPage.getSearchStudentClass());
    }

    public void clickSearchStudentStatus(){
        /**
         * 点击搜索学员状态元素
         */
        studentsListPage.click(studentsListPage.getSearchStudentStaus());
    }

    public void clickSearchWechatBindStaus(){
        /**
         * 点击搜索学员微信绑定状态元素
         */
        studentsListPage.click(studentsListPage.getSearchWechatBindStatus());
    }

    public void clickSearchJoinClassStatus(){
        /**
         * 点击搜索学员分班状态元素
         */
        studentsListPage.click(studentsListPage.getSearchJoinClassStaus());
    }

    public void clickSearchBtn(){
        /**
         * 点击搜索学员按钮
         */
        studentsListPage.click(studentsListPage.getSearchBtn());
    }

    public void clickResetBtn(){
        /**
         * 点击重置搜索条件按钮
         */
        studentsListPage.click(studentsListPage.getSearchResetBtn());
    }

    public void clickHistoryStudentList(){
        /**
         * 点击获取历史在读学员按钮
         */
        studentsListPage.click(studentsListPage.getHistoryStudentListBtn());
    }

    public void clickOnClassStudentList(){
        /**
         * 点击获取在读学员列表按钮
         */
        studentsListPage.click(studentsListPage.getOnClassStudentListBtn());
    }
}
