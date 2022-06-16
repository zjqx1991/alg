package com.raven.alg.s3linked;

/**
 * 有序序单向链表
 */
public class SingleLinkedOrder {
    // 链表数据
    Integer sort;
    // 名称
    String name;
    // 链表数据
    private SingleLinkedOrder head;
    // 链表数据
    private SingleLinkedOrder next;

    public SingleLinkedOrder() {
    }

    public SingleLinkedOrder(Integer sort, String name) {
        this.sort = sort;
        this.name = name;
    }

    /**
     * 添加数据
     */
    public void add(SingleLinkedOrder item) {
        if (this.head == null) {
            this.head = new SingleLinkedOrder();
        }
        SingleLinkedOrder node = this.getLastNode(item);
        SingleLinkedOrder lastNext = node.next;
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
     * 获取（新增节点）的前一个节点
     */
    private SingleLinkedOrder getLastNode(SingleLinkedOrder node) {
        SingleLinkedOrder lastNode = this.head;
        while (null != lastNode.next) {
            // 下一个节点
            SingleLinkedOrder temp = lastNode.next;
            // 判断 temp 节点 与 node节点的大小
            if (temp.sort > node.sort) {
                return lastNode;
            }
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
        return sort + " - " + name;
    }
}
