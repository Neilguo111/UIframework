package com.qingxiao.utils;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelHandler implements Runnable {

    public static Logger loger = Logger.getLogger(ExcelHandler.class);

    public static void main(String[] args) {

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
                    cell.setCellType(CellType.STRING);
                    if (datePool().keySet().toString().contains(cell.getStringCellValue())){
                        cell.setCellValue((String) datePool().get(cell.getStringCellValue()));
                        loger.info("改变了相应的cell内容：" + i + "" + j);
                    }
                    loger.info("当前执行循环：" + "i:" + i + " " + "j:" + j);
                }
            }
            FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") + File.separator + "test001.xls"));
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

    /**
     * 返回数据池
     * @return map
     */
    public static HashMap datePool(){
        String source = "[{\"type\":3,\"title\":\"校长姓名（系统持有者）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"校长电话（系统登录号码）\",\"text\":\"\"},{\"type\":3,\"title\":\"合约期（合同起止日期，务必真实填写，如发现作假将取消开通资格）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称1（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址1（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称2（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址2（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称3（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址3（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称4（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址4（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称5（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址5（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称6（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址6（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称7（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址7（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称8（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址8（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称9（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址9（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"},{\"type\":3,\"title\":\"校区名称10（地区—店名）\",\"text\":\"\",\"otherdone\":false},{\"type\":3,\"title\":\"所在地址10（详细地址，须包含：省-市-区-县及具体地址）\",\"text\":\"\"}]";
        Map<String, String> map = string2Map(source);
        return (HashMap) map;
    }

    /**
     * 拿文本中的关键字段与自增key生成map
     * @param source
     * @return Map
     */
    public static Map<String ,String > string2Map(String source){
        String regex = "\"title\":\"(.*?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        Map<String,String> map = new HashMap<>();
        int index = 1;
        while (matcher.find()){
            try{
                String[] split = matcher.group().split(":");
                map.put(String.valueOf(index),split[1]);
            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            index ++;
        }
        return map;
    }

    /**
     * 返回去重之后的数量
     * @param fileName
     * @return
     */
    public static int setSize(String fileName){
        Set<String> set = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            try {
                String line = null;
                while ((line = br.readLine()) != null){
                    set.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return set.size();
    }

    public void run() {

    }
}
