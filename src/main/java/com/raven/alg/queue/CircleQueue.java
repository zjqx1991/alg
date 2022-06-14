package com.raven.alg.queue;

/**
 * 数组构成环形队列
 */
public class CircleQueue {
    // 队列长度
    Integer length;
    Integer front;
    Integer rear;
    Integer size;
    Integer[] queueArray;

    public CircleQueue(Integer length) {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
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
        // 个数 +1
        this.size++;
        this.queueArray[(this.rear++) % this.length] = el;
    }

    /**
     * 获取数据
     */
    public Integer get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        // 个数 -1
        this.size--;
        return this.queueArray[(this.front++) % this.length];
    }


    /**
     * 查看头部数据
     */
    public Integer getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        System.out.println("head:" + this.queueArray[(this.front) % this.length]);
        return this.queueArray[(this.front) % this.length];
    }

    /**
     * 队列是否已满
     */
    private Boolean isFull() {
        return this.size == this.length;
    }

    /**
     * 队列是否为空
     */
    private Boolean isEmpty() {
        return this.size == 0;
    }
}
