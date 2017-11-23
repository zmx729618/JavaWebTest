package org.zwc.innerclasstest;

/**
 * 匿名内部类测试：匿名内部类是一个局部内类，一定是在new的后面，用其隐含实现一个接口或实现一个类
 * Created by zhangwenchao on 2017/11/23.
 */
public class AnonymousInnerClassTest{

    public int value(){

        return 10;
    }

    public Wrapping wrap(int x) {

        // Base constructor call:
        return new Wrapping(x) { // Pass constructor argument.
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }

    public static void main(String[] args) {

        AnonymousInnerClassTest p = new AnonymousInnerClassTest();

        Wrapping w = p.wrap(10);

        System.out.println(w.value());
    }



}
