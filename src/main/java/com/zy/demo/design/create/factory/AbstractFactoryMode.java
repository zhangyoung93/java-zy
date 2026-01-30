package com.zy.demo.design.create.factory;

/**
 * 抽象工厂模式
 *
 * @author zy
 */
public class AbstractFactoryMode {

    public static void main(String[] args) {
        //选择工厂
        Factory factory = new FordFactory();
        //生产发动机
        Engine engine = factory.createEngine();
        //生产汽车
        Car car = factory.createCar();
        //发动机安装
        engine.install();
        //汽车行驶
        car.drive();
    }
}
