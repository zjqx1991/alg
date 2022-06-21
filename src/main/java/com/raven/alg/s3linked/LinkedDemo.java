package com.raven.alg.s3linked;


public class LinkedDemo {
    public static void main(String[] args) {
        josephTest();
    }


    /**
     * 约瑟夫问题
     */
    private static void josephTest() {
        Joseph joseph = new Joseph(3);
        joseph.list();
        joseph.run(3, 3);
    }


    /**
     * 无序双向链表
     */
    private static void doubleLinkedTest() {
        DoubleLinkedNoOrder dh = new DoubleLinkedNoOrder(0, "", "");

        DoubleLinkedNoOrder d1 = new DoubleLinkedNoOrder(1, "影魔", "SF");
        DoubleLinkedNoOrder d2 = new DoubleLinkedNoOrder(2, "狙击手", "火枪");
        DoubleLinkedNoOrder d3 = new DoubleLinkedNoOrder(3, "露娜", "月骑");
        DoubleLinkedNoOrder d4 = new DoubleLinkedNoOrder(4, "卓尔游侠", "小黑");

        dh.add(d1);
        dh.add(d2);
        dh.add(d3);
        dh.add(d4);
        dh.list();


//        System.out.println("======= 删除 ======");
//        System.out.println("======= 删除 ======" + dh.delete(1));
//        dh.list();
//        System.out.println("======= 删除 ======" + dh.delete(4));
//        dh.list();
//        System.out.println("======= 删除 ======" + dh.delete(5));

//
//        System.out.println("======= 修改 ======");
//        DoubleLinkedNoOrder d5 = new DoubleLinkedNoOrder(3, "露娜~5", "月骑~5");
//        System.out.println("======= 修改 5 ======" + dh.update(d5));
//        dh.list();


        System.out.println("======= 获取 ======");
        System.out.println("======= 修改 5 ======" + dh.get(5));
        System.out.println("======= 修改 4 ======" + dh.get(4));
        dh.list();
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


        System.out.println("合并两个有序链表");
        Linked linked = SingleLinkedInterview.mergeLinked(singleLinked.head, singleLinked.head);
        while (true) {
            if (linked == null) {
                break;
            }
            if (linked.sort != null)
                System.out.println(linked);
            linked = linked.next;
        }


//        System.out.println("倒序输出链表");
//        SingleLinkedInterview.reservePrintLinked(singleLinked.head);

//        System.out.println("反转链表");
//        Linked linked = SingleLinkedInterview.reserveLinked(singleLinked.head);
//        while (true) {
//            if (linked == null) {
//                break;
//            }
//            if (linked.sort != null)
//                System.out.println(linked);
//            linked = linked.next;
//        }

//        System.out.println("反转链表2");
//        SingleLinkedInterview.reserveLinked2(singleLinked.head);
//        singleLinked.list();

//
//        System.out.println("获取倒数第5个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 5));
//        System.out.println("获取倒数第4个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 4));
//        System.out.println("获取倒数第3个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 3));
//        System.out.println("获取倒数第2个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 2));
//        System.out.println("获取倒数第1个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 1));
//
//        System.out.println("链表有效个数=====" + SingleLinkedInterview.getSingleLinkedSize(singleLinked.head));
//        System.out.println("删除数据=====");
//        singleLinked.delete(1);
//        singleLinked.delete(5);
//        singleLinked.list();
//        System.out.println("链表有效个数=====" + SingleLinkedInterview.getSingleLinkedSize(singleLinked.head));
//
//        System.out.println("更新数据=====");
//        SingleLinkedOrder singleLinked5 = new SingleLinkedOrder(2, "新手第一英雄", "矮子");
//        singleLinked.update(singleLinked5);
//        singleLinked.list();
//        System.out.println("链表有效个数=====" + SingleLinkedInterview.getSingleLinkedSize(singleLinked.head));
//
//        System.out.println("查询数据=====");
//        singleLinked.get(1);
//        singleLinked.get(3);
//        singleLinked.get(5);
//
//        System.out.println("获取倒数第5个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 5));
//        System.out.println("获取倒数第4个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 4));
//        System.out.println("获取倒数第3个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 3));
//        System.out.println("获取倒数第2个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 2));
//        System.out.println("获取倒数第1个数据=====" + SingleLinkedInterview.getLinkedByReverseIndex(singleLinked.head, 1));
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
