package com.zy.demo.design.singleton;

/**
 * 静态内部类
 *
 * @author zy
 */
public class StaticInnerClass {

    private StaticInnerClass() {

    }

    private static class SingletonHolder {
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
