package com.qingxiao.business;

import com.qingxiao.base.DriverBase;
import com.qingxiao.handle.IndexPageHandle;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 处理首页业务
 */
public class IndexPagePro {
    private DriverBase driver;
    private IndexPageHandle iph;
    public IndexPagePro(DriverBase driverBase){
        this.driver = driverBase;
        iph = new IndexPageHandle(driver);
    }

    /**
     * 新建作业打卡
     */
    public void createHomeworkSubject(String title){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickNewHomeworkSubjectBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.inputHomeworkSubjectTitle(title);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickClassSelectBtn();
        // 选定班级
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickClassConfirmBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iph.clickSubmitHomewrkSubjectBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建日历打卡
     * @param title 日历打卡主题标题
     */
    public void createCalenderSubject(String title) throws Exception {
        Thread.sleep(1000);
        iph.clickNewCalenderSubjectBtn();
        Thread.sleep(1000);
        iph.inputCalenderSubjectTile(title);
        Thread.sleep(1000);
        iph.clickClassSelectBtn();
        Thread.sleep(1000);
        iph.clickClassConfirmBtn();
        Thread.sleep(1000);
        iph.clickSubmitCalenderSubjectBtn();
        Thread.sleep(2000);
    }

    /**
     * 新学员报名
     */
    public void newStudentApply(String name,String mobile) throws InterruptedException {
        Thread.sleep(1000);
        iph.clickNewStudentApply();
        Thread.sleep(1000);
        iph.typeStudentApplyName(name);
        Thread.sleep(1000);
        iph.clickStudentSexBtn();
        Thread.sleep(1000);
        iph.typeStudentMobile(mobile);
        Thread.sleep(1000);
        iph.clickStudentApplyConfirmBtn();
        Thread.sleep(2000);
    }

    /**
     * 新建班级
     * @param className 班级名称
     * @param classCapacity 班级容量
     * @param expend 班级课时消耗
     */
    public void newClass(String className,String classCapacity,String expend) throws InterruptedException {
        Thread.sleep(1000);
        iph.clickNewClassBtn();
        Thread.sleep(1000);
        iph.clickNewClassCourseNameBtn();
        Thread.sleep(1000);
        iph.clickNewClassCourses();
        Thread.sleep(1000);
        iph.typeNewClassName(className);
        Thread.sleep(1000);
        iph.typeClassCapacity(classCapacity);
        Thread.sleep(1000);
        iph.typeClassCourseExpend(expend);
        Thread.sleep(1000);
        iph.clickNewClassConfirmBtn();
        Thread.sleep(2000);
    }

    /**
     * 新建课程
     * @param courseName 课程名称
     */
    public void newCourse(String courseName) throws InterruptedException {
        Thread.sleep(1000);
        iph.clickNewCourseBtn();
        Thread.sleep(1000);
        iph.typeNewCourseName(courseName);
        Thread.sleep(1000);
        iph.clickNewCourseConfirmBtn();
        Thread.sleep(2000);
    }
}
