package org.zwc.test;

/**
 * Created by zhangwenchao on 2017/10/26.
 */
public class Test1 {
    /**
     * int到byte[]
     * @param i
     * @return
     */
    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        //由高位到低位
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }

    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value=0;
        //由高位到低位
        for(int i = 0; i < 4; i++) {
            int shift= (4-1-i) * 8;
            value +=(bytes[i] & 0x000000FF) << shift;//往高位游
        }
        return value;
    }

    public static void main(String[] args) {
        byte[] result = intToByteArray(2000);
        for(byte b : result){
            System.out.println(b);
        }

    }




}
