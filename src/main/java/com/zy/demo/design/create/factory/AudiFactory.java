package com.zy.demo.design.create.factory;

/**
 * AudiFactory
 *
 * @author zy
 */
public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new AudiCar();
    }

    @Override
    public Engine createEngine() {
        return new AudiEngine();
    }
}
