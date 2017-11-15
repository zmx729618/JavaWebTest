package org.zwc.javalocktest;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhangwenchao on 2017/11/14.
 */
public class SpinLock {
    private static Integer a = 1;


    private AtomicReference<Thread> sign = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }


    public static void main(String[] args) {

        final SpinLock spinLock = new SpinLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    spinLock.lock();
                    a++;
                    System.out.println("Thread a puls a+1=:"+a);
                    spinLock.unlock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        },"a").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    spinLock.lock();
                    a++;
                    System.out.println("Thread b puls a+1=:" + a);
                    spinLock.unlock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"b").start();


    }

}
