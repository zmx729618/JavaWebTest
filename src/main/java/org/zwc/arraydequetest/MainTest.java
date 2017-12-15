package org.zwc.arraydequetest;

import java.util.ArrayDeque;

/**
 * Created by zhangwenchao on 2017/12/13.
 * java中stack和deque的数据结构
 */
public class MainTest {

    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);

        for(Integer i : deque){
            System.out.println(i);
        }
        System.out.println("-------------------------------");

        Integer e = deque.removeFirst();
        System.out.println(e);
        System.out.println("-------------------------------");

        Integer e1 = deque.peekFirst();
        System.out.println(e1);
        System.out.println("-------------------------------");

        for(Integer i : deque){
            System.out.println(i);
        }
    }
}
