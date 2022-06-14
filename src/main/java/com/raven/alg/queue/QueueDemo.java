package com.raven.alg.queue;


/**
 * 测试队列
 */
public class QueueDemo {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);
        queueArray.add(1);
        queueArray.add(2);
        queueArray.add(3);
        queueArray.add(4);
        queueArray.add(5);
//        queueArray.add(6);
//        System.out.println("获取头部数据 " + queueArray.getHead());

        for (int i = 0; i < 5; i++) {
            System.out.printf("%d\t", queueArray.get());
        }
    }
}
