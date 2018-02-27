package org.zwc.producerconsumertest;

import java.util.Vector;

/**
 * Created by zhangwenchao on 2018/2/27.
 */
public class Consumer implements Runnable{

    private final Vector<Object> sharedQueue;

    public Consumer(Vector<Object> sharedQueue){

        this.sharedQueue = sharedQueue;

    }


    @Override
    public void run() {
        while(true){
            System.out.println("Consumer: " + consume());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private Object consume() {

        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (sharedQueue) {
            Object obj= sharedQueue.remove(0);
            sharedQueue.notifyAll();
            return obj;
        }

    }
}


