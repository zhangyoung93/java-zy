package com.zy.demo.design.create.factory;

/**
 * FordFactory
 *
 * @author zy
 */
public class FordFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Ford();
    }

    @Override
    public Engine createEngine() {
        return new FordEngine();
    }
}
