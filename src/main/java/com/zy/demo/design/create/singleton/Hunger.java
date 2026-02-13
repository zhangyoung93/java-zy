package com.zy.demo.design.create.singleton;

/**
 * 饿汉式
 *
 * @author zy
 */
public class Hunger {

    private static final Hunger HUNGER = new Hunger();

    private Hunger() {
    }

    public static Hunger getInstance() {
        return HUNGER;
    }
}
