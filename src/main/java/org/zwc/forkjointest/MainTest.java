package org.zwc.forkjointest;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by zhangwenchao on 2018/1/2.
 */
public class MainTest {

    public static void main(String[] args) {
        long[] numbers = rangeClosed(1, 1000*10000);
        ForkJoinTest forkJoinTest = new ForkJoinTest(numbers);
        Long sum = new ForkJoinPool().invoke(forkJoinTest);
        System.out.println(sum);//50000005000000

    }

    private static long[] rangeClosed(int i, int i1) {

        long[] numbers = new long[i1];
        for(;i<=i1;i++){
            numbers[i-1]=i;
        }

        return numbers;

    }


}
