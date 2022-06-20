package com.raven.alg.s3linked;


public class LinkedDemo {
    public static void main(String[] args) {
        singleLinkedOrder();
    }


    /**
     * 有序链表
     */
    private static void singleLinkedOrder() {
        SingleLinkedOrder singleLinked = new SingleLinkedOrder(0, "", "");

        SingleLinkedOrder singleLinked1 = new SingleLinkedOrder(1, "影魔", "SF");
        SingleLinkedOrder singleLinked2 = new SingleLinkedOrder(2, "狙击手", "火枪");
        SingleLinkedOrder singleLinked3 = new SingleLinkedOrder(3, "露娜", "月骑");
        SingleLinkedOrder singleLinked4 = new SingleLinkedOrder(4, "卓尔游侠", "小黑");

        singleLinked.add(singleLinked3);
        singleLinked.add(singleLinked2);
        singleLinked.add(singleLinked1);
        singleLinked.add(singleLinked4);

        singleLinked.list();

        System.out.println("获取倒数第5个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 5));
        System.out.println("获取倒数第4个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 4));
        System.out.println("获取倒数第3个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 3));
        System.out.println("获取倒数第2个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 2));
        System.out.println("获取倒数第1个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 1));

        System.out.println("链表有效个数=====" + SingleLinkedInterview.getSingleLinkedSize(singleLinked.head));
        System.out.println("删除数据=====");
        singleLinked.delete(1);
        singleLinked.delete(5);
        singleLinked.list();
        System.out.println("链表有效个数=====" + SingleLinkedInterview.getSingleLinkedSize(singleLinked.head));

        System.out.println("更新数据=====");
        SingleLinkedOrder singleLinked5 = new SingleLinkedOrder(2, "新手第一英雄", "矮子");
        singleLinked.update(singleLinked5);
        singleLinked.list();
        System.out.println("链表有效个数=====" + SingleLinkedInterview.getSingleLinkedSize(singleLinked.head));

        System.out.println("查询数据=====");
        singleLinked.get(1);
        singleLinked.get(3);
        singleLinked.get(5);

        System.out.println("获取倒数第5个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 5));
        System.out.println("获取倒数第4个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 4));
        System.out.println("获取倒数第3个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 3));
        System.out.println("获取倒数第2个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 2));
        System.out.println("获取倒数第1个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 1));
    }

    /**
     * 无序链表
     */
    private static void singleLinked() {
        SingleLinked singleLinked = new SingleLinked(0, "", "");

        SingleLinked singleLinked1 = new SingleLinked(1, "影魔", "SF");
        SingleLinked singleLinked2 = new SingleLinked(2, "狙击手", "火枪");
        SingleLinked singleLinked3 = new SingleLinked(3, "露娜", "月骑");
        SingleLinked singleLinked4 = new SingleLinked(4, "卓尔游侠", "小黑");

        singleLinked.add2(singleLinked3);
        singleLinked.add2(singleLinked2);
        singleLinked.add2(singleLinked1);
        singleLinked.add2(singleLinked4);

        singleLinked.list();
        System.out.println("删除数据=====");
        singleLinked.delete(4);
        singleLinked.delete(5);
        singleLinked.list();

        System.out.println("更新数据=====");
        SingleLinked singleLinked5 = new SingleLinked(2, "新手第一英雄", "矮子");
        singleLinked.update(singleLinked5);
        singleLinked.list();


        System.out.println("查询数据=====");
        singleLinked.get(1);
        singleLinked.get(3);
        singleLinked.get(5);
    }
}
