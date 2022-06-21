package com.raven.alg.s4stack;

/**
 * 使用链表实现栈
 */
public class StackLinked {
    // 栈顶指针
    Lined head;

    /**
     * 入栈
     */
    public void push(int item) {
        Lined lined = new Lined(item);
        if (null != head) {
            // 插入链表的头
            lined.next = head;
        }
        head = lined;
    }


    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空！！！");
        }
        Lined head = this.head;
        this.head = this.head.next;
        return head.data;
    }

    private boolean isEmpty() {
        return null == this.head;
    }


    /**
     * 查看栈顶元素
     */
//    public int peer() {
//        if (isEmpty()) {
//            throw new RuntimeException("栈已空！！！");
//        }
//        return this.stack[top];
//    }
//

    /**
     * 查看栈顶元素
     */
    public void list() {
        if (this.head == null) {
            System.out.println("栈已空！！！");
            return;
        }
        Lined head = this.head;
        while (null != head) {
            System.out.println(" 数据为：" + head.data);
            head = head.next;
        }
    }


}

class Lined {
    int data;
    Lined next;

    public Lined(int data) {
        this.data = data;
    }
}
