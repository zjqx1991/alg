package com.raven.alg.s3linked;

import java.util.Stack;

/**
 * 单向链表面试题
 */
public class SingleLinkedInterview {


    /**
     * 反转单向链表(不破坏原链表)
     */
    public static void reservePrintLinked(Linked linked) {
        Stack<Linked> stack = new Stack<Linked>();
        Linked head = linked;
        while (true) {
            if (null == head) {
                break;
            }
            if (head.sort > 0) {
                stack.add(head);
            }
            head = head.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


    /**
     * 反转单向链表(不破坏原链表)
     */
    public static Linked reserveLinked(Linked linked) {
        Linked reserveLinked = new Linked();
        Linked head = linked;
        while (true) {
            if (null == head) {
                break;
            }
            Linked next = head.next;
            if (reserveLinked.head == null) {
                reserveLinked.head = head;
            } else {
                head.next = reserveLinked.next;
                reserveLinked.next = head;
            }
            head = next;
        }
        return reserveLinked;
    }


    /**
     * 反转单向链表(破坏原链表)
     */
    public static Linked reserveLinked2(Linked linked) {
        Linked newHead = new Linked();
        Linked head = linked;
        Linked next = null;
        while (true) {
            if (null == head) {
                break;
            }
            // 记录head 的下一个值
            next = head.next;
            if (head.sort > 0) {
                head.next = newHead.next;
                newHead.next = head;
            }
            head = next;
        }
        linked.next = newHead.next;
        return linked;
    }


    /**
     * 查找单向链表中的倒数第 k 个节点
     */
    public static Linked getLinkedByReverseIndex(Linked linked, Integer index) {
        // 获取有效链表个数
        Integer size = getSingleLinkedSize(linked);
        if (size < index) {
            return null;
        }
        Linked first = linked.next;
        for (Integer i = 0; i < size - index; i++) {
            first = first.next;
        }
        return first;
    }

    /**
     * 单向链表中有效节点个数
     */
    public static Integer getSingleLinkedSize(Linked linked) {
        Integer count = 0;
        if (null == linked || null == linked.next) {
            return count;
        }
        Linked head = linked.next;
        while (true) {
            if (null == head) {
                break;
            } else {
                count++;
            }
            head = head.next;
        }
        return count;
    }
}
