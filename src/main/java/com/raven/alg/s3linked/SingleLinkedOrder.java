package com.raven.alg.s3linked;

/**
 * 有序序单向链表
 */
public class SingleLinkedOrder extends Linked {

    public SingleLinkedOrder(Integer sort, String name, String shortName) {
        this.sort = sort;
        this.name = name;
        this.shortName = shortName;
    }

    /**
     * 新增节点
     */
    public void add(Linked item) {
        if (null == this.head) {
            this.head = new SingleLinkedOrder(0, "head", "head");
        }
        // 寻找sort 大于item 的 SingleLinkedOrder
        Linked head = this.head;
        Boolean check = false;
        while (true) {
            // 第一个有效节点
            if (null == head.next) {
                check = true;
                break;
            }
            if (head.next.sort > item.sort) {
                check = true;
                break;
            }
            head = head.next;
        }
        if (check) {
            Linked next = head.next;
            head.next = item;
            item.next = next;
        }
    }


    /**
     * 删除指定节点
     *
     * @param sort
     */
    public void delete(Integer sort) {
        if (null == this.head || null == this.head.next) {
            System.out.println("列表为空！！！");
            return;
        }
        Linked head = this.head;
        Boolean check = false;
        while (true) {
            // 为空
            if (null == head.next) {
                break;
            }
            // 找到
            if (head.next.sort == sort) {
                check = true;
                break;
            }
            head = head.next;
        }
        if (check) {
            head.next = head.next.next;
        } else {
            System.out.println("未找到 " + sort + " 该节点数据！！！");
        }
    }


    /**
     * 修改列表数据
     */
    public void update(Linked item) {
        if (null == this.head || null == this.head.next) {
            System.out.println("列表为空！！！");
            return;
        }
        // 有效节点
        Linked first = this.head.next;
        Boolean check = false;

        while (true) {
            // 找不到
            if (null == first) {
                break;
            }
            if (first.sort == item.sort) {
                check = true;
                break;
            }
            first = first.next;
        }

        if (check) {
            first.name = item.name;
            first.shortName = item.shortName;
        } else {
            System.out.println("未找到 " + sort + " 该节点数据！！！");
        }
    }


    /**
     * 获取数据
     */
    public void get(Integer sort) {
        if (null == this.head || null == this.head.next) {
            System.out.println("列表为空！！！");
            return;
        }
        Linked head = this.head;
        Boolean check = false;
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
