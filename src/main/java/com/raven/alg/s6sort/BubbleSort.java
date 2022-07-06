package com.raven.alg.s6sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * 冒泡排序思路：【3, 1, 5, 7,2】，正序排序
 * 1、从下标 index（0）开始比较 index + 1（1）值的大小
 * 2、如果index0所在的值大于index1所在的值，交换index0和index1值【1, 3, 5, 7,2】
 * 3、index++
 * 4、经过一趟的执行可以确定一个最大值【1, 3, 5, 2,7】
 * 5、开始第2趟比较，重复执行【1~4】
 */
public class BubbleSort {

    public static void main(String[] args) {

//        Integer[] arr = {3, 1, 5, 2, -2};
//        Integer[] arr = {1, 2, 3, 4, 6};
//        Integer[] sort = sort(arr);
//        System.out.println(Arrays.toString(sort));

        // 十万个数据
        Integer[] arr = new Integer[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt(80000);
        }
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();

        //排序10万个数据耗时 = 46334 49523 52203 40252
        //优惠后排序10万个数据耗时 = 43635 41963 41150
        System.out.println("排序10万个数据耗时 = " + (endTime - startTime));

    }


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static Integer[] sort(Integer[] arr) {

        if (arr.length <= 1) {
            return arr;
        }

        // 临时
        Integer tmp = 0;
        // 优化
        Boolean isChange = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果 arr[j] 大于 arr[j + 1]，则交换 j 和 j+1 位置的值
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isChange = true;
                }
            }
//            System.out.println("第 "+(i + 1)+" 趟排序后 "+Arrays.toString(arr));
            // 如果没有某一趟没有发生交换，则代表已经排序完成
            if (isChange) {
                isChange = false;
            } else {
                break;
            }
        }

        return arr;
    }

}
