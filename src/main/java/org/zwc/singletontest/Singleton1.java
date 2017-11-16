package org.zwc.singletontest;

/**
 * Created by zhangwenchao on 2017/11/16.
 * 双重检查
 */
public class Singleton1 {

    private  static volatile Singleton1 instance; //声明成 volatile

    private Singleton1 (){}

    public static Singleton1 getSingleton() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }




}
