package com.zy.demo.design.create.factory;

/**
 * 工厂模式
 *
 * @author zy
 */
public class FactoryMode {

    public static void main(String[] args) {
        //先选择具体的工厂
        CarFactory carFactory = new AudiFactory();
        //再生产工厂特有的产品
        Car car = carFactory.createCar();
        car.drive();
    }
}
