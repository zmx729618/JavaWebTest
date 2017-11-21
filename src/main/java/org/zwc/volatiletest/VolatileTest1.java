package org.zwc.volatiletest;

/**
 * Created by zhangwenchao on 2017/11/16.
 */

import java.util.concurrent.CountDownLatch;

/**
 * volatile只能保证可见性不能保证原子性
 */
public class VolatileTest1 {


    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch  countDownLatch = new CountDownLatch(10);
        final VolatileTest1 test = new VolatileTest1();
        for(int i=0;i<10;i++){
            new Thread( ){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();

                    countDownLatch.countDown();
                };
            }.start();
        }
        countDownLatch.await();
        System.out.println(test.inc);
    }
}
