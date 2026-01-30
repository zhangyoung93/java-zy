package com.zy.demo.design.create.factory;

/**
 * FordFactory
 *
 * @author zy
 */
public class FordFactory implements Factory {
    @Override
    public Car createCar() {
        return new FordCar();
    }

    @Override
    public Engine createEngine() {
        return new FordEngine();
    }
}
