package com.qingxiao.utils;


/**
 * 协助处理UI自动化工具
 */
public class Utils {

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
}
