package com.raven.alg.s5recursion;


/**
 * 8 皇后问题
 * 思路：
 * 首先放置第一个皇后
 * 固定在第一行，从第一列开始
 * (0, 1)，(0, 2)，(0, 3)，(0, 4)，(0, 5)，(0, 6)，(0, 7)
 */
public class Queen8 {

    // 已使用，需要跳过
    private final static Integer SUCCESS = 1;
    private final static Integer FAIL = 2;
    private final static Integer HS = 3;

    private static Boolean isHS = false;
    private static Integer count = 0;

    public static void run(Integer size) {
        if (size < 1) {
            throw new RuntimeException("棋盘不能小于0");
        }
        // 1、创建棋盘
        int[][] mg = initMigong(size);
        // 棋盘
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mg[i][j] + " " + " ");
            }
            System.out.println();
        }
        // 第一个皇后的位置
        go(mg, 0);
        System.out.println("Count = " + count);
    }

    private static void go(int[][] mg, int startX) {
        // 已放满
        if (startX == mg.length) {
            count++;
            System.out.println("已完成第 " + count + " 次");
            print(mg);
            return;
        }

        // 从 0 ~ 7
        for (int i = 0; i < mg.length; i++) {
            if (isHS) {
                isHS = false;
                // 处理回溯
                hs(mg, startX);
                mg[startX][i - 1] = 2;
            }
            mg[startX][i] = 1;
//            System.out.println("开始摆放第 " + (startX + 1) + " 个皇后, 第 " + (i + 1) + " 次");
//            print(mg);
            if (SUCCESS == check(mg, startX, i)) {
                go(mg, startX + 1);
            } else {
                mg[startX][i] = 2;
            }
        }
    }

    /**
     * 校验当前位置的皇后是否与已经存在的皇后冲突
     * <p>
     * 冲突：不能在同一列、同一行、一条斜线上
     *
     * @param mg
     * @param startX
     * @param startY
     * @return
     */
    private static Integer check(int[][] mg, int startX, int startY) {

        for (int i = 0; i < startX; i++) {
            for (int j = 0; j < mg.length; j++) {
                int hh = mg[i][j];
                boolean isX = i == startX;
                boolean isY = j == startY;
                Boolean isXX = Math.abs(i - startX) == Math.abs(j - startY);
                if (hh == SUCCESS && (isX || isY || isXX)) {
                    // 需要回溯
                    if (mg.length - 1 == startY) {
                        isHS = true;
                    }
                    return FAIL;
                }
            }
        }
        return SUCCESS;
    }


    /**
     * 回溯
     *
     * @param mg
     * @param startX
     * @return
     */
    private static void hs(int[][] mg, int startX) {
        for (int i = mg.length - 1; i > startX; i--) {
            for (int j = 0; j < mg.length; j++) {
                if (1 == mg[i][j]) {
                    mg[i][j] = HS;
                }
            }
        }
    }


    /**
     * 打印
     *
     * @param mg
     */
    private static void print(int[][] mg) {
        for (int i = 0; i < mg.length; i++) {
            for (int j = 0; j < mg.length; j++) {
                System.out.print(mg[i][j] + "   ");
            }
            System.out.println();
        }
    }

    /**
     * 初始化棋盘
     *
     * @param size
     * @return
     */
    private static int[][] initMigong(Integer size) {
        if (size < SUCCESS) {
            throw new RuntimeException("迷宫不能小于0");
        }
        // 创建迷宫
        int[][] mg = new int[size][size];
        return mg;
    }

}
