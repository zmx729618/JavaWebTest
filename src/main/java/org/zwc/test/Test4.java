package org.zwc.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangwenchao on 2017/12/13.
 */
public class Test4 {

    public static void main(String[] args) {
       /* Map<String,String> premiumPhone = new HashMap<String,String>();
                premiumPhone.put("Apple", "iPhone");
                premiumPhone.put("HTC", "HTC one");
               premiumPhone.put("Samsung","S5");

                Iterator iterator = premiumPhone.keySet().iterator();

                while (iterator.hasNext())
                   {
                        System.out.println(premiumPhone.get(iterator.next()));
                        premiumPhone.put("Sony", "Xperia Z");
                    }*/


        ConcurrentHashMap<String,String> premiumPhone =
                                               new ConcurrentHashMap<String,String>();
               premiumPhone.put("Apple", "iPhone");
                premiumPhone.put("HTC", "HTC one");
               premiumPhone.put("Samsung","S5");

                Iterator iterator = premiumPhone.keySet().iterator();

                while (iterator.hasNext())
                    {
                        System.out.println(premiumPhone.get(iterator.next()));
                        premiumPhone.put("Sony", "Xperia Z");
                    }


    }
}
