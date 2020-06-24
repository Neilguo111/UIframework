package com.qingxiao.utils;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AesKeyGenerate {
    public static String aesEncode(String key,String content,int count){
        try{
            javax.crypto.KeyGenerator keygen = javax.crypto.KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            keygen.init(count, random);
            SecretKey originalKey = keygen.generateKey();
            byte[] raw = originalKey.getEncoded();
            SecretKey secretKey = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteEncode = content.getBytes(StandardCharsets.UTF_8);
            byte[] byteAes = cipher.doFinal(byteEncode);
            String aesEncode = Base64Util.encode(byteAes);
            return aesEncode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String aesDncode(String key, String content, int count) {
        try {
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            javax.crypto.KeyGenerator keygen = KeyGenerator.getInstance("AES");
            // 2.根据ecnodeRules规则初始化密钥生成器
            // 生成一个随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            keygen.init(count, random);
            // 3.产生原始对称密钥
            SecretKey originalKey = keygen.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte[] raw = originalKey.getEncoded();
            // 5.根据字节数组生成AES密钥
            SecretKey secretKey = new SecretKeySpec(raw, "AES");
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // 8.将加密并编码后的内容解码成字节数组
            byte[] byteContent = Base64Util.decode(content);
            byte[] byteDecode = cipher.doFinal(byteContent);
            String aesDecode = new String(byteDecode, StandardCharsets.UTF_8);
            return aesDecode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 华贵AES解密
     *
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey   解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"),
                new IvParameterSpec(new byte[16])//初始化16空字节
        );
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes, StandardCharsets.UTF_8);
    }
    /**
     * 华贵base 64 decode
     *
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode(String base64Code) throws Exception {
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }


    /**
     * 华贵将base 64 code AES解密
     *
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }



    public static void main(String[] args) {
        String encryptDate = "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";
        String key = "08tXKWlljKQQyT0h";
        try {
            String s = aesDecrypt(encryptDate, key);
            String s1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TranData><Head><TranNo>2012000000010427</TranNo><TranDate>20200609</TranDate><TranTime>182500</TranTime><TranType></TranType></Head><Body><LCCont><ProposalContNo>118026698005495</ProposalContNo><AgentCode>NjQ3</AgentCode><ProductCode>012B1400</ProductCode><ProductName>华贵大麦2020定期寿险</ProductName><PlanCode>012B1400_B</PlanCode><PlanName>标准体</PlanName><SaleChnl></SaleChnl><SaleChnlOperator>zhonghui</SaleChnlOperator><Mult>1</Mult><Ensure>10Y</Ensure><ChargeYear>0C</ChargeYear><PayIntv>12</PayIntv><SvaliDate>2020-06-10 00:00:00</SvaliDate><EvaliDate>2030-06-09 23:59:59</EvaliDate><Amnt>100000</Amnt><Prem>388.8</Prem><InsuredTime>2020-06-09 18:21:04</InsuredTime><PayTime>2020-06-09 18:21:04</PayTime><PolicyState>7</PolicyState><PayUrl></PayUrl><BankAccout>oMzWS0ffVW30G1qXYNFfnz4v8uzY</BankAccout><BankCode>wc</BankCode><ContNo>888050001011693</ContNo></LCCont><LCAppnt><HolderName>虢伟亮</HolderName><HolderSex>0</HolderSex><HolderBirthday>1994-09-20</HolderBirthday><HolderCardType>0</HolderCardType><HolderCardNo>430921199409202233</HolderCardNo><HolderNation></HolderNation><HolderMobile>17602116237</HolderMobile><HolderEmail>614529025@qq.com</HolderEmail><AppAddress>上海市市辖区普陀区大渡河路新曹杨商务大厦12</AppAddress></LCAppnt><LCInsureds><LCInsured><InsuredRelation>00</InsuredRelation><InsuredName>虢伟亮</InsuredName><InsuredSex>0</InsuredSex><InsuredBirthday>1994-09-20</InsuredBirthday><InsuredCardType>0</InsuredCardType><InsuredCardNo>430921199409202233</InsuredCardNo><InsuredMobile>17602116237</InsuredMobile><InsuAddress>上海市市辖区普陀区大渡河路新曹杨商务大厦12</InsuAddress><SocialSecurity>1</SocialSecurity><Bnfs><Bnf><BnfType>1</BnfType><Sex></Sex><Birthday></Birthday><BnfLot></BnfLot><IDType></IDType><BnfNo></BnfNo><NAME></NAME><IDEndDate></IDEndDate><BnfGrade></BnfGrade><IDNo></IDNo><RelationToInsured></RelationToInsured></Bnf></Bnfs></LCInsured></LCInsureds></Body></TranData>";
            String s2 = aesEncode(key, s1, 128);
            System.out.println(s);
            System.out.println(s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
