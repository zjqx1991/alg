package com.raven.alg.s3linked;

import java.util.zip.CheckedInputStream;

public class DoubleLinkedNoOrder extends DoubleLinked {


    public DoubleLinkedNoOrder(Integer sort, String name, String shortName) {
        this.sort = sort;
        this.name = name;
        this.shortName = shortName;
    }

    /**
     * 新增节点
     */
    public void add(DoubleLinked item) {
        if (this.head == null) {
            this.head = new DoubleLinkedNoOrder(0, "Head", "H");
        }
        DoubleLinked head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        item.next = head.next;
        item.pre = head;
        head.next = item;
    }

    /**
     * 删除指定元素
     *
     * @param sort
     * @return
     */
    public DoubleLinked delete(Integer sort) {
        if (this.head == null || this.head.next == null) {
            System.out.println("链表为空！！！");
            return null;
        }
        Boolean check = false;
        DoubleLinked head = this.head;
        while (true) {
            if (null == head) {
                break;
            }
            if (head.sort == sort) {
                check = true;
                break;
            }
            head = head.next;
        }
        // 找到要删除数据
        if (check) {
            // 找到下一个
            DoubleLinked next = head.next;
            // 找到上一下
            DoubleLinked pre = head.pre;
            pre.next = next;
            if (next != null) {
                next.pre = pre;
            }
            return head;
        } else {
            System.out.println("没有找到要删除的下标为" + sort + "数据");
        }
        return null;
    }


    /**
     * 修改元素
     *
     * @param item
     * @return
     */
    public DoubleLinked update(DoubleLinked item) {
        if (this.head == null || this.head.next == null) {
            System.out.println("链表为空！！！");
            return null;
        }
        Boolean check = false;
        DoubleLinked head = this.head;
        while (true) {
            if (null == head) {
                break;
            }
            if (head.sort == item.sort) {
                check = true;
                break;
            }
            head = head.next;
        }
        // 找到要删除数据
        if (check) {
            head.name = item.name;
            head.shortName = item.shortName;
            return head;
        } else {
            System.out.println("没有找到要删除的下标为" + sort + "数据");
        }
        return null;
    }

    /**
     * 获取指定位置元素
     *
     * @param sort
     * @return
     */
    public DoubleLinked get(Integer sort) {
        if (this.head == null || this.head.next == null) {
            System.out.println("链表为空！！！");
            return null;
        }
        Boolean check = false;
        DoubleLinked head = this.head;
        while (true) {
            if (null == head) {
                break;
            }
            if (head.sort == sort) {
                check = true;
                break;
            }
            head = head.next;
        }
        // 找到要删除数据
        if (check) {
            return head;
        } else {
            System.out.println("没有找到要删除的下标为" + sort + "数据");
        }
        return null;
    }

}
