package com.qingxiao.utils;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class FileHanlder {

    public static Logger logger = Logger.getLogger(FileHanlder.class);

    /**
     * 转txt
     * @param source 源文件
     * @param target 目标文件
     */
    public static void ExcelToTextFile(String source,String target){

        if (source.endsWith("xls")||source.endsWith("xlsx")){
            try {
                List<Map<String ,String>> list = new ArrayList<Map<String, String>>();
                String[] rowTitle = {"A","B","C","D","E","F","G","H","I"};
                FileInputStream fileInputStream = new FileInputStream(source);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workbook.getSheetAt(0);
                for (Iterator rowIter = sheet.iterator();rowIter.hasNext();){
                    Map<String ,String > map = new HashMap<String, String>();  // 实例化map对象
                    XSSFRow row = (XSSFRow) rowIter.next();  // 获取row对象
                    for (int i = row.getFirstCellNum();i < row.getLastCellNum();i++){
                        XSSFCell cell = row.getCell(i);
                        if (null != cell){
                            map.put(rowTitle[i],cell.getStringCellValue());
                        }
                    }
                    list.add(map);
                }
                // List写入StringBuffer
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0;i < list.size();i++){
                    for (Map.Entry<String,String> entry:list.get(i).entrySet()){
                        String value = entry.getValue();
                        stringBuffer.append(value + ",");
                    }
                    stringBuffer.append("\r\n");
                }
                // StringBuffer写入target文件
                writeToFile(stringBuffer.toString(),target);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            logger.error("文件名错误，无法解析！");
        }
    }

    /**
     * 写入文件
     * @param str 目标字符串
     * @param filePath 目标文件
     */
    private static void writeToFile(String str,String filePath) {
        BufferedWriter writer = null;
        try {
            // 实例化目标文件,FileOutputStream不能直接写入String数据
            FileOutputStream fos = new FileOutputStream(filePath,true);
            // 实例化BufferedWriter，直接接受String类型数据
            writer = new BufferedWriter(new OutputStreamWriter(fos, "GBK"));
            writer.write(str + "\r\n");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭流
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExcelToTextFile(System.getProperty("user.dir") + File.separator + "test001.xls",
                System.getProperty("user.dir") + File.separator + "test.txt");
    }
}
