package com.raven.alg.s5recursion;

/**
 * 0：可以走的路
 * 1：代表墙
 * 2：走过的路
 * 3：回退的路
 * 迷宫
 */
public class Migong {

    public static void run(Integer size, int startX, int startY, int endX, int endY) {
        if (size < 1) {
            throw new RuntimeException("迷宫不能小于0");
        }
        // 1、创建迷宫
        int[][] mg = initMigong(size);
        // 迷宫围墙
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mg[i][j] + " ");
            }
            System.out.println();
        }

        // 2、走迷宫
        go(mg, startX, startY, endX, endY);
    }


    /**
     * 初始化迷宫
     * <p>
     * 0：未走过，可以走的路
     * 1：代表墙
     * 2：走过的路，可以走得通
     * 3：走过的路，但是走不通
     * <p>
     * 规则：下->右->上->左
     *
     * @param mg     迷宫
     * @param startX 开始的x位置
     * @param startY 开始的y位置
     * @param endX   结束的x位置
     * @param endY   结束的y位置
     */
    private static Boolean go(int[][] mg, int startX, int startY, int endX, int endY) {
        System.out.println("=====开始走迷宫====");
        for (int i = 0; i < mg.length; i++) {
            for (int j = 0; j < mg.length; j++) {
                System.out.print(mg[i][j] + " ");
            }
            System.out.println();
        }
        // 代表找到出口
        if (2 == mg[endX][endY]) {
            return true;
        } else {
            // 该路没有走过
            if (0 == mg[startX][startY]) {
                mg[startX][startY] = 2;
                // 规则：下->右->上->左
                if (go(mg, startX + 1, startY, endX, endY)) {
                    return true;
                } else if (go(mg, startX, startY + 1, endX, endY)) {
                    return true;
                } else if (go(mg, startX - 1, startY, endX, endY)) {
                    return true;
                } else if (go(mg, startX, startY - 1, endX, endY)) {
                    return true;
                } else {
                    // 回溯，把 2->3
                    mg[startX][startY] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 初始化迷宫
     *
     * @param size
     * @return
     */
    private static int[][] initMigong(Integer size) {
        if (size < 1) {
            throw new RuntimeException("迷宫不能小于0");
        }
        // 创建迷宫
        int[][] mg = new int[size][size];
        // 迷宫围墙
        // 1、上下墙
        for (int i = 0; i < size; i++) {
            mg[0][i] = 1;
//            mg[3][i] = 1;
            mg[size - 1][i] = 1;
        }
        // 2、左右墙
        for (int i = 0; i < size; i++) {
            mg[i][0] = 1;
            mg[i][size - 1] = 1;
        }

        // 3、中间障碍
        mg[3][1] = 1;
        mg[3][2] = 1;
        mg[3][3] = 1;

        return mg;
    }

}
