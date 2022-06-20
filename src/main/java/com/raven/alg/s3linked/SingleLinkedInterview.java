package com.raven.alg.s3linked;

/**
 * 单向链表面试题
 */
public class SingleLinkedInterview {

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
