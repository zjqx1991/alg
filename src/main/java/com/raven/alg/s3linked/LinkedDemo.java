package com.raven.alg.s3linked;


public class LinkedDemo {
    public static void main(String[] args) {
        singleLinked();
    }

    /**
     * 无序链表
     */
    private static void singleLinked() {
        SingleLinked singleLinked = new SingleLinked(0, "", "");

        SingleLinked singleLinked1 = new SingleLinked(1, "影魔", "SF");
        SingleLinked singleLinked2 = new SingleLinked(2, "狙击手", "火枪");
        SingleLinked singleLinked3 = new SingleLinked(3, "露娜","月骑");
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
