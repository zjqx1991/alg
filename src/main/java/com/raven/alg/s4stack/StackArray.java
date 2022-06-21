package com.raven.alg.s4stack;

/**
 * 使用数组实现栈
 */
public class StackArray {
    // 栈顶指针
    int top = -1;
    int[] stack;

    public StackArray(int size) {
        stack = new int[size];
    }

    /**
     * 入栈
     */
    public void push(int item) {
        if (isFull()) {
            System.out.println("栈已满！！！");
            return;
        }
        this.stack[++top] = item;
    }


    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空！！！");
        }
        return this.stack[top--];
    }


    /**
     * 查看栈顶元素
     */
    public int peer() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空！！！");
        }
        return this.stack[top];
    }


    /**
     * 查看栈顶元素
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈已空！！！");
            return;
        }
        int temp = top;
        while (true) {
            System.out.println("位置：" + (temp + 1) + " 数据为：" + this.stack[temp--]);
            if (temp == -1) {
                break;
            }
        }
    }

    /**
     * 栈已满
     */
    private Boolean isFull() {
        return top == stack.length - 1;
    }

    /**
     * 栈已空
     */
    private Boolean isEmpty() {
        return top == -1;
    }

}
