package com.zy.demo.design.create.factory;

/**
 * Ford
 *
 * @author zy
 */
public class FordCar implements Car {
    @Override
    public void drive() {
        System.out.println("FordCar drive");
    }
}
