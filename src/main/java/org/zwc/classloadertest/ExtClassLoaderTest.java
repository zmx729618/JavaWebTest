package org.zwc.classloadertest;

/**
 * Created by zhangwenchao on 2017/11/22.
 */
public class ExtClassLoaderTest {

    public static void main(String[] args)
    {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ClassLoader.getSystemClassLoader());
    }

}
