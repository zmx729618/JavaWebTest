package org.zwc.classloadertest;

/**
 * Created by zhangwenchao on 2017/11/22.
 */
public class MainTest {

    /**
     *  执行程序前:需要将 “C:\Users\zhangwenchao\IdeaProjects\JavaWebTest\target\classes;”目录下的Person.classs删除
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        MyCustomClassLoader mcl = new MyCustomClassLoader();
        Class<?> c1 = Class.forName("org.zwc.classloadertest.Person", true, mcl);
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }

}
