package com.qingxiao.utils;


import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 协助处理UI自动化工具
 */
public class Utils {

    static Logger logger = Logger.getLogger(Utils.class);
    public static final int HANGZI_LENGTH = 20902;
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

    public static char random(){
        Random random = new Random();
        return (char)(0x4e00 + random.nextInt(HANGZI_LENGTH));
    }

    public static void main(String[] args) {
        System.out.println(random());
    }

}


class Solution{
    public static int[] twoSum(int[] sums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < sums.length;i ++){
            int complete = target - sums[i];
            if (map.containsKey(complete)&&map.get(complete) != i){
                return new int[]{i,map.get(complete)};
            }
            map.put(map.get(complete),i);
        }
        throw new IllegalArgumentException("do not have that two arguments");
    }
}
