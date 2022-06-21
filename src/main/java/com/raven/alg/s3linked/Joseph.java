package com.raven.alg.s3linked;

/**
 * 约瑟夫
 */
public class Joseph {
    // head
    private Boy head;


    public Joseph() {
    }

    /**
     * 初始化数据
     */
    public Joseph(Integer maxSize) {
        Boy first = null;
        for (Integer i = 1; i <= maxSize; i++) {
            Boy boy = new Boy(i);
            if (null == this.head) {
                this.head = boy;
                first = this.head;
            } else {
                first.next = boy;
                Boy next = first.next;
                first = next;
            }
            // 新增boy的 next 执行 head
            boy.next = this.head;
        }

    }

    /**
     * 约瑟夫输出数据顺序
     *
     * @param start
     * @param step
     */
    public void run(Integer start, Integer step) {
        if (null == this.head) {
            System.out.println("约瑟夫链表为空！！！");
            return;
        }
        // 当前节点
        Boy currentNode = this.head;
        // 最后节点，lastNode.next = currentNode，当 lastNode = currentNode 时代码只有一个
        Boy lastNode = this.getLast();

        // 通过 start 来指定节点位置
        for (Integer i = 1; i < start; i++) {
            currentNode = currentNode.next;
            lastNode = lastNode.next;
        }

        while (true) {
            // 最后一个
            if (currentNode == lastNode) {
                System.out.println("输出数据：" + currentNode);
                break;
            }
            for (Integer i = 1; i < step; i++) {
                currentNode = currentNode.next;
                lastNode = lastNode.next;
            }
            // 找到数据
            System.out.println("输出数据：" + currentNode);
            currentNode = currentNode.next;
            lastNode.next = currentNode;
        }
    }

    /**
     * 输出链表
     */
    public void list() {
        if (null == this.head) {
            System.out.println("约瑟夫链表为空！！！");
            return;
        }
        Boy head = this.head;
        while (true) {
            System.out.println(head);
            if (this.head == head.next) {
                break;
            }
            head = head.next;
        }
    }

    public Boy getLast() {
        if (null == this.head) {
            System.out.println("约瑟夫链表为空！！！");
            return null;
        }
        Boy head = this.head;
        while (true) {
            if (this.head == head.next) {
                return head;
            }
            head = head.next;
        }
    }
}

class Boy {
    Integer no;
    Boy next;

    public Boy(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "no=" + no;
    }
}
