package com.zy.demo.design.create.factory;

/**
 * Audi
 *
 * @author zy
 */
public class AudiCar implements Car {
    @Override
    public void drive() {
        System.out.println("AudiCar drive");
    }
}
