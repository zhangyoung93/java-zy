package com.zy.demo.design.create.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 饿汉式
 *
 * @author zy
 */
public class Hunger implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Hunger HUNGER = new Hunger();

    private Hunger() {
    }

    public static Hunger getInstance() {
        return HUNGER;
    }

    /**
     * 防止反序列化破坏单例
     *
     * @return 单例
     * @throws ObjectStreamException ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return HUNGER;
    }
}
