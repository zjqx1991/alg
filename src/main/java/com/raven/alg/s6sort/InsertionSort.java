package com.raven.alg.s6sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序 arr【101, 43, 119, 1】
 * 插入排序的思路：
 * 在遍历的时候，没遍历一趟（index）都要确保 0~index 数据是有序。从下标1开始，因为第一个元素肯定是有序的（101）
 * 1、开始遍历数组 arr，从下标 1 开始
 * 2、比较 下标 1 的元素值(43)，与 小于 1 下标的值一一比较，如果大于则移动 arr【101, 101, 119, 1】
 * 3、如果 下标 等于 0 时，则把 下标为 1 的值 放置到下标 0 的位置 arr【43, 101, 119, 1】
 * 4、temp = 43
 * 5、上述的移动使用 while 来实现，条件为：while(index > 0 && arr[index - 1] > 43) { index-- }
 * 6、如果没有移动 index = i ，表示不需要移动，位置合适
 */
public class InsertionSort {


    public static void main(String[] args) {
//        Integer[] arr = {17, 3, 25, 14, 20, 9};
//        Integer[] arr = {101, 43, 119, 1};
//        Integer[] arr = {3, 1, 5, 2, -2};
//        Integer[] arr = {1, 2, 3, 4, 6};
//        Integer[] sort = sort(arr);
//        System.out.println("args = " + Arrays.deepToString(sort));


        // 十万个数据
        Integer[] arr = new Integer[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt(80000);
        }
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();

        //冒泡排序10万个数据耗时 = 46334 49523 52203 40252
        //优化冒泡排序10万个数据耗时 = 43635 41963 41150
        //选择排序10万个数据耗时 = 13355 16778 13461
        //优化选择排序10万个数据耗时 = 18096 18548 15211 15897
        //插入排序10万个数据耗时 = 28481 27034 27254 27670
        System.out.println("排序10万个数据耗时 = " + (endTime - startTime));
    }


    public static Integer[] sort(Integer[] arr) {
        // 保存新增数据
        Integer index = 0;
        Integer temp = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            index = i;
            // 给 sort 排序
            while (index > 0 && arr[index - 1] > temp) {
                arr[index] = arr[index - 1];
                index--;
            }
            if (index != i) {
                arr[index] = temp;
            }
//            System.out.println(index + " 第 " + i + " 次交换后" + Arrays.toString(arr));
        }
        return arr;
    }
}
