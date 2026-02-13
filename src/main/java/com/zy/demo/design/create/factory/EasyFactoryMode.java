package com.zy.demo.design.create.factory;

import java.util.Optional;

/**
 * 简单工厂模式
 *
 * @author zy
 */
public class EasyFactoryMode {

    /**
     * 生产汽车
     *
     * @param brandName 品牌名称
     * @return 汽车
     */
    public static Car createCar(String brandName) throws Exception {
        Car car;
        switch (brandName) {
            case "Benz":
                car = new BenzCar();
                break;
            case "Audi":
                car = new AudiCar();
                break;
            case "Ford":
                car = new FordCar();
                break;
            default:
                throw new Exception("car not exists");
        }
        return car;
    }

    public static void main(String[] args) {
        Car car = null;
        try {
            car = EasyFactoryMode.createCar("Benz");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Optional.ofNullable(car).ifPresent(Car::drive);
    }
}
