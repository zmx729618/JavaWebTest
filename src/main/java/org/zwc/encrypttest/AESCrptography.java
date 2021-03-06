package org.zwc.encrypttest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

/**
 * Created by zhangwenchao on 2017/11/6.
 *
 * java实现AES加密/解密操作
 */
public class AESCrptography {

    public static byte[] AES_CBC_Encrypt(byte[] content, byte[] keyBytes, byte[] iv){

        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(keyBytes));
            SecretKey key=keyGenerator.generateKey();
            Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
            byte[] result=cipher.doFinal(content);
            return result;
        }catch (Exception e) {
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    public static byte[] AES_CBC_Decrypt(byte[] content, byte[] keyBytes, byte[] iv){

        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(keyBytes));//key长可设为128，192，256位，这里只能设为128
            SecretKey key=keyGenerator.generateKey();
            Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            byte[] result=cipher.doFinal(content);
            return result;
        }catch (Exception e) {

            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]); //一个byte转换为两个16进制
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        String content="hello,hero! this is a  secret to you ";
        String key="aaaaaaaa";
        String iv="abcdefghijklmnop";

        System.out.println("加密前："+byteToHexString(content.getBytes()));
        byte[ ] encrypted=AES_CBC_Encrypt(content.getBytes(), key.getBytes(), iv.getBytes());
        System.out.println(encrypted.length);
        System.out.println("加密后："+byteToHexString(encrypted));
        System.out.println(byteToHexString(encrypted).length());
        byte[ ] decrypted=AES_CBC_Decrypt(encrypted, key.getBytes(), iv.getBytes());
        System.out.println("解密后："+byteToHexString(decrypted));
    }

}
