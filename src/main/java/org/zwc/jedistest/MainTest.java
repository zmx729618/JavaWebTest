package org.zwc.jedistest;

import redis.clients.jedis.Jedis;

/**
 * Created by zhangwenchao on 2017/11/16.
 */
public class MainTest {


    public static void main(String[] args) {
        try {
            Jedis redis = new Jedis("127.0.0.1", 6379, 400000);
            String result = redis.get("947EE8A6068F471FF3DF0803CEE2BA69");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
