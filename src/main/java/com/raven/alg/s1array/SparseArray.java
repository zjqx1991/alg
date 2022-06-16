package com.raven.alg.s1array;


/**
 * 稀疏数组
 */
public class SparseArray {

    /**
     * 二维数组转 -> 稀疏数组
     *
     * @param array 二维数组
     * @return
     */
    public static int[][] getSparseArray(int[][] array) {
        if (0 == array.length) {
            System.out.println("二维数组不能为空！！！");
        }

        // 获取二维数组行 和 列
        Integer row = array.length;
        Integer list = array[0].length;
        Integer num = 0;
        for (Integer i = 0; i < row; i++) {
            for (Integer j = 0; j < list; j++) {
                if (array[i][j] > 0) {
                    num++;
                }
            }
        }

        // 创建稀疏数组
        int[][] sparseArray = new int[num + 1][3];
        // 记录二维数组信息
        sparseArray[0][0] = row;
        sparseArray[0][1] = list;
        sparseArray[0][2] = num;

        // 保存有效数据
        int length = 0;
        for (Integer i = 0; i < row; i++) {
            for (Integer j = 0; j < list; j++) {
                int value = array[i][j];
                if (value > 0) {
                    length++;
                    sparseArray[length][0] = i;
                    sparseArray[length][1] = j;
                    sparseArray[length][2] = value;
                }
            }
        }
        return sparseArray;
    }


    /**
     * 稀疏数组 -> 二维数组转
     *
     * @param sparseArray
     * @return
     */
    public static int[][] sparseArrayToArray(int[][] sparseArray) {
        if (0 == sparseArray.length) {
            System.out.println("稀疏数组不能为空！！！");
        }
        int row = sparseArray[0][0];
        int list = sparseArray[0][1];
        // 创建二维数组
        int[][] array = new int[row][list];

        // 保存有效数据
        for (Integer i = 1; i < sparseArray.length; i++) {
            int i1 = sparseArray[i][0];
            int i2 = sparseArray[i][1];
            int v = sparseArray[i][2];
            array[i1][i2] = v;
        }
        return array;
    }
}
