package com.raven.alg.s6sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
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
