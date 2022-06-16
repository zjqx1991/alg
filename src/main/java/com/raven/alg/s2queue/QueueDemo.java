package com.raven.alg.s2queue;


/**
 * 测试队列
 */
public class QueueDemo {
    public static void main(String[] args) {
        circleQueueArray();
    }


    /**
     * 环形队列
     */
    private static void circleQueueArray() {
        CircleQueue queueArray = new CircleQueue(5);
        queueArray.add(1);
        queueArray.add(2);
        queueArray.add(3);
        queueArray.add(4);
        queueArray.add(5);

        for (int i = 0; i < 3; i++) {
            System.out.printf("当前头部：%d\t——%d\n", queueArray.getHead(), queueArray.get());
        }
        queueArray.add(6);
        queueArray.add(7);
        queueArray.add(8);

        for (int i = 0; i < 5; i++) {
            System.out.printf("当前头部：%d\t——%d\n", queueArray.getHead(), queueArray.get());
        }
    }

    /**
     * 队列
     */
    private static void queueArray() {
        QueueArray queueArray = new QueueArray(5);
        queueArray.add(1);
        queueArray.add(2);
        queueArray.add(3);
        queueArray.add(4);
        queueArray.add(5);

        for (int i = 0; i < 5; i++) {
            System.out.printf("%d\t", queueArray.get());
        }
    }
}
