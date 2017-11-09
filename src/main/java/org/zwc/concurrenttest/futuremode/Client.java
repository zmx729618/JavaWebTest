package org.zwc.concurrenttest.futuremode;

/**
 * Created by zhangwenchao on 2017/11/9.
 */
public class Client {

    public Data request(final String queryStr){
        final FutureData future = new FutureData();
        //开启一个新的线程来构造真实数据
        new Thread(){
            public void run(){
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }

}


