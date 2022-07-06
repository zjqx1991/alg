package com.raven.alg.s6sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 * 选择排序思路：【101, 43, 119, 1】，正序排序
 * 1、第1趟找到一个最小值（index），然后交换下标为0和下标为index的值
 * 2、第2趟找到一个最小值（index），然后交换下标为1和下标为index的值
 * 3、依次类推，在最差的情况下，只需 n-1 趟就会成为有序数组
 */
public class SelectSort {

    public static void main(String[] args) {
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
        System.out.println("排序10万个数据耗时 = " + (endTime - startTime));
    }


    public static Integer[] sort(Integer[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        // 记录值
        Integer tmp = 0;
        // 记录最小值的下标
        Integer index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            // 默认第一个元素为最小
            index = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[index] > arr[j]) {
                    // 记录最小值的下标
                    index = j + 1;
                }
            }
            // 比较后交换位置
            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
//            System.out.println("第 " + (i + 1) + " 次交换后" + Arrays.toString(arr));
        }
        return arr;
    }
}
