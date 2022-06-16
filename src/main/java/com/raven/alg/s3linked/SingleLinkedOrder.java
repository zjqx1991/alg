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
     * 删除数据
     */
    public void delete(Integer index) {
        SingleLinkedOrder head = this.head;
        while (null != head.next) {
            SingleLinkedOrder next1 = head.next;
            SingleLinkedOrder next2 = head.next.next;
            // 取出当前节点
            if (null != next1 && next1.sort == index) {
                if (null == next2) {
                    head.next = next2;
                    return;
                }
                head.next.name = head.next.next.name;
                head.next.sort = head.next.next.sort;
                return;
            }
            head = head.next;
        }
    }


    /**
     * 编辑数据
     */
    public void edit(SingleLinkedOrder item) {
        SingleLinkedOrder node = this.getNode(item);
        if (node == null) {
            throw new RuntimeException("编辑数据错误：" + item.toString());
        }
        node.name = item.name;
    }


    /**
     * 获取指定数据
     *
     * @param index
     * @return
     */
    public SingleLinkedOrder getNode(Integer index) {
        SingleLinkedOrder head = this.head;
        while (null != head.next) {
            // 取出当前节点
            if (head.next.sort == index) {
                return head.next;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 获取指定数据
     *
     * @param item
     * @return
     */
    private SingleLinkedOrder getNode(SingleLinkedOrder item) {
        SingleLinkedOrder head = this.head;
        while (null != head.next) {
            // 取出当前节点
            SingleLinkedOrder temp = head.next;
            if (null != temp && temp.sort == item.sort) {
                return temp;
            }
            head = temp;
        }
        return null;
    }

    /**
     * 输出链表数据
     */
    public void list() {
        SingleLinkedOrder head = this.head;
        while (null != head.next) {
            SingleLinkedOrder temp = head.next;
            System.out.printf("%s\t", temp);
            head = temp;
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
