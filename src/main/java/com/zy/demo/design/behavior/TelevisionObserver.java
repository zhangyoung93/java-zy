package com.zy.demo.design.behavior;

/**
 * 电视观察者
 *
 * @author zy
 */
public class TelevisionObserver implements Observer {

    @Override
    public void message(String msg) {
        System.out.println("TelevisionObserver receive mgs:" + msg);
    }
}
