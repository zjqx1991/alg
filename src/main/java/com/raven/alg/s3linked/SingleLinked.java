package com.raven.alg.s3linked;


/**
 * 无序单向链表
 */
public class SingleLinked extends Linked {


    public SingleLinked() {
    }

    public SingleLinked(Integer sort, String name, String shortName) {
        this.sort = sort;
        this.name = name;
        this.shortName = shortName;
    }

    /**
     * 新增节点到链表的最后
     */
    public void add(Linked item) {
        if (null == this.head) {
            this.head = new SingleLinked(0, "head", "head");
        }
        // 获取列表的头节点
        Linked head = this.head;
        while (null != head.next) {
            head = head.next;
        }
        // 获取最后一个有效节点的next（null）
        Linked nextNull = head.next;
        head.next = item;
        item.next = nextNull;
    }


    /**
     * 新增节点到链表的最后
     */
    public void add2(SingleLinked item) {
        if (null == this.head) {
            this.head = new SingleLinked(0, "head", "head");
        }
        // 获取列表的头节点
        Linked head = this.head;
        while (true) {
            if (null == head.next) {
                break;
            }
            head = head.next;
        }
        // 获取最后一个有效节点的next（null）
        Linked nextNull = head.next;
        head.next = item;
        item.next = nextNull;
    }


    /**
     * 删除指定节点
     *
     * @param sort
     */
    public void delete(Integer sort) {
        Linked head = this.head;
        Boolean check = false;
        if (null == head || null == head.next) {
            System.out.println("列表为空！！！");
            return;
        }
        while (true) {
            // 链表末尾
            if (null == head.next) {
                break;
            }
            // 找到数据，返回找到数据的前一个节点（head）
            if (head.next.sort == sort) {
                check = true;
                break;
            }
            head = head.next;
        }
        if (check) {
            head.next = head.next.next;
        } else {
            System.out.println(sort + " 数据不存在！！！");
        }
    }

    /**
     * 修改列表数据
     */
    public void update(Linked item) {
        Linked head = this.head;
        Boolean check = false;
        if (null == head || null == head.next) {
            System.out.println("列表为空！！！");
            return;
        }
        while (true) {
            // 没有找到
            if (null == head) {
                break;
            }
            // 找到了
            if (head.sort == item.sort) {
                check = true;
                break;
            }
            head = head.next;
        }

        if (check) {
            head.name = item.name;
            head.shortName = item.shortName;
        } else {
            System.out.println("没有找到该数据，无法修改！！！");
        }
    }


    /**
     * 获取数据
     */
    public void get(Integer sort) {
        Linked head = this.head;
        Boolean check = false;
        if (null == head || null == head.next) {
            System.out.println("列表为空！！！");
            return;
        }
        while (true) {
            // 没有找到
            if (null == head) {
                break;
            }
            // 找到了
            if (head.sort == sort) {
                check = true;
                break;
            }
            head = head.next;
        }

        if (check) {
            System.out.println(sort + "数据为：" + head);
        } else {
            System.out.println("无法找到" + sort + "！！！");
        }
    }

}
