package org.zwc.dynamicproxytest;

/**
 * Created by zhangwenchao on 2018/1/16.
 */
public class SubjectImpl implements  Subject{

    @Override
    public void rent() {
        System.out.println("I want to rent my house");

    }

    @Override
    public void hello(String str) {

        System.out.println("hello: " + str);


    }
}
