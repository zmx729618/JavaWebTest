package org.zwc.concurrenttest.futuremode;

/**
 * Created by zhangwenchao on 2017/11/9.
 */
public class FutureData implements Data  {

    protected RealData realData =null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData=realData;
        isReady=true;
        notifyAll();

    }

    @Override
    public  synchronized  String getResult() {
        while(!isReady){
            try{
                wait();
            }catch (Exception e){

            }
        }
        return realData.result;
    }
}


