package com.qingxiao.utils;

public class Base64Util {
    public static String encode(byte[] data) {
        if (data != null) {
            return new sun.misc.BASE64Encoder().encode(data);
        }
        return null;
    }
    public static byte[] decode(String data) {
        if (data != null) {
            try {
                return new sun.misc.BASE64Decoder().decodeBuffer(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
