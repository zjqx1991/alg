package com.raven.alg.s3linked;

/**
 * 单向链表面试题
 */
public class SingleLinkedInterview {

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
