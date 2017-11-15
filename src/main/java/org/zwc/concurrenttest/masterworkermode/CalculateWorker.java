package org.zwc.concurrenttest.masterworkermode;

/**
 * Created by zhangwenchao on 2017/11/10.
 */
public class CalculateWorker extends Worker{

    @Override
    public Object handle(Object input) {

        Integer i =(Integer)input;
        return i*i*i;
    }

}

