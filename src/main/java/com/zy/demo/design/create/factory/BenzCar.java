package com.zy.demo.design.create.factory;

/**
 * Benz
 *
 * @author zy
 */
public class BenzCar implements Car {
    @Override
    public void drive() {
        System.out.println("BenzCar drive");
    }
}
