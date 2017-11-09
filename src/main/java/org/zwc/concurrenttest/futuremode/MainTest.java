package org.zwc.concurrenttest.futuremode;

/**
 * Created by zhangwenchao on 2017/11/9.
 */
public class MainTest {


    public static void main(String[] args){
        Client client = new Client();
        //理解返回一个FutureData
        Data data = client.request("name");
        System.out.println("请求完毕！");
        try{

            //处理其他业务
            //这个过程中，真是数据RealData组装完成，重复利用等待时间
            Thread.sleep(2000);

        }catch (Exception e){

        }
        //真实数据
        System.out.println("数据 = "+ data.getResult());

    }


}



