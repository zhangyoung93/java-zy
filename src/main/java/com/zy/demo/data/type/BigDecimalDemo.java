package com.zy.demo.data.type;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 精确数值计算
 *
 * @author zy
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        //构造函数传参String，不会丢失精度
        BigDecimal bigDecimal = new BigDecimal("3.52");
        // +
        System.out.println(bigDecimal.add(new BigDecimal("1.37")));
        // -
        System.out.println(bigDecimal.subtract(new BigDecimal("1.37")));
        // *
        System.out.println(bigDecimal.multiply(new BigDecimal("1.37")));
        // / 保留2位小数，向下取整
        System.out.println(bigDecimal.divide(new BigDecimal("1.37"), 2, RoundingMode.HALF_UP));
    }
}
