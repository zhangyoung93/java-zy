package com.zy.demo.design.create.factory;

/**
 * BenzFactory
 *
 * @author zy
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }

    @Override
    public Engine createEngine() {
        return new BenzEngine();
    }
}
