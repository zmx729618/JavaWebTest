package org.zwc.singletontest;

/**
 * Created by zhangwenchao on 2017/11/16.
 * 饿汉式：static final
 */
public class Singleton2 {

    //类加载时就初始化
    private static final Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }



}
