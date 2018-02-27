package org.zwc.producerconsumertest;

import java.util.Vector;

/**
 * Created by zhangwenchao on 2018/2/27.
 */
public class Producer implements Runnable{

    private  final Vector<Object> sharedQueue;

    private  final int size;

    public Producer(Vector<Object> sharedQueue,int size){

        this.sharedQueue = sharedQueue;

        this.size = size;

    }


    @Override
    public void run() {

        for (int i = 0; i < 7; i++) {
            System.out.println("Produced:" + i);
            produce(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void produce(int i) {

        while(sharedQueue.size() == this.size){
            synchronized (sharedQueue) {
                try {
                    this.sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }

    }
}
