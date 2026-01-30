package com.zy.demo.design.create.factory;

/**
 * BenzEngine
 *
 * @author zy
 */
public class BenzEngine implements Engine {
    @Override
    public void install() {
        System.out.println("BenzEngine install");
    }
}
