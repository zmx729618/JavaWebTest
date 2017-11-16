package org.zwc.singletontest;

/**
 * Created by zhangwenchao on 2017/11/16.
 */
public enum Singleton5 {

    INSTANCE;

    public String getStirng(){
        return "xxxxxxx";
    }


    public static void main(String[] args) {

        System.out.println(Singleton5.INSTANCE.getStirng());

    }


}
