package com.raven.alg.s3linked;


/**
 * 双向链表
 */
public class DoubleLinked {
    // 链表顺序
    Integer sort;
    // 节点数据
    String name;
    // 节点数据
    String shortName;
    // 链表头节点
    protected DoubleLinked head;
    // 链表上一个节点
    protected DoubleLinked pre;
    // 链表下一个节点
    protected DoubleLinked next;

    /**
     * 输出列表
     */
    public void list() {
        if (null == this.head || null == this.head.next) {
            System.out.println("列表为空！！！");
        }
        // 获取列表的头节点
        DoubleLinked head = this.head;
        while (null != head.next) {
            System.out.println(head.next);
            head = head.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        builder.append("pro数据：(");
        builder.append(pre.sort);
        builder.append(" - ");
        builder.append(pre.name);
        builder.append(") ------ ");
        builder.append("cur数据：(");
        builder.append(sort);
        builder.append(" - ");
        builder.append(name);
        builder.append(") ------ ");
        builder.append("next数据：(");
        if (next != null) {
            builder.append(next.sort);
            builder.append(" - ");
            builder.append(next.name);
        } else {
            builder.append("null");
        }
        builder.append(")");
        return builder.toString();
    }
}
