package com.raven.alg.s3linked;

import java.util.Stack;

/**
 * 单向链表面试题
 */
public class SingleLinkedInterview {


    /**
     * 反转单向链表(不破坏原链表)
     */
    public static Linked mergeLinked(Linked linked1, Linked linked2) {
        // 新建一个头
        Linked newLinked = new Linked();
        Linked head = linked1;
        Linked head2 = linked2;
        Linked next = null;

        // 拷贝 linked1 中数据到 newLinked
        while (null != head) {
            next = head.next;
            if (head.sort > 0) {
                Linked temp = newLinked;
                while (temp.next != null) {
                    temp = temp.next;
                }
                head.next = temp.next;
                temp.next = head;
            }
            head = next;
        }

        // 添加 linked2 中数据到 newLinked
        while (null != head2) {
            next = head2.next;
            if (head2.sort > 0) {
                Linked temp2 = newLinked;
                while (temp2.next != null) {
                    if (temp2.next.sort > head2.sort) {
                        break;
                    }
                    temp2 = temp2.next;
                }
                Linked linked = new Linked();
                linked.sort = head2.sort;
                linked.name = head2.name;
                linked.shortName = head2.shortName;
                linked.next = temp2.next;
                temp2.next = linked;
            }
            head2 = next;
        }

        return newLinked;
    }


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
