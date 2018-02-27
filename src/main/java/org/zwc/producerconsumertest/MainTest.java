package org.zwc.producerconsumertest;

import java.util.Vector;

/**
 * Created by zhangwenchao on 2018/2/27.
 */
public class MainTest {
    public static void main(String[] args) {
        Vector<Object> sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");
        prodThread.start();
        consThread.start();


    }
}
