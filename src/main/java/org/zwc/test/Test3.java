package org.zwc.test;

import java.util.Collections;

/**
 * Created by zhangwenchao on 2017/12/13.
 */
public class Test3 {

    public static void main(String[] args) {

        System.out.println(0xffffffff);  // 结果： -1

        System.out.println(0xff);  //结果：255

        byte b=-1;
        System.out.println((int)(char)b);
        System.out.println((int)(char)(b & 0xff));
    }


    public static String byteToHex(byte[] bt){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<bt.length;i++){
            int tmp = bt[i]&0xff;
            String tmpStr = Integer.toHexString(tmp);
            if(tmpStr.length()<2)
                sb.append("0");
            sb.append(tmpStr);
        }
        return sb.toString().toUpperCase();
    }


}
