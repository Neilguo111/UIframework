package com.qingxiao;

import com.qingxiao.base.DriverBase;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngListenerScreenShot extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        takeScreenShot(iTestResult);
    }

    private void takeScreenShot(ITestResult iTestResult){
        //向上转型
        DriverBase instance = (DriverBase) iTestResult.getInstance();
        instance.takeScreenShot();
    }
//    /**
//     * 截图
//     */
//    public void takeScreenShot(){
//        long date = System.currentTimeMillis();
//        String path = String.valueOf(date);
//        //获取当前文件目录
//        String curPath = System.getProperty("user.dir");
//        path = path + ".png";
//        String screenPath = curPath + File.separator + path;
//        //截图
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshot,new File(screenPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
    }
}
