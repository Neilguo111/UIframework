package com.qingxiao.utils;


import org.apache.log4j.Logger;

/**
 * 协助处理UI自动化工具
 */
public class Utils {

    static Logger logger = Logger.getLogger(Utils.class);

    /**
     * 获取文本中的数字
     * @param src
     * @return
     */
    public static int getInt(String src){
        String res = "";
        for (int i = 0;i < src.length();i++){
            if (src.charAt(i)>=48||src.charAt(i)<=57){
                res += src.charAt(i);
            }
        }
        return Integer.parseInt(res);
    }

    public static String getText(String src){
        /*
         * 获取昵称，号码等字符串
         */
        String result = null;
        try {
            String[] strings = src.split("：");
            result = strings[1].trim();
        }catch (Exception e){
            logger.error("按：分隔字符串失败");
        }
        return result;
    }

}
