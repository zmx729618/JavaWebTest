package org.zwc.concurrenttest.masterworkermode;

import java.util.Map;
import java.util.Queue;

/**
 * Created by zhangwenchao on 2017/11/10.
 */


public class Worker  implements Runnable{

    //任务队列，用于取得子任务
    protected Queue<Object> workQueue;
    //子任务处理结果集
    protected Map<String ,Object> resultMap;
    public void setWorkQueue(Queue<Object> workQueue){
        this.workQueue= workQueue;
    }

    public void setResultMap(Map<String ,Object> resultMap){
        this.resultMap=resultMap;
    }
    //子任务处理的逻辑，在子类中实现具体逻辑
    public Object handle(Object input){
        return input;
    }


    @Override
    public void run() {

        while(true){//每个线程不停的从任务队列中获取任务，直到任务队列为空
            //获取子任务
            Object input= workQueue.poll();
            if(input==null){
                break;
            }
            //处理子任务
            Object re = handle(input);
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

}
