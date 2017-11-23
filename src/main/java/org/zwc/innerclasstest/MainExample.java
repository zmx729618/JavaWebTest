package org.zwc.innerclasstest;

/**
 * Created by zhangwenchao on 2017/11/23.
 */
public class MainExample {

    private class Test1 extends Example1{
        public String name(){
            return super.name();
        }
    }

    private class Test2 extends Example2 {
        public int age(){
            return super.age();
        }
    }

    public String name(){
        return new Test1().name();
    }

    public int age(){
        return new Test2().age();
    }

    public static void main(String args[]){
        MainExample mi=new MainExample();
        System.out.println("姓名:"+mi.name());
        System.out.println("年龄:"+mi.age());
    }

}
