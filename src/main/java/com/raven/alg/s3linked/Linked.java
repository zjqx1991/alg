package com.raven.alg.s3linked;

public class Linked {
    // 链表顺序
    Integer sort;
    // 节点数据
    String name;
    // 节点数据
    String shortName;
    // 链表头节点
    protected Linked head;
    // 链表下一个节点
    protected Linked next;

    /**
     * 输出列表
     */
    public void list() {
        if (null == this.head || null == this.head.next) {
            System.out.println("列表为空！！！");
        }
        // 获取列表的头节点
        Linked head = this.head;
        while (null != head.next) {
            System.out.println(head.next);
            head = head.next;
        }
    }


    @Override
    public String toString() {
        return "[ sort=" + sort + ", name=" + name + ", shortName=" + shortName + " ]";
    }
}
