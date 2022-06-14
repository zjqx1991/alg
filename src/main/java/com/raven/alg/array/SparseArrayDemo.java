package com.raven.alg.array;


/**
 * 稀疏数组
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        array[1][1] = 1;
        array[1][2] = 2;
        array[2][2] = 2;
        array[2][3] = 3;
        array[3][2] = 2;
        array[4][4] = 3;

        for (Integer i = 0; i < 5; i++) {
            System.out.println();
            for (Integer j = 0; j < 5; j++) {
                System.out.printf("%d \t", array[i][j]);
            }
        }

        System.out.println(" 稀疏数组 ");
        int[][] sparseArray = SparseArray.getSparseArray(array);

        for (Integer i = 0; i < sparseArray.length; i++) {
            System.out.println();
            for (Integer j = 0; j < 3; j++) {
                System.out.printf("%d \t", sparseArray[i][j]);
            }
        }


        System.out.println(" 稀疏数组 -> 二维数组");

        int[][] array2 = SparseArray.sparseArrayToArray(sparseArray);

        for (Integer i = 0; i < array2.length; i++) {
            System.out.println();
            for (Integer j = 0; j < array2[0].length; j++) {
                System.out.printf("%d \t", array[i][j]);
            }
        }
    }
}
