package com.raven.alg.s2queue;

/**
 * 数组构成单向队列
 * 缺点：出队列后空间无法复用
 */
public class QueueArray {
    // 队列长度
    Integer length;
    Integer front;
    Integer rear;
    Integer[] queueArray;

    public QueueArray(Integer length) {
        this.front = 0;
        this.rear = 0;
        this.length = length;
        queueArray = new Integer[length];
    }

    /**
     * 添加数据
     */
    public void add(Integer el) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能在添加");
        }
        System.out.println("rear = " + this.rear);
        this.queueArray[this.rear++] = el;
    }

    /**
     * 获取数据
     */
    public Integer get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.queueArray[this.front++];
    }


    /**
     * 查看头部数据
     */
    public Integer getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.queueArray[this.front];
    }

    /**
     * 队列是否已满
     */
    private Boolean isFull() {
        return this.rear == this.length;
    }

    /**
     * 队列是否为空
     */
    private Boolean isEmpty() {
        return this.rear == this.front;
    }
}
