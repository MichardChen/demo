package com.example;

import java.math.BigDecimal;

/**
 * @author ChenDang
 * @date 2019/8/2 0002
 */
public class Test {

    public static void main(String[] args){
        double a = 10.1288;
        double b = 10.8912; //10
        System.out.println(round(a,2));
        a=round(a,2);
        System.out.println(round(b,2));
        System.out.println(a);
        System.out.println(b);
        System.out.println(round(a+b,2));
    }

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
