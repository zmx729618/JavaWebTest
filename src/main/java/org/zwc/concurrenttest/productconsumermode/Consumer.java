package org.zwc.concurrenttest.productconsumermode;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangwenchao on 2017/11/13.
 */
public class Consumer implements Runnable {
    //缓冲区
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME=1000;


    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("start Consumer id= "+ Thread .currentThread().getId());
        Random r = new Random();

        try {
            //提取任务
            while(true){
                PCData data= queue.take();
                if(null!= data){
                    //计算平方
                    int re= data.getData()*data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}",
                            data.getData(),data.getData(),re
                    ));
                    Thread.sleep(r.nextInt(SLEEPTIME));

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }





}