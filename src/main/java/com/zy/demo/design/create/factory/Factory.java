package com.zy.demo.design.create.factory;

/**
 * 汽车工厂
 *
 * @author zy
 */
public interface Factory {

    /**
     * 生产汽车
     *
     * @return Car car
     */
    Car createCar();

    /**
     * 生产发动机
     *
     * @return Engine engine
     */
    Engine createEngine();
}
