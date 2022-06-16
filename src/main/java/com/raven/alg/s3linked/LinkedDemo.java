package com.raven.alg.s3linked;


import java.util.Arrays;

public class LinkedDemo {
    public static void main(String[] args) {

        SingleLinkedOrder singleLinked = new SingleLinkedOrder();

        SingleLinkedOrder singleLinked1 = new SingleLinkedOrder(1, "第-1");
        SingleLinkedOrder singleLinked2 = new SingleLinkedOrder(2, "第-2");
        SingleLinkedOrder singleLinked3 = new SingleLinkedOrder(3, "第-3");
        SingleLinkedOrder singleLinked4 = new SingleLinkedOrder(4, "第-4");


        singleLinked.add(singleLinked3);
        singleLinked.add(singleLinked2);
        singleLinked.add(singleLinked1);
        singleLinked.add(singleLinked4);

        singleLinked.list();

        System.out.println("===== 修改 ====");
        SingleLinkedOrder singleLinked5 = new SingleLinkedOrder(4, "第-5");
        singleLinked.edit(singleLinked5);
        singleLinked.list();

        System.out.println("===== 删除 ====");
        singleLinked.delete(4);
        singleLinked.list();

        System.out.println("===== 获取-4 ====" + singleLinked.getNode(4));
        System.out.println("===== 获取-1 ====" + singleLinked.getNode(1));

    }

    /**
     * 无序链表
     */
    private static void singleLinked() {
        SingleLinked singleLinked = new SingleLinked();

        SingleLinked singleLinked1 = new SingleLinked(1);
        SingleLinked singleLinked2 = new SingleLinked(2);
        SingleLinked singleLinked3 = new SingleLinked(3);
        SingleLinked singleLinked4 = new SingleLinked(4);

        singleLinked.add(singleLinked3);
        singleLinked.add(singleLinked2);
        singleLinked.add(singleLinked1);
        singleLinked.add(singleLinked4);

        singleLinked.list();
    }
}
