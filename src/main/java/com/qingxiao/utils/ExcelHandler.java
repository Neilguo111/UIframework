package com.qingxiao.utils;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;

public class ExcelHandler implements Runnable {

    public static Logger loger = Logger.getLogger(ExcelHandler.class);

    public static void main(String[] args) {
        replaceAllExcel(new File(System.getProperty("user.dir") + File.separator + "test001.xls"));
    }

    public static void replaceAllExcel(File file){
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis); // 实例化制定的Excel文件
            XSSFSheet sheet = workbook.getSheetAt(0); //读取第一个sheet
            loger.info(sheet.getFirstRowNum() + "\n" + sheet.getLastRowNum());
            for (int i = sheet.getFirstRowNum();i <= sheet.getLastRowNum();i++){
                XSSFRow row = sheet.getRow(i);
                for (int j = row.getFirstCellNum();j < row.getLastCellNum();j++){
                    XSSFCell cell = row.getCell(j);
                    if (datePool().keySet().toString().contains(cell.getStringCellValue())){
                        cell.setCellValue((String) datePool().get(cell.getStringCellValue()));
                        loger.info("改变了相应的cell内容：" + i + "" + j);
                    }
                    loger.info("当前执行循环：" + "i:" + i + " " + "j:" + j);
                }
            }
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fis.close();
            workbook.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createExcel(){
        String fileName = System.getProperty("user.dir") + File.separator + "test001.xls";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("new sheet");
        for (int i = 0; i < 9; i++){
            XSSFRow row = sheet.createRow(i);  // 创建row对象
            for (int j = 0; j < 9;j++){
                XSSFCell cell = row.createCell(j); // 创建单元格对象
                cell.setCellValue("test");
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap datePool(){
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("test","first change");
        return map;
    }

    public void run() {

    }
}
