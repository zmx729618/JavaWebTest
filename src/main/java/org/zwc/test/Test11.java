package org.zwc.test;

/**
 * Created by zhangwenchao on 2018/1/5.
 */
public class Test11 {

    public static void main(String[] args) {
        long millisTime = System.currentTimeMillis();

        long nanoTime = System.nanoTime();

        System.out.println(millisTime/(24*3600*365*1000L));

        System.out.println(nanoTime/(24*3600*365*1000*1000L));
    }
}
