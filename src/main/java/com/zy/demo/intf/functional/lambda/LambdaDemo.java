package com.zy.demo.intf.functional.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式
 *
 * @author zy
 */
public class LambdaDemo {

    public static void sort() {
        Integer[] integers = {4, 2, 3, 1, 5};
        List<Integer> list = Arrays.asList(integers);
        list.sort(Comparator.comparingInt(o -> o));
        System.out.println(list.toString());
    }

    public static void thread() {
        Thread t = new Thread(() -> System.out.println("thread run"));
    }

    public static void main(String[] args) {
        sort();
        thread();
    }
}
