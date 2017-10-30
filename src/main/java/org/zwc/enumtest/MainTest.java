package org.zwc.enumtest;

/**
 * Created by zhangwenchao on 2017/10/30.
 */
public class MainTest {


    public static void main(String[] args) {
        GoodsPromoteEnum gpe1 =    GoodsPromoteEnum.get("精品");

        System.out.println(gpe1.getIndex());


        GoodsPromoteEnum gpe2 =    GoodsPromoteEnum.get(1);

        System.out.println(gpe2.getValue());
    }
}
