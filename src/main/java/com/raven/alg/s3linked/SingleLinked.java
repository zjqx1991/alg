package com.raven.alg.s3linked;

/**
 * 无序单向链表
 */
public class SingleLinked {
    // 链表数据
    Integer data;
    // 链表数据
    private SingleLinked head;
    // 链表数据
    private SingleLinked next;

    public SingleLinked() {
    }

    public SingleLinked(Integer data) {
        this.data = data;
    }

    /**
     * 添加数据
     */
    public void add(SingleLinked item) {
        if (this.head == null) {
            this.head = new SingleLinked();
        }
        SingleLinked node = this.getLastNode();
        SingleLinked lastNext = node.next;
        node.next = item;
        item.next = lastNext;
    }


    /**
     * 输出链表数据
     */
    public void list() {
        while (null != this.head.next) {
            this.head = this.head.next;
            System.out.printf("%s\t", this.head);
        }
    }

    /**
     * 获取最后一个节点
     */
    private SingleLinked getLastNode() {
        SingleLinked lastNode = this.head;
        while (null != lastNode.next) {
            lastNode = lastNode.next;
        }
        System.out.println("最后一个节点：" + lastNode);
        return lastNode;
    }

    /**
     * 链表为空
     */
    private Boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return "SingleLinked{" +
                "data=" + data +
                '}';
    }
}
