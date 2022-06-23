package com.raven.alg.s5recursion;

import java.math.BigDecimal;

public class Recursion {

    /**
     * 求和
     *
     * @param num
     * @return
     */
    public static Integer sum(Integer num) {
        Integer sum = 0;
        while (num > 0) {
            sum += num;
            num--;
        }
        return sum;
    }


    /**
     * 求阶乘
     *
     * @param num
     * @return
     */
    public static BigDecimal factorial(Integer num) {
        if (num == 1) {
            return new BigDecimal(1);
        } else {
            return factorial(num - 1).multiply(new BigDecimal(num));
        }
    }

}
