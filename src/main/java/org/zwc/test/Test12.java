package org.zwc.test;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangwenchao on 2018/1/9.
 */
public class Test12 {

    public static void main(String[] args) {
        BigDecimal x = new BigDecimal(3);
        BigDecimal y = new BigDecimal(0.2);

        String[] hello = {"java","groovy","scala" };

        System.out.println(x.add(y));
        System.out.println(hello);

        Pattern pattern = Pattern.compile("123\\d*");
        Matcher matcher =  pattern.matcher("123456");
        if( matcher.matches()){

           String result = matcher.replaceFirst("123_");
           System.out.println(result);
        }




    }
}
