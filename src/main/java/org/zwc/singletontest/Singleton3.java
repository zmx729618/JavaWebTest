package org.zwc.singletontest;

/**
 * Created by zhangwenchao on 2017/11/16.
 * 懒汉式----多线程下效率不高
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3 (){}

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
