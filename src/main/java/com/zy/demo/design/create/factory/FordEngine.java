package com.zy.demo.design.create.factory;

/**
 * FordEngine
 *
 * @author zy
 */
public class FordEngine implements Engine {
    @Override
    public void install() {
        System.out.println("FordEngine install");
    }
}
